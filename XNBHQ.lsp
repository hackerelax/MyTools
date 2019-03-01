(defun c:tb1()
	(setvar "cmdecho" 0)
  	(setq ent (entsel "\n选择直线:"))
  	(setq ent (car ent))
		(setq data_ent (entget ent))
	  	(setq start (assoc 10 data_ent))
	  	(setq start (cdr start))
	  	(setq end (assoc 11 data_ent))
	  	(setq end (cdr end))
  	(setq tleng (distance start end))
  	(setq tminus (getreal "\n总差值多少？？"))
  	(setq req (getreal "\n所需值多少？？"))
  	
  	
  	(setq result (/ (* tleng req) tminus))
  	(setq osm (getvar "osmode"))
	(setvar "osmode" 0)
		(command "circle" start result)
  		
  	(setvar "osmode" osm)
  	(prin1)
  )
(defun c:tb2()
	(setvar "cmdecho" 0)
  	;取出直线
  	(setq ent (entsel "\n选择直线:"))
  	(setq ent (car ent))
		(setq data_ent (entget ent))
	  	(setq start (assoc 10 data_ent))
	  	(setq start (cdr start))
	  	(setq end (assoc 11 data_ent))
	  	(setq end (cdr end))
  	(setq tleng (distance start end))
  	(setq ent (entsel "\n选择圆:"))
	  	(setq ent (car ent))
	  	(setq data (entget ent))
	  	;取出半径
	  	(setq r (assoc 40 data))
	  	(setq r (cdr r))
  	(setq tminus (getint "\n总差值多少？？"))
	(setq result (* (/ r tleng) tminus))
  	
  	
  	
  )
(defun c:SID()
	(setvar "cmdecho" 0)
	(setq zj (/ pi 2))
	
	;航径区相关
	(setq rwy (getpoint "\n选择跑道中线任一点"))
	(setq hstart (getpoint "\n选择用于起飞的跑道末端"))
	(setq sturn (getpoint "\n选择初始转弯点"))
  	(setq count (abs (getint "\n转弯包含几段圆弧？？")))
  		
	;计算过程
	(setq rwydir (angle rwy hstart));跑道方向
	(setq course (angle hstart sturn));航迹方向
   	(setq hleng (distance hstart sturn));起始点到转弯点的距离
   	(setq left0 (polar hstart (- rwydir zj) 0.09))
	(setq right0 (polar hstart (+ rwydir zj) 0.09))
	;自动判断转弯点在扩张结束点前/后？
  	(if (>= hleng 6.48)
  		(progn 
  			(setq hend (polar hstart course 6.48));扩张结束点
  		  	(setq left1 (polar hend (- course zj) 0.9))
		  	(setq right1 (polar hend (+ course zj) 0.9))
		  	(setq left2 (polar sturn (- course zj) 0.9))
		  	(setq right2 (polar sturn (+ course zj) 0.9))
		  	(if (> count 0)
				(progn		  
				(setq ent0 (entsel "\n选择转弯第_1_段转弯弧"))
				(setq end (getpoint "\n选择第_1_段转弯弧终点"))
			  	(setq ent0 (car ent0))
			  	(setq data_ent0 (entget ent0))
			  	;取出圆心和半径
			  	(setq r0 (assoc 40 data_ent0))
			  	(setq r0 (cdr r0))
			  	(setq cen0 (assoc 10 data_ent0))
			  	(setq cen0 (cdr cen0))
			  	(command "lengthen" ent0 "")
				(setq hc (getvar "PERIMETER"))
			  	(setq jdm (/ (* 360 hc) (* 2 pi r0)))
			  	(setq jdm (/ jdm 2));旋转角度m
			  	(setq bankuanm (+ (/ (/ hc 2) 8) 0.9));中间半宽
				
			  	(initget 1 "Shun Ni")
			  	(setq ans (getkword "\n第_1_个转弯是顺时针/逆时针(S/N)？？"))
		  	
			  	(cond 
					((= ans "Ni")
				 	(setq jdm (- 0 jdm))
				))
		  	
		  	(setq osm (getvar "osmode"))
		  	(setvar "osmode" 0)
		  	(command "pline" left2 left1 left0 right0 right1 right2 "")
			(command "line" left2 right2 "")
			
			  	(setq l (+ (/ hc 8) 0.9))
			  	(setq fx (angle cen0 end))
			  	(setq a (polar end fx l))
			  	(setq b (polar end (+ fx pi) l))
			  	(command "line" a b "")
			  
			  	(setq leftm (polar sturn (- course zj) bankuanm))
			  	(setq rightm (polar sturn (+ course zj) bankuanm))
			  	(command "line" leftm rightm "")
				(setq temp (entlast))
			  	(command "rotate" temp "" cen0 jdm)
		  	
		  	(setvar "osmode" osm)
		  	)
			(progn
				(setq osm (getvar "osmode"))
			  	(setvar "osmode" 0)
			  	(command "pline" left2 left1 left0 right0 right1 right2 "")
				(command "line" left2 right2 "")
			  	(setvar "osmode" osm)
			)

		)
		  	
  		)
  	)
  	(if (< hleng 6.48)
  		(progn
		  	
  			(setq bankuan0 (+ (/ hleng 8) 0.09));转弯起始半宽
	  		(setq hc0 (- 6.48 hleng));总弧长
	  		(setq hc1 (/ hc0 2));弧长的一半
	  		(setq bankuan1 (+ (/ (+ hleng hc1) 8) 0.09));中间半宽
	  		(setq left1 (polar sturn (- course zj) bankuan0))
  			(setq right1 (polar sturn (+ course zj) bankuan0))
  			(setq left2 (polar sturn (- course zj) bankuan1))
  			(setq right2 (polar sturn (+ course zj) bankuan1))
  			(setq left3 (polar sturn (- course zj) 0.9))
  			(setq right3 (polar sturn (+ course zj) 0.9))
  			;提示选取转弯半径
  			(setq ent0 (entsel "\n选择转弯第_1_段转弯弧"))
		  	(setq end (getpoint "\n选择第_1_段转弯弧终点"))
		  	(setq ent0 (car ent0))
		  	(setq data_ent0 (entget ent0))
		  	;取出圆心和半径
		  	(setq r0 (assoc 40 data_ent0))
		  	(setq r0 (cdr r0))
		  	(setq cen0 (assoc 10 data_ent0))
		  	(setq cen0 (cdr cen0))
		  	(command "lengthen" ent0 "")
			(setq hc (- (getvar "PERIMETER") hc0))
		  	;计算过程
		  	(setq jd0 (/ (* 360 hc0) (* 2 pi r0)));旋转角度0
			(setq jd1 (/ (* 360 hc1) (* 2 pi r0)));旋转角度1
		  	(setq jdm (/ (* 360 hc) (* 2 pi r0)))
		  	(setq jdm (- 0 (/ jdm 2)));旋转角度m
		  	(setq bankuanm (+ (/ (/ hc 2) 8) 0.9));中间半宽
			
		  	(initget 1 "Shun Ni")
		  	(setq ans (getkword "\n第_1_个转弯是顺时针/逆时针(S/N)？？"))
	  	
		  	(cond	((= ans "Ni")
				(setq jd0 (- 0 jd0))
				(setq jd1 (- 0 jd1))
			 	(setq jdm (- 0 jdm))
				))
			;画线
			(setq osm (getvar "osmode"))
		  	(setvar "osmode" 0)
		  	(command "pline" left1 left0 right0 right1 "")
		  
			(command "line" left2 right2 "")
			(setq temp (entlast))
		  	(command "rotate" temp "" cen0 jd1)
		  	(setq ent1 temp)
		  	(setq data_ent1 (entget ent1))
		  	(setq left2 (assoc 10 data_ent1))
		  	(setq left2 (cdr left2))
		  	(setq right2 (assoc 11 data_ent1))
		  	(setq right2 (cdr right2))
			
		  	(command "line" left3 right3 "")
			(setq temp (entlast))
		  	(command "rotate" temp "" cen0 jd0)
		  	(setq ent2 temp)
		  	(setq data_ent2 (entget ent2))
		  	(setq left3 (assoc 10 data_ent2))
		  	(setq left3 (cdr left3))
		  	(setq right3 (assoc 11 data_ent2))
		  	(setq right3 (cdr right3))

		  	(setq fx (angle cen0 end))
		  	(setq leftm (polar end fx bankuanm))
		  	(setq rightm (polar end (+ fx pi) bankuanm))
		  	
		  	(command "line" leftm rightm "")
			(setq temp (entlast))
		  	(command "rotate" temp "" cen0 jdm)
		  	
		  	(command "arc" left1 left2 left3)
		  	(command "arc" right1 right2 right3)
			   	
		  	(setq l (+ (/ hc 8) 0.9))
		
		  	(setq a (polar end fx l))
		  	(setq b (polar end (+ fx pi) l))
		  	(command "line" a b "")
		  	(setvar "osmode" osm)
		  	
  		)
  	)
  	;剩余转弯段
  	(if (> count 1)
	  	(progn
		(setq i 0)
		(repeat (- count 1)
		  	(setq ent (entsel (strcat "\n选择第_" (itoa (+ i 2))  "_段转弯弧")))
		  	(setq end (getpoint (strcat "\n选择第_" (itoa (+ i 2))  "_段转弯弧终点")))
		  	(setq ent (car ent))
		  	(setq data (entget ent))
		  	(setq r (assoc 40 data))
		  	(setq r (cdr r))
		  	(setq cen (assoc 10 data))
		  	(setq cen (cdr cen))
		  	(command "lengthen" ent "")
		  	(setq dd (getvar "PERIMETER"))
			(setq hc (+ hc dd))
		  	(setq l (+ (/ hc 8) 0.9))
		  	(setq fx (angle cen end))
		  	(setq a (polar end fx l))
		  	(setq b (polar end (+ fx pi) l))
		  	
			(setq hcm (- hc (/ dd 2)));中间弧长
		  	(setq bankuanm1 (+ (/ hcm 8) 0.9));中间半宽
		  	(setq jdm (/ (* 360 dd) (* 2 pi r)));中间弧长旋转角度
		  	(setq jdm (- 0 (/ jdm 2)))
		  	(initget 1 "Shun Ni")
		  	(setq ans (getkword (strcat "\n第" (itoa (+ i 2))  "个转弯是顺时针/逆时针(S/N)？？")))
	  	
		  	(cond	((= ans "Ni")
			 	(setq jdm (- 0 jdm))
				))
		  	(setq leftm1 (polar end fx bankuanm1))
		  	(setq rightm1 (polar end (+ fx pi) bankuanm1))
		  	(setq osm (getvar "osmode"))
  			(setvar "osmode" 0)
		  	(command "line" a b "")
		  	(command "line" leftm1 rightm1 "")
		  	(setvar "osmode" osm)
			(setq temp (entlast))
		  	(command "rotate" temp "" cen jdm)
			(setq i (+ i 1))
		  )
	))
  	(if (> count 0)
	  	(progn
	  	(setq sjcd (/ hc 2))
	  	(princ (strcat "\n缩减保护区长度为" (rtos sjcd 2 4)))
		(setq back (getpoint "\n选择转弯后的航段点:"))
		(setq fxe (angle end back))
		(setq sjjs (polar end fxe sjcd))
		
		(initget 1 "Shun Ni")
	  	(setq ans ans)
		  (cond ((= ans "Shun")	
			  	(setq c (polar sjjs (+ fxe zj) 0.9))
				(setq d (polar sjjs (- fxe zj) 0.9))
			)
			
			((= ans "Ni")
				(setq c (polar sjjs (- fxe zj) 0.9))
				(setq d (polar sjjs (+ fxe zj) 0.9))
			))
	     
	  	(setq osm (getvar "osmode"))
	  	(setvar "osmode" 0)
			(command "line" a c "")
	  		(command "line" b d "")
	  	(setvar "osmode" osm)
	))

  	(prin1)
)

(defun C:ZW ()
	(setvar "cmdecho" 0)
  	(setq zj (/ pi 2))
  	(setq ent (entsel "\n选择最后扩展线:"))
  	(setq ent (car ent))
		(setq data_ent (entget ent))
	  	(setq start (assoc 10 data_ent))
	  	(setq start (cdr start))
	  	(setq end (assoc 11 data_ent))
	  	(setq end (cdr end))
  	(setq kuan (distance start end))
  
  	(setq count (abs (getint "转弯几段弧？")))
	(setq i 0)
  	(setq hc (* (- (/ kuan 2) 0.9) 8))
  	
  	(repeat count
	  	(setq ent (entsel (strcat "\n选择第_" (itoa (+ i 1))  "_段转弯弧")))
	  	(setq end (getpoint (strcat "\n选择第_" (itoa (+ i 1))  "_段转弯弧终点")))
	  	(setq ent (car ent))
	  	(setq data (entget ent))
	  	(setq r (assoc 40 data))
	  	(setq r (cdr r))
	  	(setq cen (assoc 10 data))
	  	(setq cen (cdr cen))
	  	(command "lengthen" ent "")
	  	(setq dd (getvar "PERIMETER"))
		(setq hc (+ hc dd))
	  	(setq l (+ (/ hc 8) 0.9))
	  	(setq fx (angle cen end))
	  	(setq a (polar end fx l))
	  	(setq b (polar end (+ fx pi) l))
	  	(setq hcm (- hc (/ dd 2)));中间弧长
		  	(setq bankuanm1 (+ (/ hcm 8) 0.9));中间半宽
		  	(setq jdm (/ (* 360 dd) (* 2 pi r)));中间弧长旋转角度
		  	(setq jdm (- 0 (/ jdm 2)))
		  	(initget 1 "Shun Ni")
		  	(setq ans (getkword (strcat "\n第" (itoa (+ i 2))  "个转弯是顺时针/逆时针(S/N)？？")))
	  	
		  	(cond	((= ans "Ni")
			 	(setq jdm (- 0 jdm))
				))
		  	(setq leftm (polar end fx bankuanm1))
		  	(setq rightm (polar end (+ fx pi) bankuanm1))
		  	(setq osm (getvar "osmode"))
  			(setvar "osmode" 0)
		  	(command "line" a b "")
		  	(command "line" leftm rightm "")
	  		(setvar "osmode" osm)
			(setq temp (entlast))
		  	(command "rotate" temp "" cen jdm)
		(setq i (+ i 1))
	  )
  	(setq sjcd (/ hc 2))
  	(princ (strcat "\n缩减保护区长度为：" (rtos sjcd 2 4)))
    	(setq back (getpoint "\n选择转弯后的航段点:"))
	(setq fxe (angle end back))
	(setq sjjs (polar end fxe sjcd))
	
  	(initget 1 "Shun Ni")
	(setq ans ans)
  	
	  (cond ((= ans "Shun")
			
		  	(setq c (polar sjjs (+ fxe zj) 0.9))
			(setq d (polar sjjs (- fxe zj) 0.9))
		)
		
		((= ans "Ni")
			
			(setq c (polar sjjs (- fxe zj) 0.9))
			(setq d (polar sjjs (+ fxe zj) 0.9))
		))
     
  	(setq osm (getvar "osmode"))
  	(setvar "osmode" 0)
		(command "line" a c "")
  		(command "line" b d "")
  	(setvar "osmode" osm)
  	(prin1)
  	
)

(defun C:PY ( / #r1 &k1 &kw1 &ob1)
 (princ "\n程序:双向偏移命令 命令:PY 需要输入参数:选择需要偏移的多条线段、偏移距离（米）")
 (vl-load-com)
 (if (and (setq &kw1 (ssget '((0 . "LINE,LWPOLYLINE,CIRCLE,ARC"))))
     (setq #r1 (abs (/ (getdist "\n输入距离") 1000)))
     
  )
  (progn
   (while (setq &k1 (ssname &kw1 0))
    (setq &kw1 (ssdel &k1 &kw1))
    (setq &ob1 (vlax-ename->vla-object &k1))
    (vla-offset &ob1 #r1)
    (vla-offset &ob1 (* #r1 -1))
   )
  )
 )
 (prin1)
)

(defun C:CD (/ CURVE TLEN SS N SUMLEN)
(princ "\n程序:统计线段长度 命令:CD 需要输入参数:选择线段")
	(vl-load-com)
	(setq SUMLEN 0)
	(setq SS (ssget '((0 . "CIRCLE,ELLIPSE,LINE,*POLYLINE,SPLINE,ARC"))))
	(setq N 0)
	(repeat (sslength SS)
	(setq CURVE (vlax-ename->vla-object (ssname SS N)))
	(setq TLEN (vlax-curve-getdistatparam CURVE (vlax-curve-getendparam CURVE)))
	(setq SUMLEN (+ SUMLEN TLEN))
	(setq N (1+ N))
	)
	(princ (strcat "\n共选择 " (itoa (sslength SS)) " 条线段. 线段总长: " (rtos SUMLEN 2 4) "公里."))
	(prin1)
)

(defun c:PD()
	(princ "\n程序:画跑道 命令:PD 需要输入参数:跑道长度（米）、跑道真方位、选择跑道中心点")
	(setvar "cmdecho" 0)
  	(setq zj (/ pi 2))
  	;长度
  	(setq dist (abs (/ (getreal "\n输入跑道长度") 1000)))
  	;方位
  	(setq dir (getreal "\n输入跑道真方位"))
  	(setq bdir (+ dir 180))
  	(setq dir (* pi (/ (- 90 dir) 180)))
  	(setq bdir (* pi (/ (- 90 bdir) 180)))
	;跑道位置
  	(setq cen (getpoint "\n选择跑道中心:"))
  	;计算过程
  	(setq a (polar cen dir (/ dist 2)))
  	(setq b (polar cen bdir (/ dist 2)))
	(setq left1 (polar a (- dir zj) 0.15))
  	(setq right1 (polar a (+ dir zj) 0.15))
	(setq left2 (polar b (+ bdir zj) 0.15))
	(setq right2 (polar b (- bdir zj) 0.15))
	       
	(setq osm (getvar "osmode"))
  	(setvar "osmode" 0)
  	;画图
	(command "pline" left1 right1 right2 left2 "c")
	(command "circle" cen 0.15)
  	(command "line" cen a)
 	(command "")
  	(command "line" cen b)
 	(command "")
	(setvar "osmode" osm)
      	(prin1)  	
  )

(defun c:sx()
  	;选择对象
  	(setq ent (entsel "\n选择对象:"))
  	(setq ent (car ent))
  	(setq data (entget ent))
  	;|取出半径和圆心
  	(setq r (assoc 40 data))
  	(setq r (cdr r))
  	(setq cen (assoc 10 data))
  	(setq cen (cdr cen))
  	(princ (+ r 1))
  	(prin1)|;
 )
(defun c:cx()
    	(setq obs (entsel (strcat "\n选择障碍物")))
	(setq obs (car obs))
	(setq odata (entget obs))
	(setq ocen (assoc 10 odata))
	(setq ocen (cdr ocen))
  	(princ "\n选择需要做的垂线")
  	(command "line" ocen "PER" PAUSE "")
  	  	
  	(prin1)
	
  )
(defun c:qx()
	
	(setq cen (getpoint "\n选择导航台中心点:"))
  	(princ "\n选择需要做的切线")
  	(command "line" cen "tan" PAUSE "")
  	  	
  	(prin1)
  )
(defun c:zx()
  	(setvar "cmdecho" 0)
	(setq zj (/ pi 2))
	(setq ent (entsel "\n选择最后扩展线:"))
  	(setq ent (car ent))
		(setq data_ent (entget ent))
	  	(setq start (assoc 10 data_ent))
	  	(setq start (cdr start))
	  	(setq end (assoc 11 data_ent))
	  	(setq end (cdr end))
  	(setq kuan (distance start end))
  	(setq ent1 (entsel "\n选择延长线:"))
  	(setq ent1 (car ent1))
		(setq data_ent1 (entget ent1))
	  	(setq start1 (assoc 10 data_ent1))
	  	(setq start1 (cdr start1))
	  	(setq end1 (assoc 11 data_ent1))
	  	(setq end1 (cdr end1))
  	(setq chang (distance start1 end1))
  	(setq c1 (* (- (/ kuan 2) 0.9) 8))
  	(setq chang (+ chang c1))
  	(setq bankuan (+ (/ chang 8) 0.9))
  	(setq course (angle start1 end1))
  	(setq left1 (polar end1 (- course zj) bankuan))
	(setq right1 (polar end1 (+ course zj) bankuan))
  	(setq left2 (polar start1 (- course zj) (/ kuan 2)))
	(setq right2 (polar start1 (+ course zj) (/ kuan 2)))
  	(setq osm (getvar "osmode"))
	(setvar "osmode" 0)
	(command "line" left1 left2 "")
  	(command "line" right1 right2 "")
	(command "line" left1 right1 "")
  	(setvar "osmode" osm)
  	(prin1)
  )
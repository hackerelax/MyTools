(defun c:tb1()
	(setvar "cmdecho" 0)
  	(setq ent (entsel "\nѡ��ֱ��:"))
  	(setq ent (car ent))
		(setq data_ent (entget ent))
	  	(setq start (assoc 10 data_ent))
	  	(setq start (cdr start))
	  	(setq end (assoc 11 data_ent))
	  	(setq end (cdr end))
  	(setq tleng (distance start end))
  	(setq tminus (getreal "\n�ܲ�ֵ���٣���"))
  	(setq req (getreal "\n����ֵ���٣���"))
  	
  	
  	(setq result (/ (* tleng req) tminus))
  	(setq osm (getvar "osmode"))
	(setvar "osmode" 0)
		(command "circle" start result)
  		
  	(setvar "osmode" osm)
  	(prin1)
  )
(defun c:tb2()
	(setvar "cmdecho" 0)
  	;ȡ��ֱ��
  	(setq ent (entsel "\nѡ��ֱ��:"))
  	(setq ent (car ent))
		(setq data_ent (entget ent))
	  	(setq start (assoc 10 data_ent))
	  	(setq start (cdr start))
	  	(setq end (assoc 11 data_ent))
	  	(setq end (cdr end))
  	(setq tleng (distance start end))
  	(setq ent (entsel "\nѡ��Բ:"))
	  	(setq ent (car ent))
	  	(setq data (entget ent))
	  	;ȡ���뾶
	  	(setq r (assoc 40 data))
	  	(setq r (cdr r))
  	(setq tminus (getint "\n�ܲ�ֵ���٣���"))
	(setq result (* (/ r tleng) tminus))
  	
  	
  	
  )
(defun c:SID()
	(setvar "cmdecho" 0)
	(setq zj (/ pi 2))
	
	;���������
	(setq rwy (getpoint "\nѡ���ܵ�������һ��"))
	(setq hstart (getpoint "\nѡ��������ɵ��ܵ�ĩ��"))
	(setq sturn (getpoint "\nѡ���ʼת���"))
  	(setq count (abs (getint "\nת���������Բ������")))
  		
	;�������
	(setq rwydir (angle rwy hstart));�ܵ�����
	(setq course (angle hstart sturn));��������
   	(setq hleng (distance hstart sturn));��ʼ�㵽ת���ľ���
   	(setq left0 (polar hstart (- rwydir zj) 0.09))
	(setq right0 (polar hstart (+ rwydir zj) 0.09))
	;�Զ��ж�ת��������Ž�����ǰ/��
  	(if (>= hleng 6.48)
  		(progn 
  			(setq hend (polar hstart course 6.48));���Ž�����
  		  	(setq left1 (polar hend (- course zj) 0.9))
		  	(setq right1 (polar hend (+ course zj) 0.9))
		  	(setq left2 (polar sturn (- course zj) 0.9))
		  	(setq right2 (polar sturn (+ course zj) 0.9))
		  	(if (> count 0)
				(progn		  
				(setq ent0 (entsel "\nѡ��ת���_1_��ת�仡"))
				(setq end (getpoint "\nѡ���_1_��ת�仡�յ�"))
			  	(setq ent0 (car ent0))
			  	(setq data_ent0 (entget ent0))
			  	;ȡ��Բ�ĺͰ뾶
			  	(setq r0 (assoc 40 data_ent0))
			  	(setq r0 (cdr r0))
			  	(setq cen0 (assoc 10 data_ent0))
			  	(setq cen0 (cdr cen0))
			  	(command "lengthen" ent0 "")
				(setq hc (getvar "PERIMETER"))
			  	(setq jdm (/ (* 360 hc) (* 2 pi r0)))
			  	(setq jdm (/ jdm 2));��ת�Ƕ�m
			  	(setq bankuanm (+ (/ (/ hc 2) 8) 0.9));�м���
				
			  	(initget 1 "Shun Ni")
			  	(setq ans (getkword "\n��_1_��ת����˳ʱ��/��ʱ��(S/N)����"))
		  	
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
		  	
  			(setq bankuan0 (+ (/ hleng 8) 0.09));ת����ʼ���
	  		(setq hc0 (- 6.48 hleng));�ܻ���
	  		(setq hc1 (/ hc0 2));������һ��
	  		(setq bankuan1 (+ (/ (+ hleng hc1) 8) 0.09));�м���
	  		(setq left1 (polar sturn (- course zj) bankuan0))
  			(setq right1 (polar sturn (+ course zj) bankuan0))
  			(setq left2 (polar sturn (- course zj) bankuan1))
  			(setq right2 (polar sturn (+ course zj) bankuan1))
  			(setq left3 (polar sturn (- course zj) 0.9))
  			(setq right3 (polar sturn (+ course zj) 0.9))
  			;��ʾѡȡת��뾶
  			(setq ent0 (entsel "\nѡ��ת���_1_��ת�仡"))
		  	(setq end (getpoint "\nѡ���_1_��ת�仡�յ�"))
		  	(setq ent0 (car ent0))
		  	(setq data_ent0 (entget ent0))
		  	;ȡ��Բ�ĺͰ뾶
		  	(setq r0 (assoc 40 data_ent0))
		  	(setq r0 (cdr r0))
		  	(setq cen0 (assoc 10 data_ent0))
		  	(setq cen0 (cdr cen0))
		  	(command "lengthen" ent0 "")
			(setq hc (- (getvar "PERIMETER") hc0))
		  	;�������
		  	(setq jd0 (/ (* 360 hc0) (* 2 pi r0)));��ת�Ƕ�0
			(setq jd1 (/ (* 360 hc1) (* 2 pi r0)));��ת�Ƕ�1
		  	(setq jdm (/ (* 360 hc) (* 2 pi r0)))
		  	(setq jdm (- 0 (/ jdm 2)));��ת�Ƕ�m
		  	(setq bankuanm (+ (/ (/ hc 2) 8) 0.9));�м���
			
		  	(initget 1 "Shun Ni")
		  	(setq ans (getkword "\n��_1_��ת����˳ʱ��/��ʱ��(S/N)����"))
	  	
		  	(cond	((= ans "Ni")
				(setq jd0 (- 0 jd0))
				(setq jd1 (- 0 jd1))
			 	(setq jdm (- 0 jdm))
				))
			;����
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
  	;ʣ��ת���
  	(if (> count 1)
	  	(progn
		(setq i 0)
		(repeat (- count 1)
		  	(setq ent (entsel (strcat "\nѡ���_" (itoa (+ i 2))  "_��ת�仡")))
		  	(setq end (getpoint (strcat "\nѡ���_" (itoa (+ i 2))  "_��ת�仡�յ�")))
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
		  	
			(setq hcm (- hc (/ dd 2)));�м仡��
		  	(setq bankuanm1 (+ (/ hcm 8) 0.9));�м���
		  	(setq jdm (/ (* 360 dd) (* 2 pi r)));�м仡����ת�Ƕ�
		  	(setq jdm (- 0 (/ jdm 2)))
		  	(initget 1 "Shun Ni")
		  	(setq ans (getkword (strcat "\n��" (itoa (+ i 2))  "��ת����˳ʱ��/��ʱ��(S/N)����")))
	  	
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
	  	(princ (strcat "\n��������������Ϊ" (rtos sjcd 2 4)))
		(setq back (getpoint "\nѡ��ת���ĺ��ε�:"))
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
  	(setq ent (entsel "\nѡ�������չ��:"))
  	(setq ent (car ent))
		(setq data_ent (entget ent))
	  	(setq start (assoc 10 data_ent))
	  	(setq start (cdr start))
	  	(setq end (assoc 11 data_ent))
	  	(setq end (cdr end))
  	(setq kuan (distance start end))
  
  	(setq count (abs (getint "ת�伸�λ���")))
	(setq i 0)
  	(setq hc (* (- (/ kuan 2) 0.9) 8))
  	
  	(repeat count
	  	(setq ent (entsel (strcat "\nѡ���_" (itoa (+ i 1))  "_��ת�仡")))
	  	(setq end (getpoint (strcat "\nѡ���_" (itoa (+ i 1))  "_��ת�仡�յ�")))
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
	  	(setq hcm (- hc (/ dd 2)));�м仡��
		  	(setq bankuanm1 (+ (/ hcm 8) 0.9));�м���
		  	(setq jdm (/ (* 360 dd) (* 2 pi r)));�м仡����ת�Ƕ�
		  	(setq jdm (- 0 (/ jdm 2)))
		  	(initget 1 "Shun Ni")
		  	(setq ans (getkword (strcat "\n��" (itoa (+ i 2))  "��ת����˳ʱ��/��ʱ��(S/N)����")))
	  	
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
  	(princ (strcat "\n��������������Ϊ��" (rtos sjcd 2 4)))
    	(setq back (getpoint "\nѡ��ת���ĺ��ε�:"))
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
 (princ "\n����:˫��ƫ������ ����:PY ��Ҫ�������:ѡ����Ҫƫ�ƵĶ����߶Ρ�ƫ�ƾ��루�ף�")
 (vl-load-com)
 (if (and (setq &kw1 (ssget '((0 . "LINE,LWPOLYLINE,CIRCLE,ARC"))))
     (setq #r1 (abs (/ (getdist "\n�������") 1000)))
     
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
(princ "\n����:ͳ���߶γ��� ����:CD ��Ҫ�������:ѡ���߶�")
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
	(princ (strcat "\n��ѡ�� " (itoa (sslength SS)) " ���߶�. �߶��ܳ�: " (rtos SUMLEN 2 4) "����."))
	(prin1)
)

(defun c:PD()
	(princ "\n����:���ܵ� ����:PD ��Ҫ�������:�ܵ����ȣ��ף����ܵ��淽λ��ѡ���ܵ����ĵ�")
	(setvar "cmdecho" 0)
  	(setq zj (/ pi 2))
  	;����
  	(setq dist (abs (/ (getreal "\n�����ܵ�����") 1000)))
  	;��λ
  	(setq dir (getreal "\n�����ܵ��淽λ"))
  	(setq bdir (+ dir 180))
  	(setq dir (* pi (/ (- 90 dir) 180)))
  	(setq bdir (* pi (/ (- 90 bdir) 180)))
	;�ܵ�λ��
  	(setq cen (getpoint "\nѡ���ܵ�����:"))
  	;�������
  	(setq a (polar cen dir (/ dist 2)))
  	(setq b (polar cen bdir (/ dist 2)))
	(setq left1 (polar a (- dir zj) 0.15))
  	(setq right1 (polar a (+ dir zj) 0.15))
	(setq left2 (polar b (+ bdir zj) 0.15))
	(setq right2 (polar b (- bdir zj) 0.15))
	       
	(setq osm (getvar "osmode"))
  	(setvar "osmode" 0)
  	;��ͼ
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
  	;ѡ�����
  	(setq ent (entsel "\nѡ�����:"))
  	(setq ent (car ent))
  	(setq data (entget ent))
  	;|ȡ���뾶��Բ��
  	(setq r (assoc 40 data))
  	(setq r (cdr r))
  	(setq cen (assoc 10 data))
  	(setq cen (cdr cen))
  	(princ (+ r 1))
  	(prin1)|;
 )
(defun c:cx()
    	(setq obs (entsel (strcat "\nѡ���ϰ���")))
	(setq obs (car obs))
	(setq odata (entget obs))
	(setq ocen (assoc 10 odata))
	(setq ocen (cdr ocen))
  	(princ "\nѡ����Ҫ���Ĵ���")
  	(command "line" ocen "PER" PAUSE "")
  	  	
  	(prin1)
	
  )
(defun c:qx()
	
	(setq cen (getpoint "\nѡ�񵼺�̨���ĵ�:"))
  	(princ "\nѡ����Ҫ��������")
  	(command "line" cen "tan" PAUSE "")
  	  	
  	(prin1)
  )
(defun c:zx()
  	(setvar "cmdecho" 0)
	(setq zj (/ pi 2))
	(setq ent (entsel "\nѡ�������չ��:"))
  	(setq ent (car ent))
		(setq data_ent (entget ent))
	  	(setq start (assoc 10 data_ent))
	  	(setq start (cdr start))
	  	(setq end (assoc 11 data_ent))
	  	(setq end (cdr end))
  	(setq kuan (distance start end))
  	(setq ent1 (entsel "\nѡ���ӳ���:"))
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
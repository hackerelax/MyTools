package com.cdbt.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.cdbt.service.NormalCalParmsService;
import com.cdbt.utils.CommonUtils;

public class NormalCalUI implements ActionListener {
	public static JFrame frame;
	private JTextField parmText1;
	private JTextField parmText2;
	private JTextField parmText3;
	private JTextField parmText4;
	private JTextField parmText5;
	private JTextField parmText6;
	private JTextField resultText;
	private JRadioButtonMenuItem lengthMenuItem;
	private JRadioButtonMenuItem distMenuItem;
	private JRadioButtonMenuItem weightMenuItem;
	private JRadioButtonMenuItem tempMenuItem;
	private JRadioButtonMenuItem speedMenuItem;
	private JRadioButtonMenuItem climbMenuItem;
	private JRadioButtonMenuItem jwdMenuItem;
	private JRadioButtonMenuItem chazhifaMenuItem;
	private JRadioButtonMenuItem obsMenuItem;
	private JRadioButtonMenuItem rwyCondMenuItem;
	private JRadioButtonMenuItem overOBSMenuItem;
	private JRadioButtonMenuItem standerdMenuItem;
	private JRadioButtonMenuItem engMenuItem;
	private JLabel parmName1;
	private JLabel parmName2;
	private JLabel parmName3;
	private JLabel parmName4;
	private JLabel parmName5;
	private JLabel parmName6;
	private JLabel resultName;
	private JButton changeButton;
	private JButton calButton;
	private boolean units = false;
	private JTextField addResultText;
	private JLabel addResultName;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JMenu unitsMenu;
	private JCheckBox isTurn;
	private JButton clearButton;
	private JMenu calMenu;
	private JMenu transMenu;
	private JButton addButton_1;
	private JButton addButton_2;
	private JButton addButton_3;
	private JRadioButtonMenuItem ARCFunctionMenuItem;
	private JRadioButtonMenuItem angleMenuItem;
	private JRadioButtonMenuItem bhqMenuItem;
	private JRadioButtonMenuItem iastotas;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					NormalCalUI window = new NormalCalUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public NormalCalUI() {
		initialize();
		frame.setLocationRelativeTo(LoginUI.frame);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("常用计算工具");
		frame.setBounds(100, 100, 550, 490);
		frame.setDefaultCloseOperation(2);

		JPanel InputPanel = new JPanel();
		InputPanel.setBackground(Color.LIGHT_GRAY);
		InputPanel.setBounds(10, 10, 514, 185);
		frame.getContentPane().add(InputPanel);
		InputPanel.setLayout(null);

		this.parmName1 = new JLabel("英尺");
		this.parmName1.setForeground(Color.BLUE);
		this.parmName1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		this.parmName1.setBounds(20, 10, 129, 30);
		InputPanel.add(this.parmName1);
		this.parmName1.setHorizontalAlignment(0);

		this.parmText1 = new JTextField();
		this.parmText1.setHorizontalAlignment(0);
		this.parmText1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		this.parmText1.setBounds(20, 50, 129, 30);
		InputPanel.add(this.parmText1);
		this.parmText1.setColumns(10);
		this.parmText1.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				NormalCalUI.this.parmText1.selectAll();
			}
		});
		this.parmName2 = new JLabel("");
		this.parmName2.setForeground(Color.BLUE);
		this.parmName2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		this.parmName2.setBounds(198, 10, 129, 30);
		InputPanel.add(this.parmName2);
		this.parmName2.setHorizontalAlignment(0);
		this.parmName2.setVisible(false);

		this.parmText2 = new JTextField();
		this.parmText2.setHorizontalAlignment(0);
		this.parmText2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		this.parmText2.setBounds(198, 50, 129, 30);
		InputPanel.add(this.parmText2);
		this.parmText2.setColumns(10);
		this.parmText2.setVisible(false);
		this.parmText2.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				NormalCalUI.this.parmText2.selectAll();
			}
		});
		this.parmName3 = new JLabel("");
		this.parmName3.setForeground(Color.BLUE);
		this.parmName3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		this.parmName3.setBounds(375, 10, 129, 30);
		InputPanel.add(this.parmName3);
		this.parmName3.setHorizontalAlignment(0);
		this.parmName3.setVisible(false);

		this.parmText3 = new JTextField();
		this.parmText3.setHorizontalAlignment(0);
		this.parmText3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		this.parmText3.setBounds(375, 50, 129, 30);
		InputPanel.add(this.parmText3);
		this.parmText3.setColumns(10);
		this.parmText3.setVisible(false);
		this.parmText3.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				NormalCalUI.this.parmText3.selectAll();
			}
		});
		this.parmName4 = new JLabel("");
		this.parmName4.setForeground(Color.BLUE);
		this.parmName4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		this.parmName4.setBounds(20, 100, 129, 30);
		InputPanel.add(this.parmName4);
		this.parmName4.setHorizontalAlignment(0);
		this.parmName4.setVisible(false);

		this.parmText4 = new JTextField();
		this.parmText4.setHorizontalAlignment(0);
		this.parmText4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		this.parmText4.setBounds(20, 140, 129, 30);
		InputPanel.add(this.parmText4);
		this.parmText4.setColumns(10);
		this.parmText4.setVisible(false);
		this.parmText4.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				NormalCalUI.this.parmText4.selectAll();
			}
		});
		this.parmName5 = new JLabel("");
		this.parmName5.setForeground(Color.BLUE);
		this.parmName5.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		this.parmName5.setBounds(198, 100, 129, 30);
		InputPanel.add(this.parmName5);
		this.parmName5.setHorizontalAlignment(0);
		this.parmName5.setVisible(false);

		this.parmText5 = new JTextField();
		this.parmText5.setHorizontalAlignment(0);
		this.parmText5.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		this.parmText5.setBounds(198, 140, 129, 30);
		InputPanel.add(this.parmText5);
		this.parmText5.setVisible(false);
		this.parmText5.setColumns(10);
		this.parmText5.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				NormalCalUI.this.parmText5.selectAll();
			}
		});
		this.parmName6 = new JLabel("");
		this.parmName6.setForeground(Color.BLUE);
		this.parmName6.setHorizontalAlignment(0);
		this.parmName6.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		this.parmName6.setBounds(375, 100, 129, 30);
		InputPanel.add(this.parmName6);
		this.parmName6.setVisible(false);

		this.parmText6 = new JTextField();
		this.parmText6.setHorizontalAlignment(0);
		this.parmText6.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		this.parmText6.setColumns(10);
		this.parmText6.setBounds(375, 140, 129, 30);
		InputPanel.add(this.parmText6);
		this.parmText6.setVisible(false);
		this.parmText6.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				NormalCalUI.this.parmText6.selectAll();
			}
		});
		JPanel resultPanel = new JPanel();
		resultPanel.setBackground(Color.LIGHT_GRAY);
		resultPanel.setBounds(10, 205, 514, 216);
		frame.getContentPane().add(resultPanel);
		resultPanel.setLayout(null);

		this.resultText = new JTextField();
		this.resultText.setEditable(false);
		this.resultText.setBounds(24, 94, 131, 30);
		this.resultText.setHorizontalAlignment(0);
		this.resultText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		this.resultText.setColumns(10);
		resultPanel.add(this.resultText);

		this.resultName = new JLabel("米");
		this.resultName.setForeground(Color.RED);
		this.resultName.setBounds(24, 54, 131, 30);
		this.resultName.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		this.resultName.setHorizontalAlignment(0);
		resultPanel.add(this.resultName);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		this.transMenu = new JMenu("单位换算");
		this.transMenu.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		menuBar.add(this.transMenu);

		this.lengthMenuItem = new JRadioButtonMenuItem("英尺/米");
		this.lengthMenuItem.setSelected(true);
		this.lengthMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		this.transMenu.add(this.lengthMenuItem);
		this.lengthMenuItem.addActionListener(this);

		this.distMenuItem = new JRadioButtonMenuItem("海里/公里");
		this.distMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		this.transMenu.add(this.distMenuItem);
		this.distMenuItem.addActionListener(this);

		this.weightMenuItem = new JRadioButtonMenuItem("磅/公斤");
		this.weightMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		this.transMenu.add(this.weightMenuItem);
		this.weightMenuItem.addActionListener(this);

		this.tempMenuItem = new JRadioButtonMenuItem("ISA/C°");
		this.tempMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		this.transMenu.add(this.tempMenuItem);
		this.tempMenuItem.addActionListener(this);

		this.speedMenuItem = new JRadioButtonMenuItem("马赫速/公里每小时");
		this.speedMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		this.transMenu.add(this.speedMenuItem);
		this.speedMenuItem.addActionListener(this);

		this.climbMenuItem = new JRadioButtonMenuItem("爬升率/爬升梯度");
		this.climbMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		this.transMenu.add(this.climbMenuItem);
		this.climbMenuItem.addActionListener(this);

		this.jwdMenuItem = new JRadioButtonMenuItem("度-分-秒/小数格式");
		this.jwdMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		this.transMenu.add(this.jwdMenuItem);
		this.jwdMenuItem.addActionListener(this);

		this.angleMenuItem = new JRadioButtonMenuItem("弧度/角度");
		this.angleMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		this.transMenu.add(this.angleMenuItem);
		this.angleMenuItem.addActionListener(this);

		this.ARCFunctionMenuItem = new JRadioButtonMenuItem("弧/角/弦关系");
		this.ARCFunctionMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		this.transMenu.add(this.ARCFunctionMenuItem);
		this.ARCFunctionMenuItem.addActionListener(this);

		this.calMenu = new JMenu("常用算法");
		this.calMenu.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		menuBar.add(this.calMenu);

		this.chazhifaMenuItem = new JRadioButtonMenuItem("插值法");
		this.chazhifaMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		this.chazhifaMenuItem.addActionListener(this);
		this.calMenu.add(this.chazhifaMenuItem);

		this.obsMenuItem = new JRadioButtonMenuItem("梯度/高度计算");
		this.obsMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		this.obsMenuItem.addActionListener(this);
		this.calMenu.add(this.obsMenuItem);

		this.rwyCondMenuItem = new JRadioButtonMenuItem("干/湿跑道计算");
		this.rwyCondMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		this.rwyCondMenuItem.addActionListener(this);
		this.calMenu.add(this.rwyCondMenuItem);

		this.overOBSMenuItem = new JRadioButtonMenuItem("超障裕度计算");
		this.overOBSMenuItem.addActionListener(this);
		this.overOBSMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		this.calMenu.add(this.overOBSMenuItem);

		ButtonGroup calGroup = new ButtonGroup();
		calGroup.add(this.lengthMenuItem);
		calGroup.add(this.distMenuItem);
		calGroup.add(this.weightMenuItem);
		calGroup.add(this.tempMenuItem);
		calGroup.add(this.speedMenuItem);
		calGroup.add(this.climbMenuItem);
		calGroup.add(this.jwdMenuItem);
		calGroup.add(this.ARCFunctionMenuItem);
		calGroup.add(this.chazhifaMenuItem);
		calGroup.add(this.obsMenuItem);
		calGroup.add(this.rwyCondMenuItem);
		calGroup.add(this.overOBSMenuItem);

		bhqMenuItem = new JRadioButtonMenuItem("保护区计算");
		calMenu.add(bhqMenuItem);
		this.bhqMenuItem.addActionListener(this);
		bhqMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		calGroup.add(this.bhqMenuItem);
		calGroup.add(this.angleMenuItem);

		iastotas = new JRadioButtonMenuItem("IAS/TAS");
		iastotas.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		transMenu.add(iastotas);
		calGroup.add(iastotas);
		iastotas.addActionListener(this);

		this.unitsMenu = new JMenu("单位选择(m)");
		this.unitsMenu.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		menuBar.add(this.unitsMenu);

		this.standerdMenuItem = new JRadioButtonMenuItem("公制");
		this.standerdMenuItem.setSelected(true);
		this.standerdMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		this.standerdMenuItem.addActionListener(this);
		this.unitsMenu.add(this.standerdMenuItem);

		this.engMenuItem = new JRadioButtonMenuItem("英制");
		this.engMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		this.engMenuItem.addActionListener(this);
		this.unitsMenu.add(this.engMenuItem);

		ButtonGroup unitsGroup = new ButtonGroup();
		unitsGroup.add(this.standerdMenuItem);
		unitsGroup.add(this.engMenuItem);

		frame.getContentPane().setLayout(null);

		this.addResultName = new JLabel("");
		this.addResultName.setForeground(Color.RED);
		this.addResultName.setBounds(198, 54, 131, 30);
		this.addResultName.setHorizontalAlignment(0);
		this.addResultName.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		this.addResultName.setVisible(false);
		resultPanel.add(this.addResultName);

		this.addResultText = new JTextField();
		this.addResultText.setEditable(false);
		this.addResultText.setBounds(198, 94, 131, 30);
		this.addResultText.setHorizontalAlignment(0);
		this.addResultText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		this.addResultText.setColumns(10);
		this.addResultText.setVisible(false);
		resultPanel.add(this.addResultText);

		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(10, 10, 330, 196);
		resultPanel.add(this.scrollPane);

		this.textArea = new JTextArea();
		this.textArea.setEditable(false);
		this.textArea.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		this.scrollPane.setViewportView(this.textArea);

		this.isTurn = new JCheckBox("在转弯段");
		this.isTurn.setHorizontalAlignment(0);
		this.isTurn.setFont(new Font("新宋体", Font.PLAIN, 12));
		this.isTurn.setBounds(377, 39, 127, 23);
		this.isTurn.setVisible(false);
		resultPanel.add(this.isTurn);

		this.clearButton = new JButton("清除");
		this.clearButton.setForeground(Color.BLUE);
		this.clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (NormalCalUI.this.overOBSMenuItem.isSelected()) {
					NormalCalUI.this.parmText5.setText("");
					NormalCalUI.this.parmText6.setText("");
					NormalCalUI.this.resultText.setText("");
					NormalCalUI.this.addResultText.setText("");
					NormalCalUI.this.textArea.setText("");
				} else {
					NormalCalUI.this.parmText1.setText("");
					NormalCalUI.this.parmText2.setText("");
					NormalCalUI.this.parmText3.setText("");
					NormalCalUI.this.parmText4.setText("");
					NormalCalUI.this.parmText5.setText("");
					NormalCalUI.this.parmText6.setText("");
					NormalCalUI.this.resultText.setText("");
					NormalCalUI.this.addResultText.setText("");
					NormalCalUI.this.textArea.setText("");
				}
			}
		});
		this.calButton = new JButton("计算");
		this.calButton.setForeground(Color.RED);
		this.calButton.setBounds(377, 10, 127, 23);
		this.calButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NormalCalParmsService parmsService = new NormalCalParmsService();
				String parm1 = NormalCalUI.this.parmText1.getText().trim();
				String parm2 = NormalCalUI.this.parmText2.getText().trim();
				String parm3 = NormalCalUI.this.parmText3.getText().trim();
				String parm4 = NormalCalUI.this.parmText4.getText().trim();
				String parm5 = NormalCalUI.this.parmText5.getText().trim();
				String parm6 = NormalCalUI.this.parmText6.getText().trim();
				if ((CommonUtils.ifStringIsDigital(parm1)) && (!parm1.isEmpty())) {
					if (NormalCalUI.this.parmName1.getText().equals("英尺")) {
						String meter = parmsService.ftToMeter(parm1);
						NormalCalUI.this.resultText.setText(meter);
					}
					if (NormalCalUI.this.parmName1.getText().equals("米")) {
						String ft = parmsService.meterToFeet(parm1);
						NormalCalUI.this.resultText.setText(ft);
					}
					if (NormalCalUI.this.parmName1.getText().equals("海里")) {
						String nm = parmsService.nmToKm(parm1);
						NormalCalUI.this.resultText.setText(nm);
					}
					if (NormalCalUI.this.parmName1.getText().equals("公里")) {
						String km = parmsService.kmToNm(parm1);
						NormalCalUI.this.resultText.setText(km);
					}
					if (NormalCalUI.this.parmName1.getText().equals("磅")) {
						String kg = parmsService.lbToKg(parm1);
						NormalCalUI.this.resultText.setText(kg);
					}
					if (NormalCalUI.this.parmName1.getText().equals("公斤")) {
						String lb = parmsService.kgToLb(parm1);
						NormalCalUI.this.resultText.setText(lb);
					}
					if (NormalCalUI.this.parmName1.getText().equals("小数格式")) {
						String dfm = parmsService.getDFM(parm1);
						NormalCalUI.this.resultText.setText(dfm);
					}
					if (NormalCalUI.this.parmName1.getText().equals("干跑道距离")) {
						String wet = parmsService.getWet(parm1);
						NormalCalUI.this.resultText.setText(wet);
					}
					if (NormalCalUI.this.parmName1.getText().equals("弧度")) {
						String angle = parmsService.rToAng(parm1);
						NormalCalUI.this.resultText.setText(angle);
					}
					if (NormalCalUI.this.parmName1.getText().equals("角度")) {
						String rad = parmsService.angToR(parm1);
						NormalCalUI.this.resultText.setText(rad);
					}

				}
				if ((NormalCalUI.this.parmName1.getText().equals("度-分-秒")) && (parm1.contains("-"))
						&& (!parm1.isEmpty())) {
					String[] split = parm1.split("-");
					boolean shuzi = true;
					for (int i = 0; i < split.length; i++) {
						if (!CommonUtils.ifStringIsDigital(split[i])) {
							shuzi = false;
						}
					}
					if (shuzi) {
						String decimal = parmsService.getDecimal(split[0], split[1], split[2]);
						NormalCalUI.this.resultText.setText(decimal);
					}
				}
				if ((CommonUtils.ifStringIsDigital(parm1)) && (!parm1.isEmpty())
						&& (CommonUtils.ifStringIsDigital(parm2)) && (!parm2.isEmpty())) {
					if (NormalCalUI.this.parmName1.getText().equals("ISA")) {
						String C = parmsService.isaToC(parm1, parm2, NormalCalUI.this.units);
						NormalCalUI.this.resultText.setText(C);
					}
					if (NormalCalUI.this.parmName1.getText().equals("C°")) {
						String ISA = parmsService.cToISA(parm1, parm2, NormalCalUI.this.units);
						NormalCalUI.this.resultText.setText(ISA);
					}
					if (NormalCalUI.this.parmName1.getText().equals("爬升率(ft/min)")) {
						String grad = parmsService.fpmToGrad(parm1, parm2);
						NormalCalUI.this.resultText.setText(grad);
					}
					if (NormalCalUI.this.parmName1.getText().equals("爬升梯度(%)")) {
						String fpm = parmsService.gradToFpm(parm1, parm2);
						NormalCalUI.this.resultText.setText(fpm);
					}
					if (NormalCalUI.this.parmName2.getText().equals("弧长")) {
						String result = parmsService.arcLengthToOther(parm1, parm2);
						String[] split = result.split("-");
						NormalCalUI.this.resultText.setText(split[0]);
						NormalCalUI.this.addResultText.setText(split[1]);
					}
					if (NormalCalUI.this.parmName2.getText().equals("夹角(°)")) {
						String result = parmsService.angleToOther(parm1, parm2);
						String[] split = result.split("-");
						NormalCalUI.this.resultText.setText(split[0]);
						NormalCalUI.this.addResultText.setText(split[1]);
					}
					if (NormalCalUI.this.parmName2.getText().equals("弦长")) {
						String result = parmsService.chordLengthToOther(parm1, parm2);
						String[] split = result.split("-");
						NormalCalUI.this.resultText.setText(split[0]);
						NormalCalUI.this.addResultText.setText(split[1]);
					}

				}
				if ((CommonUtils.ifStringIsDigital(parm1)) && (!parm1.isEmpty())
						&& (CommonUtils.ifStringIsDigital(parm2)) && (!parm2.isEmpty())
						&& (CommonUtils.ifStringIsDigital(parm3)) && (!parm3.isEmpty())) {
					if (NormalCalUI.this.parmName1.getText().equals("马赫速")) {
						String kmh = parmsService.mToKmh(parm1, NormalCalUI.this.units, parm2, parm3);
						String[] split = kmh.split("-");
						NormalCalUI.this.resultText.setText(split[1]);
						NormalCalUI.this.addResultText.setText(split[0]);
					}
					if (NormalCalUI.this.parmName1.getText().equals("公里每小时")) {
						String mach = parmsService.kmhToM(parm1, NormalCalUI.this.units, parm2, parm3);
						String[] split = mach.split("-");
						NormalCalUI.this.resultText.setText(split[1]);
						NormalCalUI.this.addResultText.setText(split[0]);
					}
					if ((NormalCalUI.this.parmName2.getText().equals("梯度(%)"))
							&& (NormalCalUI.this.resultName.getText().equals("高度/高"))) {
						String targetAlt = parmsService.getTargetAlt(parm1, parm3, parm2);
						NormalCalUI.this.resultText.setText(targetAlt);
					}
					if ((NormalCalUI.this.parmName2.getText().equals("高度"))
							&& (NormalCalUI.this.resultName.getText().equals("梯度(%)"))) {
						String grad = parmsService.getGrad(parm1, parm3, parm2);
						NormalCalUI.this.resultText.setText(grad);
					}
					if (NormalCalUI.this.resultName.getText().equals("到目标距离")) {
						String dist = parmsService.getDist(parm1, parm3, parm2);
						NormalCalUI.this.resultText.setText(dist);
					}
					if (NormalCalUI.this.parmName1.getText().equals("航迹长度")) {
						String width = parmsService.lengthToWidth(parm1, parm2, parm3);
						NormalCalUI.this.resultText.setText(width);
					}
					if (NormalCalUI.this.parmName1.getText().equals("保护区全宽")) {
						String length = parmsService.widthToLength(parm1, parm2, parm3);
						NormalCalUI.this.resultText.setText(length);
					}
					if (NormalCalUI.this.parmName1.getText().equals("IAS")) {
						String result = parmsService.iasToTas(parm1, parm2, parm3, engMenuItem.isSelected());
						String[] split = result.split("-");
						NormalCalUI.this.resultText.setText(split[0]);
						NormalCalUI.this.addResultText.setText(split[1]);
					}
				}
				if ((CommonUtils.ifStringIsDigital(parm1)) && (!parm1.isEmpty())
						&& (CommonUtils.ifStringIsDigital(parm2)) && (!parm2.isEmpty())
						&& (CommonUtils.ifStringIsDigital(parm3)) && (!parm3.isEmpty())
						&& (CommonUtils.ifStringIsDigital(parm4)) && (!parm4.isEmpty())
						&& (CommonUtils.ifStringIsDigital(parm5)) && (!parm5.isEmpty())
						&& (NormalCalUI.this.parmName3.getText().equals("目标数据"))) {
					String result = parmsService.chazhifa(parm1, parm2, parm4, parm5, parm3);
					NormalCalUI.this.resultText.setText(result);
				}
				if ((CommonUtils.ifStringIsDigital(parm1)) && (!parm1.isEmpty())
						&& (CommonUtils.ifStringIsDigital(parm2)) && (!parm2.isEmpty())
						&& (CommonUtils.ifStringIsDigital(parm3)) && (!parm3.isEmpty())
						&& (CommonUtils.ifStringIsDigital(parm4)) && (!parm4.isEmpty())
						&& (CommonUtils.ifStringIsDigital(parm5)) && (!parm5.isEmpty())
						&& (CommonUtils.ifStringIsDigital(parm6)) && (!parm6.isEmpty())
						&& (NormalCalUI.this.parmName4.getText().equals("改平高"))) {
					String result = parmsService.getObstacle(parm1, parm2, parm3, parm4, parm5, parm6,
							NormalCalUI.this.isTurn.isSelected());
					NormalCalUI.this.textArea.setText(result);
				}
				System.gc();
			}
		});
		this.calButton.setFont(new Font("新宋体", Font.PLAIN, 14));
		resultPanel.add(this.calButton);

		JButton returnButton = new JButton("返回");
		returnButton.setForeground(Color.MAGENTA);
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NormalCalUI.frame.dispose();
			}
		});
		returnButton.setBounds(377, 183, 127, 23);
		returnButton.setFont(new Font("新宋体", Font.PLAIN, 14));
		resultPanel.add(returnButton);
		this.clearButton.setFont(new Font("新宋体", Font.PLAIN, 14));
		this.clearButton.setBounds(377, 150, 127, 23);
		resultPanel.add(this.clearButton);

		this.changeButton = new JButton("转换");
		this.changeButton.setBounds(377, 117, 127, 23);

		this.changeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputTemp = NormalCalUI.this.parmName1.getText();
				String resultTemp = NormalCalUI.this.resultName.getText();
				NormalCalUI.this.parmName1.setText(resultTemp);
				NormalCalUI.this.resultName.setText(inputTemp);
			}
		});
		this.changeButton.setFont(new Font("新宋体", Font.PLAIN, 14));
		resultPanel.add(this.changeButton);

		this.addButton_1 = new JButton("");
		this.addButton_1.setForeground(Color.BLACK);
		this.addButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (NormalCalUI.this.obsMenuItem.isSelected()) {
					NormalCalUI.this.parmName2.setText("梯度(%)");
					NormalCalUI.this.parmName3.setText("高目标距离");
					NormalCalUI.this.resultName.setText("高度/高");
					NormalCalUI.this.clearButton.doClick();
				}
				if (NormalCalUI.this.ARCFunctionMenuItem.isSelected()) {
					NormalCalUI.this.parmName2.setText("弧长");
					NormalCalUI.this.resultName.setText("夹角(°)");
					NormalCalUI.this.addResultName.setText("弦长");
					NormalCalUI.this.clearButton.doClick();
				}
			}
		});
		this.addButton_1.setFont(new Font("新宋体", Font.PLAIN, 14));
		this.addButton_1.setBounds(377, 51, 127, 23);
		this.addButton_1.setVisible(false);
		resultPanel.add(this.addButton_1);

		this.addButton_2 = new JButton("");
		this.addButton_2.setForeground(Color.BLACK);
		this.addButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (NormalCalUI.this.obsMenuItem.isSelected()) {
					NormalCalUI.this.parmName2.setText("高度");
					NormalCalUI.this.parmName3.setText("梯度(%)");
					NormalCalUI.this.resultName.setText("到目标距离");
					NormalCalUI.this.clearButton.doClick();
				}
				if (NormalCalUI.this.ARCFunctionMenuItem.isSelected()) {
					NormalCalUI.this.parmName2.setText("夹角(°)");
					NormalCalUI.this.resultName.setText("弧长");
					NormalCalUI.this.addResultName.setText("弦长");
					NormalCalUI.this.clearButton.doClick();
				}
			}
		});
		this.addButton_2.setFont(new Font("新宋体", Font.PLAIN, 14));
		this.addButton_2.setBounds(377, 84, 127, 23);
		this.addButton_2.setVisible(false);
		resultPanel.add(this.addButton_2);

		this.addButton_3 = new JButton("");
		this.addButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (NormalCalUI.this.obsMenuItem.isSelected()) {
					NormalCalUI.this.parmName2.setText("高度");
					NormalCalUI.this.parmName3.setText("到目标距离");
					NormalCalUI.this.resultName.setText("梯度(%)");
					NormalCalUI.this.clearButton.doClick();
				}
				if (NormalCalUI.this.ARCFunctionMenuItem.isSelected()) {
					NormalCalUI.this.parmName2.setText("弦长");
					NormalCalUI.this.resultName.setText("弧长");
					NormalCalUI.this.addResultName.setText("夹角(°)");
					NormalCalUI.this.clearButton.doClick();
				}
			}
		});
		this.addButton_3.setForeground(Color.BLACK);
		this.addButton_3.setFont(new Font("新宋体", Font.PLAIN, 14));
		this.addButton_3.setBounds(377, 117, 127, 23);
		this.addButton_3.setVisible(false);
		resultPanel.add(this.addButton_3);

		this.textArea.setVisible(false);
		this.scrollPane.setVisible(false);
		KeyAdapter key = new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					NormalCalUI.this.calButton.doClick();
				}
				if (e.getKeyCode() == 16) {
					NormalCalUI.this.changeButton.doClick();
				}
			}
		};
		this.parmText1.addKeyListener(key);
		this.parmText2.addKeyListener(key);
		this.parmText3.addKeyListener(key);
		this.parmText4.addKeyListener(key);
		this.parmText5.addKeyListener(key);
		this.parmText6.addKeyListener(key);
	}

	public void actionPerformed(ActionEvent e) {
		JRadioButtonMenuItem temp = (JRadioButtonMenuItem) e.getSource();
		String inputName = temp.getText();
		if (temp.equals(this.standerdMenuItem)) {
			this.units = false;
		}
		if (temp.equals(this.engMenuItem)) {
			this.units = true;
		}
		if (this.units) {
			this.unitsMenu.setText("单位选择(ft)");
		} else {
			this.unitsMenu.setText("单位选择(m)");
		}
		if ((temp.equals(this.lengthMenuItem)) || (temp.equals(this.distMenuItem)) || (temp.equals(this.weightMenuItem))
				|| (temp.equals(this.jwdMenuItem)) || (temp.equals(this.angleMenuItem))) {
			this.clearButton.doClick();
			if (inputName.contains("/")) {
				String[] split = inputName.split("/");
				this.parmName1.setText(split[0]);
				this.resultName.setText(split[1]);
			}
			this.parmName2.setVisible(false);
			this.parmText2.setVisible(false);
			this.parmName3.setVisible(false);
			this.parmText3.setVisible(false);
			this.parmName4.setVisible(false);
			this.parmText4.setVisible(false);
			this.parmName5.setVisible(false);
			this.parmText5.setVisible(false);
			this.parmName6.setVisible(false);
			this.parmText6.setVisible(false);
			this.resultName.setVisible(true);
			this.resultText.setVisible(true);
			this.scrollPane.setVisible(false);
			this.textArea.setVisible(false);
			this.addResultName.setVisible(false);
			this.addResultText.setVisible(false);
			this.changeButton.setVisible(true);
			this.isTurn.setVisible(false);
			this.addButton_3.setVisible(false);
			this.addButton_2.setVisible(false);
			this.addButton_1.setVisible(false);
		}
		if (temp.equals(this.tempMenuItem)) {
			this.clearButton.doClick();
			if (inputName.contains("/")) {
				String[] split = inputName.split("/");
				this.parmName1.setText(split[0]);
				this.resultName.setText(split[1]);
			}
			this.parmName2.setVisible(true);
			this.parmText2.setVisible(true);
			this.parmName2.setText("高度");
			this.parmName3.setVisible(false);
			this.parmText3.setVisible(false);
			this.parmName4.setVisible(false);
			this.parmText4.setVisible(false);
			this.parmName5.setVisible(false);
			this.parmText5.setVisible(false);
			this.parmName6.setVisible(false);
			this.parmText6.setVisible(false);
			this.resultName.setVisible(true);
			this.resultText.setVisible(true);
			this.addResultName.setVisible(false);
			this.addResultText.setVisible(false);
			this.scrollPane.setVisible(false);
			this.textArea.setVisible(false);
			this.changeButton.setVisible(true);
			this.isTurn.setVisible(false);
			this.addButton_3.setVisible(false);
			this.addButton_2.setVisible(false);
			this.addButton_1.setVisible(false);
		}
		if (temp.equals(this.speedMenuItem)) {
			this.clearButton.doClick();
			if (inputName.contains("/")) {
				String[] split = inputName.split("/");
				this.parmName1.setText(split[0]);
				this.resultName.setText(split[1]);
			}
			this.parmName2.setVisible(true);
			this.parmText2.setVisible(true);
			this.parmName2.setText("高度");
			this.parmName3.setVisible(true);
			this.parmText3.setVisible(true);
			this.parmName4.setVisible(false);
			this.parmText4.setVisible(false);
			this.parmName5.setVisible(false);
			this.parmText5.setVisible(false);
			this.parmName6.setVisible(false);
			this.parmText6.setVisible(false);
			this.parmName3.setText("ISA");
			this.resultName.setVisible(true);
			this.resultText.setVisible(true);
			this.scrollPane.setVisible(false);
			this.textArea.setVisible(false);
			this.addResultName.setVisible(true);
			this.addResultName.setText("音速");
			this.addResultText.setVisible(true);
			this.changeButton.setVisible(true);
			this.isTurn.setVisible(false);
			this.addButton_3.setVisible(false);
			this.addButton_2.setVisible(false);
			this.addButton_1.setVisible(false);
		}
		if (temp.equals(this.climbMenuItem)) {
			this.clearButton.doClick();
			this.parmName1.setText("爬升率(ft/min)");
			this.parmName2.setVisible(true);
			this.parmText2.setVisible(true);
			this.parmName2.setText("TAS(kt)");
			this.parmName3.setVisible(false);
			this.parmText3.setVisible(false);
			this.parmName4.setVisible(false);
			this.parmText4.setVisible(false);
			this.parmName5.setVisible(false);
			this.parmText5.setVisible(false);
			this.parmName6.setVisible(false);
			this.parmText6.setVisible(false);
			this.resultName.setVisible(true);
			this.resultText.setVisible(true);
			this.resultName.setText("爬升梯度(%)");
			this.addResultName.setVisible(false);
			this.addResultText.setVisible(false);
			this.scrollPane.setVisible(false);
			this.textArea.setVisible(false);
			this.changeButton.setVisible(true);
			this.isTurn.setVisible(false);
			this.addButton_3.setVisible(false);
			this.addButton_2.setVisible(false);
			this.addButton_1.setVisible(false);
		}
		if (temp.equals(this.chazhifaMenuItem)) {
			this.clearButton.doClick();
			this.parmName1.setText("第一母数据");
			this.parmName2.setVisible(true);
			this.parmText2.setVisible(true);
			this.parmName2.setText("第二母数据");
			this.parmName3.setVisible(true);
			this.parmText3.setVisible(true);
			this.parmName3.setText("目标数据");
			this.parmName4.setVisible(true);
			this.parmText4.setVisible(true);
			this.parmName4.setText("第一子数据");
			this.parmName5.setVisible(true);
			this.parmText5.setVisible(true);
			this.parmName5.setText("第二子数据");
			this.parmName6.setVisible(false);
			this.parmText6.setVisible(false);
			this.resultName.setVisible(true);
			this.resultText.setVisible(true);
			this.addResultName.setVisible(false);
			this.addResultText.setVisible(false);
			this.scrollPane.setVisible(false);
			this.textArea.setVisible(false);
			this.resultName.setText("结果");
			this.changeButton.setVisible(false);
			this.isTurn.setVisible(false);
			this.addButton_3.setVisible(false);
			this.addButton_2.setVisible(false);
			this.addButton_1.setVisible(false);
		}
		if (temp.equals(this.obsMenuItem)) {
			this.clearButton.doClick();
			this.parmName1.setText("起始点高度");
			this.parmName2.setVisible(true);
			this.parmText2.setVisible(true);
			this.parmName2.setText("梯度(%)");
			this.parmName3.setVisible(true);
			this.parmText3.setVisible(true);
			this.parmName3.setText("到目标距离");
			this.parmName4.setVisible(false);
			this.parmText4.setVisible(false);
			this.parmName5.setVisible(false);
			this.parmText5.setVisible(false);
			this.parmName6.setVisible(false);
			this.parmText6.setVisible(false);
			this.resultName.setVisible(true);
			this.resultText.setVisible(true);
			this.addResultName.setVisible(false);
			this.addResultText.setVisible(false);
			this.scrollPane.setVisible(false);
			this.textArea.setVisible(false);
			this.resultName.setText("高度/高");
			this.changeButton.setVisible(false);
			this.isTurn.setVisible(false);
			this.addButton_3.setVisible(true);
			this.addButton_3.setText("获取梯度");
			this.addButton_2.setVisible(true);
			this.addButton_2.setText("获取距离");
			this.addButton_1.setVisible(true);
			this.addButton_1.setText("获取高度");
		}
		if (temp.equals(this.rwyCondMenuItem)) {
			this.clearButton.doClick();
			this.parmName1.setText("干跑道距离");
			this.parmName2.setVisible(false);
			this.parmText2.setVisible(false);
			this.parmName3.setVisible(false);
			this.parmText3.setVisible(false);
			this.parmName4.setVisible(false);
			this.parmText4.setVisible(false);
			this.parmName5.setVisible(false);
			this.parmText5.setVisible(false);
			this.parmName6.setVisible(false);
			this.parmText6.setVisible(false);
			this.resultName.setVisible(true);
			this.resultText.setVisible(true);
			this.addResultName.setVisible(false);
			this.addResultText.setVisible(false);
			this.scrollPane.setVisible(false);
			this.textArea.setVisible(false);
			this.resultName.setText("湿跑道距离");
			this.changeButton.setVisible(false);
			this.addButton_3.setVisible(false);
			this.addButton_2.setVisible(false);
			this.addButton_1.setVisible(false);
			this.isTurn.setVisible(false);
		}
		if (temp.equals(this.overOBSMenuItem)) {
			this.clearButton.doClick();
			this.parmName1.setText("REF0到35ft点距离");
			this.parmName2.setVisible(true);
			this.parmText2.setVisible(true);
			this.parmName2.setText("REF0距改平开始");
			this.parmName3.setVisible(true);
			this.parmText3.setVisible(true);
			this.parmName3.setText("REF0距改平结束");
			this.parmName4.setVisible(true);
			this.parmText4.setVisible(true);
			this.parmName4.setText("改平高");
			this.parmName5.setVisible(true);
			this.parmText5.setVisible(true);
			this.parmName5.setText("目标到REF0距离");
			this.parmName6.setVisible(true);
			this.parmText6.setVisible(true);
			this.parmName6.setText("在该点飞行总高");
			this.resultName.setVisible(false);
			this.resultText.setVisible(false);
			this.addResultName.setVisible(false);
			this.addResultText.setVisible(false);
			this.scrollPane.setVisible(true);
			this.textArea.setVisible(true);
			this.changeButton.setVisible(false);
			this.addButton_3.setVisible(false);
			this.addButton_2.setVisible(false);
			this.addButton_1.setVisible(false);
			this.isTurn.setVisible(true);
		}
		if (temp.equals(this.ARCFunctionMenuItem)) {
			this.clearButton.doClick();
			this.parmName1.setText("圆弧半径");
			this.parmName2.setVisible(true);
			this.parmText2.setVisible(true);
			this.parmName2.setText("弧长");
			this.parmName3.setVisible(false);
			this.parmText3.setVisible(false);
			this.parmName4.setVisible(false);
			this.parmText4.setVisible(false);
			this.parmName5.setVisible(false);
			this.parmText5.setVisible(false);
			this.parmName6.setVisible(false);
			this.parmText6.setVisible(false);
			this.resultName.setVisible(true);
			this.resultText.setVisible(true);
			this.addResultName.setVisible(true);
			this.addResultText.setVisible(true);
			this.scrollPane.setVisible(false);
			this.textArea.setVisible(false);
			this.resultName.setText("夹角(°)");
			this.addResultName.setText("弦长");
			this.changeButton.setVisible(false);
			this.isTurn.setVisible(false);
			this.addButton_3.setVisible(true);
			this.addButton_3.setText("已知弦长");
			this.addButton_2.setVisible(true);
			this.addButton_2.setText("已知夹角");
			this.addButton_1.setVisible(true);
			this.addButton_1.setText("已知弧长");
		}
		if (temp.equals(this.bhqMenuItem)) {
			this.clearButton.doClick();
			this.parmName1.setText("航迹长度");
			this.parmName2.setVisible(true);
			this.parmName2.setText("保护区起始半宽");
			this.parmText2.setVisible(true);
			this.parmName3.setText("保护区扩展率(%)");
			this.parmName3.setVisible(true);
			this.parmText3.setText("12.5");
			this.parmText3.setVisible(true);
			this.parmName4.setVisible(false);
			this.parmText4.setVisible(false);
			this.parmName5.setVisible(false);
			this.parmText5.setVisible(false);
			this.parmName6.setVisible(false);
			this.parmText6.setVisible(false);
			this.resultName.setVisible(true);
			this.resultText.setVisible(true);
			this.addResultName.setVisible(false);
			this.addResultText.setVisible(false);
			this.scrollPane.setVisible(false);
			this.textArea.setVisible(false);
			this.resultName.setText("保护区全宽");
			this.changeButton.setVisible(true);
			this.addButton_3.setVisible(false);
			this.addButton_2.setVisible(false);
			this.addButton_1.setVisible(false);
			this.isTurn.setVisible(false);

		}
		if (temp.equals(this.iastotas)) {
			this.clearButton.doClick();
			this.parmName1.setText("IAS");
			this.parmName2.setVisible(true);
			this.parmName2.setText("ISA偏差");
			this.parmText2.setVisible(true);
			this.parmName3.setText("高度");
			this.parmName3.setVisible(true);
			this.parmText3.setVisible(true);
			this.parmName4.setVisible(false);
			this.parmText4.setVisible(false);
			this.parmName5.setVisible(false);
			this.parmText5.setVisible(false);
			this.parmName6.setVisible(false);
			this.parmText6.setVisible(false);
			this.resultName.setVisible(true);
			this.resultText.setVisible(true);
			this.addResultName.setVisible(true);
			this.addResultName.setText("K值");
			this.addResultText.setVisible(true);
			this.scrollPane.setVisible(false);
			this.textArea.setVisible(false);
			this.resultName.setText("TAS");
			this.changeButton.setVisible(false);
			this.addButton_3.setVisible(false);
			this.addButton_2.setVisible(false);
			this.addButton_1.setVisible(false);
			this.isTurn.setVisible(false);

		}
	}
}

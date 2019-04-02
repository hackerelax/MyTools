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
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.cdbt.service.FuelCalParmsService;
import com.cdbt.utils.CommonUtils;

public class FuelCalculatorUI implements ActionListener {
	public static JFrame frame;
	private JTextField acText;
	private JTextField changeParmText;
	private JTextField cargoText;
	private JTextField passCountText;
	private JTextField descFText;
	private JTextField climbFText;
	private JTextField descDistText;
	private JTextField climbDistText;
	private JTextField climbTimeText;
	private FuelCalParmsService parms = new FuelCalParmsService();
	private ArrayList<String> acList = this.parms.getAC();
	private ArrayList<String> frList = this.parms.getFR();
	private ArrayList<String> passList = this.parms.getPass();
	private JTextField descTimeText;
	private JTextField cruiseTASText;
	private JTextField cruiseFuelflowText;
	private JTextField altDistText;
	private JTextArea basicContext;
	private JTextArea inputContext;
	private JTextArea distAndTimeContext;
	private JTextArea fuelConsumtionContext;
	private String yunying;
	private String flightRule;
	private JTextField altFuelFlowText;
	private JTextField altTASText;
	private JRadioButtonMenuItem weightToDistItem;
	private JRadioButtonMenuItem distToWeightItem;
	private JLabel changePram;
	private JLabel label_10;
	private JLabel altFFUnit;
	private JLabel cruseFFUnit;
	private JLabel changeParmUnit;
	private JRadioButtonMenuItem standerUnitItem;
	private JRadioButtonMenuItem engUnitItem;
	private JLabel passNumUnit;
	private JLabel cargoUnit;
	private JLabel climbFuelUnit;
	private JLabel climbDistUnit;
	private JLabel climbTimeUnit;
	private JLabel descFuelUnit;
	private JLabel descDistUnit;
	private JLabel descTimeUnit;
	private JLabel cruiseTASUnit;
	private JLabel altTASUnit;
	private JLabel altDistUnit;
	private JTextField aClimbFuelText;
	private JTextField aClimbDistText;
	private JTextField aClimbTimeText;
	private JTextField aDescTimeText;
	private JTextField aDescFText;
	private JTextField aDescDistText;
	private JCheckBox maxCrewCheck;
	private JCheckBox simpleCal;
	private JLabel aClimbFuelUnit;
	private JLabel aDescDistUnit;
	private JLabel aDescFuelUnit;
	private JLabel aClimbDistUnit;
	private JTextField waitFFText;
	private JLabel waitFFUnit;
	private JTextField crewWeghtText;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					FuelCalculatorUI window = new FuelCalculatorUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FuelCalculatorUI() {
		initialize();
		frame.setLocationRelativeTo(LoginUI.frame);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("微软雅黑", 0, 14));
		frame.setTitle("通航航程及油量分析");
		frame.setBounds(100, 100, 1130, 630);
		frame.setDefaultCloseOperation(2);
		frame.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1111, 21);
		frame.getContentPane().add(menuBar);

		JMenu acType = new JMenu("机型");
		acType.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		menuBar.add(acType);

		JMenu fr = new JMenu("飞行规则");
		fr.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		menuBar.add(fr);

		JMenu pass = new JMenu("机场分类");
		pass.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		menuBar.add(pass);

		JMenu modelMenu = new JMenu("计算模式");
		modelMenu.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		menuBar.add(modelMenu);

		this.weightToDistItem = new JRadioButtonMenuItem("已知重量求距离");
		this.weightToDistItem.setSelected(true);
		this.weightToDistItem.setHorizontalAlignment(0);
		this.weightToDistItem.setFont(new Font("微软雅黑", 0, 13));
		modelMenu.add(this.weightToDistItem);
		this.weightToDistItem.addActionListener(this);

		this.distToWeightItem = new JRadioButtonMenuItem("已知距离求重量");
		this.distToWeightItem.setHorizontalAlignment(0);
		this.distToWeightItem.setFont(new Font("微软雅黑", 0, 13));
		modelMenu.add(this.distToWeightItem);
		this.distToWeightItem.addActionListener(this);

		JMenu unitMenu = new JMenu("单位选择");
		unitMenu.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		menuBar.add(unitMenu);

		this.engUnitItem = new JRadioButtonMenuItem("英制单位");
		this.engUnitItem.setSelected(true);
		this.engUnitItem.setHorizontalAlignment(0);
		this.engUnitItem.setFont(new Font("微软雅黑", 0, 13));
		unitMenu.add(this.engUnitItem);
		this.engUnitItem.addActionListener(this);

		this.standerUnitItem = new JRadioButtonMenuItem("公制单位");
		this.standerUnitItem.setHorizontalAlignment(0);
		this.standerUnitItem.setFont(new Font("微软雅黑", 0, 13));
		unitMenu.add(this.standerUnitItem);
		this.standerUnitItem.addActionListener(this);

		ButtonGroup unitGroup = new ButtonGroup();
		unitGroup.add(this.standerUnitItem);
		unitGroup.add(this.engUnitItem);

		JMenu acAdmin = new JMenu("机型管理");
		acAdmin.setEnabled(false);
		acAdmin.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		menuBar.add(acAdmin);

		JMenuItem add = new JMenuItem("添加机型");
		add.setFont(new Font("微软雅黑", 0, 13));
		add.setHorizontalAlignment(0);
		acAdmin.add(add);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ACAddUI.main(null);
			}
		});
		JMenuItem edite = new JMenuItem("修改机型");
		edite.setFont(new Font("微软雅黑", 0, 13));
		edite.setHorizontalAlignment(0);
		acAdmin.add(edite);
		edite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ACEditeUI.main(null);
			}
		});
		JMenuItem delete = new JMenuItem("删除机型");
		delete.setFont(new Font("微软雅黑", 0, 13));
		delete.setHorizontalAlignment(0);
		acAdmin.add(delete);
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ACDeleUI.main(null);
			}
		});
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(Color.LIGHT_GRAY);
		titlePanel.setBounds(10, 130, 837, 33);
		frame.getContentPane().add(titlePanel);
		titlePanel.setLayout(null);

		JLabel climbF = new JLabel("爬升油量");
		climbF.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		climbF.setHorizontalAlignment(0);
		climbF.setForeground(Color.BLUE);
		climbF.setBounds(100, 10, 80, 15);
		titlePanel.add(climbF);

		JLabel climbDist = new JLabel("爬升距离");
		climbDist.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		climbDist.setHorizontalAlignment(0);
		climbDist.setForeground(Color.BLUE);
		climbDist.setBounds(190, 10, 80, 15);
		titlePanel.add(climbDist);

		JLabel climbTime_1 = new JLabel("爬升时间");
		climbTime_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		climbTime_1.setHorizontalAlignment(0);
		climbTime_1.setForeground(Color.BLUE);
		climbTime_1.setBounds(280, 10, 80, 15);
		titlePanel.add(climbTime_1);

		JLabel descF = new JLabel("下降油量");
		descF.setBounds(370, 10, 80, 15);
		titlePanel.add(descF);
		descF.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		descF.setHorizontalAlignment(0);
		descF.setForeground(Color.BLUE);

		JLabel descDist_1 = new JLabel("下降距离");
		descDist_1.setBounds(460, 10, 80, 15);
		titlePanel.add(descDist_1);
		descDist_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		descDist_1.setHorizontalAlignment(0);
		descDist_1.setForeground(Color.BLUE);

		JLabel descTime_1 = new JLabel("下降时间");
		descTime_1.setBounds(550, 10, 80, 15);
		titlePanel.add(descTime_1);
		descTime_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		descTime_1.setHorizontalAlignment(0);
		descTime_1.setForeground(Color.BLUE);

		JLabel TAS = new JLabel("巡航真空速");
		TAS.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		TAS.setBounds(640, 10, 80, 15);
		titlePanel.add(TAS);
		TAS.setHorizontalAlignment(0);
		TAS.setForeground(Color.BLUE);

		JLabel fuelflow = new JLabel("巡航油耗");
		fuelflow.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		fuelflow.setBounds(730, 10, 80, 15);
		titlePanel.add(fuelflow);
		fuelflow.setHorizontalAlignment(0);
		fuelflow.setForeground(Color.BLUE);

		JPanel unitsPanel = new JPanel();
		unitsPanel.setLayout(null);
		unitsPanel.setBackground(Color.LIGHT_GRAY);
		unitsPanel.setBounds(10, 200, 837, 33);
		frame.getContentPane().add(unitsPanel);

		JLabel label_1 = new JLabel("单位");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_1.setHorizontalAlignment(0);
		label_1.setForeground(Color.RED);
		label_1.setBounds(10, 10, 80, 15);
		unitsPanel.add(label_1);

		this.climbFuelUnit = new JLabel("lb");
		this.climbFuelUnit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.climbFuelUnit.setHorizontalAlignment(0);
		this.climbFuelUnit.setForeground(Color.RED);
		this.climbFuelUnit.setBounds(100, 10, 80, 15);
		unitsPanel.add(this.climbFuelUnit);

		this.climbDistUnit = new JLabel("nm");
		this.climbDistUnit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.climbDistUnit.setHorizontalAlignment(0);
		this.climbDistUnit.setForeground(Color.RED);
		this.climbDistUnit.setBounds(190, 10, 80, 15);
		unitsPanel.add(this.climbDistUnit);

		this.climbTimeUnit = new JLabel("min");
		this.climbTimeUnit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.climbTimeUnit.setHorizontalAlignment(0);
		this.climbTimeUnit.setForeground(Color.RED);
		this.climbTimeUnit.setBounds(280, 10, 80, 15);
		unitsPanel.add(this.climbTimeUnit);

		this.descFuelUnit = new JLabel("lb");
		this.descFuelUnit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.descFuelUnit.setHorizontalAlignment(0);
		this.descFuelUnit.setForeground(Color.RED);
		this.descFuelUnit.setBounds(370, 10, 80, 15);
		unitsPanel.add(this.descFuelUnit);

		this.descDistUnit = new JLabel("nm");
		this.descDistUnit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.descDistUnit.setHorizontalAlignment(0);
		this.descDistUnit.setForeground(Color.RED);
		this.descDistUnit.setBounds(460, 10, 80, 15);
		unitsPanel.add(this.descDistUnit);

		this.descTimeUnit = new JLabel("min");
		this.descTimeUnit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.descTimeUnit.setHorizontalAlignment(0);
		this.descTimeUnit.setForeground(Color.RED);
		this.descTimeUnit.setBounds(550, 10, 80, 15);
		unitsPanel.add(this.descTimeUnit);

		this.cruiseTASUnit = new JLabel("knots");
		this.cruiseTASUnit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.cruiseTASUnit.setHorizontalAlignment(0);
		this.cruiseTASUnit.setForeground(Color.RED);
		this.cruiseTASUnit.setBounds(640, 10, 80, 15);
		unitsPanel.add(this.cruiseTASUnit);

		this.cruseFFUnit = new JLabel("lb/Hr");
		this.cruseFFUnit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.cruseFFUnit.setBounds(730, 10, 80, 15);
		unitsPanel.add(this.cruseFFUnit);
		this.cruseFFUnit.setHorizontalAlignment(0);
		this.cruseFFUnit.setForeground(Color.RED);

		JPanel inputPanel = new JPanel();
		inputPanel.setBackground(Color.DARK_GRAY);
		inputPanel.setBounds(10, 161, 837, 40);
		frame.getContentPane().add(inputPanel);
		inputPanel.setLayout(null);

		this.climbFText = new JTextField();
		this.climbFText.setFont(new Font("Times New Roman", 0, 12));
		this.climbFText.setHorizontalAlignment(0);
		this.climbFText.setColumns(10);
		this.climbFText.setBounds(100, 10, 80, 21);
		inputPanel.add(this.climbFText);
		this.climbFText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				FuelCalculatorUI.this.climbFText.selectAll();
			}
		});
		this.climbDistText = new JTextField();
		this.climbDistText.setFont(new Font("Times New Roman", 0, 12));
		this.climbDistText.setHorizontalAlignment(0);
		this.climbDistText.setColumns(10);
		this.climbDistText.setBounds(190, 10, 80, 21);
		inputPanel.add(this.climbDistText);
		this.climbDistText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				FuelCalculatorUI.this.climbDistText.selectAll();
			}
		});
		this.climbTimeText = new JTextField();
		this.climbTimeText.setFont(new Font("Times New Roman", 0, 12));
		this.climbTimeText.setHorizontalAlignment(0);
		this.climbTimeText.setColumns(10);
		this.climbTimeText.setBounds(280, 10, 80, 21);
		inputPanel.add(this.climbTimeText);
		this.climbTimeText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				FuelCalculatorUI.this.climbTimeText.selectAll();
			}
		});
		this.cruiseTASText = new JTextField();
		this.cruiseTASText.setFont(new Font("Times New Roman", 0, 12));
		this.cruiseTASText.setHorizontalAlignment(0);
		this.cruiseTASText.setColumns(10);
		this.cruiseTASText.setBounds(640, 10, 80, 21);
		inputPanel.add(this.cruiseTASText);
		this.cruiseTASText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				FuelCalculatorUI.this.cruiseTASText.selectAll();
			}
		});
		this.cruiseFuelflowText = new JTextField();
		this.cruiseFuelflowText.setFont(new Font("Times New Roman", 0, 12));
		this.cruiseFuelflowText.setHorizontalAlignment(0);
		this.cruiseFuelflowText.setColumns(10);
		this.cruiseFuelflowText.setBounds(730, 10, 80, 21);
		inputPanel.add(this.cruiseFuelflowText);
		this.cruiseFuelflowText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				FuelCalculatorUI.this.cruiseFuelflowText.selectAll();
			}
		});
		this.descTimeText = new JTextField();
		this.descTimeText.setBounds(550, 10, 80, 21);
		inputPanel.add(this.descTimeText);
		this.descTimeText.setFont(new Font("Times New Roman", 0, 12));
		this.descTimeText.setHorizontalAlignment(0);
		this.descTimeText.setColumns(10);
		this.descTimeText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				FuelCalculatorUI.this.descTimeText.selectAll();
			}
		});
		this.descFText = new JTextField();
		this.descFText.setBounds(370, 10, 80, 21);
		inputPanel.add(this.descFText);
		this.descFText.setFont(new Font("Times New Roman", 0, 12));
		this.descFText.setHorizontalAlignment(0);
		this.descFText.setColumns(10);
		this.descFText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				FuelCalculatorUI.this.descFText.selectAll();
			}
		});
		this.descDistText = new JTextField();
		this.descDistText.setBounds(459, 10, 80, 21);
		inputPanel.add(this.descDistText);
		this.descDistText.setFont(new Font("Times New Roman", 0, 12));
		this.descDistText.setHorizontalAlignment(0);
		this.descDistText.setColumns(10);

		JLabel label_3 = new JLabel("主航程");
		label_3.setHorizontalAlignment(0);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_3.setBounds(10, 12, 80, 15);
		inputPanel.add(label_3);
		this.descDistText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				FuelCalculatorUI.this.descDistText.selectAll();
			}
		});
		JPanel resultPanel = new JPanel();
		resultPanel.setBackground(Color.DARK_GRAY);
		resultPanel.setBounds(10, 380, 1097, 204);
		frame.getContentPane().add(resultPanel);
		resultPanel.setLayout(null);

		final JButton countButton = new JButton("计算");
		countButton.setBounds(266, 68, 103, 25);
		resultPanel.add(countButton);
		countButton.setForeground(Color.RED);
		countButton.setFont(new Font("新宋体", Font.PLAIN, 14));

		JButton clearButton = new JButton("重置");
		clearButton.setBounds(266, 140, 103, 23);
		resultPanel.add(clearButton);
		clearButton.setForeground(Color.BLUE);
		clearButton.setFont(new Font("新宋体", Font.PLAIN, 14));
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuelCalculatorUI.frame.dispose();
				FuelCalculatorUI.main(null);
			}
		});
		JButton returnButton = new JButton("返回");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuelCalculatorUI.frame.dispose();
			}
		});
		returnButton.setForeground(Color.MAGENTA);
		returnButton.setFont(new Font("新宋体", Font.PLAIN, 14));
		returnButton.setBounds(266, 173, 103, 23);
		resultPanel.add(returnButton);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 246, 186);
		resultPanel.add(scrollPane_1);

		this.inputContext = new JTextArea();
		this.inputContext.setEditable(false);
		scrollPane_1.setViewportView(this.inputContext);
		this.inputContext.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		this.inputContext.setLineWrap(true);
		this.inputContext.setForeground(Color.BLACK);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(379, 10, 350, 186);
		resultPanel.add(scrollPane_2);

		this.distAndTimeContext = new JTextArea();
		this.distAndTimeContext.setEditable(false);
		scrollPane_2.setViewportView(this.distAndTimeContext);
		this.distAndTimeContext.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		this.distAndTimeContext.setLineWrap(true);
		this.distAndTimeContext.setForeground(Color.BLACK);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(739, 10, 348, 186);
		resultPanel.add(scrollPane_3);

		this.fuelConsumtionContext = new JTextArea();
		this.fuelConsumtionContext.setEditable(false);
		scrollPane_3.setViewportView(this.fuelConsumtionContext);
		this.fuelConsumtionContext.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		this.fuelConsumtionContext.setLineWrap(true);
		this.fuelConsumtionContext.setForeground(Color.BLACK);

		this.simpleCal = new JCheckBox("简单计算");
		this.simpleCal.setBounds(266, 12, 103, 23);
		resultPanel.add(this.simpleCal);
		this.simpleCal.setSelected(true);
		this.simpleCal.setHorizontalAlignment(0);
		this.simpleCal.setFont(new Font("新宋体", Font.PLAIN, 12));

		JButton transButton = new JButton("换算工具");
		transButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NormalCalUI.main(null);
			}
		});
		transButton.setForeground(Color.MAGENTA);
		transButton.setFont(new Font("新宋体", Font.PLAIN, 14));
		transButton.setBounds(266, 103, 103, 25);
		resultPanel.add(transButton);

		this.maxCrewCheck = new JCheckBox("最大机组人数");
		this.maxCrewCheck.setBounds(266, 39, 103, 23);
		resultPanel.add(this.maxCrewCheck);
		this.maxCrewCheck.setHorizontalAlignment(0);
		this.maxCrewCheck.setFont(new Font("新宋体", Font.PLAIN, 12));
		this.simpleCal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (FuelCalculatorUI.this.simpleCal.isSelected()) {
					FuelCalculatorUI.this.aClimbFuelText.setVisible(false);
					FuelCalculatorUI.this.aClimbDistText.setVisible(false);
					FuelCalculatorUI.this.aClimbTimeText.setVisible(false);
					FuelCalculatorUI.this.aDescFText.setVisible(false);
					FuelCalculatorUI.this.aDescDistText.setVisible(false);
					FuelCalculatorUI.this.aDescTimeText.setVisible(false);
				} else {
					FuelCalculatorUI.this.aClimbFuelText.setVisible(true);
					FuelCalculatorUI.this.aClimbDistText.setVisible(true);
					FuelCalculatorUI.this.aClimbTimeText.setVisible(true);
					FuelCalculatorUI.this.aDescFText.setVisible(true);
					FuelCalculatorUI.this.aDescDistText.setVisible(true);
					FuelCalculatorUI.this.aDescTimeText.setVisible(true);
				}
			}
		});
		countButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ac = FuelCalculatorUI.this.acText.getText().trim();
				String changeParm = FuelCalculatorUI.this.changeParmText.getText().trim();
				String passCount = FuelCalculatorUI.this.passCountText.getText().trim();
				String cargo = FuelCalculatorUI.this.cargoText.getText().trim();
				String climbFuel = FuelCalculatorUI.this.climbFText.getText().trim();
				String climbDist = FuelCalculatorUI.this.climbDistText.getText().trim();
				String climbTime = FuelCalculatorUI.this.climbTimeText.getText().trim();
				String descFuel = FuelCalculatorUI.this.descFText.getText().trim();
				String descDist = FuelCalculatorUI.this.descDistText.getText().trim();
				String descTime = FuelCalculatorUI.this.descTimeText.getText().trim();
				String cruiseTAS = FuelCalculatorUI.this.cruiseTASText.getText().trim();
				String cruiseFuelflow = FuelCalculatorUI.this.cruiseFuelflowText.getText().trim();
				String altTAS = FuelCalculatorUI.this.altTASText.getText().trim();
				String altFuelflow = FuelCalculatorUI.this.altFuelFlowText.getText().trim();
				String altDist = FuelCalculatorUI.this.altDistText.getText().trim();
				String waiFuelflow = FuelCalculatorUI.this.waitFFText.getText().trim();
				String crewWt = FuelCalculatorUI.this.crewWeghtText.getText().trim();
				String altClimbTime;
				String altDescFuel;
				String altDescDist;
				String altDescTime;
				String altClimbFuel;
				String altClimbDist;
				if (FuelCalculatorUI.this.simpleCal.isSelected()) {
					altDescFuel = descFuel;
					altDescDist = descDist;
					altDescTime = descTime;
					altClimbFuel = climbFuel;
					altClimbDist = climbDist;
					altClimbTime = climbTime;
				} else {
					altDescFuel = FuelCalculatorUI.this.aDescFText.getText().trim();
					altDescDist = FuelCalculatorUI.this.aDescDistText.getText().trim();
					altDescTime = FuelCalculatorUI.this.aDescTimeText.getText().trim();
					altClimbFuel = FuelCalculatorUI.this.aClimbFuelText.getText().trim();
					altClimbDist = FuelCalculatorUI.this.aClimbDistText.getText().trim();
					altClimbTime = FuelCalculatorUI.this.aClimbTimeText.getText().trim();
				}
				if (ac.isEmpty()) {
					FuelCalculatorUI.this.distAndTimeContext.setText("请选择机型");
					FuelCalculatorUI.this.fuelConsumtionContext.setText("请选择机型");
				} else if ((changeParm.isEmpty()) || (passCount.isEmpty()) || (cargo.isEmpty()) || (climbFuel.isEmpty())
						|| (descFuel.isEmpty()) || (climbDist.isEmpty()) || (descDist.isEmpty())
						|| (climbTime.isEmpty()) || (descTime.isEmpty()) || (cruiseTAS.isEmpty())
						|| (cruiseFuelflow.isEmpty()) || (altClimbFuel.isEmpty()) || (altDescFuel.isEmpty())
						|| (altClimbDist.isEmpty()) || (altDescDist.isEmpty()) || (altClimbTime.isEmpty())
						|| (altDescTime.isEmpty()) || (altTAS.isEmpty()) || (altFuelflow.isEmpty())
						|| (altDist.isEmpty()) || (waiFuelflow.isEmpty())) {
					FuelCalculatorUI.this.distAndTimeContext.setText("请输入完整！");
					FuelCalculatorUI.this.fuelConsumtionContext.setText("请输入完整！");
				} else if ((CommonUtils.ifStringIsDigital(changeParm)) && (CommonUtils.ifStringIsInteger(passCount))
						&& (CommonUtils.ifStringIsDigital(cargo)) && (CommonUtils.ifStringIsDigital(climbFuel))
						&& (CommonUtils.ifStringIsDigital(descFuel)) && (CommonUtils.ifStringIsDigital(climbDist))
						&& (CommonUtils.ifStringIsDigital(descDist)) && (CommonUtils.ifStringIsDigital(climbTime))
						&& (CommonUtils.ifStringIsDigital(descTime)) && (CommonUtils.ifStringIsDigital(cruiseTAS))
						&& (CommonUtils.ifStringIsDigital(cruiseFuelflow)) && (CommonUtils.ifStringIsDigital(altTAS))
						&& (CommonUtils.ifStringIsDigital(altFuelflow)) && (CommonUtils.ifStringIsDigital(altDist))
						&& (CommonUtils.ifStringIsDigital(altClimbFuel)) && (CommonUtils.ifStringIsDigital(altDescFuel))
						&& (CommonUtils.ifStringIsDigital(altClimbDist)) && (CommonUtils.ifStringIsDigital(altDescDist))
						&& (CommonUtils.ifStringIsDigital(altClimbTime)) && (CommonUtils.ifStringIsDigital(altDescTime))
						&& (CommonUtils.ifStringIsDigital(waiFuelflow))) {
					if (FuelCalculatorUI.this.changePram.getText().equals("起飞重量")) {
						String input = FuelCalculatorUI.this.parms.getDistInputInfo(changeParm, passCount, cargo,
								climbFuel, descFuel, climbDist, descDist, climbTime, descTime, cruiseTAS,
								cruiseFuelflow, altClimbFuel, altDescFuel, altClimbDist, altDescDist, altClimbTime,
								altDescTime, altTAS, altFuelflow, altDist, waiFuelflow, FuelCalculatorUI.this.yunying,
								FuelCalculatorUI.this.flightRule, FuelCalculatorUI.this.maxCrewCheck.isSelected(),
								crewWt);
						FuelCalculatorUI.this.inputContext.setText(input);

						String result = FuelCalculatorUI.this.parms.getDistResult(changeParm, passCount, cargo,
								climbFuel, descFuel, climbDist, descDist, climbTime, descTime, cruiseTAS,
								cruiseFuelflow, altClimbFuel, altDescFuel, altClimbDist, altDescDist, altClimbTime,
								altDescTime, altTAS, altFuelflow, altDist, waiFuelflow,
								FuelCalculatorUI.this.maxCrewCheck.isSelected(),
								FuelCalculatorUI.this.engUnitItem.isSelected(), crewWt);

						String[] split = result.split(",");
						FuelCalculatorUI.this.distAndTimeContext.setText(split[0]);
						FuelCalculatorUI.this.fuelConsumtionContext.setText(split[1]);
					}
					if (FuelCalculatorUI.this.changePram.getText().equals("主航程距离")) {
						String input = FuelCalculatorUI.this.parms.getWeightInputInfo(changeParm, passCount, cargo,
								climbFuel, descFuel, climbDist, descDist, climbTime, descTime, cruiseTAS,
								cruiseFuelflow, altClimbFuel, altDescFuel, altClimbDist, altDescDist, altClimbTime,
								altDescTime, altTAS, altFuelflow, altDist, waiFuelflow, FuelCalculatorUI.this.yunying,
								FuelCalculatorUI.this.flightRule, FuelCalculatorUI.this.maxCrewCheck.isSelected(),
								crewWt);
						FuelCalculatorUI.this.inputContext.setText(input);

						String result = FuelCalculatorUI.this.parms.getWeightResult(changeParm, passCount, cargo,
								climbFuel, descFuel, climbDist, descDist, climbTime, descTime, cruiseTAS,
								cruiseFuelflow, altClimbFuel, altDescFuel, altClimbDist, altDescDist, altClimbTime,
								altDescTime, altTAS, altFuelflow, altDist, waiFuelflow,
								FuelCalculatorUI.this.maxCrewCheck.isSelected(),
								FuelCalculatorUI.this.engUnitItem.isSelected(), crewWt);

						String[] split = result.split(",");
						FuelCalculatorUI.this.distAndTimeContext.setText(split[0]);
						FuelCalculatorUI.this.fuelConsumtionContext.setText(split[1]);
					}
				} else {
					FuelCalculatorUI.this.distAndTimeContext.setText("不要乱搞！");
					FuelCalculatorUI.this.fuelConsumtionContext.setText("不要乱搞！");
				}
				System.gc();
			}
		});
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 347, 1097, 33);
		frame.getContentPane().add(panel);

		JLabel label_7 = new JLabel("重要输入信息");
		label_7.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_7.setHorizontalAlignment(0);
		label_7.setForeground(Color.BLUE);
		label_7.setBounds(10, 10, 243, 15);
		panel.add(label_7);

		this.label_10 = new JLabel("距离和时间相关结果");
		this.label_10.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		this.label_10.setHorizontalAlignment(0);
		this.label_10.setForeground(Color.BLUE);
		this.label_10.setBounds(380, 10, 350, 15);
		panel.add(this.label_10);

		JLabel label_11 = new JLabel("油耗相关结果");
		label_11.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_11.setHorizontalAlignment(0);
		label_11.setForeground(Color.BLUE);
		label_11.setBounds(740, 10, 350, 15);
		panel.add(label_11);

		ButtonGroup acGroup = new ButtonGroup();
		for (int i = 0; i < this.acList.size(); i++) {
			String temp = (String) this.acList.get(i);
			String[] split = temp.split("-");
			JRadioButtonMenuItem actpye = new JRadioButtonMenuItem(split[0]);
			actpye.setFont(new Font("微软雅黑", 0, 13));
			acType.add(actpye);
			acGroup.add(actpye);
			actpye.addActionListener(this);
		}
		ButtonGroup frGroup = new ButtonGroup();
		for (int i = 0; i < this.frList.size(); i++) {
			String temp = (String) this.frList.get(i);
			String[] split = temp.split("-");
			JRadioButtonMenuItem flightrule = new JRadioButtonMenuItem(split[0]);
			flightrule.setFont(new Font("微软雅黑", 0, 13));
			fr.add(flightrule);
			frGroup.add(flightrule);
			flightrule.addActionListener(this);
			if (i == 0) {
				flightrule.setSelected(true);
			}
		}
		ButtonGroup passGroup = new ButtonGroup();
		for (int i = 0; i < this.passList.size(); i++) {
			String temp = (String) this.passList.get(i);
			String[] split = temp.split("-");
			JRadioButtonMenuItem passenger = new JRadioButtonMenuItem(split[0]);
			passenger.setFont(new Font("微软雅黑", 0, 13));
			pass.add(passenger);
			passGroup.add(passenger);
			passenger.addActionListener(this);
			if (i == 0) {
				passenger.setSelected(true);
			}
		}
		ButtonGroup modelGroup = new ButtonGroup();
		modelGroup.add(this.weightToDistItem);
		modelGroup.add(this.distToWeightItem);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 234, 837, 33);
		frame.getContentPane().add(panel_1);

		JLabel label_12 = new JLabel("爬升油量");
		label_12.setHorizontalAlignment(0);
		label_12.setForeground(Color.BLUE);
		label_12.setFont(new Font("微软雅黑", 0, 14));
		label_12.setBounds(100, 10, 80, 15);
		panel_1.add(label_12);

		JLabel label_13 = new JLabel("爬升距离");
		label_13.setHorizontalAlignment(0);
		label_13.setForeground(Color.BLUE);
		label_13.setFont(new Font("微软雅黑", 0, 14));
		label_13.setBounds(190, 10, 80, 15);
		panel_1.add(label_13);

		JLabel label_14 = new JLabel("爬升时间");
		label_14.setHorizontalAlignment(0);
		label_14.setForeground(Color.BLUE);
		label_14.setFont(new Font("微软雅黑", 0, 14));
		label_14.setBounds(280, 10, 80, 15);
		panel_1.add(label_14);

		JLabel label_15 = new JLabel("下降油量");
		label_15.setHorizontalAlignment(0);
		label_15.setForeground(Color.BLUE);
		label_15.setFont(new Font("微软雅黑", 0, 14));
		label_15.setBounds(370, 10, 80, 15);
		panel_1.add(label_15);

		JLabel label_16 = new JLabel("下降距离");
		label_16.setHorizontalAlignment(0);
		label_16.setForeground(Color.BLUE);
		label_16.setFont(new Font("微软雅黑", 0, 14));
		label_16.setBounds(460, 10, 80, 15);
		panel_1.add(label_16);

		JLabel label_17 = new JLabel("下降时间");
		label_17.setHorizontalAlignment(0);
		label_17.setForeground(Color.BLUE);
		label_17.setFont(new Font("微软雅黑", 0, 14));
		label_17.setBounds(550, 10, 80, 15);
		panel_1.add(label_17);

		JLabel label_2 = new JLabel("备降真空速");
		label_2.setBounds(640, 10, 80, 15);
		panel_1.add(label_2);
		label_2.setHorizontalAlignment(0);
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("微软雅黑", 0, 14));

		JLabel label_4 = new JLabel("备降油耗");
		label_4.setBounds(730, 10, 80, 15);
		panel_1.add(label_4);
		label_4.setHorizontalAlignment(0);
		label_4.setForeground(Color.BLUE);
		label_4.setFont(new Font("微软雅黑", 0, 14));

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(10, 265, 837, 40);
		frame.getContentPane().add(panel_2);
		KeyAdapter key = new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					countButton.doClick();
				}
			}
		};
		this.aClimbFuelText = new JTextField();
		this.aClimbFuelText.setHorizontalAlignment(0);
		this.aClimbFuelText.setFont(new Font("Times New Roman", 0, 12));
		this.aClimbFuelText.setColumns(10);
		this.aClimbFuelText.setBounds(100, 10, 80, 21);
		this.aClimbFuelText.setVisible(false);
		panel_2.add(this.aClimbFuelText);
		this.aClimbFuelText.addKeyListener(key);
		this.aClimbFuelText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				FuelCalculatorUI.this.aClimbFuelText.selectAll();
			}
		});
		this.aClimbDistText = new JTextField();
		this.aClimbDistText.setHorizontalAlignment(0);
		this.aClimbDistText.setFont(new Font("Times New Roman", 0, 12));
		this.aClimbDistText.setColumns(10);
		this.aClimbDistText.setBounds(190, 10, 80, 21);
		this.aClimbDistText.setVisible(false);
		panel_2.add(this.aClimbDistText);
		this.aClimbDistText.addKeyListener(key);
		this.aClimbDistText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				FuelCalculatorUI.this.aClimbDistText.selectAll();
			}
		});
		this.aClimbTimeText = new JTextField();
		this.aClimbTimeText.setHorizontalAlignment(0);
		this.aClimbTimeText.setFont(new Font("Times New Roman", 0, 12));
		this.aClimbTimeText.setColumns(10);
		this.aClimbTimeText.setBounds(280, 10, 80, 21);
		this.aClimbTimeText.setVisible(false);
		panel_2.add(this.aClimbTimeText);
		this.aClimbTimeText.addKeyListener(key);
		this.aClimbTimeText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				FuelCalculatorUI.this.aClimbTimeText.selectAll();
			}
		});
		this.aDescTimeText = new JTextField();
		this.aDescTimeText.setHorizontalAlignment(0);
		this.aDescTimeText.setFont(new Font("Times New Roman", 0, 12));
		this.aDescTimeText.setColumns(10);
		this.aDescTimeText.setBounds(550, 10, 80, 21);
		this.aDescTimeText.setVisible(false);
		panel_2.add(this.aDescTimeText);
		this.aDescTimeText.addKeyListener(key);
		this.aDescTimeText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				FuelCalculatorUI.this.aDescTimeText.selectAll();
			}
		});
		this.aDescFText = new JTextField();
		this.aDescFText.setHorizontalAlignment(0);
		this.aDescFText.setFont(new Font("Times New Roman", 0, 12));
		this.aDescFText.setColumns(10);
		this.aDescFText.setBounds(370, 10, 80, 21);
		this.aDescFText.setVisible(false);
		panel_2.add(this.aDescFText);
		this.aDescFText.addKeyListener(key);
		this.aDescFText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				FuelCalculatorUI.this.aDescFText.selectAll();
			}
		});
		this.aDescDistText = new JTextField();
		this.aDescDistText.setHorizontalAlignment(0);
		this.aDescDistText.setFont(new Font("Times New Roman", 0, 12));
		this.aDescDistText.setColumns(10);
		this.aDescDistText.setBounds(460, 10, 80, 21);
		this.aDescDistText.setVisible(false);
		panel_2.add(this.aDescDistText);
		this.aDescDistText.addKeyListener(key);
		this.aDescDistText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				FuelCalculatorUI.this.aDescDistText.selectAll();
			}
		});
		JLabel label_6 = new JLabel("备降航程");
		label_6.setHorizontalAlignment(0);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_6.setBounds(10, 12, 80, 15);
		panel_2.add(label_6);

		this.altTASText = new JTextField();
		this.altTASText.setBounds(640, 10, 80, 21);
		panel_2.add(this.altTASText);
		this.altTASText.setHorizontalAlignment(0);
		this.altTASText.setFont(new Font("Times New Roman", 0, 12));
		this.altTASText.setColumns(10);

		this.altFuelFlowText = new JTextField();
		this.altFuelFlowText.setBounds(730, 10, 80, 21);
		panel_2.add(this.altFuelFlowText);
		this.altFuelFlowText.setHorizontalAlignment(0);
		this.altFuelFlowText.setFont(new Font("Times New Roman", 0, 12));
		this.altFuelFlowText.setColumns(10);
		this.altFuelFlowText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				FuelCalculatorUI.this.altFuelFlowText.selectAll();
			}
		});
		this.altFuelFlowText.addKeyListener(key);
		this.altTASText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				FuelCalculatorUI.this.altTASText.selectAll();
			}
		});
		this.altTASText.addKeyListener(key);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(10, 304, 837, 33);
		frame.getContentPane().add(panel_3);

		JLabel label_23 = new JLabel("单位");
		label_23.setHorizontalAlignment(0);
		label_23.setForeground(Color.RED);
		label_23.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_23.setBounds(10, 10, 80, 15);
		panel_3.add(label_23);

		this.aClimbDistUnit = new JLabel("nm");
		this.aClimbDistUnit.setHorizontalAlignment(0);
		this.aClimbDistUnit.setForeground(Color.RED);
		this.aClimbDistUnit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.aClimbDistUnit.setBounds(190, 10, 80, 15);
		panel_3.add(this.aClimbDistUnit);

		JLabel aClimbTimeUnit = new JLabel("min");
		aClimbTimeUnit.setHorizontalAlignment(0);
		aClimbTimeUnit.setForeground(Color.RED);
		aClimbTimeUnit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		aClimbTimeUnit.setBounds(280, 10, 80, 15);
		panel_3.add(aClimbTimeUnit);

		this.aDescFuelUnit = new JLabel("lb");
		this.aDescFuelUnit.setHorizontalAlignment(0);
		this.aDescFuelUnit.setForeground(Color.RED);
		this.aDescFuelUnit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.aDescFuelUnit.setBounds(370, 10, 80, 15);
		panel_3.add(this.aDescFuelUnit);

		this.aDescDistUnit = new JLabel("nm");
		this.aDescDistUnit.setHorizontalAlignment(0);
		this.aDescDistUnit.setForeground(Color.RED);
		this.aDescDistUnit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.aDescDistUnit.setBounds(460, 10, 80, 15);
		panel_3.add(this.aDescDistUnit);

		JLabel aDescTimeUnit = new JLabel("min");
		aDescTimeUnit.setHorizontalAlignment(0);
		aDescTimeUnit.setForeground(Color.RED);
		aDescTimeUnit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		aDescTimeUnit.setBounds(550, 10, 80, 15);
		panel_3.add(aDescTimeUnit);

		this.aClimbFuelUnit = new JLabel("lb");
		this.aClimbFuelUnit.setHorizontalAlignment(0);
		this.aClimbFuelUnit.setForeground(Color.RED);
		this.aClimbFuelUnit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.aClimbFuelUnit.setBounds(100, 10, 80, 15);
		panel_3.add(this.aClimbFuelUnit);

		this.altTASUnit = new JLabel("knots");
		this.altTASUnit.setBounds(640, 10, 80, 15);
		panel_3.add(this.altTASUnit);
		this.altTASUnit.setHorizontalAlignment(0);
		this.altTASUnit.setForeground(Color.RED);
		this.altTASUnit.setFont(new Font("Times New Roman", Font.PLAIN, 12));

		this.altFFUnit = new JLabel("lb/Hr");
		this.altFFUnit.setBounds(730, 10, 80, 15);
		panel_3.add(this.altFFUnit);
		this.altFFUnit.setHorizontalAlignment(0);
		this.altFFUnit.setForeground(Color.RED);
		this.altFFUnit.setFont(new Font("Times New Roman", Font.PLAIN, 12));

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(10, 25, 1097, 33);
		frame.getContentPane().add(panel_4);

		JLabel ac_1 = new JLabel("机型");
		ac_1.setBounds(100, 10, 80, 15);
		panel_4.add(ac_1);
		ac_1.setFont(new Font("微软雅黑", 0, 14));
		ac_1.setForeground(Color.BLUE);
		ac_1.setHorizontalAlignment(0);

		this.changePram = new JLabel("起飞重量");
		this.changePram.setBounds(190, 10, 80, 15);
		panel_4.add(this.changePram);
		this.changePram.setFont(new Font("微软雅黑", 0, 14));
		this.changePram.setHorizontalAlignment(0);
		this.changePram.setForeground(Color.BLUE);

		JLabel passcount = new JLabel("乘客数");
		passcount.setBounds(280, 10, 80, 15);
		panel_4.add(passcount);
		passcount.setFont(new Font("微软雅黑", 0, 14));
		passcount.setHorizontalAlignment(0);
		passcount.setForeground(Color.BLUE);

		JLabel cargo_1 = new JLabel("货物");
		cargo_1.setBounds(370, 10, 80, 15);
		panel_4.add(cargo_1);
		cargo_1.setFont(new Font("微软雅黑", 0, 14));
		cargo_1.setHorizontalAlignment(0);
		cargo_1.setForeground(Color.BLUE);

		JLabel label_5 = new JLabel("备降距离");
		label_5.setBounds(460, 10, 80, 15);
		panel_4.add(label_5);
		label_5.setFont(new Font("微软雅黑", 0, 14));
		label_5.setHorizontalAlignment(0);
		label_5.setForeground(Color.BLUE);

		JLabel label = new JLabel("基本信息");
		label.setBounds(846, 11, 242, 15);
		panel_4.add(label);
		label.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label.setHorizontalAlignment(0);
		label.setForeground(Color.BLUE);

		JLabel waitFF = new JLabel("等待油耗");
		waitFF.setHorizontalAlignment(0);
		waitFF.setForeground(Color.BLUE);
		waitFF.setFont(new Font("微软雅黑", 0, 14));
		waitFF.setBounds(550, 10, 80, 15);
		panel_4.add(waitFF);

		JLabel crewWeight = new JLabel("机组重量");
		crewWeight.setHorizontalAlignment(SwingConstants.CENTER);
		crewWeight.setForeground(Color.BLUE);
		crewWeight.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		crewWeight.setBounds(640, 11, 80, 15);
		panel_4.add(crewWeight);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.DARK_GRAY);
		panel_5.setBounds(10, 56, 837, 40);
		frame.getContentPane().add(panel_5);

		JLabel label_27 = new JLabel("基本信息");
		label_27.setHorizontalAlignment(0);
		label_27.setForeground(Color.WHITE);
		label_27.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_27.setBounds(10, 12, 80, 15);
		panel_5.add(label_27);

		this.acText = new JTextField();
		this.acText.setBounds(100, 12, 80, 21);
		panel_5.add(this.acText);
		this.acText.setEditable(false);
		this.acText.setFont(new Font("Times New Roman", 0, 12));
		this.acText.setHorizontalAlignment(0);
		this.acText.setColumns(10);

		this.waitFFText = new JTextField();
		this.waitFFText.setBounds(550, 11, 80, 21);
		panel_5.add(this.waitFFText);
		this.waitFFText.setHorizontalAlignment(0);
		this.waitFFText.setFont(new Font("Times New Roman", 0, 12));
		this.waitFFText.setColumns(10);
		this.waitFFText.addKeyListener(key);
		this.waitFFText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				FuelCalculatorUI.this.waitFFText.selectAll();
			}
		});
		this.changeParmText = new JTextField();
		this.changeParmText.setBounds(190, 12, 80, 21);
		panel_5.add(this.changeParmText);
		this.changeParmText.setFont(new Font("Times New Roman", 0, 12));
		this.changeParmText.setHorizontalAlignment(0);
		this.changeParmText.setColumns(10);
		this.changeParmText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				FuelCalculatorUI.this.changeParmText.selectAll();
			}
		});
		this.passCountText = new JTextField();
		this.passCountText.setBounds(280, 12, 80, 21);
		panel_5.add(this.passCountText);
		this.passCountText.setFont(new Font("Times New Roman", 0, 12));
		this.passCountText.setHorizontalAlignment(0);
		this.passCountText.setColumns(10);
		this.passCountText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				FuelCalculatorUI.this.passCountText.selectAll();
			}
		});
		this.cargoText = new JTextField();
		this.cargoText.setBounds(370, 12, 80, 21);
		panel_5.add(this.cargoText);
		this.cargoText.setFont(new Font("Times New Roman", 0, 12));
		this.cargoText.setHorizontalAlignment(0);
		this.cargoText.setColumns(10);
		this.cargoText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				FuelCalculatorUI.this.cargoText.selectAll();
			}
		});
		this.altDistText = new JTextField();
		this.altDistText.setBounds(460, 11, 80, 21);
		panel_5.add(this.altDistText);
		this.altDistText.setFont(new Font("Times New Roman", 0, 12));
		this.altDistText.setText("200");
		this.altDistText.setHorizontalAlignment(0);
		this.altDistText.setColumns(10);

		crewWeghtText = new JTextField();
		crewWeghtText.setText("91");
		crewWeghtText.setHorizontalAlignment(SwingConstants.CENTER);
		crewWeghtText.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		crewWeghtText.setColumns(10);
		crewWeghtText.setBounds(640, 10, 80, 21);
		this.crewWeghtText.addKeyListener(key);
		panel_5.add(crewWeghtText);
		this.crewWeghtText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				FuelCalculatorUI.this.crewWeghtText.selectAll();
			}
		});

		this.altDistText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				FuelCalculatorUI.this.altDistText.selectAll();
			}
		});
		this.altDistText.addKeyListener(key);
		this.cargoText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				FuelCalculatorUI.this.cargoText.selectAll();
			}
		});
		this.cargoText.addKeyListener(key);
		this.passCountText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				FuelCalculatorUI.this.passCountText.selectAll();
			}
		});
		this.passCountText.addKeyListener(key);
		this.changeParmText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				FuelCalculatorUI.this.changeParmText.selectAll();
			}
		});
		this.changeParmText.addKeyListener(key);
		this.acText.addKeyListener(key);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(Color.LIGHT_GRAY);
		panel_6.setBounds(10, 95, 837, 33);
		frame.getContentPane().add(panel_6);

		JLabel label_33 = new JLabel("单位");
		label_33.setHorizontalAlignment(0);
		label_33.setForeground(Color.RED);
		label_33.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_33.setBounds(10, 10, 80, 15);
		panel_6.add(label_33);

		this.changeParmUnit = new JLabel("kg");
		this.changeParmUnit.setBounds(190, 10, 80, 15);
		panel_6.add(this.changeParmUnit);
		this.changeParmUnit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.changeParmUnit.setHorizontalAlignment(0);
		this.changeParmUnit.setForeground(Color.RED);

		this.passNumUnit = new JLabel("个");
		this.passNumUnit.setBounds(280, 10, 80, 15);
		panel_6.add(this.passNumUnit);
		this.passNumUnit.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		this.passNumUnit.setHorizontalAlignment(0);
		this.passNumUnit.setForeground(Color.RED);

		this.cargoUnit = new JLabel("kg");
		this.cargoUnit.setBounds(370, 10, 80, 15);
		panel_6.add(this.cargoUnit);
		this.cargoUnit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.cargoUnit.setHorizontalAlignment(0);
		this.cargoUnit.setForeground(Color.RED);

		this.altDistUnit = new JLabel("nm");
		this.altDistUnit.setBounds(463, 10, 80, 15);
		panel_6.add(this.altDistUnit);
		this.altDistUnit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.altDistUnit.setHorizontalAlignment(0);
		this.altDistUnit.setForeground(Color.RED);

		this.waitFFUnit = new JLabel("lb/Hr");
		this.waitFFUnit.setHorizontalAlignment(0);
		this.waitFFUnit.setForeground(Color.RED);
		this.waitFFUnit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.waitFFUnit.setBounds(553, 10, 80, 15);
		panel_6.add(this.waitFFUnit);

		JLabel lblKg = new JLabel("kg/P");
		lblKg.setHorizontalAlignment(SwingConstants.CENTER);
		lblKg.setForeground(Color.RED);
		lblKg.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblKg.setBounds(643, 10, 80, 15);
		panel_6.add(lblKg);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.DARK_GRAY);
		panel_7.setBounds(846, 57, 261, 280);
		frame.getContentPane().add(panel_7);
		panel_7.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 241, 260);
		panel_7.add(scrollPane);

		this.basicContext = new JTextArea();
		this.basicContext.setEditable(false);
		scrollPane.setViewportView(this.basicContext);
		this.basicContext.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		this.basicContext.setForeground(Color.BLACK);
		this.basicContext.setLineWrap(true);

		this.climbFText.addKeyListener(key);
		this.climbDistText.addKeyListener(key);
		this.climbTimeText.addKeyListener(key);
		this.descFText.addKeyListener(key);
		this.descDistText.addKeyListener(key);
		this.descTimeText.addKeyListener(key);
		this.cruiseTASText.addKeyListener(key);
		this.cruiseFuelflowText.addKeyListener(key);
	}

	public void actionPerformed(ActionEvent e) {
		JRadioButtonMenuItem temp = (JRadioButtonMenuItem) e.getSource();
		if (temp.isSelected()) {
			for (int i = 0; i < this.acList.size(); i++) {
				String acResult = (String) this.acList.get(i);
				String[] split1 = acResult.split("-");
				if (split1[0].equals(temp.getText())) {
					this.parms.getACInfo(acResult);
					this.acText.setText(temp.getText());
					this.basicContext.setText("  机型：" + split1[0] + "\n  基本空机重：" + split1[1] + "kg\n  最少机组人数："
							+ split1[9] + "人\n  最多机组人数：" + split1[10] + "人\n  最大起飞重量：" + split1[2] + "kg\n  最大乘客数量： "
							+ split1[3] + " 人\n  最大可用燃油量：" + split1[4] + "kg\n  最大商载：" + split1[5] + "kg\n  总最大载量："
							+ split1[6] + "kg\n  行李舱最大载量： " + split1[7] + "kg\n  最大使用高度限制： " + split1[8] + "米");
				}
			}
			for (int i = 0; i < this.frList.size(); i++) {
				String frResult = (String) this.frList.get(i);
				String[] split2 = frResult.split("-");
				if (split2[0].equals(temp.getText())) {
					this.parms.getFRInfo(frResult);
					this.altDistText.setText(split2[2]);
					this.flightRule = frResult;
				}
			}
			for (int i = 0; i < this.passList.size(); i++) {
				String passResult = (String) this.passList.get(i);
				String[] split3 = passResult.split("-");
				if (split3[0].equals(temp.getText())) {
					this.parms.getPassInfo(passResult);
					this.yunying = passResult;
				}
			}
			if (this.weightToDistItem.isSelected()) {
				this.changePram.setText("起飞重量");
				this.label_10.setText("距离和时间相关结果");
				this.changeParmUnit.setText("kg");
			}
			if (this.distToWeightItem.isSelected()) {
				this.changePram.setText("主航程距离");
				this.label_10.setText("重量和时间相关结果");
				this.changeParmUnit.setText("km");
			}
			if (this.standerUnitItem.isSelected()) {
				this.climbFuelUnit.setText("kg");
				this.climbDistUnit.setText("km");
				this.descFuelUnit.setText("kg");
				this.descDistUnit.setText("km");
				this.aClimbFuelUnit.setText("kg");
				this.aClimbDistUnit.setText("km");
				this.aDescFuelUnit.setText("kg");
				this.aDescDistUnit.setText("km");
				this.cruiseTASUnit.setText("km/Hr");
				this.cruseFFUnit.setText("kg/Hr");
				this.altTASUnit.setText("km/Hr");
				this.altFFUnit.setText("kg/Hr");
				this.waitFFUnit.setText("kg/Hr");
			}
			if (this.engUnitItem.isSelected()) {
				this.climbFuelUnit.setText("lb");
				this.climbDistUnit.setText("nm");
				this.descFuelUnit.setText("lb");
				this.descDistUnit.setText("nm");
				this.aClimbFuelUnit.setText("lb");
				this.aClimbDistUnit.setText("nm");
				this.aDescFuelUnit.setText("lb");
				this.aDescDistUnit.setText("nm");
				this.cruiseTASUnit.setText("knots");
				this.cruseFFUnit.setText("lb/Hr");
				this.altTASUnit.setText("knots");
				this.altFFUnit.setText("lb/Hr");
				this.waitFFUnit.setText("lb/Hr");
			}
		}
	}
}

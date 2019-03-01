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

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.cdbt.service.OBSCalParmsService;
import com.cdbt.utils.CommonUtils;

public class OBSCalUI {
	private int num = 0;
	public static JFrame frame;
	private DefaultTableModel tableModel = new DefaultTableModel();
	private JTable resultTable;
	private JTextField rwyEndAltText;
	private JTextField obsAltText;
	private JTextField lineLengthText;
	private JTextField turnLengthText;
	private JTextField gradLossText;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					OBSCalUI window = new OBSCalUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public OBSCalUI() {
		initialize();
		frame.setLocationRelativeTo(LoginUI.frame);
	}

	private void initialize() {
		frame = new JFrame("梯度计算工具");
		frame.setTitle("障碍物梯度计算");
		frame.setBounds(100, 100, 1027, 395);
		frame.setDefaultCloseOperation(2);
		String[] columnNames = { "障碍物编号", "障碍物标高", "高出跑道末端", "修正高", "总距离", "障碍物梯度", "不考虑树高梯度", "所需爬升梯度", "砍树后所需梯度" };

		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 10, 991, 72);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("跑道末端标高(m)");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("微软雅黑", 0, 14));
		lblNewLabel.setHorizontalAlignment(0);
		lblNewLabel.setBounds(10, 13, 110, 15);
		panel.add(lblNewLabel);

		JLabel lblm_2 = new JLabel("障碍物高度(m)");
		lblm_2.setForeground(Color.BLUE);
		lblm_2.setFont(new Font("微软雅黑", 0, 14));
		lblm_2.setHorizontalAlignment(0);
		lblm_2.setBounds(250, 13, 110, 15);
		panel.add(lblm_2);

		JLabel lblm_1 = new JLabel("直线段长度(m)");
		lblm_1.setForeground(Color.BLUE);
		lblm_1.setFont(new Font("微软雅黑", 0, 14));
		lblm_1.setHorizontalAlignment(0);
		lblm_1.setBounds(370, 13, 110, 15);
		panel.add(lblm_1);

		final JCheckBox isNatureOBS = new JCheckBox("是否为自然障碍物");
		isNatureOBS.setBackground(Color.LIGHT_GRAY);
		isNatureOBS.setFont(new Font("微软雅黑", 0, 12));
		isNatureOBS.setHorizontalAlignment(0);
		isNatureOBS.setSelected(true);
		isNatureOBS.setBounds(639, 10, 127, 23);
		panel.add(isNatureOBS);

		JLabel lblm = new JLabel("转弯段长度(m)");
		lblm.setForeground(Color.BLUE);
		lblm.setFont(new Font("微软雅黑", 0, 14));
		lblm.setHorizontalAlignment(0);
		lblm.setBounds(490, 13, 110, 15);
		panel.add(lblm);

		JLabel label_3 = new JLabel("转弯梯度损失(%)");
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("微软雅黑", 0, 14));
		label_3.setHorizontalAlignment(0);
		label_3.setBounds(130, 13, 110, 15);
		panel.add(label_3);

		this.rwyEndAltText = new JTextField();
		this.rwyEndAltText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				OBSCalUI.this.rwyEndAltText.selectAll();
			}
		});
		this.rwyEndAltText.setFont(new Font("微软雅黑", 0, 14));
		this.rwyEndAltText.setHorizontalAlignment(0);
		this.rwyEndAltText.setBounds(10, 38, 110, 21);
		panel.add(this.rwyEndAltText);
		this.rwyEndAltText.setColumns(10);

		this.obsAltText = new JTextField();
		this.obsAltText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				OBSCalUI.this.obsAltText.selectAll();
			}
		});
		this.gradLossText = new JTextField();
		this.gradLossText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				OBSCalUI.this.gradLossText.selectAll();
			}
		});
		this.gradLossText.setFont(new Font("微软雅黑", 0, 14));
		this.gradLossText.setText("0.8");
		this.gradLossText.setHorizontalAlignment(0);
		this.gradLossText.setColumns(10);
		this.gradLossText.setBounds(130, 38, 110, 21);
		panel.add(this.gradLossText);
		this.obsAltText.setFont(new Font("微软雅黑", 0, 14));
		this.obsAltText.setHorizontalAlignment(0);
		this.obsAltText.setColumns(10);
		this.obsAltText.setBounds(250, 38, 110, 21);
		panel.add(this.obsAltText);

		this.lineLengthText = new JTextField();

		this.lineLengthText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				OBSCalUI.this.lineLengthText.selectAll();
			}
		});
		this.lineLengthText.setFont(new Font("微软雅黑", 0, 14));
		this.lineLengthText.setHorizontalAlignment(0);
		this.lineLengthText.setColumns(10);
		this.lineLengthText.setBounds(370, 38, 110, 21);
		panel.add(this.lineLengthText);

		this.turnLengthText = new JTextField();

		this.turnLengthText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				OBSCalUI.this.turnLengthText.selectAll();
			}
		});
		this.turnLengthText.setText("0");
		this.turnLengthText.setFont(new Font("微软雅黑", 0, 14));
		this.turnLengthText.setHorizontalAlignment(0);
		this.turnLengthText.setColumns(10);
		this.turnLengthText.setBounds(490, 38, 110, 21);
		panel.add(this.turnLengthText);

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 92, 991, 254);
		frame.getContentPane().add(scrollPane);

		this.tableModel.setColumnIdentifiers(columnNames);

		final JButton CalButton = new JButton("计算");
		CalButton.setForeground(Color.RED);

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OBSCalParmsService parms = new OBSCalParmsService();
				String rwyEndAlt = OBSCalUI.this.rwyEndAltText.getText().trim();
				String OBSAlt = OBSCalUI.this.obsAltText.getText().trim();
				String lineLength = OBSCalUI.this.lineLengthText.getText().trim();
				String turnLength = OBSCalUI.this.turnLengthText.getText().trim();
				String gradLoss = OBSCalUI.this.gradLossText.getText().trim();
				if ((rwyEndAlt.isEmpty()) || (OBSAlt.isEmpty()) || (lineLength.isEmpty()) || (turnLength.isEmpty())
						|| (gradLoss.isEmpty())) {
					return;
				}
				if ((CommonUtils.ifStringIsPositive(rwyEndAlt)) && (CommonUtils.ifStringIsPositive(OBSAlt))
						&& (CommonUtils.ifStringIsPositive(lineLength)) && (CommonUtils.ifStringIsPositive(turnLength))
						&& (CommonUtils.ifStringIsPositive(gradLoss))) {
					OBSCalUI.this.num += 1;
					String NUM = String.valueOf(OBSCalUI.this.num);
					String[] result = parms.getOBSResult(NUM, rwyEndAlt, OBSAlt, lineLength, turnLength, gradLoss,
							isNatureOBS.isSelected());
					OBSCalUI.this.tableModel.addRow(result);

					OBSCalUI.this.resultTable = new JTable(OBSCalUI.this.tableModel) {
						private static final long serialVersionUID = 1L;

						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
					OBSCalUI.this.resultTable.setBackground(Color.WHITE);
					scrollPane.setViewportView(OBSCalUI.this.resultTable);
					OBSCalUI.this.resultTable.setFont(new Font("微软雅黑", 0, 14));
					OBSCalUI.this.resultTable.getTableHeader().setFont(new Font("微软雅黑", 0, 14));
					DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
					tcr.setHorizontalAlignment(0);
					tcr.setHorizontalAlignment(0);
					OBSCalUI.this.resultTable.setDefaultRenderer(Object.class, tcr);
					OBSCalUI.this.resultTable.setForeground(Color.BLUE);
					OBSCalUI.this.resultTable.setRowSelectionAllowed(true);
					OBSCalUI.this.resultTable.setColumnSelectionAllowed(true);
					OBSCalUI.this.resultTable.setCellSelectionEnabled(true);
					OBSCalUI.this.resultTable.getTableHeader().setReorderingAllowed(false);
					OBSCalUI.this.resultTable.getTableHeader().setResizingAllowed(false);
					OBSCalUI.this.resultTable.getTableHeader().setBackground(Color.LIGHT_GRAY);
					OBSCalUI.this.resultTable.setSelectionForeground(Color.RED);
					OBSCalUI.this.obsAltText.requestFocus();
					OBSCalUI.this.obsAltText.setText("");
				} else {
				}
			}
		};
		KeyAdapter key = new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					CalButton.doClick();
				}
			}
		};
		this.rwyEndAltText.addKeyListener(key);
		this.gradLossText.addKeyListener(key);
		this.obsAltText.addKeyListener(key);
		this.lineLengthText.addKeyListener(key);
		this.turnLengthText.addKeyListener(key);
		CalButton.setFont(new Font("新宋体", 0, 14));
		CalButton.setBounds(639, 38, 127, 23);
		CalButton.addActionListener(listener);

		panel.add(CalButton);

		JButton clearButton = new JButton("重置");
		clearButton.setForeground(Color.BLUE);
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OBSCalUI.main(null);
				OBSCalUI.frame.dispose();
			}
		});
		clearButton.setFont(new Font("新宋体", 0, 14));
		clearButton.setBounds(789, 38, 93, 23);
		panel.add(clearButton);

		JButton returnButton = new JButton("返回");
		returnButton.setForeground(Color.MAGENTA);
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OBSCalUI.frame.dispose();
			}
		});
		returnButton.setFont(new Font("新宋体", 0, 14));
		returnButton.setBounds(888, 38, 93, 23);
		panel.add(returnButton);
	}

}

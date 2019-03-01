package com.cdbt.ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.cdbt.service.TaxService;

public class TaxCalUI {
	private JFrame frame;
	private JTextField incomeText;
	private JTextField taxText;
	private JLabel label_1;
	private JTextField deductionText;
	private JButton clearButton;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaxCalUI window = new TaxCalUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TaxCalUI() {
		initialize();
		this.frame.setLocationRelativeTo(LoginUI.frame);
	}

	private void initialize() {
		this.frame = new JFrame();
		this.frame.setTitle("个税计算器");
		this.frame.setBounds(100, 100, 450, 300);
		this.frame.setDefaultCloseOperation(2);
		this.frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("净收入");
		lblNewLabel.setFont(new Font("微软雅黑", 0, 14));
		lblNewLabel.setHorizontalAlignment(0);
		lblNewLabel.setBounds(48, 70, 93, 15);
		this.frame.getContentPane().add(lblNewLabel);

		this.incomeText = new JTextField();
		this.incomeText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		this.incomeText.setHorizontalAlignment(0);
		this.incomeText.setBounds(48, 108, 93, 21);
		this.frame.getContentPane().add(this.incomeText);
		this.incomeText.setColumns(10);
		this.incomeText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				TaxCalUI.this.incomeText.selectAll();
			}
		});
		this.label_1 = new JLabel("抵扣部分");
		this.label_1.setHorizontalAlignment(0);
		this.label_1.setFont(new Font("微软雅黑", 0, 14));
		this.label_1.setBounds(151, 70, 93, 15);
		this.frame.getContentPane().add(this.label_1);

		this.deductionText = new JTextField();
		this.deductionText.setText("0");
		this.deductionText.setHorizontalAlignment(0);
		this.deductionText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		this.deductionText.setColumns(10);
		this.deductionText.setBounds(151, 108, 93, 21);
		this.deductionText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				TaxCalUI.this.deductionText.selectAll();
			}
		});
		this.frame.getContentPane().add(this.deductionText);

		JLabel label = new JLabel("纳税");
		label.setFont(new Font("微软雅黑", 0, 14));
		label.setHorizontalAlignment(0);
		label.setBounds(273, 70, 93, 15);
		this.frame.getContentPane().add(label);

		this.taxText = new JTextField();
		this.taxText.setEditable(false);
		this.taxText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		this.taxText.setHorizontalAlignment(0);
		this.taxText.setColumns(10);
		this.taxText.setBounds(273, 108, 93, 21);
		this.frame.getContentPane().add(this.taxText);

		this.clearButton = new JButton("清空");
		this.clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaxCalUI.this.incomeText.setText("");
				TaxCalUI.this.deductionText.setText("0");
			}
		});
		final JButton calButton = new JButton("计算");
		calButton.setFont(new Font("新宋体", 0, 14));
		calButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaxService service = new TaxService();
				String income = TaxCalUI.this.incomeText.getText().trim();
				String deduction = TaxCalUI.this.deductionText.getText().trim();
				String tax = service.getTax(income, deduction);
				TaxCalUI.this.taxText.setText(tax);
			}
		});
		calButton.setBounds(100, 185, 93, 23);
		this.frame.getContentPane().add(calButton);
		this.clearButton.setFont(new Font("新宋体", Font.PLAIN, 14));
		this.clearButton.setBounds(222, 185, 93, 23);
		this.frame.getContentPane().add(this.clearButton);
		KeyAdapter key = new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					calButton.doClick();
				}
			}
		};
		this.incomeText.addKeyListener(key);
		this.deductionText.addKeyListener(key);
	}
}

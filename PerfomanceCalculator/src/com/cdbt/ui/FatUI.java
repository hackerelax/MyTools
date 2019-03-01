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

import com.cdbt.service.FunService;
import com.cdbt.utils.CommonUtils;

public class FatUI {
	private JFrame frame;
	private JTextField heightText;
	private JTextField weightText;
	private JTextField resultText;
	private FunService funService = new FunService();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FatUI window = new FatUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FatUI() {
		initialize();
		frame.setLocationRelativeTo(LoginUI.frame);
	}

	private void initialize() {
		this.frame = new JFrame();
		this.frame.setTitle("肥胖计算器");
		this.frame.setBounds(100, 100, 450, 300);
		this.frame.setDefaultCloseOperation(2);
		this.frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("身高(cm)");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(0);
		lblNewLabel.setBounds(43, 46, 78, 15);
		this.frame.getContentPane().add(lblNewLabel);

		this.heightText = new JTextField();
		this.heightText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		this.heightText.setHorizontalAlignment(0);
		this.heightText.setBounds(43, 84, 78, 21);
		this.frame.getContentPane().add(this.heightText);
		this.heightText.setColumns(10);
		this.heightText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				FatUI.this.heightText.selectAll();
			}
		});
		JLabel lblkg = new JLabel("体重(kg)");
		lblkg.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblkg.setHorizontalAlignment(0);
		lblkg.setBounds(156, 46, 78, 15);
		this.frame.getContentPane().add(lblkg);

		this.weightText = new JTextField();
		this.weightText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		this.weightText.setHorizontalAlignment(0);
		this.weightText.setColumns(10);
		this.weightText.setBounds(156, 84, 78, 21);
		this.frame.getContentPane().add(this.weightText);
		this.weightText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				FatUI.this.weightText.selectAll();
			}
		});
		this.resultText = new JTextField();
		this.resultText.setEditable(false);
		this.resultText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		this.resultText.setHorizontalAlignment(0);
		this.resultText.setColumns(10);
		this.resultText.setBounds(274, 84, 104, 21);
		this.frame.getContentPane().add(this.resultText);

		JLabel label_1 = new JLabel("结果");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_1.setHorizontalAlignment(0);
		label_1.setBounds(274, 46, 104, 15);
		this.frame.getContentPane().add(label_1);

		final JButton calButton = new JButton("计算");
		calButton.setFont(new Font("新宋体", Font.PLAIN, 14));
		calButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String height = FatUI.this.heightText.getText();
				String weight = FatUI.this.weightText.getText();
				if ((CommonUtils.ifStringIsDigital(height)) && (CommonUtils.ifStringIsDigital(weight))) {
					String result = FatUI.this.funService.getFatResult(height, weight);
					FatUI.this.resultText.setText(result);
				}
			}
		});
		calButton.setBounds(95, 176, 93, 23);
		this.frame.getContentPane().add(calButton);

		JButton clearButton = new JButton("清空");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FatUI.this.heightText.setText("");
				FatUI.this.weightText.setText("");
				FatUI.this.resultText.setText("");
			}
		});
		clearButton.setFont(new Font("新宋体", Font.PLAIN, 14));
		clearButton.setBounds(221, 176, 93, 23);
		this.frame.getContentPane().add(clearButton);
		KeyAdapter key = new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					calButton.doClick();
				}
			}
		};
		this.heightText.addKeyListener(key);
		this.weightText.addKeyListener(key);
	}
}

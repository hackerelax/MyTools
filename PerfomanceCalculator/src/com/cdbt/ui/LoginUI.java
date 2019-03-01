package com.cdbt.ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoginUI implements ActionListener {
	static JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					LoginUI window = new LoginUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginUI() {
		initialize();
		frame.setLocationRelativeTo(null);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("性能小公举");
		frame.setBounds(100, 100, 379, 422);
		frame.setDefaultCloseOperation(3);
		frame.getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 343, 364);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton button = new JButton("常用计算工具");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NormalCalUI.main(null);
			}
		});
		button.setBounds(91, 75, 150, 23);
		panel_1.add(button);
		button.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JButton button_1 = new JButton("航程及油量分析");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuelCalculatorUI.main(null);
			}
		});
		button_1.setBounds(91, 108, 150, 23);
		panel_1.add(button_1);
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JButton button_2 = new JButton("障碍物计算工具");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OBSCalUI.main(null);
			}
		});
		button_2.setBounds(91, 141, 150, 23);
		panel_1.add(button_2);
		button_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JButton button_3 = new JButton("个税计算器");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaxCalUI.main(null);
			}
		});
		button_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		button_3.setBounds(91, 174, 150, 23);
		panel_1.add(button_3);

		JButton button_4 = new JButton("肥胖计算器");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FatUI.main(null);
			}
		});
		button_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		button_4.setBounds(91, 207, 150, 23);
		panel_1.add(button_4);
	}

	public void actionPerformed(ActionEvent e) {
	}
}

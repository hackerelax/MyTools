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
		frame.setTitle("程序小公举");
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
	}

	public void actionPerformed(ActionEvent e) {
	}
}

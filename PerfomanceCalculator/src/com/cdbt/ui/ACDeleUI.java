package com.cdbt.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.cdbt.service.FuelCalParmsService;

public class ACDeleUI {
	private JFrame frame;
	private FuelCalParmsService parms = new FuelCalParmsService();
	private ArrayList<String> acList = this.parms.getAC();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ACDeleUI window = new ACDeleUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ACDeleUI() {
		initialize();
		this.frame.setLocationRelativeTo(FuelCalculatorUI.frame);
	}

	private void initialize() {
		this.frame = new JFrame();
		this.frame.setTitle("删除机型");
		this.frame.setBounds(100, 100, 317, 225);
		this.frame.setDefaultCloseOperation(2);
		this.frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 301, 187);
		this.frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("选择机型");
		lblNewLabel.setFont(new Font("微软雅黑", 0, 12));
		lblNewLabel.setHorizontalAlignment(0);
		lblNewLabel.setBounds(102, 30, 93, 15);
		panel.add(lblNewLabel);

		JLabel result = new JLabel("结果显示：");
		result.setFont(new Font("微软雅黑", 0, 12));
		result.setForeground(Color.RED);
		result.setBounds(102, 103, 93, 21);
		panel.add(result);

		final JComboBox<String> ACType = new JComboBox<String>();
		for (int i = 0; i < this.acList.size(); i++) {
			String temp = this.acList.get(i);
			String[] split = temp.split("-");
			ACType.addItem(split[0]);
		}
		ACType.setBounds(102, 55, 93, 21);
		panel.add(ACType);

		JButton button = new JButton("删除");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = (String) ACType.getSelectedItem();
				ACDeleUI.this.parms.deleteAC(item);
			}
		});
		button.setBounds(102, 147, 93, 23);
		panel.add(button);
	}
}

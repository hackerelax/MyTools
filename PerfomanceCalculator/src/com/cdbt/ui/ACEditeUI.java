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
import javax.swing.JTextField;

import com.cdbt.service.FuelCalParmsService;

public class ACEditeUI {
	private JFrame frame;
	private JTextField bow;
	private JTextField mtow;
	private JTextField maxFuel;
	private JTextField maxSeat;
	private JTextField maxPayload;
	private JTextField maxTotalLoad;
	private JTextField maxCargo;
	private JTextField maxAlt;
	private FuelCalParmsService parms = new FuelCalParmsService();
	private ArrayList<String> acList = this.parms.getAC();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ACEditeUI window = new ACEditeUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ACEditeUI() {
		initialize();
		this.frame.setLocationRelativeTo(FuelCalculatorUI.frame);
	}

	private void initialize() {
		this.frame = new JFrame();
		this.frame.setTitle("编辑机型");
		this.frame.setBounds(100, 100, 450, 300);
		this.frame.setDefaultCloseOperation(2);
		this.frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 262);
		this.frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("机型");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(0);
		lblNewLabel.setBounds(26, 10, 66, 15);
		panel.add(lblNewLabel);

		JLabel label = new JLabel("基本空机重量");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label.setHorizontalAlignment(0);
		label.setBounds(102, 10, 66, 15);
		panel.add(label);

		this.bow = new JTextField();
		this.bow.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		this.bow.setHorizontalAlignment(0);
		this.bow.setColumns(10);
		this.bow.setBounds(102, 34, 66, 21);
		panel.add(this.bow);

		JLabel label_1 = new JLabel("最大起飞重量");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_1.setHorizontalAlignment(0);
		label_1.setBounds(178, 10, 66, 15);
		panel.add(label_1);

		this.mtow = new JTextField();
		this.mtow.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		this.mtow.setHorizontalAlignment(0);
		this.mtow.setColumns(10);
		this.mtow.setBounds(178, 34, 66, 21);
		panel.add(this.mtow);

		JLabel label_2 = new JLabel("最大可用燃油重量");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_2.setHorizontalAlignment(0);
		label_2.setBounds(254, 10, 66, 15);
		panel.add(label_2);

		this.maxFuel = new JTextField();
		this.maxFuel.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		this.maxFuel.setHorizontalAlignment(0);
		this.maxFuel.setColumns(10);
		this.maxFuel.setBounds(254, 34, 66, 21);
		panel.add(this.maxFuel);

		JLabel label_3 = new JLabel("最大商载");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_3.setHorizontalAlignment(0);
		label_3.setBounds(26, 65, 66, 15);
		panel.add(label_3);

		this.maxSeat = new JTextField();
		this.maxSeat.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		this.maxSeat.setHorizontalAlignment(0);
		this.maxSeat.setColumns(10);
		this.maxSeat.setBounds(330, 34, 66, 21);
		panel.add(this.maxSeat);

		JLabel label_4 = new JLabel("总最大载量");
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_4.setHorizontalAlignment(0);
		label_4.setBounds(102, 65, 66, 15);
		panel.add(label_4);

		this.maxPayload = new JTextField();
		this.maxPayload.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		this.maxPayload.setHorizontalAlignment(0);
		this.maxPayload.setColumns(10);
		this.maxPayload.setBounds(26, 89, 66, 21);
		panel.add(this.maxPayload);

		JLabel label_5 = new JLabel("行李舱最大载量");
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_5.setHorizontalAlignment(0);
		label_5.setBounds(178, 65, 66, 15);
		panel.add(label_5);

		this.maxTotalLoad = new JTextField();
		this.maxTotalLoad.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		this.maxTotalLoad.setHorizontalAlignment(0);
		this.maxTotalLoad.setColumns(10);
		this.maxTotalLoad.setBounds(102, 89, 66, 21);
		panel.add(this.maxTotalLoad);

		JLabel label_6 = new JLabel("最大使用高度限制");
		label_6.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_6.setHorizontalAlignment(0);
		label_6.setBounds(254, 65, 66, 15);
		panel.add(label_6);

		this.maxCargo = new JTextField();
		this.maxCargo.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		this.maxCargo.setHorizontalAlignment(0);
		this.maxCargo.setColumns(10);
		this.maxCargo.setBounds(178, 89, 66, 21);
		panel.add(this.maxCargo);

		JLabel label_7 = new JLabel("最大座位数");
		label_7.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_7.setHorizontalAlignment(0);
		label_7.setBounds(330, 10, 66, 15);
		panel.add(label_7);

		this.maxAlt = new JTextField();
		this.maxAlt.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		this.maxAlt.setHorizontalAlignment(0);
		this.maxAlt.setColumns(10);
		this.maxAlt.setBounds(254, 89, 66, 21);
		panel.add(this.maxAlt);

		JLabel result = new JLabel("单位：重量kg，高度m");
		result.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		result.setForeground(Color.RED);
		result.setBounds(26, 135, 294, 21);
		panel.add(result);

		final JComboBox<String> ac = new JComboBox<String>();
		ac.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		ac.setToolTipText("");
		ac.setBounds(26, 35, 66, 21);
		panel.add(ac);
		ac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = (String) ac.getSelectedItem();
				for (int i = 0; i < ACEditeUI.this.acList.size(); i++) {
					String string = ACEditeUI.this.acList.get(i);
					String[] split = string.split("-");
					if (item.equals(split[0])) {
						ACEditeUI.this.bow.setText(split[1]);
						ACEditeUI.this.mtow.setText(split[2]);
						ACEditeUI.this.maxSeat.setText(split[3]);
						ACEditeUI.this.maxFuel.setText(split[4]);
						ACEditeUI.this.maxPayload.setText(split[5]);
						ACEditeUI.this.maxTotalLoad.setText(split[6]);
						ACEditeUI.this.maxCargo.setText(split[7]);
						ACEditeUI.this.maxAlt.setText(split[8]);
					}
				}
			}
		});
		JButton button = new JButton("确定");
		button.setFont(new Font("新宋体", Font.PLAIN, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = (String) ac.getSelectedItem();
				boolean b = ACEditeUI.this.parms.editeAC(name, ACEditeUI.this.bow.getText(),
						ACEditeUI.this.mtow.getText(), ACEditeUI.this.maxSeat.getText(),
						ACEditeUI.this.maxFuel.getText(), ACEditeUI.this.maxPayload.getText(),
						ACEditeUI.this.maxTotalLoad.getText(), ACEditeUI.this.maxCargo.getText(),
						ACEditeUI.this.maxAlt.getText(), name, name, name);
				System.out.println(b);
			}
		});
		button.setBounds(102, 204, 93, 23);
		panel.add(button);

		JButton button_1 = new JButton("清空");
		button_1.setFont(new Font("新宋体", Font.PLAIN, 12));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ACEditeUI.this.bow.setText("");
				ACEditeUI.this.mtow.setText("");
				ACEditeUI.this.maxSeat.setText("");
				ACEditeUI.this.maxFuel.setText("");
				ACEditeUI.this.maxPayload.setText("");
				ACEditeUI.this.maxTotalLoad.setText("");
				ACEditeUI.this.maxCargo.setText("");
				ACEditeUI.this.maxAlt.setText("");
			}
		});
		button_1.setBounds(227, 204, 93, 23);
		panel.add(button_1);
		for (int i = 0; i < this.acList.size(); i++) {
			String temp = this.acList.get(i);
			String[] split = temp.split("-");
			ac.addItem(split[0]);
		}
	}
}

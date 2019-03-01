package com.cdbt.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cdbt.service.FuelCalParmsService;

public class ACAddUI {
	private JFrame frame;
	private JTextField ac;
	private JTextField bow;
	private JTextField mtow;
	private JTextField maxFuel;
	private JTextField maxSeat;
	private JTextField maxPayload;
	private JTextField maxTotalLoad;
	private JTextField maxCargo;
	private JTextField maxAlt;
	private FuelCalParmsService parms = new FuelCalParmsService();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ACAddUI window = new ACAddUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ACAddUI() {
		initialize();
		this.frame.setLocationRelativeTo(FuelCalculatorUI.frame);
	}

	private void initialize() {
		this.frame = new JFrame();
		this.frame.setTitle("新增机型");
		this.frame.setBounds(100, 100, 450, 300);
		this.frame.setDefaultCloseOperation(2);
		this.frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 262);
		this.frame.getContentPane().add(panel);
		panel.setLayout(null);

		this.ac = new JTextField();
		this.ac.setHorizontalAlignment(0);
		this.ac.setBounds(26, 34, 66, 21);
		panel.add(this.ac);
		this.ac.setColumns(10);

		JLabel lblNewLabel = new JLabel("机型");
		lblNewLabel.setFont(new Font("微软雅黑", 0, 12));
		lblNewLabel.setHorizontalAlignment(0);
		lblNewLabel.setBounds(26, 10, 66, 15);
		panel.add(lblNewLabel);

		JLabel label = new JLabel("基本空机重量");
		label.setFont(new Font("微软雅黑", 0, 12));
		label.setHorizontalAlignment(0);
		label.setBounds(102, 10, 66, 15);
		panel.add(label);

		this.bow = new JTextField();
		this.bow.setFont(new Font("微软雅黑", 0, 12));
		this.bow.setHorizontalAlignment(0);
		this.bow.setColumns(10);
		this.bow.setBounds(102, 34, 66, 21);
		panel.add(this.bow);

		JLabel label_1 = new JLabel("最大起飞重量");
		label_1.setFont(new Font("微软雅黑", 0, 12));
		label_1.setHorizontalAlignment(0);
		label_1.setBounds(178, 10, 66, 15);
		panel.add(label_1);

		this.mtow = new JTextField();
		this.mtow.setFont(new Font("微软雅黑", 0, 12));
		this.mtow.setHorizontalAlignment(0);
		this.mtow.setColumns(10);
		this.mtow.setBounds(178, 34, 66, 21);
		panel.add(this.mtow);

		JLabel label_2 = new JLabel("最大可用燃油重量");
		label_2.setFont(new Font("微软雅黑", 0, 12));
		label_2.setHorizontalAlignment(0);
		label_2.setBounds(254, 10, 66, 15);
		panel.add(label_2);

		this.maxFuel = new JTextField();
		this.maxFuel.setFont(new Font("微软雅黑", 0, 12));
		this.maxFuel.setHorizontalAlignment(0);
		this.maxFuel.setColumns(10);
		this.maxFuel.setBounds(254, 34, 66, 21);
		panel.add(this.maxFuel);

		JLabel label_3 = new JLabel("最大商载");
		label_3.setFont(new Font("微软雅黑", 0, 12));
		label_3.setHorizontalAlignment(0);
		label_3.setBounds(26, 65, 66, 15);
		panel.add(label_3);

		this.maxSeat = new JTextField();
		this.maxSeat.setFont(new Font("微软雅黑", 0, 12));
		this.maxSeat.setHorizontalAlignment(0);
		this.maxSeat.setColumns(10);
		this.maxSeat.setBounds(330, 34, 66, 21);
		panel.add(this.maxSeat);

		JLabel label_4 = new JLabel("总最大载量");
		label_4.setFont(new Font("微软雅黑", 0, 12));
		label_4.setHorizontalAlignment(0);
		label_4.setBounds(102, 65, 66, 15);
		panel.add(label_4);

		this.maxPayload = new JTextField();
		this.maxPayload.setFont(new Font("微软雅黑", 0, 12));
		this.maxPayload.setHorizontalAlignment(0);
		this.maxPayload.setColumns(10);
		this.maxPayload.setBounds(26, 89, 66, 21);
		panel.add(this.maxPayload);

		JLabel label_5 = new JLabel("行李舱最大载量");
		label_5.setFont(new Font("微软雅黑", 0, 12));
		label_5.setHorizontalAlignment(0);
		label_5.setBounds(178, 65, 66, 15);
		panel.add(label_5);

		this.maxTotalLoad = new JTextField();
		this.maxTotalLoad.setFont(new Font("微软雅黑", 0, 12));
		this.maxTotalLoad.setHorizontalAlignment(0);
		this.maxTotalLoad.setColumns(10);
		this.maxTotalLoad.setBounds(102, 89, 66, 21);
		panel.add(this.maxTotalLoad);

		JLabel label_6 = new JLabel("使用高度限制");
		label_6.setFont(new Font("微软雅黑", 0, 12));
		label_6.setHorizontalAlignment(0);
		label_6.setBounds(254, 65, 66, 15);
		panel.add(label_6);

		this.maxCargo = new JTextField();
		this.maxCargo.setFont(new Font("微软雅黑", 0, 12));
		this.maxCargo.setHorizontalAlignment(0);
		this.maxCargo.setColumns(10);
		this.maxCargo.setBounds(178, 89, 66, 21);
		panel.add(this.maxCargo);

		JLabel label_7 = new JLabel("最大座位数");
		label_7.setFont(new Font("微软雅黑", 0, 12));
		label_7.setHorizontalAlignment(0);
		label_7.setBounds(330, 10, 66, 15);
		panel.add(label_7);

		this.maxAlt = new JTextField();
		this.maxAlt.setFont(new Font("微软雅黑", 0, 12));
		this.maxAlt.setHorizontalAlignment(0);
		this.maxAlt.setColumns(10);
		this.maxAlt.setBounds(254, 89, 66, 21);
		panel.add(this.maxAlt);

		final JLabel result = new JLabel("单位：重量kg,高度m");
		result.setFont(new Font("微软雅黑", 0, 12));
		result.setForeground(Color.RED);
		result.setBounds(26, 135, 294, 21);
		panel.add(result);

		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean b = ACAddUI.this.parms.addAC(ACAddUI.this.ac.getText().trim(),
							ACAddUI.this.bow.getText().trim(), ACAddUI.this.mtow.getText().trim(),
							ACAddUI.this.maxSeat.getText().trim(), ACAddUI.this.maxFuel.getText().trim(),
							ACAddUI.this.maxPayload.getText().trim(), ACAddUI.this.maxTotalLoad.getText().trim(),
							ACAddUI.this.maxCargo.getText().trim(), ACAddUI.this.maxAlt.getText().trim());
					if (b) {
						result.setText("添加成功");
						FuelCalculatorUI.main(null);
						ACAddUI.this.frame.dispose();
					} else {
						result.setText("添加失败");
					}
				} catch (Exception e1) {
					result.setText("添加失败");
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(102, 204, 93, 23);
		panel.add(button);

		JButton button_1 = new JButton("清空");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ACAddUI.this.ac.setText("");
				ACAddUI.this.bow.setText("");
				ACAddUI.this.mtow.setText("");
				ACAddUI.this.maxSeat.setText("");
				ACAddUI.this.maxFuel.setText("");
				ACAddUI.this.maxPayload.setText("");
				ACAddUI.this.maxTotalLoad.setText("");
				ACAddUI.this.maxCargo.setText("");
				ACAddUI.this.maxAlt.setText("");
			}
		});
		button_1.setBounds(227, 204, 93, 23);
		panel.add(button_1);
	}
}

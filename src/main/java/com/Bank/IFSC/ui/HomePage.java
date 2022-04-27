package com.Bank.IFSC.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.Bank.IFSC.model.*;
import com.Bank.IFSC.service.*;

public class HomePage {

	
	private Service bankService = new Service();

	public HomePage() {
		
		JFrame frame = new JFrame("FIND BANK DETAIL USING IFSC CODE");
		frame.setSize(600, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(178, 215, 66));
		panel.setLayout(null);

		JTextField textField = new JTextField();
		textField.setBounds(100, 100, 300, 35);
		panel.add(textField);

		JButton button = new JButton("Search");
		button.setBounds(410, 100, 100, 35);
		panel.add(button);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("", Font.BOLD, 12));
		JScrollPane jp = new JScrollPane(textArea);
		jp.setBounds(100, 160, 410, 200);
		panel.add(jp);

		frame.add(panel);

		frame.setVisible(true);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Bank bank = bankService.getBankDetailAPi(textField.getText());
				if (bank != null) {
					String result = "Bank Name : " + bank.getBANK() + "\n" + "Bank Address : " + bank.getADDRESS()
							+ "\n" + "Bank City : " + bank.getCITY() + "\n" + "Bank Branch : " + bank.getBRANCH() + "\n"
							+ "Bank District : " + bank.getDISTRICT() + "\n" + "Bank State : " + bank.getSTATE() + "\n";
					textArea.setText(result);
				} else {
					textArea.setText("Please check your IFSC code");
				}

			}
		});
	}

	public static void main(String[] args) {
		new HomePage();
	}
}

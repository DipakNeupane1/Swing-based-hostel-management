package com.dipak.hostelmgmtsystem.view;



import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.dipak.hostelmgmtsystem.dao.AdminDao;
import com.dipak.hostelmgmtsystem.dao.AdminDaoImpl;


import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogInForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userNameTxtBox;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public LogInForm() {
		setResizable(false);
		setTitle("LogIn Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(432, 399);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new TitledBorder(new LineBorder(new Color(255, 175, 175), 2, true), "Log in Form",
				TitledBorder.CENTER, TitledBorder.TOP, new Font(null, Font.BOLD, 12), Color.BLUE));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setForeground(new Color(50, 205, 50));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(68, 111, 68, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(new Color(50, 205, 50));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(68, 171, 80, 14);
		contentPane.add(lblNewLabel_1);
		
		userNameTxtBox = new JTextField();
		userNameTxtBox.setBounds(170, 111, 142, 20);
		contentPane.add(userNameTxtBox);
		userNameTxtBox.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(170, 168, 142, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userName=userNameTxtBox.getText();
				String password=new String(passwordField.getPassword());
				AdminDao adminDao=new AdminDaoImpl();
				int userId=adminDao.login(userName, password);
				if(userId>=1) {
					Dashboard dashboard=new Dashboard();
					dashboard.userNameLbl.setText(userName);
					dashboard.setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(LogInForm.this, "worng Username or password !!!","ERROR!!!",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setForeground(new Color(50, 205, 50));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(170, 237, 142, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SignUp");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignUpForm signup=new SignUpForm();
				signup.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(50, 205, 50));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(170, 302, 142, 37);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("You would like to signup first?,click on singup.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setBounds(138, 285, 217, 14);
		contentPane.add(lblNewLabel_2);
	}
}

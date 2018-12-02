package com.dipak.hostelmgmtsystem.view;


import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.dipak.hostelmgmtsystem.dao.AdminDao;
import com.dipak.hostelmgmtsystem.dao.AdminDaoImpl;
import com.dipak.hostelmgmtsystem.dto.Admin;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUpForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userNameTxtBox;
	private JTextField emailTxtBox;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Create the frame.
	 */
	public SignUpForm() {
		setResizable(false);
		setTitle("User Signup Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(512, 466);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 0), 2, true), "User SignUp Form",
				TitledBorder.CENTER, TitledBorder.TOP,new Font(null, Font.BOLD, 12), Color.BLUE));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(new Color(50, 205, 50));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(95, 112, 79, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(50, 205, 50));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(95, 151, 79, 14);
		contentPane.add(lblPassword);
		
		JLabel lblReenterPassword = new JLabel("Re-Enter Password");
		lblReenterPassword.setForeground(new Color(50, 205, 50));
		lblReenterPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblReenterPassword.setBounds(93, 189, 117, 14);
		contentPane.add(lblReenterPassword);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(50, 205, 50));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(95, 230, 79, 14);
		contentPane.add(lblEmail);
		
		userNameTxtBox = new JTextField();
		userNameTxtBox.setBounds(220, 109, 182, 20);
		contentPane.add(userNameTxtBox);
		userNameTxtBox.setColumns(10);
		
		emailTxtBox = new JTextField();
		emailTxtBox.setBounds(220, 227, 182, 20);
		contentPane.add(emailTxtBox);
		emailTxtBox.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(220, 148, 182, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(220, 186, 182, 20);
		contentPane.add(passwordField_1);
		
		JButton signUpBtn = new JButton("SignUp");
		signUpBtn.setBackground(new Color(255, 240, 245));
		signUpBtn.setForeground(new Color(50, 205, 50));
		signUpBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		signUpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userName=userNameTxtBox.getText();
				String password=new String(passwordField.getPassword());
				String password1=new String(passwordField_1.getPassword());
				String email=emailTxtBox.getText();
				if(userName.isEmpty()||password.isEmpty()||password1.isEmpty()) {
					JOptionPane.showMessageDialog(SignUpForm.this, "Please fill all the necessary fields","Sorry!!!",JOptionPane.YES_NO_OPTION);
				}else
				{
				if(password.equalsIgnoreCase(password1)) {
					Admin admin=new Admin();
					admin.setUserName(userName);
					admin.setPassword(password);
					admin.setEmail(email);
					AdminDao adminDao=new AdminDaoImpl();
					int created=adminDao.getCreated(admin);
					if(created>=1) {
						JOptionPane.showMessageDialog(SignUpForm.this, "Successfully Created new User!!!","SUCCESS!!!",JOptionPane.PLAIN_MESSAGE);
					new LogInForm().setVisible(true);
					dispose();
					}
					else {
						JOptionPane.showMessageDialog(SignUpForm.this,"Database Connectivity Error","ERROR!!!",JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
				JOptionPane.showConfirmDialog(SignUpForm.this,"You want to enter again ?","Password not Matching!!!",JOptionPane.YES_NO_OPTION);
				}
				
			}
				}
		});
		signUpBtn.setBounds(354, 352, 117, 35);
		contentPane.add(signUpBtn);
	}
}

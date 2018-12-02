package com.dipak.hostelmgmtsystem.view;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SplashScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel splashScreenLbl;
	public JProgressBar progressBar;
static SplashScreen splashScreen;
private javax.swing.Timer timer;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		splashScreen=new SplashScreen();
		splashScreen.getTimer();
	}

	/**
	 * Create the frame.
	 */
	public SplashScreen() {
		setResizable(false);
		setTitle("Hostel Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(436,368);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		splashScreenLbl = new JLabel("");
		splashScreenLbl.setIcon(new ImageIcon(SplashScreen.class.getResource("/images/Hostel-Management-System_web-Global-IT-Solution.png")));
		splashScreenLbl.setBounds(0, 0, 430, 289);
		contentPane.add(splashScreenLbl);
		
		timer=new javax.swing.Timer(50, new progressBarListener());
		
		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(0, 0, 205));
		progressBar.setStringPainted(true);
		progressBar.setBounds(0, 289, 430, 50);
		contentPane.add(progressBar);
	}
	public void getTimer() {
		timer.start();
	}
	private class progressBarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		int val=progressBar.getValue();
		splashScreen.setVisible(true);
		if(val==100) {
			timer.stop();
			splashScreen.setVisible(false);
			new LogInForm().setVisible(true);
		}
		progressBar.setValue(++val);
		}
		
	}
}

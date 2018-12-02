package com.dipak.hostelmgmtsystem.view;


import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Dashboard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel userNameLbl;
	public JLabel clockLbl;

	/**
	 * Create the frame.
	 */
	public Dashboard() {
		setResizable(false);
		setTitle("DashBoard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit toolKit=Toolkit.getDefaultToolkit();
		Dimension dim=toolKit.getScreenSize();
		setSize(dim.width, dim.height);
		setSize(1366,859);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(250, 128, 114));
		desktopPane.setBounds(0, 92, 1360, 667);
		contentPane.add(desktopPane);
		
		clockLbl = new JLabel("");
		clockLbl.setForeground(new Color(0, 0, 205));
		clockLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		clockLbl.setBounds(1196, 11, 154, 23);
		desktopPane.add(clockLbl);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1360, 26);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("Student  ");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_1.setForeground(new Color(0, 0, 139));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New Student");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentRegistration studentRegistration=new StudentRegistration();
				desktopPane.add(studentRegistration);
				studentRegistration.show();
			}
		});
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {	
			}
		});
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mntmNewMenuItem.setForeground(new Color(0, 0, 139));
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Student Details");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AllStudent allStudent=new AllStudent();
			desktopPane.add(allStudent);
			allStudent.show();
			}
		});
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mntmNewMenuItem_1.setForeground(new Color(0, 0, 139));
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("Hostel Rooms  ");
		mnNewMenu_2.setForeground(new Color(0, 0, 139));
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New Room");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomCreate roomCreate=new RoomCreate();
				desktopPane.add(roomCreate);
				roomCreate.show();
			}
		});
		mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mntmNewMenuItem_2.setForeground(new Color(0, 0, 139));
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Room Details");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllRooms allRooms=new AllRooms();
				desktopPane.add(allRooms);
				allRooms.show();
			}
		});
		mntmNewMenuItem_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mntmNewMenuItem_3.setForeground(new Color(0, 0, 139));
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_3 = new JMenu("Tools    ");
		mnNewMenu_3.setForeground(new Color(0, 0, 139));
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Notepad");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Runtime rt=Runtime.getRuntime();
				try {
					rt.exec("notepad.exe");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		mntmNewMenuItem_4.setForeground(new Color(0, 0, 139));
		mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_3.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("MS-Paint");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runtime rt=Runtime.getRuntime();
				try {
					rt.exec("mspaint.exe");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		mntmNewMenuItem_5.setForeground(new Color(0, 0, 139));
		mntmNewMenuItem_5.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_4 = new JMenu("Extra");
		mnNewMenu_4.setForeground(new Color(0, 0, 139));
		mnNewMenu_4.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Calculator");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runtime rt=Runtime.getRuntime();
			try {
				rt.exec("calc.exe");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			}
		});
		mntmNewMenuItem_6.setForeground(new Color(0, 0, 139));
		mntmNewMenuItem_6.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_4.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu = new JMenu("");
		menuBar.add(mnNewMenu);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 25, 509, 34);
		contentPane.add(toolBar);
		
		JButton btnNewButton = new JButton("New Student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentRegistration st=new StudentRegistration();
				desktopPane.add(st);
				st.show();
			}
		});
		btnNewButton.setIcon(new ImageIcon(Dashboard.class.getResource("/images/Young-student1.jpg")));
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("All Student");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllStudent all=new AllStudent();
				desktopPane.add(all);
				all.show();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(Dashboard.class.getResource("/images/images1.png")));
		btnNewButton_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New Room");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomCreate rc=new RoomCreate();
				desktopPane.add(rc);
				rc.show();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(Dashboard.class.getResource("/images/room.jpg")));
		btnNewButton_2.setForeground(new Color(0, 0, 128));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		toolBar.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("All Room");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllRooms ar=new AllRooms();
				desktopPane.add(ar);
				ar.show();
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(Dashboard.class.getResource("/images/allrooms.gif")));
		btnNewButton_3.setForeground(new Color(0, 0, 128));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		toolBar.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Logout");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LogInForm().setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setForeground(new Color(0, 0, 128));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setBounds(1262, 45, 88, 34);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("Username :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/images/user.jpg")));
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setBounds(990, 37, 119, 45);
		contentPane.add(lblNewLabel);
		
		userNameLbl = new JLabel("");
		userNameLbl.setForeground(new Color(0, 0, 128));
		userNameLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		userNameLbl.setBounds(1107, 45, 129, 26);
		contentPane.add(userNameLbl);
		showClock();
	}
	public void showClock() {
		Thread clock=new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(;;) {
					Calendar cal=Calendar.getInstance();
					int year=cal.get(Calendar.YEAR);
					int month=cal.get(Calendar.MONTH);
					int day=cal.get(Calendar.DAY_OF_MONTH)+1;
					int hour=cal.get(Calendar.HOUR);
					int minute=cal.get(Calendar.MINUTE);
					int second=cal.get(Calendar.SECOND);
					clockLbl.setText(hour+":"+minute+":"+second+":"+""+year+"/"+month+"/"+day);
				}
				}
		});
		clock.start();
	}
}

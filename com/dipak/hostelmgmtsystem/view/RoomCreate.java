package com.dipak.hostelmgmtsystem.view;


import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel; 
import javax.swing.border.TitledBorder;

import com.dipak.hostelmgmtsystem.dao.StudentDao;
import com.dipak.hostelmgmtsystem.dao.StudentDaoImpl;
import com.dipak.hostelmgmtsystem.dto.Student;

import javax.swing.border.LineBorder;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JDesktopPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class RoomCreate extends JInternalFrame {
StudentDao studentDao=new StudentDaoImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField roomNoTxtBox;
	private JTextField totalSeatsTxtBox;
	public JCheckBox firstSeatChkBox;
	public JCheckBox secondSeatChkBox ;
	public JCheckBox thirdSeatChkBox;
	public JLabel idLbl;
	public JRadioButton fRadioBtn;
	public JRadioButton vRadioBtn;
	public JLabel ridLbl;
	public JLabel stuIdLbl;
	
	/**
	 * Create the frame.
	 */
	public RoomCreate() {
		setClosable(true);
		setResizable(false);
		setTitle("New Room");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(572, 457);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new TitledBorder(new LineBorder(new Color(210, 180, 140), 2, true),
				"Create Room/Update Room", TitledBorder.CENTER, TitledBorder.TOP, new Font(null, Font.BOLD, 12), new Color(0, 0, 205)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		idLbl = new JLabel("");
		idLbl.setBounds(34, 48, 46, 14);
		contentPane.add(idLbl);
		
		JLabel lblNewLabel_1 = new JLabel("Room No");
		lblNewLabel_1.setForeground(new Color(50, 205, 50));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(89, 137, 62, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblSeats = new JLabel("Seats");
		lblSeats.setForeground(new Color(50, 205, 50));
		lblSeats.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSeats.setBounds(89, 182, 46, 14);
		contentPane.add(lblSeats);
		
		JLabel lblTargetedSeatNo = new JLabel("Targeted Seat No");
		lblTargetedSeatNo.setForeground(new Color(50, 205, 50));
		lblTargetedSeatNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTargetedSeatNo.setBounds(89, 239, 106, 14);
		contentPane.add(lblTargetedSeatNo);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setForeground(new Color(50, 205, 50));
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStatus.setBounds(89, 285, 46, 14);
		contentPane.add(lblStatus);
		
		roomNoTxtBox = new JTextField();
		roomNoTxtBox.setBounds(183, 134, 159, 20);
		contentPane.add(roomNoTxtBox);
		roomNoTxtBox.setColumns(10);
		
		totalSeatsTxtBox = new JTextField();
		totalSeatsTxtBox.setBounds(183, 179, 159, 20);
		contentPane.add(totalSeatsTxtBox);
		totalSeatsTxtBox.setColumns(10);
		
		firstSeatChkBox = new JCheckBox("First");
		firstSeatChkBox.setBackground(new Color(240, 255, 255));
		firstSeatChkBox.setForeground(new Color(50, 205, 50));
		firstSeatChkBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		firstSeatChkBox.setBounds(196, 235, 62, 23);
		contentPane.add(firstSeatChkBox);
		
		secondSeatChkBox = new JCheckBox("Second");
		secondSeatChkBox.setBackground(new Color(240, 255, 255));
		secondSeatChkBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		secondSeatChkBox.setForeground(new Color(50, 205, 50));
		secondSeatChkBox.setBounds(260, 235, 67, 23);
		contentPane.add(secondSeatChkBox);
		
		thirdSeatChkBox = new JCheckBox("Third");
		thirdSeatChkBox.setBackground(new Color(240, 255, 255));
		thirdSeatChkBox.setForeground(new Color(50, 205, 50));
		thirdSeatChkBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		thirdSeatChkBox.setBounds(344, 235, 62, 23);
		contentPane.add(thirdSeatChkBox);
		
		JButton checkRoomBtn = new JButton("Check");
		checkRoomBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int roomNo=Integer.parseInt(roomNoTxtBox.getText());
				Student st=studentDao.getRoomById(roomNo);
				if(roomNo!=st.getRoomNo()) {
					JOptionPane.showMessageDialog(RoomCreate.this, "Sorry same Room Number is not Found","SORRY!!!",JOptionPane.ERROR_MESSAGE);
				}
				else {
					stuIdLbl.setText(String.valueOf(st.getId()));
					totalSeatsTxtBox.setText(String.valueOf(st.getSeats()));
					ridLbl.setText(String.valueOf(st.getRid()));
					//for targeted seats
					String[] seat=st.getTargetedSeat().split("/");
					for(String seats:seat) {
						if(seats.equals("First")) {
							firstSeatChkBox.setSelected(true);
						}
						if(seats.equalsIgnoreCase("Second")) {
							secondSeatChkBox.setSelected(true);
						}
						if(seats.equals("Third"))
								{
							thirdSeatChkBox.setSelected(true);
						}
					}
					//for status
					if(st.getStatus().equals("Full")) {
						fRadioBtn.setSelected(true);
					}
					else {
						vRadioBtn.setSelected(true);
					
				}
				}
			}
		});
		checkRoomBtn.setForeground(new Color(50, 205, 50));
		checkRoomBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		checkRoomBtn.setBounds(386, 133, 89, 23);
		contentPane.add(checkRoomBtn);
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Student student=new Student();
				student.setRoomNo(Integer.parseInt(roomNoTxtBox.getText()));
				student.setSeats(Integer.parseInt(totalSeatsTxtBox.getText()));
			//student.setAvailableSeats(Integer.parseInt(availableSeatsTxtBox.getText()));
			//for targeted seats check box
			String targetedSeat="";
			if(firstSeatChkBox.isSelected()) {
				targetedSeat=targetedSeat+firstSeatChkBox.getText()+"/";
			}
			if(secondSeatChkBox.isSelected()) {
				targetedSeat=targetedSeat+secondSeatChkBox.getText()+"/";
			}
			if(thirdSeatChkBox.isSelected()) {
				targetedSeat=targetedSeat+thirdSeatChkBox.getText()+"/";
			}
		student.setTargetedSeat(targetedSeat);
		if(fRadioBtn.isSelected()) {
			student.setStatus("Full");
		}
		else {
			student.setStatus("Vacant");
		}
		StudentDao studentDao=new StudentDaoImpl();
		String id=idLbl.getText();
		if(id==null ||id.isEmpty()){
			int rooms=studentDao.createRoom(student);
			student.setId(Integer.parseInt("0"));
			if(rooms>=1) {
				JOptionPane.showMessageDialog(RoomCreate.this, "Successfully Created new Room","Room Created !!!",JOptionPane.PLAIN_MESSAGE);
				JDesktopPane desktopPane=getDesktopPane();
				AllRooms allroom=new AllRooms();
				desktopPane.add(allroom);
				allroom.show();
				dispose();
			}
			else {
				JOptionPane.showMessageDialog(RoomCreate.this, "Database error occur","ERROR !!!",JOptionPane.ERROR_MESSAGE);
				}
		}
		else {
			student.setId(Integer.parseInt(idLbl.getText()));
			student.setRid(Integer.parseInt(ridLbl.getText()));
			int sid=Integer.parseInt(stuIdLbl.getText());
			if(sid==0) {
			int update=studentDao.updateRoom(student);
			if(update>=1) {
				int shifted=studentDao.shiftRoom(student);
				if(shifted>=1) {
				JOptionPane.showMessageDialog(RoomCreate.this, "Successfully shifted into new Room","shifted !!!",JOptionPane.PLAIN_MESSAGE);
				JDesktopPane desktopPane=getDesktopPane();
				AllRooms allRoom=new AllRooms();
				desktopPane.add(allRoom);
				allRoom.show();
				dispose();
			}
				}
			else {
				JOptionPane.showMessageDialog(RoomCreate.this, "same room is not found","ERROR !!!",JOptionPane.ERROR_MESSAGE);
			}
		}
			else {
				JOptionPane.showMessageDialog(RoomCreate.this, "same room is not vacant","Sorry Room is Already Full !!!",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		}
		});
		submitBtn.setForeground(new Color(50, 205, 50));
		submitBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		submitBtn.setBounds(222, 365, 120, 31);
		contentPane.add(submitBtn);
		
		fRadioBtn = new JRadioButton("Full");
		fRadioBtn.setForeground(new Color(50, 205, 50));
		fRadioBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		fRadioBtn.setBackground(new Color(240, 255, 255));
		fRadioBtn.setBounds(195, 281, 46, 23);
		contentPane.add(fRadioBtn);
		
		vRadioBtn = new JRadioButton("Vacant");
		vRadioBtn.setForeground(new Color(50, 205, 50));
		vRadioBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		vRadioBtn.setBackground(new Color(240, 255, 255));
		vRadioBtn.setBounds(260, 281, 67, 23);
		contentPane.add(vRadioBtn);
		//adding radio button into one group
		ButtonGroup group=new ButtonGroup();
		group.add(fRadioBtn);
		group.add(vRadioBtn);
		
		ridLbl = new JLabel("");
		ridLbl.setBounds(34, 73, 46, 14);
		contentPane.add(ridLbl);
		
		stuIdLbl = new JLabel("");
		stuIdLbl.setBounds(404, 182, 46, 14);
		contentPane.add(stuIdLbl);
	}
}

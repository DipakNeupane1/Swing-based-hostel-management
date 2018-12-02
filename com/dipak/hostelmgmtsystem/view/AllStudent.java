package com.dipak.hostelmgmtsystem.view;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.dipak.hostelmgmtsystem.dao.StudentDao;
import com.dipak.hostelmgmtsystem.dao.StudentDaoImpl;
import com.dipak.hostelmgmtsystem.dto.Student;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AllStudent extends JInternalFrame {
StudentDao studentDao=new StudentDaoImpl();
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable studentTable;
	private JTextField searchTxtBox;

	/**
	 * Create the frame.
	 */
	public AllStudent() {
		setClosable(true);
		setResizable(false);
		setTitle("Student Registration Details");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(917, 308);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		studentTable = new JTable();
		String [] columnNames= {"ID","Name","Address","Phone No","Email","DOB","College Name","Subject","Department","Gender","Admission Fee","Admission Date","Hostel Fee","Pay/Pending Date","Room No"};
		DefaultTableModel tableModel=new DefaultTableModel(columnNames, 0);
		studentTable.setModel(tableModel);
		//calling method define below //method for extract the value from database and set into student table
		loadStudentInTable();
		
		JScrollPane scrollPane = new JScrollPane(studentTable);
		scrollPane.setBounds(10, 44, 891, 173);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("New Student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDesktopPane desktopPane=getDesktopPane();
				StudentRegistration studentRegistration=new StudentRegistration();
				desktopPane.add(studentRegistration);
			studentRegistration.show();
	dispose();
			}
		});
		btnNewButton.setForeground(new Color(50, 205, 50));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(10, 239, 119, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update Sutdent");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel tableModel=(DefaultTableModel) studentTable.getModel();
				int row=studentTable.getSelectedRow();
				Object id=tableModel.getValueAt(row, 0);
				Student st=studentDao.getStudentById(Integer.parseInt(id.toString()));
				StudentRegistration sReg=new StudentRegistration();
				sReg.lblSid.setText(String.valueOf(st.getId()));
				sReg.sNameTxtBox.setText(st.getsName());
				sReg.sAddTxtBox.setText(st.getsAddress());
				sReg.sPhoneTxtBox.setText(st.getsPhoneNo());
				sReg.sEmailTxtBox.setText(st.getEmail());
				sReg.dobDateChooser.setDate(st.getDob());
				sReg.sCollegeTxtBox.setText(st.getcName());
				sReg.departcomboBox.setSelectedItem((Object) st.getDepartment());
				sReg.AddDateChooser.setDate(st.getAddDate());
				sReg.hDateChooser.setDate(st.getFeeDate());
				//for radio buttons
				if(st.getGender().equals("Male")) {
					sReg.mRadioBtn.setSelected(true);
				}
				else {
					sReg.fRadioBtn.setSelected(true);
				}
				//another radio buttons
				if(st.getAdmissionFee().equals("Paid")) {
					sReg.rdbtnPaid.setSelected(true);
				}
				else {
					sReg.rdbtnUnpaid.setSelected(true);
				}
				//another radio buttons
				if(st.getHostelFee().equals("Clear")) {
					sReg.rdbtnClear.setSelected(true);
				}
				else {
					sReg.rdbtnPending.setSelected(true);
				}
				//for subject
				String [] subjects=st.getSubject().split("/");
			for(String sub:subjects) {
				if(sub.equals("Medical")) {
					sReg.subMedicalChkBox.setSelected(true);
				}
				if(sub.equals("Java")) {
					sReg.subJavaChkBox.setSelected(true);
				}
				if(sub.equals("Account")) {
					sReg.subAccChkBox.setSelected(true);
				}
				if(sub.equals("Education")) {
					sReg.subEduChkBox.setSelected(true);
				}
			}
			//for imageurl
			ImageIcon imageIcon=new ImageIcon(st.getImageUrl());
			Image image=imageIcon.getImage().getScaledInstance(128, 130, Image.SCALE_SMOOTH);
			sReg.picUploadLbl.setIcon(new ImageIcon(image));
			JDesktopPane desktopPane=getDesktopPane();
			desktopPane.add(sReg);
			sReg.show();
			dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(50, 205, 50));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(150, 239, 146, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete Student");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel=(DefaultTableModel) studentTable.getModel();
				int row=studentTable.getSelectedRow();
				Object id=tableModel.getValueAt(row, 0);
				int messages=JOptionPane.showConfirmDialog(AllStudent.this, "Are You sure to delete this record","DELETE!!!",JOptionPane.YES_NO_OPTION);
				if(messages==0) {
					studentDao.deleteStudent(Integer.parseInt(id.toString()));
					loadStudentInTable();
				}
			}
		});
		btnNewButton_2.setForeground(new Color(50, 205, 50));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(306, 239, 142, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Shift In Room");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel tableModel=(DefaultTableModel) studentTable.getModel();
				int row=studentTable.getSelectedRow();
				Object id=tableModel.getValueAt(row, 0);
				RoomCreate rCreate=new RoomCreate();
				rCreate.idLbl.setText(String.valueOf(id));
				JDesktopPane desktopPane=getDesktopPane();
				desktopPane.add(rCreate);
				rCreate.show();
				dispose();
				
			}
		});
		btnNewButton_3.setForeground(new Color(50, 205, 50));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBounds(458, 239, 128, 29);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Registered Student Details");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(310, 24, 190, 22);
		contentPane.add(lblNewLabel);
		
		searchTxtBox = new JTextField();
		searchTxtBox.setToolTipText("Search By Name EG:Dipak");
		searchTxtBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				String sName=searchTxtBox.getText();
				if(sName==null || sName.isEmpty()) {
					loadStudentInTable();
				}
				else {
					loadNameInTable(sName);
				}
			}
		});
		searchTxtBox.setBounds(757, 13, 144, 20);
		contentPane.add(searchTxtBox);
		searchTxtBox.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Search Student By Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setBounds(605, 15, 146, 14);
		contentPane.add(lblNewLabel_1);
	}
	public void loadStudentInTable() {
		List<Student> allStudent=studentDao.allStudent();
		DefaultTableModel tableModel=(DefaultTableModel) studentTable.getModel();
		tableModel.setRowCount(0);
		for(Student s:allStudent) {
			tableModel.addRow(new Object[] {s.getId(),s.getsName(),s.getsAddress(),s.getsPhoneNo(),s.getEmail(),s.getDob(),s.getcName(),s.getSubject(),s.getDepartment(),s.getGender(),s.getAdmissionFee(),s.getAddDate(),s.getHostelFee(),s.getFeeDate(),s.getRoomNo()});
		}
	}
	public void loadNameInTable(String sName) {
		List<Student> allsName=studentDao.searchStudent(sName);
		DefaultTableModel tableModel=(DefaultTableModel) studentTable.getModel();
		tableModel.setRowCount(0);
		for(Student ss:allsName) {
			tableModel.addRow(new Object[] {ss.getId(),ss.getsName(),ss.getsAddress(),ss.getsPhoneNo(),ss.getEmail(),ss.getDob(),ss.getcName(),ss.getSubject(),ss.getDepartment(),ss.getGender(),ss.getAdmissionFee(),ss.getAddDate(),ss.getHostelFee(),ss.getFeeDate(),ss.getRoomNo()});
		}
	}
}

package com.dipak.hostelmgmtsystem.view;



import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;

import com.dipak.hostelmgmtsystem.dao.StudentDao;
import com.dipak.hostelmgmtsystem.dao.StudentDaoImpl;
import com.dipak.hostelmgmtsystem.dto.Student;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentRegistration extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField sNameTxtBox;
	public JTextField sAddTxtBox;
	public JTextField sPhoneTxtBox;
	public JTextField sEmailTxtBox;
	public JTextField sCollegeTxtBox;
	public JComboBox<String> departcomboBox;
	public JLabel picUploadLbl;
	public JCheckBox subMedicalChkBox;
	public JCheckBox subAccChkBox;
	public JCheckBox subJavaChkBox;
	public JCheckBox subEduChkBox;
	public JRadioButton mRadioBtn;
	public JRadioButton fRadioBtn;
	public JDateChooser AddDateChooser;
	public JDateChooser hDateChooser;
	public JDateChooser dobDateChooser;
	public JLabel lblSid;
	public JRadioButton rdbtnPaid;
	public JRadioButton rdbtnUnpaid;
	public  JRadioButton rdbtnClear;
	public JRadioButton rdbtnPending;
public static final String IMAGE_UPLOAD_PATH="/E:/hostelimages/";
File file;

	/**
	 * Create the frame.
	 */
	public StudentRegistration() {
		setClosable(true);
		setResizable(false);
		setTitle("Student Registration Form");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(584, 663);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new TitledBorder(new LineBorder(new Color(244, 164, 96), 2, true),
				"Student Registration Form", TitledBorder.CENTER, TitledBorder.TOP,new Font(null,Font.BOLD, 14), new Color(0, 0, 205)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Address");
		lblNewLabel.setForeground(new Color(50, 205, 50));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(78, 107, 63, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblPhoneNo = new JLabel("phone No");
		lblPhoneNo.setForeground(new Color(50, 205, 50));
		lblPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPhoneNo.setBounds(78, 152, 63, 21);
		contentPane.add(lblPhoneNo);
		
		JLabel lblEmail = new JLabel("Email ");
		lblEmail.setForeground(new Color(50, 205, 50));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(78, 195, 55, 21);
		contentPane.add(lblEmail);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setForeground(new Color(50, 205, 50));
		lblDob.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDob.setBounds(78, 238, 55, 21);
		contentPane.add(lblDob);
		
		JLabel lblCollegeName = new JLabel("College Name");
		lblCollegeName.setForeground(new Color(50, 205, 50));
		lblCollegeName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCollegeName.setBounds(78, 281, 88, 21);
		contentPane.add(lblCollegeName);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setForeground(new Color(50, 205, 50));
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSubject.setBounds(78, 313, 63, 21);
		contentPane.add(lblSubject);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setForeground(new Color(50, 205, 50));
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDepartment.setBounds(78, 353, 88, 21);
		contentPane.add(lblDepartment);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(new Color(50, 205, 50));
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGender.setBounds(78, 402, 63, 21);
		contentPane.add(lblGender);
		
		JLabel lblAddmissionFee = new JLabel("Addmission Fee");
		lblAddmissionFee.setForeground(new Color(50, 205, 50));
		lblAddmissionFee.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddmissionFee.setBounds(78, 438, 88, 21);
		contentPane.add(lblAddmissionFee);
		
		JLabel label_8 = new JLabel(" Name");
		label_8.setForeground(new Color(50, 205, 50));
		label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_8.setBounds(78, 62, 55, 21);
		contentPane.add(label_8);
		
		JLabel lblFeePaidDate = new JLabel("Fee paid Date");
		lblFeePaidDate.setForeground(new Color(50, 205, 50));
		lblFeePaidDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFeePaidDate.setBounds(78, 571, 88, 21);
		contentPane.add(lblFeePaidDate);
		
		JLabel lblHostelFee = new JLabel("Hostel Fee");
		lblHostelFee.setForeground(new Color(50, 205, 50));
		lblHostelFee.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHostelFee.setBounds(78, 529, 88, 21);
		contentPane.add(lblHostelFee);
		
		JLabel lblAddmissionDate = new JLabel("Addmission Date");
		lblAddmissionDate.setForeground(new Color(50, 205, 50));
		lblAddmissionDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddmissionDate.setBounds(78, 482, 102, 21);
		contentPane.add(lblAddmissionDate);
		
		sNameTxtBox = new JTextField();
		sNameTxtBox.setBounds(193, 62, 177, 20);
		contentPane.add(sNameTxtBox);
		sNameTxtBox.setColumns(10);
		
		sAddTxtBox = new JTextField();
		sAddTxtBox.setColumns(10);
		sAddTxtBox.setBounds(193, 107, 177, 20);
		contentPane.add(sAddTxtBox);
		
		sPhoneTxtBox = new JTextField();
		sPhoneTxtBox.setColumns(10);
		sPhoneTxtBox.setBounds(193, 152, 177, 20);
		contentPane.add(sPhoneTxtBox);
		
		sEmailTxtBox = new JTextField();
		sEmailTxtBox.setColumns(10);
		sEmailTxtBox.setBounds(193, 195, 177, 20);
		contentPane.add(sEmailTxtBox);
		
		sCollegeTxtBox = new JTextField();
		sCollegeTxtBox.setColumns(10);
		sCollegeTxtBox.setBounds(193, 281, 177, 20);
		contentPane.add(sCollegeTxtBox);
		
		subMedicalChkBox = new JCheckBox("Medical ");
		subMedicalChkBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		subMedicalChkBox.setForeground(new Color(50, 205, 50));
		subMedicalChkBox.setBackground(new Color(240, 255, 255));
		subMedicalChkBox.setBounds(193, 312, 71, 23);
		contentPane.add(subMedicalChkBox);
		
		subAccChkBox = new JCheckBox("Account");
		subAccChkBox.setForeground(new Color(50, 205, 50));
		subAccChkBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		subAccChkBox.setBackground(new Color(240, 255, 255));
		subAccChkBox.setBounds(266, 312, 75, 23);
		contentPane.add(subAccChkBox);
		
		subJavaChkBox = new JCheckBox("Java");
		subJavaChkBox.setForeground(new Color(50, 205, 50));
		subJavaChkBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		subJavaChkBox.setBackground(new Color(240, 255, 255));
		subJavaChkBox.setBounds(343, 312, 57, 23);
		contentPane.add(subJavaChkBox);
		
		subEduChkBox = new JCheckBox("Education");
		subEduChkBox.setForeground(new Color(50, 205, 50));
		subEduChkBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		subEduChkBox.setBackground(new Color(240, 255, 255));
		subEduChkBox.setBounds(399, 312, 88, 23);
		contentPane.add(subEduChkBox);
		
		departcomboBox = new JComboBox<>();
		departcomboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		departcomboBox.setForeground(new Color(50, 205, 50));
		departcomboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Science And Technology", "Medicine", "Management", "Education", "Humanities"}));
		departcomboBox.setBackground(new Color(240, 255, 255));
		departcomboBox.setBounds(193, 353, 177, 20);
		contentPane.add(departcomboBox);
		
		mRadioBtn = new JRadioButton("Male");
		mRadioBtn.setForeground(new Color(50, 205, 50));
		mRadioBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		mRadioBtn.setBackground(new Color(240, 255, 255));
		mRadioBtn.setBounds(193, 401, 55, 23);
		contentPane.add(mRadioBtn);
		
		fRadioBtn = new JRadioButton("Female");
		fRadioBtn.setForeground(new Color(50, 205, 50));
		fRadioBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		fRadioBtn.setBackground(new Color(240, 255, 255));
		fRadioBtn.setBounds(266, 401, 75, 23);
		contentPane.add(fRadioBtn);
		
		ButtonGroup group=new ButtonGroup();
		group.add(mRadioBtn);
		group.add(fRadioBtn);
		
		
		AddDateChooser = new JDateChooser();
		AddDateChooser.setBounds(192, 482, 149, 20);
		contentPane.add(AddDateChooser);
		
		hDateChooser = new JDateChooser();
		hDateChooser.setBounds(193, 571, 155, 20);
		contentPane.add(hDateChooser);
		
		dobDateChooser = new JDateChooser();
		dobDateChooser.setBounds(193, 239, 177, 20);
		contentPane.add(dobDateChooser);
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Student student=new Student();
				student.setsName(sNameTxtBox.getText());
				student.setsAddress(sAddTxtBox.getText());
				student.setsPhoneNo(new String(sPhoneTxtBox.getText()));
				student.setEmail(sEmailTxtBox.getText());
				student.setDob(dobDateChooser.getDate());
				student.setAddDate(AddDateChooser.getDate());
				student.setFeeDate(hDateChooser.getDate());
				student.setDepartment((String) departcomboBox.getSelectedItem());
				student.setcName(sCollegeTxtBox.getText());
				
				String imageUrl="";
				if(file!=null) {
				imageUrl=IMAGE_UPLOAD_PATH+file.getName();
				}
				else {
					imageUrl=null;
				}
				student.setImageUrl(imageUrl);
				//for checkboxes
				String subject="";
				if(subMedicalChkBox.isSelected()) {
					subject=subject+subMedicalChkBox.getText()+"/";
				}
				if(subAccChkBox.isSelected()) {
					subject=subject+subAccChkBox.getText()+"/";
				}
				if(subJavaChkBox.isSelected()) {
					subject=subject+subJavaChkBox.getText()+"/";
				}
				if(subEduChkBox.isSelected()) {
					subject=subject+subEduChkBox.getText()+"/";
				}
				student.setSubject(subject);
				//for radio buttons
				if(mRadioBtn.isSelected()) {
					student.setGender("Male");
				}
				else
				{
					student.setGender("Female");
				}
				//for admission fee buttons
				if(rdbtnPaid.isSelected()) {
					student.setAdmissionFee("Paid");
				}
				else {
					student.setAdmissionFee("Unpaid");
				}
				//for hostel fee buttons
				if(rdbtnClear.isSelected()) {
					student.setHostelFee("Clear");
				}
				else {
					student.setHostelFee("Pending");
				}
				
				StudentDao studentDao=new StudentDaoImpl();
				
				String StudentId=lblSid.getText();
				if(StudentId==null || StudentId.isEmpty()) {
				int register=studentDao.registerStudent(student);
			     if(register>=1) {
			    	 if(file==null) {
							JOptionPane.showConfirmDialog(StudentRegistration.this,"Do you want to submit without image","Are you sure!!!",JOptionPane.YES_OPTION);
						}else {
						try {
							BufferedImage bi=ImageIO.read(file);
							ImageIO.write(bi, "JPG",new File(imageUrl));
						} catch (IOException e) {
							e.printStackTrace();
						}
						}
					JOptionPane.showMessageDialog(StudentRegistration.this, "Successfully Registered New Student","Registered!!!",JOptionPane.PLAIN_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(StudentRegistration.this, "Database Error Occur","ERROR!!!",JOptionPane.ERROR_MESSAGE);
				}
				
				}
				else {
					student.setId(Integer.parseInt(lblSid.getText()));
					int update=studentDao.updateStudentInfo(student);
					if(update>=1) {
						JOptionPane.showMessageDialog(StudentRegistration.this,"Successfully Updated student information","Updated!!!",JOptionPane.PLAIN_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(StudentRegistration.this,"Database Error Occur!!!","ERROR!!!",JOptionPane.ERROR_MESSAGE);
					}
				}
				
				JDesktopPane desktopPane=getDesktopPane();
				AllStudent all=new AllStudent();
				desktopPane.add(all);
				all.show();
				dispose();
				
				}
		});
		submitBtn.setForeground(new Color(50, 205, 50));
		submitBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		submitBtn.setBounds(385, 593, 102, 23);
		contentPane.add(submitBtn);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(192, 192, 192), 2, true));
		panel.setBounds(428, 30, 123, 130);
		contentPane.add(panel);
		panel.setLayout(null);
		
		picUploadLbl = new JLabel("Photo");
		picUploadLbl.setBounds(0, 0, 133, 130);
		panel.add(picUploadLbl);
		picUploadLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFileChooser picChooser=new JFileChooser();
				if(picChooser.showOpenDialog(picUploadLbl)==JFileChooser.APPROVE_OPTION) {
					file=picChooser.getSelectedFile();
					ImageIcon imageIcon=new ImageIcon(picChooser.getSelectedFile().getPath());
					Image image=imageIcon.getImage().getScaledInstance(128, 130, Image.SCALE_SMOOTH);
					picUploadLbl.setIcon(new ImageIcon(image));
				}
			}
		});
		picUploadLbl.setForeground(new Color(0, 0, 205));
		picUploadLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		picUploadLbl.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblSid = new JLabel("");
		lblSid.setBounds(25, 45, 46, 14);
		contentPane.add(lblSid);
		
		rdbtnPaid = new JRadioButton("Paid");
		rdbtnPaid.setForeground(new Color(50, 205, 50));
		rdbtnPaid.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnPaid.setBackground(new Color(240, 255, 255));
		rdbtnPaid.setBounds(193, 437, 55, 23);
		contentPane.add(rdbtnPaid);
		
		rdbtnUnpaid = new JRadioButton("Unpaid");
		rdbtnUnpaid.setForeground(new Color(50, 205, 50));
		rdbtnUnpaid.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnUnpaid.setBackground(new Color(240, 255, 255));
		rdbtnUnpaid.setBounds(266, 437, 66, 23);
		contentPane.add(rdbtnUnpaid);
		
		ButtonGroup group1=new ButtonGroup();
		group1.add(rdbtnPaid);
		group1.add(rdbtnUnpaid);
		
		rdbtnClear = new JRadioButton("Clear");
		rdbtnClear.setForeground(new Color(50, 205, 50));
		rdbtnClear.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnClear.setBackground(new Color(240, 255, 255));
		rdbtnClear.setBounds(193, 528, 55, 23);
		contentPane.add(rdbtnClear);
		
		rdbtnPending = new JRadioButton("Pending");
		rdbtnPending.setForeground(new Color(50, 205, 50));
		rdbtnPending.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnPending.setBackground(new Color(240, 255, 255));
		rdbtnPending.setBounds(266, 528, 75, 23);
		contentPane.add(rdbtnPending);
		
		ButtonGroup group2=new ButtonGroup();
		group2.add(rdbtnClear);
		group2.add(rdbtnPending);
	}
}

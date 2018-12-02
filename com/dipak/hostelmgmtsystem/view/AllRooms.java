package com.dipak.hostelmgmtsystem.view;



import java.util.List;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.dipak.hostelmgmtsystem.dao.StudentDao;
import com.dipak.hostelmgmtsystem.dao.StudentDaoImpl;
import com.dipak.hostelmgmtsystem.dto.Student;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AllRooms extends JInternalFrame {
StudentDao studentDao=new StudentDaoImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable studentTable;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTextField searchtxtBox;
	private JLabel lblNewLabel;


	/**
	 * Create the frame.
	 */
	public AllRooms() {
		setClosable(true);
		setTitle("Rooms Details");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize( 513, 362);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		studentTable = new JTable();
		String []columnNames= {"rid","id","Room No","Total Seats","Targeted Seat","Status"};
		DefaultTableModel tableModel=new DefaultTableModel(columnNames,0);
		studentTable.setModel(tableModel);
		getAllRooms();
		JScrollPane scrollPane = new JScrollPane(studentTable);
		scrollPane.setBounds(10, 93, 477, 151);
		contentPane.add(scrollPane);
		
		btnNewButton = new JButton("Add Room");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDesktopPane desktopPane=getDesktopPane();
				RoomCreate rcreate=new RoomCreate();
				desktopPane.add(rcreate);
				rcreate.show();
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(50, 205, 50));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(37, 277, 110, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Update Room");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel tableModel=(DefaultTableModel) studentTable.getModel();
				int row=studentTable.getSelectedRow();
				Object id=tableModel.getValueAt(row, 1);
				Object rid=tableModel.getValueAt(row, 0);
				RoomCreate rCreate=new RoomCreate();
				rCreate.idLbl.setText(String.valueOf(id));
				rCreate.ridLbl.setText(String.valueOf(rid));
				JDesktopPane desktopPane=getDesktopPane();
				desktopPane.add(rCreate);
				rCreate.show();
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(50, 205, 50));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(157, 277, 137, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Delete Room");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel=(DefaultTableModel) studentTable.getModel();
				int row=studentTable.getSelectedRow();
				Object rid=tableModel.getValueAt(row, 0);
				int message=JOptionPane.showConfirmDialog(AllRooms.this,"Are you Want to delete this item??","DELETED!!!",JOptionPane.YES_NO_OPTION);
				if(message==0) {
					studentDao.deleteRoom(Integer.parseInt(rid.toString()));
					getAllRooms();
				}
			}
		});
		btnNewButton_2.setForeground(new Color(50, 205, 50));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(304, 277, 119, 23);
		contentPane.add(btnNewButton_2);
		
		searchtxtBox = new JTextField();
		searchtxtBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				String status=searchtxtBox.getText();
				if(status==null||status.isEmpty()) {
					getAllRooms();
				}
				else {
					getAllStatus(status);
				}
			}
		});
		searchtxtBox.setToolTipText("Type Eg:vacant");
		searchtxtBox.setBounds(354, 36, 133, 23);
		contentPane.add(searchtxtBox);
		searchtxtBox.setColumns(10);
		
		lblNewLabel = new JLabel("Search Status of All Rooms");
		lblNewLabel.setForeground(new Color(106, 90, 205));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(176, 41, 176, 15);
		contentPane.add(lblNewLabel);
	}
	public void getAllRooms() {
	List<Student> roomList=studentDao.allRooms();
	DefaultTableModel tableModel=(DefaultTableModel) studentTable.getModel();
	tableModel.setRowCount(0);
	for(Student s:roomList) {
		tableModel.addRow(new Object[] {s.getRid(),s.getId(),s.getRoomNo(),s.getSeats(),s.getTargetedSeat(),s.getStatus()});
	}
	}
	public void getAllStatus(String status) {
		List<Student> roomStatus=studentDao.searchRoom(status);
		DefaultTableModel tableModel=(DefaultTableModel) studentTable.getModel();
		tableModel.setRowCount(0);
		for(Student ss:roomStatus) {
			tableModel.addRow(new Object[] {ss.getRid(),ss.getId(),ss.getRoomNo(),ss.getSeats(),ss.getTargetedSeat(),ss.getStatus()});
		}
	}
}

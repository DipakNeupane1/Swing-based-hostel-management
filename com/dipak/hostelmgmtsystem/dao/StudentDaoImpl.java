package com.dipak.hostelmgmtsystem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dipak.hostelmgmtsystem.dto.Student;
import com.dipak.hostelmgmtsystem.util.DbUtil;

public class StudentDaoImpl implements StudentDao{
PreparedStatement ps=null;
Connection con=null;
	@Override
	public int createRoom(Student student) {
		String sql="insert into hostel_rooms(id,room_number,seats,targeted_seat,status)values(?,?,?,?,?)";
		int roomId=0;
		try {
			ps=DbUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, student.getId());
			ps.setInt(2,student.getRoomNo());
			ps.setInt(3,student.getSeats());
			//ps.setInt(4,student.getAvailableSeats());
			ps.setString(4,student.getTargetedSeat());
			ps.setString(5, student.getStatus());
			roomId=ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return roomId;
	}
	@Override
	public List<Student> allRooms() {
		List<Student> student=new ArrayList<>();
		String sql="select * from hostel_rooms";
		try {
			ps=DbUtil.getConnection().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Student studentResult=new Student();
				studentResult.setRid(rs.getInt("rid"));
				studentResult.setId(rs.getInt("id"));
				studentResult.setRoomNo(rs.getInt("room_number"));
				studentResult.setSeats(rs.getInt("seats"));
				studentResult.setTargetedSeat(rs.getString("targeted_seat"));
				studentResult.setStatus(rs.getString("status"));
				student.add(studentResult);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
	@Override
	public void deleteRoom(int rid) {
		String sql="delete from hostel_rooms where rid=?";
		try {
			ps=DbUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, rid);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Student> searchRoom(String status) {
		List<Student> roomStatus=new ArrayList<>();
		String sql="select * from hostel_rooms where status like ?";
		try {
			ps=DbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, "%"+status+"%");
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Student studentResult=new Student();
				studentResult.setRid(rs.getInt("rid"));
				studentResult.setId(rs.getInt("id"));
				studentResult.setRoomNo(rs.getInt("room_number"));
				studentResult.setSeats(rs.getInt("seats"));
				studentResult.setTargetedSeat(rs.getString("targeted_seat"));
				studentResult.setStatus(rs.getString("status"));
				roomStatus.add(studentResult);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return roomStatus;
	}
	@Override
	public int registerStudent(Student student) {
		String sql="insert into student_table(name,address,phone_no,email,dob,c_name,subject,department,gender,addmission_fee,addmission_date,hostel_fee,paid_date,image_url)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int registered=0;
		try {
			ps=DbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, student.getsName());
			ps.setString(2, student.getsAddress());
			ps.setString(3,student.getsPhoneNo());
			ps.setString(4, student.getEmail());
			ps.setDate(5,new Date(student.getDob().getTime()));
			ps.setString(6, student.getcName());
			ps.setString(7, student.getSubject());
			ps.setString(8, student.getDepartment());
			ps.setString(9, student.getGender());
			ps.setString(10, student.getAdmissionFee());
			ps.setDate(11, new Date(student.getAddDate().getTime()));
			ps.setString(12, student.getHostelFee());
			ps.setDate(13, new Date(student.getFeeDate().getTime()));
			//ps.setInt(14, student.getRoomNo());
			ps.setString(14, student.getImageUrl());
			registered=ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
    return registered;
	}
	@Override
	public List<Student> allStudent() {
		List<Student> allStudent=new ArrayList<>();
		String sql="select * from student_table";
		try {
			ps=DbUtil.getConnection().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Student student=new Student();
				student.setId(rs.getInt("id"));
				student.setsName(rs.getString("name"));
				student.setsAddress(rs.getString("address"));
				student.setsPhoneNo(rs.getString("phone_no"));
				student.setEmail(rs.getString("email"));
				student.setDob(rs.getDate("dob"));
				student.setcName(rs.getString("c_name"));
				student.setSubject(rs.getString("subject"));
				student.setDepartment(rs.getString("department"));
				student.setGender(rs.getString("gender"));
				student.setAdmissionFee(rs.getString("addmission_fee"));
				student.setAddDate(rs.getDate("addmission_date"));
				student.setHostelFee(rs.getString("hostel_fee"));
				student.setFeeDate(rs.getDate("paid_date"));
				student.setRoomNo(rs.getInt("room_no"));
				allStudent.add(student);	
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return allStudent;
	}
	@Override
	public void deleteStudent(int id) {
		String sql="delete from student_table where id=?";
		try {
			ps=DbUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Student> searchStudent(String sName) {
		List<Student> searchStudent=new ArrayList<>();
		String sql="select * from student_table where name like ?";
		try {
			ps=DbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, "%"+sName+"%");
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Student studentDetails=new Student();
				studentDetails.setId(rs.getInt("id"));
				studentDetails.setsName(rs.getString("name"));
				studentDetails.setsAddress(rs.getString("address"));
				studentDetails.setsPhoneNo(rs.getString("phone_no"));
				studentDetails.setEmail(rs.getString("email"));
				studentDetails.setDob(rs.getDate("dob"));
				studentDetails.setcName(rs.getString("c_name"));
				studentDetails.setSubject(rs.getString("subject"));
				studentDetails.setDepartment(rs.getString("department"));
				studentDetails.setGender(rs.getString("gender"));
				studentDetails.setAdmissionFee(rs.getString("addmission_fee"));
				studentDetails.setAddDate(rs.getDate("addmission_date"));
				studentDetails.setHostelFee(rs.getString("hostel_fee"));
				studentDetails.setFeeDate(rs.getDate("paid_date"));
				studentDetails.setRoomNo(rs.getInt("room_no"));
				searchStudent.add(studentDetails);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return searchStudent;
	}
	@Override
	public int updateStudentInfo(Student student) {
		String sql="update student_table set name=?,address=?,phone_no=?,email=?,dob=?,c_name=?,subject=?,department=?,gender=?,addmission_fee=?,addmission_date=?,hostel_fee=?,paid_date=?,image_url=? where id=?";
		int updated=0;
		try {
			ps=DbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, student.getsName());
			ps.setString(2, student.getsAddress());
			ps.setString(3,student.getsPhoneNo());
			ps.setString(4, student.getEmail());
			ps.setDate(5,new Date(student.getDob().getTime()));
			ps.setString(6, student.getcName());
			ps.setString(7, student.getSubject());
			ps.setString(8, student.getDepartment());
			ps.setString(9, student.getGender());
			ps.setString(10, student.getAdmissionFee());
			ps.setDate(11, new Date(student.getAddDate().getTime()));
			ps.setString(12, student.getHostelFee());
			ps.setDate(13, new Date(student.getFeeDate().getTime()));
			ps.setString(14, student.getImageUrl());
			ps.setInt(15, student.getId());
			updated=ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return updated;
	}
	@Override
	public Student getStudentById(int id) {
		Student student=new Student();
		String sql="select * from student_table where id=?";
		try {
			ps=DbUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				student.setId(rs.getInt("id"));
				student.setsName(rs.getString("name"));
				student.setsAddress(rs.getString("address"));
				student.setsPhoneNo(rs.getString("phone_no"));
				student.setEmail(rs.getString("email"));
				student.setDob(rs.getDate("dob"));
				student.setcName(rs.getString("c_name"));
				student.setSubject(rs.getString("subject"));
				student.setDepartment(rs.getString("department"));
				student.setGender(rs.getString("gender"));
				student.setAdmissionFee(rs.getString("addmission_fee"));
				student.setAddDate(rs.getDate("addmission_date"));
				student.setHostelFee(rs.getString("hostel_fee"));
				student.setFeeDate(rs.getDate("paid_date"));
				student.setRoomNo(rs.getInt("room_no"));
				student.setImageUrl(rs.getString("image_url"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
	
	@Override
	public int updateRoom(Student student) {
		int update=0;
		String sql="update hostel_rooms set rid=?,id=?,seats=?,targeted_seat=?,status=? where room_number=?";
		try {
			ps=DbUtil.getConnection().prepareStatement(sql);
			ps.setInt(1,student.getRid());
			ps.setInt(2, student.getId());
			ps.setInt(3, student.getSeats());
			ps.setString(4, student.getTargetedSeat());
			ps.setString(5, student.getStatus());
			ps.setInt(6, student.getRoomNo());
			update=ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return update;
	}
	@Override
	public int shiftRoom(Student student) {
		int shift=0;
		String sql="update student_table set room_no=? where id=?";
		try {
			ps=DbUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, student.getRoomNo());
			ps.setInt(2, student.getId());
			shift=ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return shift;
	}
	@Override
	public Student getRoomById(int roomNo) {
		Student student=new Student();
		String sql="select * from hostel_rooms where room_number=?";
		try {
			ps=DbUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, roomNo);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				student.setRid(rs.getInt("rid"));
				student.setRoomNo(rs.getInt("room_number"));
				student.setId(rs.getInt("id"));
				student.setSeats(rs.getInt("seats"));
				student.setTargetedSeat(rs.getString("targeted_seat"));
				student.setStatus(rs.getString("status"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return student;
		
	}

}

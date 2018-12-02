package com.dipak.hostelmgmtsystem.dao;

import java.util.List;

import com.dipak.hostelmgmtsystem.dto.Student;

public interface StudentDao{
public int createRoom(Student student);
public List<Student> allRooms();
public void deleteRoom(int rid);
public List<Student> searchRoom(String status);
public int registerStudent(Student student);
public List<Student> allStudent();
public void deleteStudent(int id);
public List<Student> searchStudent(String sName);
public  int updateStudentInfo(Student student);
public Student getStudentById(int id);
public int updateRoom(Student student);
public int shiftRoom(Student student);
public Student getRoomById(int roomNo);

}

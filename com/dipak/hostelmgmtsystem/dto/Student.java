package com.dipak.hostelmgmtsystem.dto;

import java.util.Date;

public class Student {
private int id;
private int rid;
private String sName;
private String sAddress;
private String sPhoneNo;
private String email;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
private Date dob;
private String imageUrl;
private String cName;
private String subject;
private String department;
private String gender;
private String AdmissionFee;
private Date addDate;
private String hostelFee;
private Date feeDate;
private int roomNo;
private int  seats;
private String targetedSeat;
public String getTargetedSeat() {
	return targetedSeat;
}
public void setTargetedSeat(String targetedSeat) {
	this.targetedSeat = targetedSeat;
}
private int availableSeats;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getRid() {
	return rid;
}
public void setRid(int rid) {
	this.rid = rid;
}
public String getsName() {
	return sName;
}
public void setsName(String sName) {
	this.sName = sName;
}
public String getsAddress() {
	return sAddress;
}
public void setsAddress(String sAddress) {
	this.sAddress = sAddress;
}
public String getsPhoneNo() {
	return sPhoneNo;
}
public void setsPhoneNo(String sPhoneNo) {
	this.sPhoneNo = sPhoneNo;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public String getImageUrl() {
	return imageUrl;
}
public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}
public String getcName() {
	return cName;
}
public void setcName(String cName) {
	this.cName = cName;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getAdmissionFee() {
	return AdmissionFee;
}
public void setAdmissionFee(String admissionFee) {
	AdmissionFee = admissionFee;
}
public Date getAddDate() {
	return addDate;
}
public void setAddDate(Date addDate) {
	this.addDate = addDate;
}
public String getHostelFee() {
	return hostelFee;
}
public void setHostelFee(String hostelFee) {
	this.hostelFee = hostelFee;
}
public Date getFeeDate() {
	return feeDate;
}
public void setFeeDate(Date feeDate) {
	this.feeDate = feeDate;
}
public int getRoomNo() {
	return roomNo;
}
public void setRoomNo(int roomNo) {
	this.roomNo = roomNo;
}
public int getSeats() {
	return seats;
}
public void setSeats(int seats) {
	this.seats = seats;
}
public int getAvailableSeats() {
	return availableSeats;
}
public void setAvailableSeats(int availableSeats) {
	this.availableSeats = availableSeats;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
private String status;



}

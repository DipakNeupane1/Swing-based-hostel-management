package com.dipak.hostelmgmtsystem.dao;

import com.dipak.hostelmgmtsystem.dto.Admin;

public interface AdminDao {

	public int getCreated(Admin admin);
	public int login(String userName,String password);
}

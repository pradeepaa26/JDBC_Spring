package com.example.pradeeeepaa.service;

import java.util.List;

import com.example.pradeeeepaa.model.DTO;
import com.example.pradeeeepaa.model.Usermodel;
import com.example.pradeeeepaa.repository.Databaseconnection;

public class Userservice {
	static Databaseconnection db=new Databaseconnection();
	
	public List<Usermodel> displaydata()
	{
		return db.display();
	}
	public boolean insertdata(Usermodel u)
	{
		
		
		if(db.insert(u))
		return true;
		else
			return false;
	}
	public boolean deletedata(int id) {
		if(db.delete(id))
			return true;
		else 
			return false;
	}
	public boolean updatedata(DTO dto_obj)
	{
		if(db.update(dto_obj))
			return true;
		else
			return false;
	}
	}


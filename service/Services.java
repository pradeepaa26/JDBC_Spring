package com.example.crud_operation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud_operation.model.Usermodel;
import com.example.crud_operation.repository.Databaseconnection;

@Service
public class Services implements Employeeservice{
   @Autowired
   private Databaseconnection db;
   @Override
	public List<Usermodel> display() {
		
		return db.display();
	}
@Override
public void insert(Usermodel u) {
	db.insert(u);
}
@Override
public void update(Usermodel u) {
	db.update(u);
	
}
@Override
public void delete(int id) {
db.delete(id);
	
}

}

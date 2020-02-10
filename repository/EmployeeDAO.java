package com.example.crud_operation.repository;

import java.util.List;

import com.example.crud_operation.model.Usermodel;


public interface EmployeeDAO {
	public List<Usermodel> display();
	public void insert(Usermodel u);
	public void update(Usermodel u);
	public void delete(int id);
}

package com.example.crud_operation.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.crud_operation.model.EmployeeRowmapper;
import com.example.crud_operation.model.Usermodel;
@Transactional
@Repository
public class Databaseconnection implements EmployeeDAO {
@Autowired
	private JdbcTemplate jdbctemplate;
	@Override 
	public List<Usermodel> display() {
		String sql="SELECT * FROM datas";
		RowMapper<Usermodel> rowmapper=new EmployeeRowmapper();
		List<Usermodel> list=jdbctemplate.query(sql,rowmapper);
		return list;
	}
	@Override
	public void insert(Usermodel user) {
		String sql="insert into datas(id,name,age) values(?,?,?)";
		jdbctemplate.update(sql,user.getId(),user.getName(),user.getAge());
		
	}
	@Override
	public void update(Usermodel user) {
		String sql="update datas set age=? where id=?";
		jdbctemplate.update(sql,user.getAge(),user.getId());
	}
	@Override
	public void delete(int id) {
		String sql="delete from datas where id=?";
		jdbctemplate.update(sql,id);
		
	}

}

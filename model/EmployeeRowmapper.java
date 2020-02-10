package com.example.crud_operation.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowmapper implements RowMapper<Usermodel>{

	@Override
	public Usermodel mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usermodel user=new Usermodel();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setAge(rs.getInt("age"));
		return user;
	}

}

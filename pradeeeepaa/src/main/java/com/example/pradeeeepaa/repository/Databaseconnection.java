package com.example.pradeeeepaa.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.pradeeeepaa.model.DTO;
import com.example.pradeeeepaa.model.Usermodel;
@Repository
public class Databaseconnection {	
	public boolean insert(Usermodel u)
	 {Connection con=null;
	 int i=0;
		PreparedStatement ps=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing_db","root","root");
	        ps=con.prepareStatement( "INSERT INTO datas (id, name, age) VALUES (?,?,?);");
	        ps.setInt(1,u.getId());
	        ps.setString(2,u.getName());
	        ps.setInt(3,u.getAge());
	        i=ps.executeUpdate();
		   }
			catch(Exception e)
			{
				e.printStackTrace();
			}
		finally
		{
			try{
				ps.close();
		        con.close();	
			}catch(Exception e)
			{
				System.out.println("exception");
			}
		}
		 if(i>0)
			 return true;
		 else 
			 return false;
	 }
 public List<Usermodel> display()
 {
	  List<Usermodel> list=new ArrayList<Usermodel>();

	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	try {

	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing_db","root","root");
	String sql= "SELECT * FROM datas;";
   ps=con.prepareStatement(sql);
   rs=ps.executeQuery();
	while(rs.next())
	{	 Usermodel u=new Usermodel();
		
		u.setId(rs.getInt("id"));
		u.setName(rs.getString("name"));
		u.setAge(rs.getInt("age"));
		list.add(u);
	}	
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	finally
	{
		try{
			ps.close();
	        con.close();	
		}catch(Exception e)
		{
			System.out.println("exception");
		}
	}
	return list;
 
 }
 public boolean delete(int user_id)
 {Connection con=null;
 int i=0;
	PreparedStatement ps=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver"); 
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing_db","root","root");
	
ps=con.prepareStatement( "DELETE FROM datas WHERE id=(?)");
ps.setInt(1,user_id);
i=ps.executeUpdate();
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	finally
	{
		try{
			ps.close();
	        con.close();	
		}catch(Exception e)
		{
			System.out.println("exception");
		}
	}
	 if(i>0)
		 return true;
	 else 
		 return false;
 }
 public boolean update(DTO obj)
 {Connection con=null;
 int i=0;
	PreparedStatement ps=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver"); 
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing_db","root","root");
	
ps=con.prepareStatement( "UPDATE datas SET age=(?) WHERE id=(?)");
ps.setInt(1,obj.getAge());
ps.setInt(2,obj.getId());
i=ps.executeUpdate();
System.out.println(i);
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	finally
	{
		try{
			ps.close();
	        con.close();	
		}catch(Exception e)
		{
			System.out.println("exception");
		}
	}
	 if(i>0)
		 return true;
	 else 
		 return false;
 }
 
}


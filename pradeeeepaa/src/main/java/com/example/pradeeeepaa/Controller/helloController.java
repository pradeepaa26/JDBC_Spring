package com.example.pradeeeepaa.Controller;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pradeeeepaa.model.DTO;
import com.example.pradeeeepaa.model.Usermodel;
import com.example.pradeeeepaa.service.Userservice;

@RestController

public class helloController {
	static Userservice us=new Userservice();
	//static List empty=new ArrayList<Usermodel>();
	@GetMapping("/get")
	public static List<Usermodel> get() {
		return us.displaydata();
	}
	
	@PostMapping("/insert")
	public String insert_data(@RequestBody Usermodel u_obj) {
		boolean flag=us.insertdata(u_obj);
		if(flag)
			return("insertion successful");
		else
			return ("insertion failed");
				
	}
	@DeleteMapping("/delete/{id}")
	public String delete_data(@PathVariable int id) {
		boolean flag=us.deletedata(id);
		if(flag)
			return("deletion successful");
		else
			return("deletion failed");
	}
   @PutMapping("/update")
   public String update_data(@RequestBody DTO u_obj)
   {
	   boolean flag=us.updatedata(u_obj);
	   if(flag)
		   return("updation successful");
	   else
		   return("updation failed");
   }
}
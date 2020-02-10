package com.example.crud_operation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.crud_operation.model.Usermodel;
import com.example.crud_operation.service.Services;

@RestController
@RequestMapping("/employee")
public class Controller {

	@Autowired
	private Services es;
	//static List empty=new ArrayList<Usermodel>();
@GetMapping("/get")
	public  List<Usermodel> get() {
		return es.display();
	}
@PostMapping("/insert")
public void insert(@RequestBody Usermodel user)
{
	es.insert(user);		
}
@PutMapping("/update")
public void update(@RequestBody Usermodel user)
{
	es.update(user);
}
@DeleteMapping("/delete/{id}")
public void delete(@PathVariable int id) {
	es.delete(id);
}
}

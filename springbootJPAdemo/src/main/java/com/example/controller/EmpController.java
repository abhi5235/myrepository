package com.example.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.service.EmpService;

@RestController
public class EmpController {
	@Autowired
	EmpService empservice;

	//Create
	@PostMapping("/emp")
	public  String  addEmp(@RequestBody Employee emp) {
		String addedObj =  empservice.addEmpInDataBase(emp);
		return addedObj;
		
	}
	//Read
//	@GetMapping("/emp")
//	public Employee getEmp(@PathVariable int id) {
//		return empservice.getEmpDatafromDB(id);
//	}
	//Read opreation by request param
//		@GetMapping("/emp")
//		public Employee getEmp(@RequestParam int id) {
//			return empservice.getEmpDatafromDB(id);
//		}
		@PutMapping("emp")
		public String updateEmp(@RequestBody Employee emp) {
			return empservice.updateDataofEmp(emp);
		}
		@DeleteMapping("/emp")
		public String deleteEmp(@PathVariable int id) {
		 String deleteDataofEmp = empservice.deleteDataofEmp(id);
		return deleteDataofEmp;
		}
//		@GetMapping("/emp")
//		public List<Employee> getEmployee(String skills) {
//			return empservice.findWithSkills(skills);
//		}
		@GetMapping("/empLike")
		public List<Employee> getEmpDataByPattern(@RequestBody String pattern){
			JSONObject json=new JSONObject(pattern);
			String pa=json.getString("pattern");
			return empservice.findEmpWithPattern(pa);
			
		}
		@GetMapping("/empWithId/{id}")
		public List<Employee> fetchAllEmp(@PathVariable int id){
			return empservice.fetchEmpFromDB(id);
		}
}

package com.example.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repo.EmpRepository;

@Service
public class EmpService {
	private static final Slice<Employee> empData = null;
	@Autowired
	EmpRepository emprepo;

//	public Employee addEmpInDataBase(Employee emp) {
//		System.out.println(emprepo.getClass());
//		Employee savedObj = emprepo.save(emp);
//		return savedObj;
//	}
	public String addEmpInDataBase(Employee emp) {
		if (emprepo.findById(emp.getEid()).isPresent()) {
			return "Data of " + emp.getEid() + " is already in database";
		}
		Employee savedObj = emprepo.save(emp);
		return "Data of " + savedObj.getEid() + " is saved in Database";
	}

//	public Employee getEmpDatafromDB(int id) {
//		Optional<Employee> OptionalEmp = emprepo.findById(id);
//		Employee employee = OptionalEmp.get();
//		return employee;
//	}

	@Transactional
	public String updateDataofEmp(Employee emp) {
		Optional<Employee> OptionalEmp = emprepo.findById(emp.getEid());
		if (OptionalEmp.isEmpty()) {
			return "Employee " + emp.getEid() + " is not a part of organization";
		} else {
			Employee employeeInDB = OptionalEmp.get();
			employeeInDB.setName(emp.getName());
			employeeInDB.setSkills(emp.getSkills());
			employeeInDB.setAddr(emp.getAddr());
			return "Employee " + emp.getEid() + " data is updated";
		}
	}

	public String deleteDataofEmp(int id) {
		if (emprepo.findById(id).isEmpty()) {
			return "Employee data " + id + " is not present";
		} else {
			emprepo.deleteById(id);
			return "Employee data " + id + " is deleted";
		}
	}

//	public List<Employee> findWithSkills(String skills) {
//		List e=emprepo.findBySkills(skills);
//		return e;
//		
//	}

	public List<Employee> findEmpWithPattern(String pattern) {
		return emprepo.fndBynameLike(pattern);
	}

	public List<Employee> fetchEmpFromDB(int id) {
		return emprepo.fetchById(id);
	}
	public List<Employee> fetchAllEmpFromDB(int pagenumber){
		Sort sortBy= Sort.by("name");
		PageRequest firstPagewithTwoRecords =PageRequest.of(pagenumber, 2,sortBy);
		Page<Employee> empData = emprepo.findAll(firstPagewithTwoRecords);
		return empData.getContent();
	}

}

package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Employee;

@Repository
public interface EmpRepository extends PagingAndSortingRepository<Employee, Integer> {

//	List<Employee> findBySkills(String skills);


	List<Employee> fndBynameLike(String pattern);
	
	@Query(value = "select * from employee",nativeQuery = true)
	List<Employee> fetchAll();
	
	@Query(value = "select * from employee  where employee_id =?1",nativeQuery = true)
	List<Employee> fetchById(int id);

}

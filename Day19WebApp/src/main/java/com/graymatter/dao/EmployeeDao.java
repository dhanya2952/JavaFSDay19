package com.graymatter.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.graymatter.model.Employee;

//Bean Like

@Component
public class EmployeeDao {
	
	//crud operations
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) 
	{
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//insert
	public int addEmployee(Employee emp)
	{
		String query="insert into employee values("+emp.getEmpId()+",'"+emp.getEmpName()+"',"+emp.getEmpSal()+");";
		return jdbcTemplate.update(query);
		
	}
	
	//select
	public List<Employee> getAllEmployees()
	{
		String query="select * from Employee";
		List<Employee> empList= jdbcTemplate.query(query,new EmployeeRowMapper());//record to object
		return empList;
		
	}
	
	//update
	public int updateEmployee(Employee emp)
	{
		String query="update employee set empname='"+emp.getEmpName()+"',empsal="+emp.getEmpSal()+"where empid="+emp.getEmpId();
		return jdbcTemplate.update(query);
	}

	//delete
	public int deleteEmployee(int id)
	{
		String query="delete from employee where empid="+id;
		return jdbcTemplate.update(query);
	}
	
	//select by id
	public Employee selectEmpByid(int empid)
	{
		String query="select * from Employee where empid="+empid;
		List<Employee> empList= jdbcTemplate.query(query,new EmployeeRowMapper());
		return empList.get(0);
	}
	

}

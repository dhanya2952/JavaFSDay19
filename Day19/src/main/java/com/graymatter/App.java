package com.graymatter;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.graymatter.dao.EmployeeDao;
import com.graymatter.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc-bean.xml");
        EmployeeDao dao= (EmployeeDao) context.getBean("empdao");
//        int i=dao.addEmployee(new Employee(1710,"amit",20000));
//        System.out.println("row inserted successfully");
        
//        dao.updateEmployee(new Employee(1711,"arun",80000));
//        System.out.println("row updated");
        
//        dao.deleteEmployee(new Employee(1712,"dhanya",100001));
//        System.out.println("row deleted");
        
//        List<Employee> emplist=dao.getAllEmployees();
//        for(Employee e:emplist)
//        	System.out.println(e);
        
        //dao.updateEmployee(new Employee(1711,"arun",80000));
        System.out.println(dao.selectEmpByid(1710));
        
    }
}

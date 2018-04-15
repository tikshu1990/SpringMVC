package com.joona.spring.mvc.components;

import static java.lang.System.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class EmpController {

    @Autowired
    private EmpService service;

    @RequestMapping("/")
    public String welcomeMvc() {
        out.println("----------------------------------------");
        out.println("Request landed on EmpController !!!!!!!!!!!");
        out.println("----------------------------------------");
        return "home";

    }

    @RequestMapping("/employees")
    String retrieveEmployees(HttpServletRequest request) {
        out.println("Retrieve all employees");
        List<Employee> employees = service.getEmployees();
        employees.sort((emp1, emp2) -> emp1.getFirstName().compareTo(emp2.getFirstName()));
        request.setAttribute("employees", employees);
        return "emps";
    }

    public Employee createEmployee(String fName, String lName, Long number) {
        Employee empToSave = new Employee();
        empToSave.setFirstName(fName);
        empToSave.setLastName(lName);
        empToSave.setContactNo(number);

        Employee employee = service.saveEmployee(empToSave);

        return employee;
    }
}

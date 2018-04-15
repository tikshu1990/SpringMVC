package com.joona.spring.mvc.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    @Autowired
    @Qualifier("postgres")
    private EmpDao dao;


    public Employee saveEmployee(Employee empToSave) {
        Employee createdEmp = new Employee();
        final String
            email =
            new StringBuilder().append(empToSave.getFirstName()).append(".").append(empToSave.getLastName()).append("@target.com").toString();
        boolean exists = dao.mailExists(email);
        if (exists) {
            //TODO(Anooj) : Update the email id with the number and check again
        } else {
            empToSave.setEmailId(email);
            createdEmp = dao.save(empToSave);
        }
        return createdEmp;
    }

    public List<Employee> getEmployees() {
        return dao.getEmployees();
    }
}

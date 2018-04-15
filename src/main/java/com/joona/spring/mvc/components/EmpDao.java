package com.joona.spring.mvc.components;

import java.util.List;

public interface EmpDao {

    boolean mailExists(String email);

    Employee save(Employee empToSave);

    List<Employee> getEmployees();
}

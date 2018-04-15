package com.joona.spring.mvc.components;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("cassandra")
public class CassandraDAO implements EmpDao {

    @Override
    public boolean mailExists(String email) {
        return false;
    }

    @Override
    public Employee save(Employee empToSave) {
        empToSave.setEmpId(135);
        return empToSave;
    }

    @Override
    public List<Employee> getEmployees() {
        return null;
    }
}

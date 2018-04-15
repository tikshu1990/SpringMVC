package com.joona.spring.mvc.components;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString(exclude = {"firstName", "lastName", "contactNo"})
public class Employee {
    private long contactNo;
    private String firstName;
    private String lastName;
    private String emailId;
    private int empId;
}

package com.myexample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 7555528328750849884L;

    public EmployeeNotFoundException(Integer employeeNumber) {
        super("No such employee: " + employeeNumber);
    }
    
}

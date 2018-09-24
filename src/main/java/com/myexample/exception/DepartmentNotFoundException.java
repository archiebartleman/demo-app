package com.myexample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DepartmentNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -72982581440385978L;

    public DepartmentNotFoundException(String deptNo) {
        super("No such department: " + deptNo);
    }

    public DepartmentNotFoundException() {
        super("No departments");
    }

}

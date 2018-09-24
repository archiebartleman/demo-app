package com.myexample.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.Date;

@JsonRootName("DeptEmp")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeptEmp implements Serializable {

    @Getter
    @Setter
    private DeptEmpId id;

    @Getter
    @Setter
    private Date fromDate;

    @Getter
    @Setter
    private Date toDate;

    @Getter
    @Setter
    @JsonManagedReference(value="deptEmp-department")
    private Department department;

    @Getter
    @Setter
    @JsonManagedReference(value="deptEmp-employee")
    private Employee employee;

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this).toString();
    }

}

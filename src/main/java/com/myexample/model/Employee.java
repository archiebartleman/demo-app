package com.myexample.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonRootName("Employee")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee implements Serializable {

    @Getter
    @Setter
    private Integer empNo;

    @Getter
    @Setter
    private Date birthDate;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private Gender gender;

    @Getter
    @Setter
    private Date hireDate;

    @JsonBackReference(value="deptEmp-employee")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Getter
    @Setter
    private Set<DeptEmp> deptEmps = new HashSet<>(0);

    @JsonBackReference(value="deptManager-employee")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Getter
    @Setter
    private Set<DeptManager> deptManagers = new HashSet<>(0);

    @JsonBackReference(value = "salary-employee")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Getter
    @Setter
    private Set<Salary> salaries = new HashSet<>(0);

    @JsonBackReference(value = "title-employee")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Getter
    @Setter
    private Set<Title> titles = new HashSet<>(0);

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this).toString();
    }

}

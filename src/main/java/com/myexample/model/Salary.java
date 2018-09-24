package com.myexample.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.Date;

@JsonRootName("Salary")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Salary implements Serializable {

    private static final long serialVersionUID = -5811693689828153153L;

    @Getter
    @Setter
    private SalaryId id;

    @Getter
    @Setter
    private Integer salary;

    @Getter
    @Setter
    private Date toDate;

    @Getter
    @Setter
    @JsonManagedReference(value = "salary-employee")
    private Employee employee;

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this).toString();
    }

}

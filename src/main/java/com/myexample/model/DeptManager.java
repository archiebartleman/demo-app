package com.myexample.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.Date;

@JsonRootName("DeptManager")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeptManager implements Serializable {

    private static final long serialVersionUID = -8152068364999456470L;

    @Getter
    @Setter
    private DeptManagerId id;

    @Getter
    @Setter
    private Date fromDate;

    @Getter
    @Setter
    private Date toDate;

    @Getter
    @Setter
    @JsonManagedReference(value="deptManager-department")
    private Department department;

    @Getter
    @Setter
    @JsonManagedReference(value="deptManager-employee")
    private Employee employee;

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this).toString();
    }
}

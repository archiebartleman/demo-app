package com.myexample.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@JsonRootName("Department")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Department implements Serializable {

    private static final long serialVersionUID = -5487734223614045902L;

    @Getter
    @Setter
    private String deptNo;

    @Getter
    @Setter
    private String deptName;

    @JsonBackReference(value="deptEmp-department")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<DeptEmp> deptEmps = new HashSet<>(0);

    @JsonBackReference(value="deptManager-department")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<DeptManager> deptManagers = new HashSet<>(0);

    public Set<DeptEmp> getDeptEmps() {
        return this.deptEmps;
    }

    public void setDeptEmps(Set<DeptEmp> deptEmps) {
        this.deptEmps = deptEmps;
    }

    public Set<DeptManager> getDeptManagers() {
        return this.deptManagers;
    }

    public void setDeptManagers(Set<DeptManager> deptManagers) {
        this.deptManagers = deptManagers;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this).toString();
    }

}

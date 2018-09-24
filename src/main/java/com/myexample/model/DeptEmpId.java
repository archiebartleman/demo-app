package com.myexample.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

public class DeptEmpId implements Serializable {

    @Getter
    @Setter
    private Integer empNo;

    @Getter
    @Setter
    private String deptNo;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeptEmpId)) {
            return false;
        }
        DeptEmpId castOther = (DeptEmpId) other;
        return
                this.empNo.equals(castOther.empNo)
                        && this.deptNo.equals(castOther.deptNo);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.empNo.hashCode();
        hash = hash * prime + this.deptNo.hashCode();

        return hash;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this).toString();
    }

}

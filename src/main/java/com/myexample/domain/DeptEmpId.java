package com.myexample.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Embeddable
public class DeptEmpId implements Serializable {

    private static final long serialVersionUID = -2894729732904698758L;

    @Column(name = "emp_no", insertable = false, updatable = false, unique = true, nullable = false)
    @NotNull
    @Getter
    @Setter
    private Integer empNo;

    @Column(name = "dept_no", insertable = false, updatable = false, unique = true, nullable = false, length = 4)
    @NotNull
    @Size(max = 4)
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
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this).toString();
    }

}

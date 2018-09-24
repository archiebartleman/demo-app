package com.myexample.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class SalaryId implements Serializable {

    private static final long serialVersionUID = -7394092319677500719L;
    
    @Column(name = "emp_no", insertable = false, updatable = false, unique = true, nullable = false)
    @NotNull
    @Getter
    @Setter
    private Integer empNo;

    @Temporal(TemporalType.DATE)
    @Column(name = "from_date", unique = true, nullable = false)
    @NotNull
    @Getter
    @Setter
    private Date fromDate;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SalaryId)) {
            return false;
        }
        SalaryId castOther = (SalaryId)other;
        return
                this.empNo.equals(castOther.empNo)
                        && this.fromDate.equals(castOther.fromDate);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.empNo.hashCode();
        hash = hash * prime + this.fromDate.hashCode();

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

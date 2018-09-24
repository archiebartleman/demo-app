package com.myexample.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.Date;

public class TitleId implements Serializable {

    private static final long serialVersionUID = -3608661445218980212L;

    @Getter
    @Setter
    private Integer empNo;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private Date fromDate;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TitleId)) {
            return false;
        }
        TitleId castOther = (TitleId) other;
        return
                this.empNo.equals(castOther.empNo)
                        && this.title.equals(castOther.title)
                        && this.fromDate.equals(castOther.fromDate);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.empNo.hashCode();
        hash = hash * prime + this.title.hashCode();
        hash = hash * prime + this.fromDate.hashCode();

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

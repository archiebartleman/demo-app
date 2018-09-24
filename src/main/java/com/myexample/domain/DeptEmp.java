package com.myexample.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "DeptEmp")
@Table(name = "dept_emp")
@NamedQuery(name = "DeptEmp.findAll", query = "SELECT d FROM DeptEmp d")
@JsonRootName("DeptEmp")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class DeptEmp implements Serializable {

    private static final long serialVersionUID = -8515962456506663855L;

    @EmbeddedId
    @NotNull
    @Getter
    @Setter
    private DeptEmpId id;

    @Temporal(TemporalType.DATE)
    @Column(name = "from_date", nullable = false)
    @NotNull
    @Getter
    @Setter
    private Date fromDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "to_date", nullable = false)
    @NotNull
    @Getter
    @Setter
    private Date toDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "dept_no", nullable = false, insertable = false, updatable = false)
    @NotNull
    @Getter
    @Setter
    @JsonBackReference(value="deptEmp-department")
    private Department department;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "emp_no", nullable = false, insertable = false, updatable = false)
    @NotNull
    @Getter
    @Setter
    @JsonBackReference(value="deptEmp-employee")
    private Employee employee;

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this).toString();
    }

}

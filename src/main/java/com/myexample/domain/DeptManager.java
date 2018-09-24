package com.myexample.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "DeptManager")
@Table(name = "dept_manager")
@NamedQuery(name = "DeptManager.findAll", query = "SELECT d FROM DeptManager d")
@JsonRootName("DeptManager")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class DeptManager implements Serializable {

    private static final long serialVersionUID = -3789746179388991392L;

    @EmbeddedId
    @NotNull
    @Getter
    @Setter
    private DeptManagerId id;

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
    @JoinColumn(name = "dept_no", nullable = false, insertable = false, updatable = false)
    @NotNull
    @Getter
    @Setter
    @JsonBackReference(value="deptManager-department")
    private Department department;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_no", nullable = false, insertable = false, updatable = false)
    @NotNull
    @Getter
    @Setter
    @JsonBackReference(value="deptManager-employee")
    private Employee employee;

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this).toString();
    }
}

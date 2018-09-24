package com.myexample.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "Salary")
@Table(name = "salaries")
@NamedQuery(name = "Salary.findAll", query = "SELECT s FROM Salary s")
@JsonRootName("Salary")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Salary implements Serializable {

    private static final long serialVersionUID = 707797424824539629L;

    @EmbeddedId
    @NotNull
    @Getter
    @Setter
    private SalaryId id;

    @Column(name = "salary", nullable = false)
    @NotNull
    @Getter
    @Setter
    private Integer salary;

    @Temporal(TemporalType.DATE)
    @Column(name = "to_date", nullable = false)
    @NotNull
    @Getter
    @Setter
    private Date toDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_no", nullable = false, insertable = false, updatable = false)
    @NotNull
    @Getter
    @Setter
    @JsonBackReference(value = "salary-employee")
    private Employee employee;

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this).toString();
    }

}

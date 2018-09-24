package com.myexample.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name = "Employee")
@Table(name = "employees")
@NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
@JsonRootName("Employee")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "empNo")
public class Employee implements Serializable {

    private static final long serialVersionUID = 5745487194225018774L;

    @Id
    @Column(name = "emp_no", unique = true)
    @NotNull
    @Getter
    @Setter
    private Integer empNo;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date", nullable = false)
    @NotNull
    @Getter
    @Setter
    private Date birthDate;

    @Column(name = "first_name", nullable = false, length = 14)
    @NotNull
    @Size(max = 14)
    @Getter
    @Setter
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 16)
    @NotNull
    @Size(max = 16)
    @Getter
    @Setter
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    @Getter
    @Setter
    private Gender gender;

    @Temporal(TemporalType.DATE)
    @Column(name = "hire_date", nullable = false)
    @NotNull
    @Getter
    @Setter
    private Date hireDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade = {CascadeType.ALL})
    @Fetch(FetchMode.SELECT)
    @JsonManagedReference(value = "deptEmp-employee")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<DeptEmp> deptEmps = new HashSet<>(0);

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade = {CascadeType.ALL})
    @Fetch(FetchMode.SELECT)
    @JsonManagedReference(value = "deptManager-employee")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<DeptManager> deptManagers = new HashSet<>(0);

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade = {CascadeType.ALL})
    @Fetch(FetchMode.SELECT)
    @JsonManagedReference(value = "salary-employee")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<Salary> salaries = new HashSet<>(0);

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade = {CascadeType.ALL})
    @Fetch(FetchMode.SELECT)
    @JsonManagedReference(value = "title-employee")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<Title> titles = new HashSet<>(0);

    public Set<DeptEmp> getDeptEmps() {
        return this.deptEmps;
    }

    public void setDeptEmps(Set<DeptEmp> deptEmps) {
        this.deptEmps = deptEmps;
    }

    public DeptEmp addDeptEmp(DeptEmp deptEmp) {
        getDeptEmps().add(deptEmp);
        deptEmp.setEmployee(this);

        return deptEmp;
    }

    public DeptEmp removeDeptEmp(DeptEmp deptEmp) {
        getDeptEmps().remove(deptEmp);
        deptEmp.setEmployee(null);

        return deptEmp;
    }

    public Set<DeptManager> getDeptManagers() {
        return this.deptManagers;
    }

    public void setDeptManagers(Set<DeptManager> deptManagers) {
        this.deptManagers = deptManagers;
    }

    public DeptManager addDeptManager(DeptManager deptManager) {
        getDeptManagers().add(deptManager);
        deptManager.setEmployee(this);

        return deptManager;
    }

    public DeptManager removeDeptManager(DeptManager deptManager) {
        getDeptManagers().remove(deptManager);
        deptManager.setEmployee(null);

        return deptManager;
    }

    public Set<Salary> getSalaries() {
        return this.salaries;
    }

    public void setSalaries(Set<Salary> salaries) {
        this.salaries = salaries;
    }

    public Salary addSalary(Salary salary) {
        getSalaries().add(salary);
        salary.setEmployee(this);

        return salary;
    }

    public Salary removeSalary(Salary salary) {
        getSalaries().remove(salary);
        salary.setEmployee(null);

        return salary;
    }

    public Set<Title> getTitles() {
        return this.titles;
    }

    public void setTitles(Set<Title> titles) {
        this.titles = titles;
    }

    public Title addTitle(Title title) {
        getTitles().add(title);
        title.setEmployee(this);

        return title;
    }

    public Title removeTitle(Title title) {
        getTitles().remove(title);
        title.setEmployee(null);

        return title;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this).toString();
    }

}

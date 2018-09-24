package com.myexample.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Department")
@Table(name = "departments")
@NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d")
@JsonRootName("Department")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "deptNo")
public class Department implements Serializable {

    private static final long serialVersionUID = 398875768405039160L;

    @Id
    @Column(name = "dept_no", unique = true, nullable = false, length = 4)
    @NotNull
    @Size(max = 4)
    @Getter
    @Setter
    private String deptNo;

    @Column(name = "dept_name", unique = true, nullable = false, length = 40)
    @NotNull
    @Size(max = 40)
    @Getter
    @Setter
    private String deptName;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    @NotNull
    @JsonManagedReference(value = "deptEmp-department")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<DeptEmp> deptEmps = new HashSet<>(0);

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    @JsonManagedReference(value = "deptManager-department")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<DeptManager> deptManagers = new HashSet<>(0);

    public Set<DeptEmp> getDeptEmps() {
        return this.deptEmps;
    }

    public void setDeptEmps(Set<DeptEmp> deptEmps) {
        this.deptEmps = deptEmps;
    }

    public DeptEmp addDeptEmp(DeptEmp deptEmp) {
        getDeptEmps().add(deptEmp);
        deptEmp.setDepartment(this);

        return deptEmp;
    }

    public DeptEmp removeDeptEmp(DeptEmp deptEmp) {
        getDeptEmps().remove(deptEmp);
        deptEmp.setDepartment(null);

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
        deptManager.setDepartment(this);

        return deptManager;
    }

    public DeptManager removeDeptManager(DeptManager deptManager) {
        getDeptManagers().remove(deptManager);
        deptManager.setDepartment(null);

        return deptManager;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this).toString();
    }

}

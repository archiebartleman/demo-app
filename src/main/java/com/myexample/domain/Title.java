package com.myexample.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "Title")
@Table(name = "titles")
@NamedQuery(name = "Title.findAll", query = "SELECT t FROM Title t")
@JsonRootName("Title")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Title implements Serializable {

    private static final long serialVersionUID = 1907881286945308944L;

    @EmbeddedId
    @NotNull
    @Getter
    @Setter
    private TitleId id;

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
    @JsonBackReference(value = "title-employee")
    private Employee employee;

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this).toString();
    }

}

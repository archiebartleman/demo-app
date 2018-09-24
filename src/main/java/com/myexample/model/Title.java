package com.myexample.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.Date;

@JsonRootName("Title")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Title implements Serializable {

    private static final long serialVersionUID = -8077460646255472634L;

    @Getter
    @Setter
    private TitleId id;

    @Getter
    @Setter
    private Date toDate;

    @Getter
    @Setter
    @JsonManagedReference(value = "title-employee")
    private Employee employee;

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this).toString();
    }

}

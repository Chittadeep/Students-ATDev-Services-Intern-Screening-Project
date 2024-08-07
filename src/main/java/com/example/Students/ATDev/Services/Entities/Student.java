package com.example.Students.ATDev.Services.Entities;

import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Student cannot be created without name")
    private String name;
   
    @NotNull(message = "Student cannot be created without email")
    @Email
    @Column(unique=true)
    private String email;
   
    @Size(min=10, max = 10, message = "Phone number should be of 10 digits")
    @Column(unique = true)
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phoneNumber;
   
    @Size(min=1, max=2, message = "blood group can be of 2 characters only")
    private String bloodGroup;

    @Lob
    @Column(length = 500000)
    private byte[] photo;

    @Override
    public boolean equals(Object o)
    {
        if(o==this)
        return true;

        if(!(o instanceof Student))
        return false;

        Student s = (Student) o;
        return s.getId()==this.getId();
    }
}

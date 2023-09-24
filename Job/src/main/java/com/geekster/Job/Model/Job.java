package com.geekster.Job.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Job {
    @Id
    private Long id;
    private String title;
    private String description;
    private String location;
    @Min(value=20000)
    private Double salary; //(hint @min for salary : should be above 20,000 )
    private String companyEmail;

    private String companyName;
    private String employerName;
    @Enumerated(EnumType.STRING)
    private Type jobType;
    private LocalDate appliedDate;

    public void setJobLocation(String location) {
        this.location=location;
    }
}

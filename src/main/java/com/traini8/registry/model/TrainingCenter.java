package com.traini8.registry.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    @Size(max = 40, message = "Center name must be less than 40 characters")
    @NotBlank(message = "Center name is mandatory")
    private String centerName;

    @Column(nullable = false, unique = true, length = 12)
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center code must be 12 alphanumeric characters")
    @NotBlank(message = "Center code is mandatory")
    private String centerCode;

    @Embedded
    private Address address;

    @Min(value = 1, message = "Student capacity must be at least 1")
    private Integer studentCapacity;

    @ElementCollection
    private List<@NotBlank String> coursesOffered;

    @Column(nullable = false, updatable = false)
    private Long createdOn;

    @Email(message = "Invalid email format")
    private String contactEmail;

    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")
    @NotBlank(message = "Contact phone is mandatory")
    private String contactPhone;

}



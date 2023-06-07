package com.marzhiievskyi.spring_mvc_project.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(schema = "mvc_project_db", name = "client")

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 5, max = 45, message = "login must be from 5 to 45 symbols")
    private String login;

    @NotEmpty
    @Size(min = 4, max = 100, message = "password must be from 5 to 100 symbols")
    private String password;

    @NotEmpty
    @Size(min = 3, max = 45, message = "name must be from 3 to 45 symbols")
    private String name;

    @Size(min = 3, max = 45, message = "surname must be from 3 to 45 symbols")
    private String surname;

    @Email(message = "incorrect type of email")
    @NotEmpty(message = "must be not empty")
    @Size(min = 4, max = 50, message = "email size from 4 to 50 symbols")
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Permission permission;

    @Column(name = "registered_date")
    @CreationTimestamp
    private LocalDateTime clientRegistered;

    @Column(name = "updated_date")
    @UpdateTimestamp
    private LocalDateTime clientUpdated;
}

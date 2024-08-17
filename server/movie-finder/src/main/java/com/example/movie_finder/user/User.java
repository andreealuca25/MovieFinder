package com.example.movie_finder.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "app_user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "First name is mandatory.")
    private String firstName;
    @NotBlank(message = "Last name is mandatory.")
    private String lastName;
    @NotBlank(message = "Email is mandatory.")
    @Email(message = "Email doesn't have the right format. Example: example@email.com")
    private String email;
    @NotBlank(message = "Password is mandatory.")
    @Size(min=7, message = "The password should be at least 7 characters long.")
    private String password;
}

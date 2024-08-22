package com.example.movie_finder.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "app_user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
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
    @Size(min = 7, message = "The password should be at least 7 characters long.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{7,}$",
            message = "Password must contain at least one digit, one lowercase, one uppercase, one special character, and no whitespace.")
    private String password;
}

package org.example.bai_tap_1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email(message = "Email khong dung dinh dang")
    private String email;

    @Pattern(regexp = "^\\d{9}$",message = "NHap sai dinh dang")
    private String password;

    @NotBlank(message = "Vui long nhap ten")
    private String firstName;
    @NotBlank(message = "Vui long nhap ten")
    private String lastName;

    @NotBlank(message = "Vui long nhap so dien thoai")
    private String phone;
    @NotBlank(message = "Vui long nhap so dien thoai")
    private String address;

    @Past(message = "Ngay sinh khong dung dinh dang")
    private LocalDate birthday;
}

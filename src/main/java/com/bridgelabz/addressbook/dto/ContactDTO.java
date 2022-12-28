package com.bridgelabz.addressbook.dto;

import com.bridgelabz.addressbook.validationconfig.ValidState;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {
    @NotBlank(message = "Please enter First Name")
    @Pattern(regexp="^[A-Z][a-zA-Z]{2,}$", message = "First name should have min 3 char and first char Capital")
    private String firstName;
    @NotBlank(message = "Please enter Last Name")
    @Pattern(regexp="^[A-Z][a-z A-Z]{2,}$", message = "Last name should have min 3 char and first char Capital")
    private String lastName;
    @NotBlank(message = "Please enter Address")
    private String address;
    @NotBlank(message = "Please enter City")
    private String city;
    @NotBlank(message = "Please enter State")
    @ValidState
    private String state;
    @Pattern(regexp= "^[1-9][0-9]{5}$", message = "Please enter valid Zip Code")
    private String zipCode;
    @NotBlank(message = "Please enter Phone Number")
    @Pattern(regexp ="^(0/91)?[7-9][0-9]{9}$", message = "Please enter valid Phone Number")
    private String phoneNumber;
    @Email(message = "Please enter Valid Email Id")
    private String email;
}
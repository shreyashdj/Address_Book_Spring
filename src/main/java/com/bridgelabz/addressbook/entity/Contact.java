package com.bridgelabz.addressbook.entity;

import com.bridgelabz.addressbook.dto.ContactDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int contactId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String email;
    private LocalDateTime createdOn;
    private LocalDateTime modifiedOn;

    public Contact(ContactDTO contactDTO){
        this.firstName=contactDTO.getFirstName();
        this.lastName = contactDTO.getLastName();
        this.address = contactDTO.getAddress();
        this.city = contactDTO.getCity();
        this.state = contactDTO.getState();
        this.zipCode = contactDTO.getZipCode();
        this.phoneNumber = contactDTO.getPhoneNumber();
        this.email = contactDTO.getEmail();
    }

    @Override
    public String toString() {
        return  "\n Contact Id = " + contactId +
                "\n First Name = " + firstName +
                "\n Last Name = " + lastName +
                "\n Address = " + address +
                "\n City = " + city +
                "\n State = " + state +
                "\n Zip Code = " + zipCode +
                "\n Phone Number = " + phoneNumber +
                "\n Email Id = " + email +
                "\n Created On = " + createdOn +
                "\n Modified On = " + modifiedOn ;
    }
}

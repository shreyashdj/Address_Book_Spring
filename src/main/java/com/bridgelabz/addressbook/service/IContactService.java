package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.entity.Contact;

import java.util.List;
import java.util.Optional;

public interface IContactService {
    List<Contact> getAllContact();
    Contact getContactById(int personId);
    Contact addContact(ContactDTO contactDTO);
    Contact updateContact(int personId,ContactDTO contactDTO);
    void deleteContactById(int personId);

    List<Contact> getContactDataByName(String fName);

    List<Contact> getContactDataByCity(String city);
}
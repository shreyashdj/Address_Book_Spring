package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.entity.Contact;
import com.bridgelabz.addressbook.exception.ContactException;
import com.bridgelabz.addressbook.repository.ContactRepository;
import com.bridgelabz.addressbook.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ContactService implements IContactService {
//    private static final ArrayList<String> states = new ArrayList<>(List.of("goa", "maharashtra","gujarat", "bihar", "asam"));
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    EmailService emailService;
    @Override
    public List<Contact> getAllContact() {
        if ( contactRepository.findAll().isEmpty()){
            throw new ContactException("No contact found");
        } else {
            return contactRepository.findAll();
        }
    }
    @Override
    public Contact getContactById(int contactId) {
        return contactRepository.findById(contactId).orElseThrow(() -> new ContactException("Contact not found for id " + contactId));
    }

    @Override
    public Contact addContact(ContactDTO contactDTO) {
//        if (states.contains(contactDTO.getState())){
            Contact contact = new Contact(contactDTO);
            contact.setCreatedOn(LocalDateTime.now());
            contactRepository.save(contact);
            emailService.sendEmail(contact.getEmail(), "Contact Added successfully!!", "   ---- Contact Details ----" + contact.toString());
            return contact;
//        } else {
//            throw new ContactException("Please enter valid State name");
//        }
    }
    @Override
    public Contact updateContact(int contactId, ContactDTO contactDTO) {
        if (contactRepository.findById(contactId).isPresent()){
//            if (states.contains(contactDTO.getState())){
                Contact contact = new Contact(contactDTO);
                contact.setContactId(contactId);
                contact.setCreatedOn(contactRepository.findById(contactId).get().getCreatedOn());
                contact.setModifiedOn(LocalDateTime.now());
                emailService.sendEmail(contact.getEmail(), "Contact Updated successfully!!", "    ---- Contact Details ----\n\n" + contact.toString());
            return contactRepository.save(contact);
//            } else {
//                throw new ContactException("Please enter valid State name");
//            }
        } else {
            throw new ContactException("Contact not found for id " + contactId);
        }

    }
    @Override
    public void deleteContactById(int contactId) {
        if (contactRepository.findById(contactId).isPresent()){
            contactRepository.deleteById(contactId);
        } else {
            throw new ContactException("Contact not found for id " + contactId);
        }
    }

    @Override
    public List<Contact> getContactDataByName(String fName) {
        if (contactRepository.findByName(fName).isEmpty()){
            throw new ContactException("Contact not found for name " + fName);
        } else {
           return contactRepository.findByName(fName);
        }
    }

    @Override
    public List<Contact> getContactDataByCity(String city) {
        if (contactRepository.findByCity(city).isEmpty()){
            throw new ContactException("Contact not found for city " + city);
        } else {
           return contactRepository.findByCity(city);
        }
    }
}
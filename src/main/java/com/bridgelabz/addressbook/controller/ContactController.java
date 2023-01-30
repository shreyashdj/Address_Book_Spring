package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.entity.Contact;
import com.bridgelabz.addressbook.service.IContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AddressBook")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContactController {
    @Autowired
    IContactService contactService;
    @GetMapping("/getAll")
    public ResponseEntity<ResponseDTO> getAllContact(){
        List<Contact> contactList = contactService.getAllContact();
        ResponseDTO responseDTO = new ResponseDTO("Get call for all contacts Succeed", contactList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/getById/{contactId}")
    public ResponseEntity<ResponseDTO> getContactById(@PathVariable int contactId){
        Contact contactListById = contactService.getContactById(contactId);
        ResponseDTO responseDTO = new ResponseDTO("Get call Successes for search By Id", contactListById);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addContact(@Valid @RequestBody ContactDTO contactDTO){
        Contact Data = contactService.addContact(contactDTO);
        ResponseDTO responseDTO = new ResponseDTO("Contact Added Successfully",Data);
        return  new ResponseEntity<>(responseDTO,HttpStatus.CREATED);
    }
    @PutMapping("/update/{contactId}")
    public ResponseEntity<ResponseDTO> UpdateEmployeePayroll(@PathVariable("contactId") int contactId, @Valid @RequestBody ContactDTO contactDTO){
        Contact Data = contactService.updateContact(contactId, contactDTO);
        ResponseDTO responseDTO = new ResponseDTO("Contact Updated Successfully",Data);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);

    }
    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<ResponseDTO> DeleteEmployeePayroll(@PathVariable int contactId){
        contactService.deleteContactById(contactId);
        ResponseDTO responseDTO=new ResponseDTO("Contact Deleted successfully for Id =", contactId);
        return  new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("fName/{fName}")
    public ResponseEntity<ResponseDTO> getContactDataByName(@PathVariable("fName") String fName) {
        List<Contact> contactList = contactService.getContactDataByName(fName);
        ResponseDTO responseDTO = new ResponseDTO("Get Call for contact by name Successful", contactList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("city/{city}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataByDepartment(@PathVariable("city") String city) {
        List<Contact> contactList = contactService.getContactDataByCity(city);
        ResponseDTO responseDTO = new ResponseDTO("Get Call for contact by city Successful", contactList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}

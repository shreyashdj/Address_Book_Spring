package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
    @Query(value = "select * from contact a where a.name = ?", nativeQuery = true)
    List<Contact> findByName(String name);
    @Query(value = "select * from contact a where a.city = ?", nativeQuery = true)

    List<Contact> findByCity(String city);
}

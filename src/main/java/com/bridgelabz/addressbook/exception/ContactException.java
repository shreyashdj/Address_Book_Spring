package com.bridgelabz.addressbook.exception;

public class ContactException extends RuntimeException {
    public ContactException() {
    }

    public ContactException(String message) {
        super(message);
    }
}

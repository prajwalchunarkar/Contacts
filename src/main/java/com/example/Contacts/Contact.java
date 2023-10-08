package com.example.Contacts;

import java.util.Objects;

public class Contact {

    String FirstName;

    String LastName;

    String Email;

    public Contact() {
    }

    String PhoneNumber;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public Contact(String firstName, String lastName, String email, String phoneNumber) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        PhoneNumber = phoneNumber;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(FirstName, contact.FirstName) &&
                Objects.equals(LastName, contact.LastName) &&
                Objects.equals(Email, contact.Email) &&
                Objects.equals(PhoneNumber, contact.PhoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FirstName, LastName, Email, PhoneNumber);
    }
}

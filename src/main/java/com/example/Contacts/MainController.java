package com.example.Contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@RestController
public class MainController {
    @Autowired
    ContactList contactList;


    @RequestMapping("/home")
    public String home(){
        return "Welcome";
    }

    @GetMapping("/getContact")
    public HashSet<Contact> getContact(){
        return contactList.getHs();
    }
    @PostMapping("/createContact")
    public HashSet<Contact> createContact(@RequestBody Contact contact){
//        System.out.println(contact.getFirstName());
        contactList.addNewUser(contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getPhoneNumber() );



        return contactList.getHs();
    }

    @GetMapping("/searchContact")
    public HashSet<Contact> searchContact(@RequestBody Contact contact){
        return contactList.SearchContact(contact);

    }


    @PostMapping("/deleteContact")
    public void deleteContact(@RequestBody Contact contact){
        contactList.deleteContact(contact);
    }
    @PostMapping("/updateContact")
    public HashSet<Contact> updateContact(@RequestBody Contact contact){
        contactList.updateContact(contact);
        return null;
    }




}

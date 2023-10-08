package com.example.Contacts;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ContactList {


    List<Contact> list;
    HashSet<Contact> hs;

    public HashSet<Contact> getHs() {
        return hs;
    }

    public void setHs(HashSet<Contact> hs) {
        this.hs = hs;
    }

    public HashMap<String, HashSet<Contact>> getHmf() {
        return hmf;
    }

    public void setHmf(HashMap<String, HashSet<Contact>> hmf) {
        this.hmf = hmf;
    }

    public HashMap<String, HashSet<Contact>> getHml() {
        return hml;
    }

    public void setHml(HashMap<String, HashSet<Contact>> hml) {
        this.hml = hml;
    }

    public HashMap<String, HashSet<Contact>> getHme() {
        return hme;
    }

    public void setHme(HashMap<String, HashSet<Contact>> hme) {
        this.hme = hme;
    }

    public HashMap<String, HashSet<Contact>> getHmp() {
        return hmp;
    }

    public void setHmp(HashMap<String, HashSet<Contact>> hmp) {
        this.hmp = hmp;
    }

    HashMap<String, HashSet<Contact>> hmf;
    HashMap<String, HashSet<Contact>> hml;
    HashMap<String, HashSet<Contact>> hme;
    HashMap<String, HashSet<Contact>> hmp;

    public List<Contact> getList() {
        return list;
    }

    public void setList(List<Contact> list) {
        this.list = list;
    }

    public ContactList() {
        this.list = new ArrayList<Contact>();
        hs= new HashSet<Contact>();
        hmf = new HashMap<>();
        hml = new HashMap<>();
        hme =  new HashMap<>();
        hmp =  new HashMap<>();
        addNewUser("praj","chu", "chunarkarprajwal@gmail.com", "9767810478");

    }

    public void addNewUser(String firstName, String lastName, String email, String phoneNumber) {
        Contact c = new Contact(firstName,  lastName,  email,  phoneNumber);
        if(hs.contains(c))
        {
            System.out.println("already");
        }
        hs.add(c);
        if(hmf.containsKey(firstName))
        {
            HashSet<Contact> hs = hmf.get(firstName);
            hs.add(c);
        }
        else{
            hmf.put(firstName, new HashSet<Contact>());
            HashSet<Contact> hs = hmf.get(firstName);
            hs.add(c);
        }


        if(hml.containsKey(lastName))
        {
            HashSet<Contact> hs = hml.get(lastName);
            hs.add(c);
        }
        else{
            hml.put(lastName, new HashSet<Contact>());
            HashSet<Contact> hs = hml.get(lastName);
            hs.add(c);
        }

        if(hme.containsKey(email))
        {
            HashSet<Contact> hs = hme.get(email);
            hs.add(c);
        }
        else{
            hme.put(email, new HashSet<Contact>());
            HashSet<Contact> hs = hme.get(email);
            hs.add(c);
        }

        if(hmp.containsKey(email))
        {
            HashSet<Contact> hs = hmp.get(phoneNumber);
            hs.add(c);
        }
        else{
            hmp.put(phoneNumber, new HashSet<Contact>());
            HashSet<Contact> hs = hmp.get(phoneNumber);
            hs.add(c);
        }



    }

    public void deleteContact(Contact contact) {
        if(contact==null){return ;}

        if(hs.contains(contact))
        {
            hs.remove(contact);
            hmf.get(contact.getFirstName()).remove(contact);
            hml.get(contact.getLastName()).remove(contact);
            hme.get(contact.getEmail()).remove(contact);
            hmp.get(contact.getPhoneNumber()).remove(contact);
        }


    }

    public HashSet<Contact> SearchContact(Contact contact) {
        if(this.getHmf().containsKey(contact.getFirstName()))
        {

            return this.getHmf().get(contact.getFirstName());
        }
        if(this.getHml().containsKey(contact.getLastName()))
        {
            return this.getHml().get(contact.getLastName());

        }
        if(this.getHme().containsKey(contact.getEmail()))
        {
            return this.getHme().get(contact.getEmail());

        }
        return null;
    }

    public void updateContact(Contact contact) {


        if(contact==null){return ;}
        Contact oldContact = null;
        HashSet<Contact> hsf = hmf.get(contact.getFirstName());
        Iterator<Contact> itf= hsf.iterator();
        while(itf.hasNext())
        {
            HashSet<Contact> hsl = hml.get(contact.getLastName());
            Iterator<Contact> itl= hsf.iterator();
            while(itl.hasNext())
            {
                Contact cf = itf.next();
                Contact cl = itl.next();
                HashSet<Contact> hse = hme.get(contact.getLastName());
                Iterator<Contact> ite= hsf.iterator();
                while(ite.hasNext())
                {
                    Contact ce = ite.next();
                    if(cf.equals(cl)&&ce.equals(cl))
                    {
                        oldContact = ce;
                    }
                }
            }
        }
        if(hs.contains(oldContact))
        {
            hs.remove(oldContact);
            hmf.get(oldContact.getFirstName()).remove(oldContact);
            hml.get(oldContact.getLastName()).remove(oldContact);
            hme.get(oldContact.getEmail()).remove(oldContact);
            hmp.get(oldContact.getPhoneNumber()).remove(oldContact);
            addNewUser(contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getPhoneNumber());
        }
    }
}

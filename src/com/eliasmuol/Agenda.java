package com.eliasmuol;

import java.io.IOException;
// Agenda pide y da informacion al usuario

public class Agenda {
    private FileManager fileManager;

    public Agenda(String agendaFilePath) throws IOException {
        this.fileManager = new FileManager(agendaFilePath);
    }

    public void addContact() {
        Contact contact = new Contact();
        System.out.println("Name:");
        contact.setName(Prompt.scan());
        System.out.println("Phone:");
        contact.setPhone(Prompt.scan());

        fileManager.addContact(contact);
    }

    public void printContacts() {
        int position = 0;
        for (Contact contact : fileManager.loadContacts()) {
            System.out.println(position++ + ": " + contact.toString());
        }
    }

    public void deleteContact() {
        System.out.println("Contact position:");
        fileManager.deleteContact(Integer.parseInt(Prompt.scan()));
    }

    public int getContactNumber() {
        System.out.println("Contact list:");
        return fileManager.loadContacts().size();
    }
}
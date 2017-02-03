package com.eliasmuol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//File manager se encarga de escribir leer y borrar los archivos, vamos gestionarlos
public class FileManager {
    private String agendaFilePath;

    public FileManager(String agendaFilePath) throws IOException {
        super();
        this.agendaFilePath = agendaFilePath;
        if (!new File(agendaFilePath).exists())
            new File(agendaFilePath).createNewFile();
    }

    public void addContact(Contact contact) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(agendaFilePath, true));
            bufferedWriter.write(contact.getName() + "-" + contact.getPhone() + "\n");
            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println("There is a problem loading the diary File");
        }
    }

    public void deleteContact(int position) {
        try {
            File inputFile = new File(agendaFilePath);

            File tempFile = File.createTempFile("temp", "agenda");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(agendaFilePath));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile));

            String line;
            int lineNumber = 0;

            while ((line = bufferedReader.readLine()) != null) {
                // Nos saltamos la posicion indicada
                if (lineNumber != position) {
                    bufferedWriter.write(line + "\n");
                }
                lineNumber++;
            }
            bufferedReader.close();
            bufferedWriter.close();
            // Sobreescribimos el fichero omitiendo la linea que queríamos
            // borrar
            inputFile.delete();
            tempFile.renameTo(inputFile);

        } catch (

                IOException e) {
            System.err.println("There is a problem in the file");
        }

    }

    public List<Contact> loadContacts() {

        List<Contact> contactList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(agendaFilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] namePhonePair = line.split("-");
                contactList.add(new Contact(namePhonePair[0], namePhonePair[1]));
            }
            bufferedReader.close();

        } catch (IOException e) {
            System.err.println("There is a problem loading the diary File");
        }

        return contactList;
    }

}

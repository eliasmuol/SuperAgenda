package com.eliasmuol;

import java.io.IOException;

// Si la clase va a representar un proceso que se ejecuta todo el tiempo, se le suele llamar Runner
public class Runner {
    private Agenda agenda;

    public Runner(String agendaFilePath) throws IOException {
        super();
        this.agenda = new Agenda(agendaFilePath);
    }

    // El metodo que arranca el proceso
    public void start() {

        boolean end = false;
        Prompt.init();

        while (!end) {
            Prompt.print(agenda.getContactNumber());

            switch (CommandParser.parse(Prompt.scan())) {

                case ADD:
                    agenda.addContact();
                    break;
                case DELETE:
                    agenda.deleteContact();
                    break;
                case LOOK:
                    agenda.printContacts();
                    break;
                case HELP:
                    Prompt.printHelp();
                    break;
                case UNKNOWN:
                    break;
                case QUIT:
                    end = true;
            }
        }

    }

}
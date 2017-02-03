package com.eliasmuol;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // aqui esta direccion se guardaran los archivos de texto
        //podemos cambiarlo, la ultima parte es el nombre y el tipo de archivo que vamos a crear
        new Runner("C:\\Users\\usuario\\IdeaProjects\\agenda\\agenda.txt").start();
    }
}
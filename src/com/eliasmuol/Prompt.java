package com.eliasmuol;

import java.util.Scanner;
// imprimir y leer del usuario
public class Prompt {

    public static void init() {
        System.out.println("Esta es tu agenda personalizada.");
    }

    // this text show ever you need.
    public static void print(int contactNumber) {
        System.out.println("[" + contactNumber + "] contactos");
        System.out.println("Hola digame que necesita:");
        printHelp();
    }

    public static String scan() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }

    public static void printHelp() {
        System.out.println("(a)dd: Add contact");
        System.out.println("(l)ook: List contacts");
        System.out.println("(d)elete: Delete contact");
        System.out.println("(h)elp: help");
    }
}
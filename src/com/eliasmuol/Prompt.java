package com.eliasmuol;

import java.util.Scanner;
// imprimir y leer del usuario
public class Prompt {

    public static void init() {
        System.out.println("This is your personalized diary.");
    }

    // this text show ever you need.
    public static void print(int contactNumber) {
        System.out.println("[" + contactNumber + "] contacts");
        System.out.println("Hello, tell me what do you need:");
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
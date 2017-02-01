package com.eliasmuol;

public class CommandParser {

    public static Command parse(String text) {

        if (text.equalsIgnoreCase("add") || text.equalsIgnoreCase("a")) {
            return Command.ADD;
        }
        if (text.equalsIgnoreCase("delete") || text.equalsIgnoreCase("d")) {
            return Command.DELETE;
        }
        if (text.equalsIgnoreCase("quit") || text.equalsIgnoreCase("q")) {
            return Command.QUIT;
        }
        if (text.equalsIgnoreCase("look") || text.equalsIgnoreCase("l")) {
            return Command.LOOK;
        }
        if (text.equalsIgnoreCase("h")) {
            return Command.HELP;
        }
        return Command.UNKNOWN;
    }
}

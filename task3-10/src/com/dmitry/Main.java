package com.dmitry;

import com.dmitry.ui.cli.CommandLineInterface;

public class Main {

    public static void main(String[] args) {
        if(args[0].equals("CLI")) {
            CommandLineInterface cli = new CommandLineInterface();
        }
    }
}

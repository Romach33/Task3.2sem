package com.dmitry.ui.cli;



import com.dmitry.datastructs.Queue;

import java.util.Random;
import java.util.Scanner;

public class CommandLineInterface {
    private Scanner input;

    private Queue<Integer> sortableQueue;

    private void helpCall() {
        System.out.println(" QUEUE BUBBLE SORT UTIL ");
        System.out.println();
        System.out.println("Usage:");
        System.out.println("'help' - calls help");
        System.out.println("'generateQ' - generates basic Q from 1 to 10");
        System.out.println("'insertQ' - u can insert ur own Q, obviously");
        System.out.println("'bubbleSort' - u can use bubble sort algorithm to this Queue");
        System.out.println("'exit' - u can shutdown app");
    }

    private void genQCall() {
        sortableQueue = new Queue<>();
        Random randomizer = new Random();
        for (int i = 0; i < 11; i++) {
            sortableQueue.insert(randomizer.nextInt(50));
        }

        System.out.println("Your generated QUEUE:");
        System.out.println(sortableQueue.toString());
    }

    private void insQCall() {
        sortableQueue = new Queue<>();
        System.out.print("ur inline elements with ' ' split to insert > ");
        String insertable = input.nextLine();
        for (int i = 0; i < insertable.split(" ").length; i++) {
            sortableQueue.insert(Integer.parseInt(insertable.split(" ")[i]));
        }
        System.out.println("Your inserted QUEUE:");
        System.out.println(sortableQueue.toString());
    }

    private void sortQueueCall(){
        if(sortableQueue!=null) {
            sortableQueue.bubbleSort();
            System.out.println("Your sorted queue:");
            System.out.println(sortableQueue.toString());
        }
    }
    public CommandLineInterface() {
        helpCall();
        input = new Scanner(System.in);

        System.out.print("> ");
        String inp = input.nextLine();
        for (; !inp.equals("exit") ;) {
            switch (inp) {
                case "help":
                    helpCall();
                    break;
                case "generateQ":
                    genQCall();
                    break;
                case "insertQ":
                    insQCall();
                    break;
                case "bubbleSort":
                    sortQueueCall();
                    break;
            }
            System.out.print("> ");
            inp = input.nextLine();
        }
    }
}

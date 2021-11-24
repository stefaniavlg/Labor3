package com.company;

import com.company.view.ConsoleView;

/**
 * Main class where program starts.
 */
public class Main {

    /**
     * Start point of the application
     * @param args command line arguments
     */
    public static void main(String[] args) {

        //System.out.println("Start point");
        ConsoleView consoleView = new ConsoleView();
        consoleView.run();
    }
}

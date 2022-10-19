package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;

public class DvdLibraryController {
    //getting access to the UserIO by creating an object name io
    private UserIO io = new UserIOConsoleImpl();

    //creating a method with no return that is going to display what matches user input
    public void run(){
        //initializing my variables
        boolean keepGoing = true;
        int menuSelection = 0;

        /*as keepGoing remains true, continue to perform while loop, until keepGoing reaches false, in that
        case user must have chose 9 for Exit. that will kick us out of the while loop and print GOODBYE */
        while(keepGoing){
            /*using print method from UIOCImpl and replacing parameter with an actual string to print. When we
              head back to UIOCImpl, we notice print method's job is to print its string parameter in the console*/
            io.print("Main Menu");
            io.print("1. Add DVD to Collection");
            io.print("2. Remove DVD from Collection");
            io.print("3. View DVDs in the Collection");
            io.print("4. Display information for particular DVD");
            io.print("5. Edit the information for Existing DVD");
            io.print("6. Search for DVD by title");
            io.print("7. Load DVD Library from a file");
            io.print("8. Save DVD Library back to file");
            io.print("9. Exit");

            /* assigning another value to menuSelection. More precisely a int value using the readInt method from
                UIOCImpl method which returns a number. menuSelection will be = to a number */
            menuSelection = io.readInt("Please select from the above choices.", 1, 9);

            switch (menuSelection){
                case 1:
                    io.print("ADD DVD");
                    break;
                case 2:
                    io.print("REMOVE DVD");
                    break;
                case 3:
                    io.print("VIEW DVDs");
                    break;
                case 4:
                    io.print("DISPLAY DVD INFO");
                    break;
                case 5:
                    io.print("EDIT DVD");
                    break;
                case 6:
                    io.print("SEARCH DVD");
                    break;
                case 7:
                    io.print("LOAD DVD LIBRARY FROM FILE");
                    break;
                case 8:
                    io.print("SAVE DVD LIBRARY BACK TO FILE");
                    break;
                case 9:
                    keepGoing = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }
        }
        io.print("GOOD BYE");
    }

}
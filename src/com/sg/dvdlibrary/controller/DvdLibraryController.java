package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DvdLibraryDao;
import com.sg.dvdlibrary.dao.DvdLibraryDaoException;
import com.sg.dvdlibrary.dao.DvdLibraryDaoImpl;
import com.sg.dvdlibrary.dto.Dvd;
import com.sg.dvdlibrary.ui.DvdLibraryView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;

import java.util.List;

public class DvdLibraryController {
    //getting access to the UserIO by creating an object name io
    private UserIO io = new UserIOConsoleImpl();
    //getting access to the View by creating an object
    private DvdLibraryView view;
    //getting access to the Dao
    private DvdLibraryDao dao;

    //constructor that initializes view and dao
    public DvdLibraryController(DvdLibraryDao dao, DvdLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    //creating a method with no return that is going to display what matches user input
    public void run() throws DvdLibraryDaoException {
        //initializing my variables
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
        /*as keepGoing remains true, continue to perform while loop, until keepGoing reaches false, in that
        case user must have chose 9 for Exit. that will kick us out of the while loop and print GOODBYE */
            while (keepGoing) {
            /*using print method from UIOCImpl and replacing parameter with an actual string to print. When we
              head back to UIOCImpl, we notice print method's job is to print its string parameter in the console*/
                io.print("Main Menu");
                io.print("1. Add DVD to Collection");
                io.print("2. Remove DVD from Collection");
                io.print("3. View DVDs in the Collection");
                io.print("4. Display information for particular DVD");
                io.print("5. Edit the information for Existing DVD");
                io.print("6. Load DVD Library from a file");
                io.print("7. Save DVD Library back to file");
                io.print("8. Exit");

            /* assigning another value to menuSelection. More precisely a int value using the readInt method from
                UIOCImpl method which returns a number. menuSelection will be = to a number */
                menuSelection = io.readInt("Please select from the above choices.", 1, 8);

                switch (menuSelection) {
                    case 1:
                        createDvd();
                        break;
                    case 2:
                        removeDvd();
                        break;
                    case 3:
                        listDvds();
                        break;
                    case 4:
                        viewDvd();
                        break;
                    case 5:
                        editDvd();
                        break;
                    case 6:
                        io.print("LOAD DVD LIBRARY FROM FILE");
                        break;
                    case 7:
                        io.print("SAVE DVD LIBRARY BACK TO FILE");
                        break;
                    case 8:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (DvdLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());

        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createDvd() throws DvdLibraryDaoException {
        view.displayCreateDvDBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getTitle(), newDvd);
        view.displayCreateSuccessBanner();
    }

    private void listDvds() throws DvdLibraryDaoException {
        view.displayDisplayAllBanner();
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
    }

    private void viewDvd() throws DvdLibraryDaoException {
        view.displayDisplayDvdBanner();
        String title = view.getDvdTitleChoice();
        Dvd dvd = dao.getDvd(title);
        view.displayDvd(dvd);
    }

    private void removeDvd() throws DvdLibraryDaoException {
        view.displayRemoveDvdBanner();
        String title = view.getDvdTitleChoice();
        Dvd removedDvd = dao.removeDvd(title);
        view.displayRemoveResult(removedDvd);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    private void editDvd() throws DvdLibraryDaoException {
        view.displayEditDvdBanner();//=== Edit DVD ===
        String title = view.getDvdTitleChoice();//asks user to input title
        Dvd currentDVD = dao.getDvd(title);//returns title
        if (currentDVD == null) {
            view.displayNullDVD(); //if user inputs non-existing dvd, it will return "no such dvd"
        } else {
            view.displayDvd(currentDVD); //displays current dvd info
            int editMenuSelection = 0;
            boolean keepGoing = true;
            while (keepGoing) {
                editMenuSelection = view.printEditMenuAndGetSelection(); //Editing Menu

                switch (editMenuSelection) {
                    case 1:
                        editReleaseDate(title);
                        break;
                    case 2:
                        editMPAA(title);
                        break;
                    case 3:
                        editDirectorName(title);
                        break;
                    case 4:
                        editUserRating(title);
                        break;
                    case 5:
                        editStudioName(title);
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
                if (keepGoing == false) {
                    break;
                }
            }
        }
    }

    private int getEditMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void editReleaseDate(String title) throws DvdLibraryDaoException {
        view.displayEditReleaseDateBanner();//=== Edit DVD Release Date ===
        String newReleaseDate = view.getNewReleaseDate();//asks input for new release date
        dao.editReleaseDate(title, newReleaseDate);
        view.displayEditDvdSuccess();//displays success in editing
    }

    private void editMPAA(String title) throws DvdLibraryDaoException {
        view.displayEditMpaaBanner();
        String newMpaaRating = view.getNewMpaaRating();
        dao.editMPAA(title, newMpaaRating);
        view.displayEditDvdSuccess();
    }

    private void editDirectorName(String title) throws DvdLibraryDaoException {
        view.displayEditDirectorNameBanner();
        String newDirectorName = view.getNewDirectorName();
        dao.editDirectorName(title, newDirectorName);
        view.displayEditDvdSuccess();
    }

    private void editUserRating(String title) throws DvdLibraryDaoException {
        view.displayEditUserRating();
        String newUserRating = view.getNewUserRating();
        dao.editUserRating(title, newUserRating);
        view.displayEditDvdSuccess();
    }

    private void editStudioName(String title) throws DvdLibraryDaoException {
        view.displayEditStudio();
        String newStudioName = view.getNewStudio();
        dao.editStudio(title, newStudioName);
        view.displayEditDvdSuccess();
    }
}


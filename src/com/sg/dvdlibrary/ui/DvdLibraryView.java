package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.Dvd;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;

import java.util.List;


public class DvdLibraryView {
    //getting access to UIO and UIOCImpl by creating an object named io
    private UserIO io = new UserIOConsoleImpl();

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add DVD to Collection");
        io.print("2. Remove DVD from Collection");
        io.print("3. View DVDs in the Collection");
        io.print("4. Display information for particular DVD");
        io.print("5. Edit the information for Existing DVD");
        io.print("6. Load DVD Library from a file");
        io.print("7. Save DVD Library back to file");
        io.print("8. Exit");

        return io.readInt("Please select from the above choices.", 1, 8);
    }

    //this method prompts the user for title, release date, MPAA, Director's name, Studio, Ratings
    // gather the information, creates object and returns object
    public Dvd getNewDvdInfo(){
        String title = io.readString("Please enter the title of the DVD:");
        String ReleaseDate = io.readString("Please enter the Release Date:");
        String MPAA = io.readString("Please enter the MPAA:");
        String DirectorsName = io.readString("Please enter the Director's Name:");
        String Studio = io.readString("Please enter the Studio:");
        String UserRating = io.readString("Ratings?");

        Dvd currentDvd = new Dvd(title);
        currentDvd.setReleaseDate(ReleaseDate);
        currentDvd.setMPAA(MPAA);
        currentDvd.setDirectorsName(DirectorsName);
        currentDvd.setStudio(Studio);
        currentDvd.setUserRating(UserRating);
        return currentDvd;
    }
    // This method simply displays a banner or heading to the UI indicating that
    // the next interactions on the screen will be for creating a new dvd.
    public void displayCreateDvDBanner() {
        io.print("=== Create DvD ===");
    }
    //The second method displays a message that the new dvd was successfully created and waits for the user to hit Enter to continue
    public void displayCreateSuccessBanner() {
        io.readString("DvD successfully created.  Please hit enter to continue");
    }
    //A method that takes a list of DVD objects as a parameter and displays the information for each Dvd to the screen.
    public void displayDvdList(List<Dvd> dvdList){
        for (Dvd currentDvd : dvdList){
            String DvdInfo = String.format("%s: %s, %s, %s, %s, %s",
                    currentDvd.getTitle(),
                    currentDvd.getReleaseDate(),
                    currentDvd.getMPAA(),
                    currentDvd.getDirectorsName(),
                    currentDvd.getStudio(),
                    currentDvd.getUserRating());
            io.print(DvdInfo);
        }
        io.readString("Please hit enter to continue");
    }
    public void displayDisplayAllBanner() {
        io.print("=== Display All Dvds ===");
    }

    public void displayDisplayDvdBanner () {
        io.print("=== Display DVD ===");
    }

    public String getDvdTitleChoice() {
        return io.readString("Please enter the dvd title.");
    }

    public void displayDvd(Dvd dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMPAA());
            io.print(dvd.getDirectorsName());
            io.print(dvd.getStudio());
            io.print(dvd.getUserRating());
            io.print("");
        } else {
            io.print("DVD does not exist.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDvdBanner() {
        io.print("=== Remove Dvd ===");
    }

    public void displayRemoveResult(Dvd dvdRecord) {
        if(dvdRecord != null){
            io.print("DVD successfully removed.");
        }else{
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("CIAO!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    // ALL ABOUT EDITING EXISTING DVDS
    public int printEditMenuAndGetSelection() {
        io.print("Edit Menu");
        io.print("1. Edit Release Date");
        io.print("2. Edit MPAA");
        io.print("3. Edit Director Name");
        io.print("4. Edit User Rating");
        io.print("5. Edit Studio Name");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public void displayEditDvdBanner() {
        io.print("=== Edit DVD ===");
    }

    public void displayEditDvdSuccess() {
        io.readString(
                "DVD successfully Edited.  Please hit enter to continue");
    }

    public void displayEditReleaseDateBanner() {
        io.print("=== Edit DVD Release Date ===");
    }

    public void displayEditMpaaBanner() {
        io.print("=== Edit DVD MPAA rating ===");
    }

    public void displayEditDirectorNameBanner() {
        io.print("=== Edit DVD Director's Name ===");
    }

    public void displayEditStudio() {
        io.print("=== Edit DVD Studio ===");
    }

    public void displayEditUserRating() {
        io.print("=== Edit DVD User Rating ===");
    }

    public String getNewReleaseDate() {
        return io.readString("Please enter new release date.");
    }

    public String getNewMpaaRating() {
        return io.readString("Please enter new MPAA rating.");
    }

    public String getNewDirectorName() {
        return io.readString("Please enter new director's name.");
    }

    public String getNewUserRating() {
        return io.readString("Please enter new user rating.");
    }

    public String getNewStudio() {
        return io.readString("Please enter new studio.");
    }

    public void displayNullDVD() {
        io.print("No such DVD.");
        io.readString("Please hit enter to continue.");
    }
}


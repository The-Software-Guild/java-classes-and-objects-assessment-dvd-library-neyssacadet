package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class DvdLibraryDaoImpl implements DvdLibraryDao {
    private Map<String, Dvd> dvds = new HashMap<>();

    public static final String LIBRARY_FILE = "library.txt";
    public static final String DELIMITER = "::";

    // MARSHALL AND UNMARSHALL
    private Dvd unmarshallDvd(String dvdAsText){
        String[] dvdTokens = dvdAsText.split(DELIMITER);

        String title = dvdTokens[0];

        // Which we can then use to create a new Dvd object to satisfy
        // the requirements of the Dvd constructor.
        Dvd dvdFromFile = new Dvd(title);


        // Index 1 - Release date
        dvdFromFile.setReleaseDate(dvdTokens[1]);

        // Index 2 - MPAA
        dvdFromFile.setMPAA(dvdTokens[2]);

        // Index 3 - Director's name
        dvdFromFile.setDirectorsName(dvdTokens[3]);

        // Index 4 - user ratings
        dvdFromFile.setUserRating(dvdTokens[4]);

        // Index 5 - studio name
        dvdFromFile.setStudio(dvdTokens[5]);

        // We have now created a dvd! Return it!
        return dvdFromFile;
    }

    private void loadLibrary() throws DvdLibraryDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException(
                    "-_- Could not load library data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentDvd holds the most recent dvd unmarshalled
        Dvd currentDvd;

        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a dvd
            currentDvd = unmarshallDvd(currentLine);

            dvds.put(currentDvd.getTitle(), currentDvd);
        }
        // close scanner
        scanner.close();
    }

    private String marshallDvd(Dvd aDvd){
        String dvdAsText = aDvd.getTitle() + DELIMITER;

        // add the rest of the properties in the correct order:

        // release
        dvdAsText += aDvd.getReleaseDate() + DELIMITER;

        // mpaa
        dvdAsText += aDvd.getMPAA() + DELIMITER;

        // director's name
        dvdAsText += aDvd.getDirectorsName() + DELIMITER;

        // user ratings
        dvdAsText += aDvd.getUserRating() + DELIMITER;

        // studio name - don't forget to skip the DELIMITER here.
        dvdAsText += aDvd.getStudio();

        // We have now turned a dvd to text! Return it!
        return dvdAsText;
    }

    private void writeLibrary() throws DvdLibraryDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DvdLibraryDaoException(
                    "Could not save dvd data.", e);
        }

        String DvdAsText;
        List<Dvd> dvdList = this.getAllDvds();
        for (Dvd currentDvd : dvdList) {
            // turn a dvd into a String
            DvdAsText = marshallDvd(currentDvd);
            // write the dvd object to the file
            out.println(DvdAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }


    // IMPLEMENTATION OF ALL DAO METHODS
    //putting the supplied dvd into out map by using the title as the key.
    @Override
    public Dvd addDvd(String title, Dvd dvd) throws DvdLibraryDaoException {
        loadLibrary();
        Dvd prevDvd = dvds.put(title,dvd);
        writeLibrary();
        return prevDvd;
    }
    //gets aa of the Dvd objects out of the dvd map as a collection by calling the values() method
    @Override
    public List<Dvd> getAllDvds() throws DvdLibraryDaoException {
        loadLibrary();
        return new ArrayList<Dvd>(dvds.values());
    }

    @Override
    public Dvd getDvd(String title) throws DvdLibraryDaoException {
        loadLibrary();
        return dvds.get(title);
    }

    @Override
    public Dvd removeDvd(String title) throws DvdLibraryDaoException {
        loadLibrary();
        Dvd removedDvd = dvds.remove(title);
        writeLibrary();
        return removedDvd;
    }
    //EDITING SECTION
    @Override
    public Dvd editReleaseDate(String title, String newReleaseDate) throws DvdLibraryDaoException {
        loadLibrary();
        Dvd editDvd = dvds.get(title);
        editDvd.setReleaseDate(newReleaseDate);
        writeLibrary();
        return editDvd;
    }

    @Override
    public Dvd editMPAA(String title, String newMpaaRating) throws DvdLibraryDaoException {
        loadLibrary();
        Dvd editDvd = dvds.get(title);
        editDvd.setReleaseDate(newMpaaRating);
        writeLibrary();
        return editDvd;
    }

    @Override
    public Dvd editDirectorName(String title, String newDirectorName) throws DvdLibraryDaoException {
        loadLibrary();
        Dvd editDvd = dvds.get(title);
        editDvd.setReleaseDate(newDirectorName);
        writeLibrary();
        return editDvd;
    }

    @Override
    public Dvd editUserRating(String title, String newUserRating) throws DvdLibraryDaoException {
        loadLibrary();
        Dvd editDvd = dvds.get(title);
        editDvd.setReleaseDate(newUserRating);
        writeLibrary();
        return editDvd;
    }

    @Override
    public Dvd editStudio(String title, String newStudioName) throws DvdLibraryDaoException {
        loadLibrary();
        Dvd editDvd = dvds.get(title);
        editDvd.setReleaseDate(newStudioName);
        writeLibrary();
        return editDvd;
    }
}
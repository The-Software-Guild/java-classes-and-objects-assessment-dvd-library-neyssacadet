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

    //putting the supplied dvd into out map by using the title as the key.
    @Override
    public Dvd addDvd(String title, Dvd dvd) throws DvdLibraryDaoException {
        Dvd prevDvd = dvds.put(title,dvd);
        return prevDvd;
    }
    //gets aa of the Dvd objects out of the dvd map as a collection by calling the values() method
    @Override
    public List<Dvd> getAllDvds() throws DvdLibraryDaoException {
        return new ArrayList<Dvd>(dvds.values());
    }

    @Override
    public Dvd getDvd(String title) throws DvdLibraryDaoException {
        return dvds.get(title);
    }

    @Override
    public Dvd removeDvd(String title) throws DvdLibraryDaoException {
        Dvd removedDvd = dvds.remove(title);
        return removedDvd;
    }

    @Override
    public Dvd editReleaseDate(String title, String newReleaseDate) throws DvdLibraryDaoException {

    }

    @Override
    public Dvd editMPAA(String title, String newMpaaRating) throws DvdLibraryDaoException {
        return null;
    }

    @Override
    public Dvd editDirectorName(String title, String newDirectorName) throws DvdLibraryDaoException {
        return null;
    }

    @Override
    public Dvd editUserRating(String title, String newUserRating) throws DvdLibraryDaoException {
        return null;
    }

    @Override
    public Dvd editStudio(String title, String newStudioName) throws DvdLibraryDaoException {
        return null;
    }
}
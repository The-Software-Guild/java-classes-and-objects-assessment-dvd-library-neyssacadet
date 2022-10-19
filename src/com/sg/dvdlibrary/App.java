package com.sg.dvdlibrary;

import com.sg.dvdlibrary.controller.DvdLibraryController;
//import com.sg.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.sg.dvdlibrary.dao.DvdLibraryDao;
//import com.sg.dvdlibrary.ui.DvdLibraryView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author salajrawi
 */
public class App {

    public static void main(String[] args) {
        DvdLibraryController controller = new DvdLibraryController();
        controller.run();
    }
}

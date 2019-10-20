/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDLibrary;

import Controller.DVDLibraryController;
import DAO.DVDLibraryDao;
import DAO.DVDLibraryDaoFileImpl;
import UI.DVDView;
import UI.UserIO;
import UI.UserIOConsoleImpl;

/**
 *
 * @author daler
 */
public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        DVDView myView = new DVDView(myIo);
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller = new DVDLibraryController(myDao, myView);
        controller.run();
    }
}

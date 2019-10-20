/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DVDLibraryDao;
import DAO.DVDLibraryDaoException;
import DAO.DVDLibraryDaoFileImpl;
import DTO.DVD;
import UI.DVDView;
import UI.UserIO;
import UI.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author daler
 */
public class DVDLibraryController {
    
    public DVDLibraryController(DVDLibraryDao dao, DVDView view){
        this.dao = dao;
        this.view = view;
    }

    DVDView view; //= new DVDView();
    DVDLibraryDao dao; //= new DVDLibraryDaoFileImpl();
    private UserIO io = new UserIOConsoleImpl();
    
    private void createDVD() throws DVDLibraryDaoException {
        view.displayAddDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayAddSuccessBanner();
    }
    
    private void listDVDs() throws DVDLibraryDaoException {
        view.displayDisplayAllDVDsBanner();
        List<DVD> DVDList = dao.getAllDVDs();
        view.displayDVDList(DVDList);
    }
    
    private void viewDVD() throws DVDLibraryDaoException {
        view.displayDisplayDVDBanner();
        String title = view.getDVDTitleChoice();
        DVD dvd = dao.getDVD(title);
        view.displayDVD(dvd);
    }
    
    private void removeDVD() throws DVDLibraryDaoException {
        view.displayRemoveDVDBanner();
        String title = view.getDVDTitleChoice();
        dao.removeDVD(title);
        view.displayRemoveSuccessBanner();
    }
    
    private void removeDVDToEdit() throws DVDLibraryDaoException {
        String title = view.getDVDTitleChoice();
        dao.removeDVD(title);
    }
    
    private void editDVD() throws DVDLibraryDaoException {//this, the dao, the daoFileImpl, or the view is somehow duplicating the edited dvd
        view.displayEditDVDBanner();
        String title = view.getDVDEditChoice();
        removeDVDToEdit();
        DVD editedDVD = view.getEditedDVDInfo();
        dao.editInfo(title, editedDVD);
        view.displayDVDEditSuccessBanner();
    }
    
    public void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    public void exitMessage() {
        view.displayExitBanner();
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
        while (keepGoing) {
            io.print("Main Menu");
            io.print("1. Add DVD");
            io.print("2. Remove DVD");
            io.print("3. Edit DVD Information");
            io.print("4. List DVDs");
            io.print("5. Search by Title and Show Information");
            //io.print("6. Search DVD By Title");
            io.print("6. Exit");

            menuSelection = io.readInt("Please select from the above choices", 1, 6);

            switch (menuSelection) {
                case 1:
                    createDVD();
                    break;
                case 2:
                    removeDVD();
                    break;
                case 3:
                    editDVD();
                    break;
                case 4:
                    listDVDs();
                    break;
                case 5:
                    viewDVD();
                    break;
               // case 6:
                   // io.print("search dvd by title");
                 //   break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();

            }
        }
        exitMessage();
        } catch (DVDLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

}

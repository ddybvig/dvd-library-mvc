/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DVD;
import java.util.List;

/**
 *
 * @author daler
 */
public interface DVDLibraryDao {
    //for menu choice number 1 (add DVD). this should be consistent with my DVD class in terms of the constructor. should only need to supply title upon adding.
    DVD addDVD(String title, DVD dvd) throws DVDLibraryDaoException;
    
    //menu choice 2: remove DVD. will ask for title again in order to remove.
    DVD removeDVD(String title) throws DVDLibraryDaoException;
    
    //menu choice 3: edit DVD info. will ask for input for all fields.
    DVD editInfo(String title, DVD dvd)throws DVDLibraryDaoException; //look around to figure out if this, the daoFIleImpl, or the view method is duplicating the edited dvd
    
    //menu choice 4: list all DVDs. returns a list of all DVDs and associated info fields?
    List<DVD> getAllDVDs() throws DVDLibraryDaoException;
    
    //menu choice 5: show DVD info. takes in the title String then returns all the info.
    DVD getDVD(String title) throws DVDLibraryDaoException;
    
    //menu choice 6: search dvd by title: pretty much the same as number 5?
    //DVD getDVDByTitle(String title); commented out cuz making title my unique identifier makes this redundant
}

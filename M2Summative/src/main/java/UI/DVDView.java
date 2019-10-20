/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DTO.DVD;
import java.util.List;

/**
 *
 * @author daler
 */
public class DVDView {
    
    private UserIO io;
    public DVDView(UserIO io) {
        this.io = io;
    }
    
    //UserIO io = new UserIOConsoleImpl();
    
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add DVD");
        io.print("2. Remove DVD");
        io.print("3. Edit DVD Information");
        io.print("4. List DVDs");
        io.print("5. Search by DVD Title and Show Information");
       // io.print("Search DVDs by Title");
        io.print("6. Exit");
        
        return io.readInt("Please select from the above choices.", 1, 6);
                
                
                
    }
    
    public DVD getNewDVDInfo() {
        String title = io.readString("Please enter movie title");
        String releaseDate = io.readString("Please enter movie release year.");
        String rating = io.readString("Please enter movie MPAA rating.");
        String director = io.readString("Please enter director's name.");
        String studio = io.readString("Please enter studio name.");
        String userComments = io.readString("Add any comments you have on the movie here (e.g. star rating, family-friendly, etc.)");
        DVD currentDVD = new DVD(title);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setRating(rating);
        currentDVD.setDirector(director);
        currentDVD.setStudio(studio);
        currentDVD.setUserComments(userComments);
        return currentDVD;
    }
    
    public DVD getEditedDVDInfo() {//somehow this is duplicating the edited dvd
        io.print("The edit wizard will now prompt you for each piece of DVD information. "
                + "Please enter new information for the applicable fields. Otherwise re-enter the original information.");
        String title = io.readString("Please enter new movie title, if applicable.");
        String releaseDate = io.readString("Please enter new movie release year, if applicable.");
        String rating = io.readString("Please enter new movie MPAA rating, if applicable.");
        String director = io.readString("Please enter new director's name, if applicable.");
        String studio = io.readString("Please enter new studio name, if applicable.");
        String userComments = io.readString("Add any comments you have on the movie here (e.g. star rating, family-friendly, etc.)");
        DVD editedDVD = new DVD(title);
        editedDVD.setReleaseDate(releaseDate);
        editedDVD.setRating(rating);
        editedDVD.setDirector(director);
        editedDVD.setStudio(studio);
        editedDVD.setUserComments(userComments);
        return editedDVD;
    }
    
    public void displayAddDVDBanner() {
        io.print("=== Add New DVD ===");
    }
    
    public void displayAddSuccessBanner() {
        io.readString("DVD successfully added. Please hit enter to continue.");
    }
    
    public void displayDVDList(List<DVD> DVDList) {
        for (DVD currentDVD : DVDList) {
            io.print(currentDVD.getTitle()+ " : " + currentDVD.getReleaseDate()+ " : " + currentDVD.getRating()+ 
                    " : " + currentDVD.getDirector()+ " : " + currentDVD.getStudio() + " : " + currentDVD.getUserComments());
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayDisplayAllDVDsBanner() {
        io.print("=== Display All DVDs ===");
    }
    
    public void displayDisplayDVDBanner() {
        io.print("=== Display DVD ===");
    }
    
    public String getDVDTitleChoice() {
        return io.readString("Please enter the title of the DVD you want to search for.");
    }
    
    public String getDVDEditChoice() {
        return io.readString("Please enter the title of the DVD you want to edit.");
    }
    
    public void displayDVD(DVD dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getRating());
            io.print(dvd.getDirector());
            io.print(dvd.getStudio());
            io.print(dvd.getUserComments());
        } else {
            io.print("DVD title not found.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayRemoveDVDBanner() {
        io.print("=== Remove DVD ===");
    }
    
    public void displayRemoveSuccessBanner() {
        io.readString("DVD successfully removed. Please hit enter to continue.");
    }
    
    public void displayEditDVDBanner() {
        io.print("=== Edit DVD ===");
    }
    
    public void displayDVDEditSuccessBanner() {
        io.readString("DVD successfully edited. Please hit enter to continue.");
    }
    
    public void displayExitBanner() {
        io.print("Goodbye!");
    }
    
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
    
}

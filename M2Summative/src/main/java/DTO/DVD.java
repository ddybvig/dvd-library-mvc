/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author daler
 */
public class DVD {

    //list each field, make them all private
    private String title;
    private String releaseDate;
    private String rating;
    private String director;
    private String studio;
    private String userComments;

    //do i need to put constructors in here as well?
    //does it make sense to have any of these fields be read only?
    public DVD(String title) { //this should make title the unique identifier/read only. there is no setter for this one. **it is passed as a parameter into the constructor**
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserComments() {
        return userComments;
    }

    public void setUserComments(String userComments) {
        this.userComments = userComments;
    }

}

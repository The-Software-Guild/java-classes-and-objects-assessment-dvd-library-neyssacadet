package com.sg.dvdlibrary.dto;

public class Dvd {
    private String title;
    private String ReleaseDate;
    private String MPAA;
    private String DirectorsName;
    private String Studio;
    private String UserRating;

    //why are we using a constructor and getter and for the rest we use setter/getter?? Is there a reason we cannot just use setter/getter? but it kinda is a setter/getter
    public Dvd(String title) {
        this.title = title;
    }
    public String getTitle (){
        return title;
    }
    //Setter and getter for release dates
    public void setReleaseDate(){
        this.ReleaseDate = ReleaseDate;
    }
    public String getReleaseDate(){
        return ReleaseDate;
    }
    //Setter and Getter for MPAA
    public void setMPAA(){
        this.MPAA = MPAA;
    }
    public String getMPAA(){
        return MPAA;
    }
    //Setter and Getter for DirectorsName
    public void setDirectorsName(){
        this.DirectorsName = DirectorsName;
    }
    public String getDirectorsName(){
        return DirectorsName;
    }
    //Setter and Getter for Studio
    public void setStudio(){
        this.Studio = Studio;
    }
    public String getStudio(){
        return Studio;
    }
    //Setter and Getter for User Rating
    public void setUserRating(){
        this.UserRating = UserRating;
    }
    public String getUserRating(){
        return UserRating;
    }
}

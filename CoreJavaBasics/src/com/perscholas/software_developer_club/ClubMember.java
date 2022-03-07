package com.perscholas.software_developer_club;

public class ClubMember {
    
    private String name;
    private String city;
    private String favoriteLanguage;

    public ClubMember() { }

    public ClubMember(String name, String city, String favoriteLanguage) {
        this.name = name;
        this.city = city;
        this.favoriteLanguage = favoriteLanguage;
    }

    @Override
    public String toString() {
        return String.format("Member Name: %s%nLocation: %s%nFavorite Language: %s", 
            name, city, favoriteLanguage);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFavoriteLanguage() {
        return this.favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

}

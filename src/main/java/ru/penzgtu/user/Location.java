package ru.penzgtu.user;

import java.util.Objects;

public class Location {
    private String street;
    private String city;
    private String state;
    private String country;
    private String zip;
    private Coordinates coordinates;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "[" + street + ", " + city + ", " + state + ", "
                + country + ", " + zip + ", " + coordinates + "]";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Location)) {
            return false;
        }
        Location that = (Location) object;
        return street.equals(that.street)
                && city.equals(that.city)
                && state.equals(that.state)
                && country.equals(that.country)
                && zip.equals(that.zip)
                && coordinates.equals(that.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city, state, country, zip, coordinates);
    }
}

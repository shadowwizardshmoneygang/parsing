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

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getZip() {
        return zip;
    }

    public Coordinates getCoordinates() {
        return coordinates;
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

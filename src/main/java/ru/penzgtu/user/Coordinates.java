package ru.penzgtu.user;

import java.util.Objects;

public class Coordinates {
    private Double latitude;
    private Double longitude;

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "[" + latitude + ", " + longitude + "]";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Coordinates)) {
            return false;
        }
        Coordinates that = (Coordinates) object;
        return Double.compare(latitude, that.latitude) == 0
                && Double.compare(longitude ,that.longitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }
}

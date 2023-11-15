package ru.penzgtu.user;

import java.util.Objects;

public class Name {
    private String first;
    private String middle;
    private String last;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return first + " " + middle + " " + last;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Name)) {
            return false;
        }
        Name that = (Name) object;
        return first.equals(that.first)
                && middle.equals(that.middle)
                && last.equals(that.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, middle, last);
    }
}

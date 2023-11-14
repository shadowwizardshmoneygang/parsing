package ru.penzgtu.user;

import java.util.Objects;

public class Job {
    private String title;
    private String descriptor;
    private String area;
    private String type;
    private String company;

    public String getTitle() {
        return title;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public String getArea() {
        return area;
    }

    public String getType() {
        return type;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "[" + title + ", " + descriptor + ", " + area + ", "
                + type + ", " + company + "]";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Job)) {
            return false;
        }
        Job that = (Job) object;
        return title.equals(that.title)
                && descriptor.equals(that.descriptor)
                && area.equals(that.area)
                && type.equals(that.type)
                && company.equals(that.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, descriptor, area, type, company);
    }
}

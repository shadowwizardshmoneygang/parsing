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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

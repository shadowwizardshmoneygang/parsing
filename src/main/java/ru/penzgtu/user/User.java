package ru.penzgtu.user;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class User {
    private Integer id;
    private Status status;
    private Name name;
    private BigDecimal monthlySalary;
    private LocalDateTime birthday;
    private String username;
    private String password;
    private List<String> emails;
    private String phoneNumber;
    private Location location;
    private String website;
    private String domain;
    private Job job;
    private CreditCard creditCard;
    private String uuid;
    private String objectId;

    public Integer getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public Name getName() {
        return name;
    }

    public BigDecimal getMonthlySalary() {
        return monthlySalary;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getEmails() {
        return emails;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Location getLocation() {
        return location;
    }

    public String getWebsite() {
        return website;
    }

    public String getDomain() {
        return domain;
    }

    public Job getJob() {
        return job;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public String getUuid() {
        return uuid;
    }

    public String getObjectId() {
        return objectId;
    }

    @Override
    public String toString() {
        return "[" + id + ", " + status + ", " + name + ", " + monthlySalary + ", "
                + birthday + ", " + username + ", " + password + ", " + emails + ", "
                + phoneNumber + ", " + location + ", " + website + ", " + domain + ", "
                + job + ", " + creditCard + ", " + uuid + ", " + objectId + "]";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof User)) {
            return false;
        }
        User that = (User) object;
        return id.equals(that.id) && status.equals(that.status) & name.equals(that.name)
                && monthlySalary.equals(that.monthlySalary) && birthday.equals(that.birthday)
                && username.equals(that.username) && password.equals(that.password)
                && emails.equals(that.emails) && phoneNumber.equals(that.phoneNumber)
                && location.equals(that.location) && website.equals(that.website)
                && domain.equals(that.domain) && job.equals(that.job)
                && creditCard.equals(that.creditCard) && uuid.equals(that.uuid)
                && objectId.equals(that.objectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, name, monthlySalary, birthday, username, password,
                emails, phoneNumber, location, website, domain, job, creditCard, uuid, objectId);
    }
}

package ru.penzgtu.user;

import java.util.Objects;

public class CreditCard {
    private String number;
    private String cvv;
    private String issuer;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    @Override
    public String toString() {
        return "[" + number + ", " + cvv + ", " + issuer + "]";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof CreditCard)) {
            return false;
        }
        CreditCard that = (CreditCard) object;
        return number.equals(that.number)
                && cvv.equals(that.cvv)
                && issuer.equals(that.issuer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, cvv, issuer);
    }
}

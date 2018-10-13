package com.fifthgen.prahranvet.vetwarebridge.data.model;

import java.util.Objects;

public class Sender {

    private String accountCode;
    private String name;
    private String email;
    private String phone;
    private String authorisedBy;

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAuthorisedBy() {
        return authorisedBy;
    }

    public void setAuthorisedBy(String authorisedBy) {
        this.authorisedBy = authorisedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sender sender = (Sender) o;
        return Objects.equals(accountCode, sender.accountCode) &&
                Objects.equals(name, sender.name) &&
                Objects.equals(email, sender.email) &&
                Objects.equals(phone, sender.phone) &&
                Objects.equals(authorisedBy, sender.authorisedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountCode, name, email, phone, authorisedBy);
    }

    @Override
    public String toString() {
        return "Sender{" +
                "accountCode='" + accountCode + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", authorisedBy='" + authorisedBy + '\'' +
                '}';
    }
}

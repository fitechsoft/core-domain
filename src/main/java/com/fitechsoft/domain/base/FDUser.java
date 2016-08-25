package com.fitechsoft.domain.base;

import javax.persistence.Entity;

/**
 * Created by chun on 16/8/25.
 */
@Entity
public class FDUser extends FDSubject {

    private String firstName;
    private String lastName;
    private String email;
    private String address;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public FDUser(String firstName, String lastName) {
        super();
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
        super.setIdentifier(this.firstName + " " + this.lastName);
    }

    @Override
    public void setSuperior(FDSubject superior) {

        if (!(superior instanceof FDDepartment)) {
            throw new IllegalArgumentException();
        }

        super.setSuperior(superior);

        ((FDDepartment) superior).addOneToStaff(this);
    }
}

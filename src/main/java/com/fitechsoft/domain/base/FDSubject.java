package com.fitechsoft.domain.base;


import javax.persistence.*;

/**
 * This class represents all active subjects.
 *
 * @author Chun Cao
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class FDSubject extends FDEntity {


    @Column(unique = true)
    private String identifier;


    @ManyToOne(cascade = CascadeType.ALL)
    private FDSubject superior;


    protected FDSubject() {

    }

    protected FDSubject(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public FDSubject getSuperior() {
        return superior;
    }

    public void setSuperior(FDSubject superior) {
        this.superior = superior;
    }


}
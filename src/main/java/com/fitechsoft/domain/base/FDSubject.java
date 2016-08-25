package com.fitechsoft.domain.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by chun on 16/8/24.
 */
@MappedSuperclass
public class FDSubject extends AbstractEntity {


    @Column(unique = true)
    private String identifier;


    private FDSubject superior;


    protected FDSubject() {

    }

    protected FDSubject(String identifier) {
        this.identifier = identifier;
    }

    protected String getIdentifier() {
        return identifier;
    }

    protected void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public FDSubject getSuperior() {
        return superior;
    }

    public void setSuperior(FDSubject superior) {
        this.superior = superior;
    }


}
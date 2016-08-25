package com.fitechsoft.domain.subject;

import com.fitechsoft.domain.base.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by chun on 16/8/24.
 */
@Entity
public class Subject extends AbstractEntity {


    @Column(unique = true)
    private String identifier;

    protected Subject() {

    }

    public Subject(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

}
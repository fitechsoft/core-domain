package com.fitechsoft.domain.base;

import javax.persistence.Entity;

/**
 * Created by chun on 16/8/25.
 */
@Entity
public class FDOperation {



    private String opName;

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

}

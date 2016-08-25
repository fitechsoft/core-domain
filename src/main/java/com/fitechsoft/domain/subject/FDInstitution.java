package com.fitechsoft.domain.subject;

import com.fitechsoft.domain.base.FDSubject;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * The class represents institutions aka Banks here.

 * @author Chun Cao
 */
@Entity
public class FDInstitution extends FDSubject {

    public FDInstitution(String institutionID) {
        super(institutionID);
        this.inferiors = new HashSet<FDInstitution>();
        this.departments = new HashSet<FDDepartment>();
    }


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = false)
    private Set<FDInstitution> inferiors;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = false)
    private Set<FDDepartment> departments;


    @Override
    public void setSuperior(FDSubject superior) {

        if (!(superior instanceof FDInstitution)) {
            throw new IllegalArgumentException();
        }

        super.setSuperior(superior);
        ((FDInstitution) superior).addInferiorInstitution(this);
    }


    private void addInferiorInstitution(FDInstitution inferior) {
        this.inferiors.add(inferior);
    }

    public Set<FDInstitution> getInferiors() {
        return this.inferiors;
    }

    public Set<FDDepartment> getDepartments() {
        return this.departments;
    }

    public void addDepartment(FDDepartment department) {
        this.departments.add(department);
    }
}

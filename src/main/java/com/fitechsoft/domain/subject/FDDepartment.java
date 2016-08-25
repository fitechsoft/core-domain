package com.fitechsoft.domain.subject;

import com.fitechsoft.domain.base.FDSubject;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * The class represents departments in some institution.

 * @author Chun Cao
 */
@Entity
public class FDDepartment extends FDSubject {


    public FDDepartment(String departmentName) {
        super(departmentName);
        subDepartments = new HashSet<FDDepartment>();
        staff = new HashSet<FDUser>();
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = false)
    private Set<FDDepartment> subDepartments;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = false)
    private Set<FDUser> staff;


    @Override
    public void setSuperior(FDSubject superior) {

        if (!(superior instanceof FDInstitution || superior instanceof FDDepartment)) {
            throw new IllegalArgumentException();
        }

        super.setSuperior(superior);

        if (superior instanceof FDInstitution ){
            ((FDInstitution) superior).addDepartment(this);
        }else{
            ((FDDepartment) superior).addSubDepartment(this);
        }

    }

    private void addSubDepartment(FDDepartment department) {
        this.subDepartments.add(department);
    }

    public Set<FDDepartment> getSubDepartments() {
        return this.subDepartments;
    }

    public Set<FDUser> getStaff() {
        return staff;
    }

    protected void addOneToStaff(FDUser one) {
        this.staff.add(one);
    }

}

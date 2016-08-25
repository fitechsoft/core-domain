package com.fitechsoft.domain.base;

import com.fitechsoft.domain.subject.FDDepartment;
import com.fitechsoft.domain.subject.FDInstitution;
import com.fitechsoft.domain.subject.FDUser;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by chun on 16/8/25.
 */
public class SubjectTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testInstitutions() {

        FDInstitution PBOC = new FDInstitution("PBOC");

        FDInstitution njBank = new FDInstitution("NJ Bank");
        FDInstitution shBank = new FDInstitution("SH Bank");

        njBank.setSuperior(PBOC);
        shBank.setSuperior(PBOC);

        assertThat(PBOC.getInferiors().size(), is(2));

        assertThat(njBank.getSuperior(), is(PBOC));
        assertThat(shBank.getSuperior(), is(PBOC));

        assertThat(PBOC.getInferiors().contains(shBank), is(true));
        assertThat(PBOC.getInferiors().contains(njBank), is(true));

        assertThat(PBOC.getSuperior(), is(nullValue()));

        assertThat(PBOC.getDepartments().size(), is(0));

        assertThat(PBOC.getIdentifier().equals("PBOC"), is(true));


        assertThat(njBank.getSuperior(), is(notNullValue()));


    }

    @Test
    public void testDepartments() {

        FDInstitution njBank = new FDInstitution("NJ Bank");

        FDDepartment techDept = new FDDepartment("Tech Dept");

        FDDepartment bcDept = new FDDepartment("BlockChain Dept");
        FDDepartment bdDept = new FDDepartment("BidData Dept");

        bcDept.setSuperior(techDept);
        bdDept.setSuperior(techDept);


        techDept.setSuperior(njBank);

        assertThat(njBank.getDepartments().contains(techDept), is(true));

        assertThat(techDept.getSubDepartments().size(), is(2));
        assertThat(techDept.getSubDepartments().contains(bcDept), is(true));
        assertThat(techDept.getSubDepartments().contains(bdDept), is(true));

        assertThat(bdDept.getSubDepartments().contains(bcDept), is(false));
        assertThat(bdDept.getSubDepartments().contains(techDept), is(false));


    }


    @Test
    public void testUsers() {

        FDDepartment techDept = new FDDepartment("Tech Dept");
        FDUser alice = new FDUser("Alice", "Huang");
        FDUser bob = new FDUser("Bob", "Zhang");
        FDUser john = new FDUser("John", "Lee");

        alice.setSuperior(techDept);

        exception.expect(IllegalArgumentException.class);
        bob.setSuperior(alice);

        assertThat(techDept.getStaff().contains(alice), is(true));
        assertThat(techDept.getStaff().contains(bob), is(true));
        assertThat(techDept.getStaff().contains(john), is(false));


        assertThat(alice.getSuperior(), is(techDept));
        assertThat(bob.getSuperior(), is(techDept));
        assertThat(john.getSuperior(), is(nullValue()));

    }

}


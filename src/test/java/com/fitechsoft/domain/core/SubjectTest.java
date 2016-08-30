package com.fitechsoft.domain.core;

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
    public void testSubjects() {

        FDSubject subjectA = new FDSubject("SubjectA");

        FDSubject subjectB = new FDSubject("SubjectB");

        subjectA.setSuperior(subjectB);

        assertThat(subjectA.getSuperior(), is(notNullValue()));
        assertThat(subjectB.getSuperior(), is(nullValue()));

        assertThat(subjectA.getSuperior(), is(subjectB));

        assertThat(subjectA.getIdentifier(), is("SubjectA"));
        assertThat(subjectB.getIdentifier(), is("SubjectB"));

    }



    @Test
    public void testSuperiorRelations(){

        FDSubject subjectA = new FDSubject("SubjectA");

        FDSubject subjectB = new FDSubject("SubjectB");

        subjectA.setSuperior(subjectB);

        assertThat(subjectA.getSuperior(), is(notNullValue()));
        assertThat(subjectB.getSuperior(), is(nullValue()));

        assertThat(subjectA.getSuperior(), is(subjectB));
    }

}


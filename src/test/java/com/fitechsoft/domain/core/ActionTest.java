package com.fitechsoft.domain.core;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by chun on 16/8/30.
 */
public class ActionTest {
    @Test
    public void testActions() {

        assertThat(FDAction.ACTION_CREATE, is(notNullValue()));
        assertNotEquals(FDAction.ACTION_DELETE, FDAction.ACTION_READ);
        assertEquals(FDAction.ACTION_UPDATE, FDAction.ACTION_UPDATE);

    }

}
package com.fitechsoft.domain.core;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * This class represents all passive objects in the system.
 *
 * @author Chun Cao
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class FDObject extends FDEntity {

}

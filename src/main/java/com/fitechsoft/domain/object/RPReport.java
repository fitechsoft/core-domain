package com.fitechsoft.domain.object;

import com.fitechsoft.domain.base.FDEntity;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by chun on 16/8/26.
 */
public class RPReport extends FDEntity {

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<RPField> fields;

}

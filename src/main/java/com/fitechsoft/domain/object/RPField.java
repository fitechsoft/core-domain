package com.fitechsoft.domain.object;

import com.fitechsoft.domain.base.FDEntity;
import org.hibernate.annotations.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import java.util.Date;

/**
 * Created by chun on 16/8/26.
 */
@Entity
public class RPField<T> extends FDEntity {

    private String name;

    @Any(metaColumn = @Column(name = "what_i_contain"))
    @Cascade(CascadeType.ALL)
    @AnyMetaDef(
            idType = "integer",
            metaType = "string",
            metaValues = {
                    @MetaValue(value = "Integer", targetEntity = Integer.class),
                    @MetaValue(value = "String", targetEntity = String.class),
                    @MetaValue(value = "Double", targetEntity = Double.class),
                    @MetaValue(value = "Date", targetEntity = Date.class)
            })
    @JoinColumn(name = "property_id")
    private T value;

}

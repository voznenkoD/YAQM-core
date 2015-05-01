package org.perspectiveJuniors.YAQM.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Created by Всеволод on 11.04.2015.
 */

@Entity
@Table(name="USER")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="VEHICLE_TYPE",
        discriminatorType= DiscriminatorType.STRING
)

public abstract class AbstractUser {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="USER_ID")
    private long id;
    @Column(name="PERSONAL_DATA")
    private AbstractPersonalData personalData;

    public AbstractUser(){};

    public AbstractUser(long id, AbstractPersonalData personalData) {
        this.id = id;
        this.personalData = personalData;
    }

    public long getId() {
        return id;
    }


    public AbstractPersonalData getPersonalData() {
        return personalData;
    }

}

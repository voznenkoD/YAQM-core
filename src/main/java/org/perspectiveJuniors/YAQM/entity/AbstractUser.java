package org.perspectiveJuniors.YAQM.entity;

import org.perspectiveJuniors.YAQM.entity.impl.PersonalData;

/**
 * Created by Всеволод on 11.04.2015.
 */
public abstract class AbstractUser {
    private long id;
    private PersonalData personalData;

    public AbstractUser(){};

    public AbstractUser(long id, PersonalData personalData) {
        this.id = id;
        this.personalData = personalData;
    }

    public long getId() {
        return id;
    }


    public PersonalData getPersonalData() {
        return personalData;
    }

}

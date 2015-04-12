package org.perspectiveJuniors.YAQM.entity.impl;

import org.perspectiveJuniors.YAQM.entity.AbstractPersonalData;

/**
 * Created by Всеволод on 11.04.2015.
 */
public class PersonalData extends AbstractPersonalData{
    public PersonalData() {
    }

    public PersonalData(String name, String surname, String login) {
        super(name, surname, login);
    }
}

package org.perspectiveJuniors.YAQM.entity.impl;

import org.perspectiveJuniors.YAQM.entity.AbstractPersonalData;
import org.perspectiveJuniors.YAQM.entity.AbstractUser;

import javax.persistence.*;

/**
 * Created by Всеволод on 11.04.2015.
 */

@Entity
public class PersonalData extends AbstractPersonalData{

    public PersonalData(){super();}

    public PersonalData(String name, String surname, String login) {
        super(name,surname,login);
    }

}

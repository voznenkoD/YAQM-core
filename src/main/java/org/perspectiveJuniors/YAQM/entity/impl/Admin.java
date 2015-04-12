package org.perspectiveJuniors.YAQM.entity.impl;

import org.perspectiveJuniors.YAQM.entity.AbstractUser;

/**
 * Created by Всеволод on 11.04.2015.
 */
public class Admin extends AbstractUser {
    public Admin() {}
    public Admin(long id, PersonalData personalData) {
        super(id, personalData);
    }
}

package org.perspectiveJuniors.YAQM.entity.impl;

import org.perspectiveJuniors.YAQM.entity.AbstractUser;

/**
 * Created by Всеволод on 11.04.2015.
 */
public class Client extends AbstractUser {
    public Client() {
    }
    public Client(long id, PersonalData personalData) {
        super(id, personalData);
    }
}

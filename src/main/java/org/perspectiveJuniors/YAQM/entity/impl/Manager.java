package org.perspectiveJuniors.YAQM.entity.impl;

import org.perspectiveJuniors.YAQM.entity.AbstractPersonalData;
import org.perspectiveJuniors.YAQM.entity.AbstractUser;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Всеволод on 11.04.2015.
 */
public class Manager extends AbstractUser{
    public Manager() {
    }

    public Manager(long id, AbstractPersonalData personalData) {
        super(id, personalData);
    }
}

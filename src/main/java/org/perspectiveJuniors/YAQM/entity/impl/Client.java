package org.perspectiveJuniors.YAQM.entity.impl;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.perspectiveJuniors.YAQM.entity.AbstractPersonalData;
import org.perspectiveJuniors.YAQM.entity.AbstractUser;

/**
 * Created by Всеволод on 11.04.2015.
 */

@Entity
@DiscriminatorValue("CLIENT")
public class Client extends AbstractUser {
    public Client() {
        super();
    }
    public Client(long id, AbstractPersonalData personalData) {
        super(id, personalData);
    }


    public void setId(long id) {
        super.setId(id);
    }

    public void setPersonalData(AbstractPersonalData personalData) {
        super.setPersonalData(personalData);
    }


}

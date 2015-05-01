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
@Table(name="CLIENT")
@DiscriminatorValue("CLIENT")
public class Client extends AbstractUser {
    public Client() {
    }
    public Client(long id, AbstractPersonalData personalData) {
        super(id, personalData);
    }
}

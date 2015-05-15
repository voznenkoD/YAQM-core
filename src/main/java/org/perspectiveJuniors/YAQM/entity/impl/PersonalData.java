package org.perspectiveJuniors.YAQM.entity.impl;

import org.perspectiveJuniors.YAQM.entity.AbstractPersonalData;
import org.perspectiveJuniors.YAQM.entity.AbstractUser;

import javax.persistence.*;

/**
 * Created by Всеволод on 11.04.2015.
 */
@Entity
@Table(name="PERSONAL_DATA")
public class PersonalData extends AbstractPersonalData{
    @Column(name="NAME")
    private String name;
    @Column(name="SURNAME")
    private String surname;
    @Column(name="LOGIN")
    private String login;
    @OneToOne
    @PrimaryKeyJoinColumn
    private AbstractUser absUser;

    public PersonalData(){};

    public PersonalData(String name, String surname, String login) {
        this.name = name;
        this.surname = surname;
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }
}

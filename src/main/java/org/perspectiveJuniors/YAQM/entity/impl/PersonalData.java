package org.perspectiveJuniors.YAQM.entity.impl;

import org.perspectiveJuniors.YAQM.entity.AbstractPersonalData;

/**
 * Created by Всеволод on 11.04.2015.
 */
public class PersonalData extends AbstractPersonalData{
    private String name;
    private String surname;
    private String login;

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

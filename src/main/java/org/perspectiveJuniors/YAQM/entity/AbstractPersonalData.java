package org.perspectiveJuniors.YAQM.entity;

/**
 * Created by Всеволод on 11.04.2015.
 */
public abstract class AbstractPersonalData {
    private String name;
    private String surname;
    private String login;

    public AbstractPersonalData(){};

    public AbstractPersonalData(String name, String surname, String login) {
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

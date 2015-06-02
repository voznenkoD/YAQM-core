package org.perspectiveJuniors.YAQM.entity;

import javax.persistence.*;

/**
 * Created by Всеволод on 11.04.2015.
 */
@Entity
@Table(name="PERSONAL_DATA")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public abstract class AbstractPersonalData {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="USER_ID")
    protected long id;

    @Column(name="NAME")
    private String name;

    @Column(name="SURNAME")
    private String surname;

    @Column(name="LOGIN")
    private String login;

    @Column(name="PASSWORD")
    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private AbstractUser absUser;

    public AbstractPersonalData(){};

    public AbstractPersonalData(String name, String surname, String login) {
        this.name = name;
        this.surname = surname;
        this.login = login;
    }

    public AbstractPersonalData(String name, String surname, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractPersonalData)) return false;

        AbstractPersonalData that = (AbstractPersonalData) o;

        if (id != that.id) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        return result;
    }
}

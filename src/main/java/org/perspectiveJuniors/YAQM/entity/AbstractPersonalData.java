package org.perspectiveJuniors.YAQM.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Всеволод on 11.04.2015.
 */
@Entity
@Table(name="PERSONAL_DATA")
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
    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private AbstractUser absUser;

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

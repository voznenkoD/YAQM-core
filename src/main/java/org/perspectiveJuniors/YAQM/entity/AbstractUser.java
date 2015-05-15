package org.perspectiveJuniors.YAQM.entity;

import javax.persistence.*;

/**
 * Created by Всеволод on 11.04.2015.
 */

@Entity
@Table(name="USER")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="USER_TYPE",
        discriminatorType= DiscriminatorType.STRING
)

public abstract class AbstractUser {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="USER_ID")
    private long id;
    @Column(name="PERSONAL_DATA")
    @OneToOne(mappedBy="absUser", cascade=CascadeType.ALL)
    private AbstractPersonalData personalData;

    public AbstractUser(){};

    public AbstractUser(long id, AbstractPersonalData personalData) {
        this.id = id;
        this.personalData = personalData;
    }

    public long getId() {
        return id;
    }


    public AbstractPersonalData getPersonalData() {
        return personalData;
    }

}

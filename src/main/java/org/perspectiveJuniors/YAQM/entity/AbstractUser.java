package org.perspectiveJuniors.YAQM.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

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
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="USER_ID")
    protected long id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "absUser", cascade = CascadeType.ALL)
    protected AbstractPersonalData personalData;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<UserRole> userRole = new HashSet<UserRole>(0);

    public AbstractUser(){};

    public AbstractUser(long id, AbstractPersonalData personalData) {
        this.id = id;
        this.personalData = personalData;
    }

    public AbstractUser(long id, AbstractPersonalData personalData,
            Set<UserRole> userRole) {
        this.id = id;
        this.personalData = personalData;
        this.userRole = userRole;
    }

    public long getId() {
        return id;
    }


    public AbstractPersonalData getPersonalData() {
        return personalData;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPersonalData(AbstractPersonalData personalData) {
        this.personalData = personalData;
    }

    public Set<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractUser)) return false;

        AbstractUser that = (AbstractUser) o;

        if (id != that.id) return false;
        if (!(personalData != null ? !personalData.equals(that.personalData) : that.personalData != null)) return true;
        else return false;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (personalData != null ? personalData.hashCode() : 0);
        return result;
    }
}

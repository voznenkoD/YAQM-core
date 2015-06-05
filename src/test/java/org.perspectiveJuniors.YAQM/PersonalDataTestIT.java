package org.perspectiveJuniors.YAQM;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.perspectiveJuniors.YAQM.entity.impl.PersonalData;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by vsevolod on 05.06.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class PersonalDataTestIT {

    @Test
    public void testPersonalDataWithoutParameters(){
        PersonalData personalData = new PersonalData();
        assertNull(personalData.getLogin());
        assertNull(personalData.getName());
        assertNull(personalData.getPassword());
        assertNull(personalData.getSurname());
    }

    @Test
    public void testPersonalDataWith_3_parameters(){
        String name, surname, login;
        name="Name";
        surname="Surname";
        login="Login";
        PersonalData personalData = new PersonalData(name,surname,login);
        assertEquals(name, personalData.getName());
        assertEquals(surname, personalData.getSurname());
        assertEquals(login, personalData.getLogin());
        assertNull(personalData.getPassword());
    }

    @Test
    public void testPersonalDataWith_4_parameters(){
        String name, surname, login, password;
        name="Name";
        surname="Surname";
        login="Login";
        password="Password";
        PersonalData personalData = new PersonalData(name,surname,login,password);
        assertEquals(name,personalData.getName());
        assertEquals(surname, personalData.getSurname());
        assertEquals(login,personalData.getLogin());
        assertEquals(password, personalData.getPassword());
    }

    @Test
    public void testPersonalDataWithSetters(){
        String name, surname, login, password;
        name="Name";
        surname="Surname";
        login="Login";
        password="Password";
        PersonalData personalData = new PersonalData();
        personalData.setLogin(login);
        personalData.setName(name);
        personalData.setPassword(password);
        personalData.setSurname(surname);
        assertEquals(name,personalData.getName());
        assertEquals(surname, personalData.getSurname());
        assertEquals(login,personalData.getLogin());
        assertEquals(password,personalData.getPassword());
    }
}

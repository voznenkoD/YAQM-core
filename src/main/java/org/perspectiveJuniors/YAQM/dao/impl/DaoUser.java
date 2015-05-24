package org.perspectiveJuniors.YAQM.dao.impl;

import org.perspectiveJuniors.YAQM.dao.IDaoUser;
import org.perspectiveJuniors.YAQM.entity.AbstractUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by eljetto on 4/21/15.
 */
@Repository
@Transactional
@Qualifier("daoUser")
public class DaoUser extends GenericDao<AbstractUser> implements IDaoUser {


}

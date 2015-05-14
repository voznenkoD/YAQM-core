package org.perspectiveJuniors.YAQM.dao.impl;

import org.perspectiveJuniors.YAQM.dao.IDaoUser;
import org.perspectiveJuniors.YAQM.entity.AbstractUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by eljetto on 4/21/15.
 */
@Repository
@Transactional
public class DaoUserDaoUser extends GenericDao<AbstractUser> implements IDaoUser {


}

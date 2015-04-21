package org.perspectiveJuniors.YAQM.dao;

import org.perspectiveJuniors.YAQM.entity.AbstractUser;
import java.util.List;

/**
 * Created by Всеволод on 20.04.2015.
 */
public interface IDaoUser {
    public void create(AbstractUser user);
    public void update(AbstractUser user);
    public void delete(AbstractUser user);
    public AbstractUser get(long userId);
    public List<AbstractUser> getAll();
}

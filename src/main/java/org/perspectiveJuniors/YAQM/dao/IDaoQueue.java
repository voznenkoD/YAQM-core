package org.perspectiveJuniors.YAQM.dao;

import org.perspectiveJuniors.YAQM.entity.IQueue;

import java.util.List;

/**
 * Created by Всеволод on 20.04.2015.
 */
public interface IDaoQueue {
    public void create(IQueue queue);
    public void update(IQueue queue);
    public void delete(IQueue queue);
    public IQueue get(long userId);
    public List<IQueue> getAll();
}

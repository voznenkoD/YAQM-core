package org.perspectiveJuniors.YAQM.entity.impl;

import org.perspectiveJuniors.YAQM.entity.IQueue;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


public class Queue implements IQueue {
    private long id;
    private HashSet<Long> adminSet = new HashSet<>();
    private LinkedHashMap<Long,Long> orderMap = new LinkedHashMap<>();

    public Queue(){};

    public Queue(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void addAdmin(long id){
        adminSet.add(new Long(id));
    }

    public boolean containsAdmin(long adminId){
        return adminSet.contains(new Long(adminId));
    }

    public void deleteAdmin(long adminId){
        Iterator<Long> iterator = adminSet.iterator();
        while (iterator.hasNext()){
            Long element = iterator.next();
            if(element.longValue()==adminId)
                adminSet.remove(new Long(adminId));
        }
    }

    public void addOrder(long clientId, long managerId){
        orderMap.put(clientId,managerId);
    }

    public boolean containsOrder(long clientId){
        return orderMap.containsKey(clientId);
    }

    public void deleteOrder(long clientId){
        Iterator<Map.Entry<Long,Long>> iterator = orderMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Long,Long> entry = iterator.next();
            if(entry.getKey().longValue()==clientId)
                orderMap.remove(clientId);
        }
    }

}

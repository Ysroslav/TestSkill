package ru.bodrov.enterprise.TryForStaff.model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

//@MappedSuperclass
public class AbstractEnt {

    //@Id
    protected String id = UUID.randomUUID().toString();

    public String getId(){return id;}

    public void setId(String id){this.id = id;}
}

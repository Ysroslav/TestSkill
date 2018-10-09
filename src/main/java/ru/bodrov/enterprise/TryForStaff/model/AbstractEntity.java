package ru.bodrov.enterprise.TryForStaff.model;

import java.util.UUID;

public class AbstractEntity {
    
    protected String id = UUID.randomUUID().toString();

    public String getId(){return id;}

    public void setId(String id){this.id = id;}
}

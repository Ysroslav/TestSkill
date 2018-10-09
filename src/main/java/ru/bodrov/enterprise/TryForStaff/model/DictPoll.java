package ru.bodrov.enterprise.TryForStaff.model;

import org.springframework.stereotype.Component;

public class DictPoll extends AbstractEntity {

    private String nameType;

    public DictPoll(String nameType){
        this.nameType = nameType;
    }

    public String getNameType(){
        return  nameType;
    }

    public void setNameType(String nameType){
        this.nameType = nameType;
    }
}

package ru.bodrov.enterprise.TryForStaff.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("poll")
public class Poll extends AbstractEntity {

    @Autowired
    private DictPoll dictPoll;

    @Value("Main Test")
    private String testName;

    private Date dateCreateTest;

    @Value("80")
    private int minValueBall;

    @Value("30")
    private int timeTest;

    @Value("${dictPoll.nameType}")
    private String type;

    public String getTestName(){
        return testName;
    }

    public Date getDateCreateTest(){
        return dateCreateTest;
    }

    public int getMinValueBall(){
        return minValueBall;
    }

    public int getTimeTest(){
        return timeTest;
    }

    public String getType(){
        return type;
    }

    public void setTestName(String testName){
        this.testName = testName;
    }

    public void setDateCreateTest(Date dateCreateTest){
        this.dateCreateTest = dateCreateTest;
    }

    public void setMinValueBall(int minValueBall){
        this.minValueBall = minValueBall;
    }

    public void setTimeTest(int timeTest){
        this.timeTest = timeTest;
    }

    public void setType(String type){
        this.type = type;
    }
}

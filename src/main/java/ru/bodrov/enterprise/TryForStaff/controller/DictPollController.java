package ru.bodrov.enterprise.TryForStaff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.bodrov.enterprise.TryForStaff.model.Department;
import ru.bodrov.enterprise.TryForStaff.repository.DepartmentRepository;
import ru.bodrov.enterprise.TryForStaff.repository.DictPollRepository;

import java.util.Map;

public class DictPollController {

    @Autowired
    private DictPollRepository dictPollRepository;

    @RequestMapping(value={"/poll-list"}, method = RequestMethod.GET)
    public String departmentList(Map<String, Object> model){
        model.put("polls", dictPollRepository.getListPoll());
        return "poll-list";
    }

}

package ru.bodrov.enterprise.TryForStaff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.bodrov.enterprise.TryForStaff.model.Department;
import ru.bodrov.enterprise.TryForStaff.model.Staff;
import ru.bodrov.enterprise.TryForStaff.repository.DepartmentRepository;
import ru.bodrov.enterprise.TryForStaff.repository.StaffRepository;

import java.sql.Date;
import java.util.Map;

@Controller
public class StaffController {

    @Autowired
    private StaffRepository staffRepository;

    @RequestMapping(value={"/staff-list"}, method = RequestMethod.GET)
    public String staffList(Map<String, Object> model){
        model.put("staffs", staffRepository.getListStaff());
        return "staff-list";
    }

    @RequestMapping(value = {"/staff-create"}, method = RequestMethod.GET)
    public String staffCreate(){
        staffRepository.merge(new Staff("Name", "Family",  new Date(new java.util.Date().getTime()), new Department("New depart")));
        return "redirect:/staff-list";
    }

    @RequestMapping(value = {"/staff-remove"}, method = RequestMethod.GET)
    public String staffRemove(@RequestParam("id") String staffId){
        staffRepository.removeStaffById(staffId);
        return "redirect:/staff-list";
    }

    @RequestMapping(value={"/staff-edit"}, method =RequestMethod.GET)
    public String staffEdit(@RequestParam("id") String staffId, Map<String, Object> model){
        final Staff staff = staffRepository.findOne(staffId);
        model.put("staff", staff);
        return "staff-edit";
    }

    @RequestMapping(value={"/staff-save"}, method =RequestMethod.POST)
    public String staffSave(@ModelAttribute("staff") Staff staff){
        staffRepository.merge(staff);
        return "redirect:/staff-list";
    }
}

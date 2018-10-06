package ru.bodrov.enterprise.TryForStaff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.bodrov.enterprise.TryForStaff.model.Department;
import ru.bodrov.enterprise.TryForStaff.repository.DepartmentRepository;

import java.util.Map;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

   @RequestMapping(value={"/department-list"}, method = RequestMethod.GET)
    public String departmentList(Map<String, Object> model){
       model.put("departments", departmentRepository.getListDepartment());
       return "department-list";
   }

   @RequestMapping(value = {"/department-create"}, method = RequestMethod.GET)
    public String departmentCreate(){
       departmentRepository.merge(new Department("New department"));
       return "redirect:/department-list";
   }

   @RequestMapping(value = {"/department-remove"}, method = RequestMethod.GET)
    public String departmentRemove(@RequestParam("id") String departmentId){
       departmentRepository.removeDepartmentById(departmentId);
       return "redirect:/department-list";
   }

   @RequestMapping(value={"/department-edit"}, method = RequestMethod.GET)
   public String departmentEdit(@RequestParam("id") String departmentId, Map<String, Object> model){
       final Department department = departmentRepository.findOne(departmentId);
       model.put("department", department);
       return "department-edit";
   }

    @RequestMapping(value={"/department-save"}, method =RequestMethod.POST)
    public String departmentSave(@ModelAttribute("department") Department department){
        departmentRepository.merge(department);
        return "redirect:/department-list";
    }
}

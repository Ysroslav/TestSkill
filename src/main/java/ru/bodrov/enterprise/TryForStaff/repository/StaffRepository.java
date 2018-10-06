package ru.bodrov.enterprise.TryForStaff.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import ru.bodrov.enterprise.TryForStaff.model.Department;
import ru.bodrov.enterprise.TryForStaff.model.Staff;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Repository
@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
public class StaffRepository {

    private Map<String, Staff> staffs = new LinkedHashMap<>();

    @PostConstruct
    private void init(){
        merge(new Staff("Иван", "Иванов", new Date(new java.util.Date().getTime()), new Department("IT")));
        merge(new Staff("Петр", "Петров", new Date(new java.util.Date().getTime()), new Department("HR")));
        merge(new Staff("Иван", "Сидоров", new Date(new java.util.Date().getTime()), new Department("GR")));
    }

    @NotNull
    public Collection<Staff> getListStaff(){
        return staffs.values();
    }


    public void merge(@Nullable final Staff staff){
        if(staff==null) return;
        if(staff.getId()==null||staff.getId().isEmpty()) return;
        staffs.put(staff.getId(), staff);
    }

    public Staff findOne(@Nullable final String staffId){
        if(staffId==null||staffId.isEmpty()) return null;
        return staffs.get(staffId);
    }

    public void removeStaffById(@Nullable final String staffId){
        if(staffId==null||staffId.isEmpty()) return;
        staffs.remove(staffId);
    }
}

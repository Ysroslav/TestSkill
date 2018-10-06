package ru.bodrov.enterprise.TryForStaff.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import ru.bodrov.enterprise.TryForStaff.model.Department;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Repository
@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DepartmentRepository {

    private Map<String, Department> departments = new LinkedHashMap<>();

    @PostConstruct
    private void init(){
        merge(new Department("IT"));
        merge(new Department("HR"));
        merge(new Department("GR"));
    }

    @NotNull
    public Collection<Department> getListDepartment(){
        return departments.values();
    }


    public void merge(@Nullable final Department department){
        if(department==null) return;
        if(department.getId()==null||department.getId().isEmpty()) return;
        departments.put(department.getId(), department);
    }

    public Department findOne(@Nullable final String departmentId){
        if(departmentId==null||departmentId.isEmpty()) return null;
        return departments.get(departmentId);
    }

    public void removeDepartmentById(@Nullable final String departmentId){
        if(departmentId==null||departmentId.isEmpty()) return;
        departments.remove(departmentId);
    }
}

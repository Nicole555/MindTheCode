package com.mindthecode.CompanyDirectory.services;

import com.mindthecode.CompanyDirectory.mappers.DepartmentMapper;
import com.mindthecode.CompanyDirectory.models.entities.Department;
import com.mindthecode.CompanyDirectory.models.responses.*;
import com.mindthecode.CompanyDirectory.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private DepartmentMapper mapper;

    public DepartmentService(DepartmentMapper mapper, DepartmentRepository departmentRepository) {

    }

    public GenericResponse<AllDepartmentsResponse> getAllDepartments() {
        List<DepartmentResponse> departments = mapper.mapDepartments(repository.findAll());
        if (departments == null || departments.size() > 0)
            return new GenericResponse<>(new AllDepartmentsResponse(departments));

        return new GenericResponse<>(new ErrorResponse(0, "Error", "No departments were found"));
    }

    public GenericResponse<AllDepartmentsResponse> getDepartmentById(long id) {
        Iterable<Department> retrievedDepartments = repository.findAll();
        for (Department department : retrievedDepartments) {
            if (department.getId() == id) {
                List<DepartmentResponse> list = new ArrayList<>();
                list.add(mapper.mapDepartmentToDepartmentResponse(department));
                return new GenericResponse<>(new AllDepartmentsResponse(list));
            }
        }
        return new GenericResponse<>(new ErrorResponse(0, "Unknown department", "No department found with id " + id));
    }

    public GenericResponse<String> saveDepartment(Department department) {
        try {
            repository.save(department);
            return new GenericResponse<>("Saved department #" + department.getId());
        } catch (Exception ex) {
            ex.printStackTrace();
            return new GenericResponse<>(new ErrorResponse(0, "Error", "Could not save department #" + department.getId()));
        }
    }

    public GenericResponse<String> saveDepartments(Iterable<Department> departments) {
        try {
            repository.saveAll(departments);
            return new GenericResponse<>("Saved departments");
        } catch (Exception ex) {
            ex.printStackTrace();
            return new GenericResponse<>(new ErrorResponse(0, "Error", "Could not save departments"));
        }
    }

    public GenericResponse<String> deleteDepartment(Department department) {
        try {
            repository.delete(department);
            return new GenericResponse<>("Deleted department #" + department.getId());
        } catch (Exception ex) {
            ex.printStackTrace();
            return new GenericResponse<>(new ErrorResponse(0, "Error", "Could not delete the department"));
        }
    }

    public GenericResponse<String> deleteDepartments(Iterable<Department> departments) {
        try {
            repository.deleteAll(departments);
            return new GenericResponse<>("Deleted departments");
        } catch (Exception ex) {
            ex.printStackTrace();
            return new GenericResponse<>(new ErrorResponse(0, "Error", "Could not delete departments"));
        }
    }

    public GenericResponse<String> deleteAllDepartments() {
        try {
            repository.deleteAll();
            return new GenericResponse<>("Deleted all departments");
        } catch (Exception ex) {
            ex.printStackTrace();
            return new GenericResponse<>(new ErrorResponse(0, "Error", "Could not delete all departments"));
        }
    }


}

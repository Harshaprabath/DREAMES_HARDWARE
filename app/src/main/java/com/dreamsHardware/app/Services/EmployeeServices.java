package com.dreamsHardware.app.Services;

import com.dreamsHardware.app.Exceptions.ResourceNotFoundException;
import com.dreamsHardware.app.Models.Employee;
import com.dreamsHardware.app.Repositories.EmployeeRepositery;
import com.dreamsHardware.app.ViewModel.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeServices {

    @Autowired
    private EmployeeRepositery employeeRepositery;

    public List<Employee> findAll() {

        List<Employee> employees = (List<Employee>) employeeRepositery.findAll();

        List<Employee> activeEmp = new ArrayList<>();
        for(int i=0;i<employees.size();i++){

            Employee employee = employees.get(i);

            if (employee.isWork()) {
                activeEmp.add(employee);
            }
        }
        return activeEmp;
    }

    public Employee findById(Integer empId) {

        Employee employee = employeeRepositery.findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", empId));
        return employee;

    }


    public Response saveEmp(Employee NewEmployee) {

        Response response = new Response();

        if(NewEmployee.getId() == null) {

            NewEmployee.setWork(true);
            employeeRepositery.save(NewEmployee);
            response.isSuccess = true;
            response.message = "Successfully Saved";
        }
        else if(NewEmployee.getId() != null){

            NewEmployee.setWork(true);
            employeeRepositery.save(NewEmployee);
            response.isSuccess = true;
            response.message = "Successfully Update";
        }
        else{
            response.isSuccess = false;
            response.message = "Unsuccessfully";
        }

        return response;
    }


    public Response deleteEmp(Integer EmpId) {

        Response response = new Response();
        Employee employee = employeeRepositery.findById(EmpId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", EmpId));

        if(employee != null) {
            employee.setWork(false);
            employeeRepositery.save(employee);

            response.isSuccess = true;
            response.message = "Successfully deleted";
        }
        else{
            response.isSuccess = false;
            response.message = "Unsuccessfully";
        }
        return response;
    }

    public List<Employee> empSearch(String name){

        boolean iswork = true;
        return employeeRepositery.empSearch(name,iswork);

    }


}

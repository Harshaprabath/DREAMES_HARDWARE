package com.dreamsHardware.app.Controllers;

import com.dreamsHardware.app.Services.EmployeeServices;
import com.dreamsHardware.app.Models.Employee;

import com.dreamsHardware.app.ViewModel.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping("/all")
    public List<Employee> findAllEmpS() {

        return employeeServices.findAll();

    }

    @GetMapping("/find/{id}")
    public Employee getEmpById(@PathVariable(value = "id") Integer empId) {
        return employeeServices.findById(empId);

    }

    @PostMapping("/save")
    public Response saveEmp(@Valid @RequestBody Employee employee) {

        return employeeServices.saveEmp(employee);

    }

    @DeleteMapping("/delete/{id}")
    public Response deleteEmp(@PathVariable(value = "id") Integer empId) {

        return employeeServices.deleteEmp(empId);

    }

    @GetMapping("/search/{name}")
    public List<Employee> Search (@PathVariable(value = "name") String name) {

        return employeeServices.empSearch(name);

    }
}

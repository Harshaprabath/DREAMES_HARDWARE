package com.dreamsHardware.app.Repositories;


import com.dreamsHardware.app.Models.Employee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepositery extends CrudRepository<Employee, Integer> {

    //search query
    @Query(value = "SELECT * FROM employee e WHERE e.name LIKE ?1% and e.work = ?2",nativeQuery = true)
    List<Employee> empSearch(String Name, boolean iswork);
}

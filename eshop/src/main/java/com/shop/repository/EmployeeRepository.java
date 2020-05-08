package com.shop.repository;

import com.shop.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

   @Query(value = "select * from Employee p  where  p.email_id=:email_id",nativeQuery = true)
   public Employee findByEmailId(@Param("email_id") String email_id);












}

package com.shop.controllers;

import com.shop.exception.ResourceNotFoundException;
import com.shop.model.Employee;
import com.shop.repository.EmployeeRepository;
import com.shop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/api/authentication/{username}/{password}")
    public ResponseEntity<?> authentication(@PathVariable String username, @PathVariable String password) {
        System.out.println("username: "+ username +" - password="+ password);

//        Employee employee=employeeRepository.findByEmailId(username);
        //System.out.println("username="+employee);
        Employee user = employeeRepository.findByEmailId(username);

        return ResponseEntity.ok(user);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(employee);
    }



    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }


    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                   @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employee.setEmailId(employeeDetails.getEmailId());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setPassword(employeeDetails.getPassword());
        employee.setRole(employeeDetails.getRole());

        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }





  /*  @Autowired
    private EmployeeService employeeService;
    private Object Employee;*/

//    @GetMapping("/employees")
//    public List<Employee> getAllEmployees() {
//     //  List<Employee> user = employeeRepository.findByEmailId("shaheryarnadeem@live.com");
//        return employeeRepository.findAll();
//    }

    //  @GetMapping("/employees/{employee}")
//        public ResponseEntity< Employee> getEmployeeByEmailId(@PathVariable(value = "employee") String employee)
//        throws ResourceNotFoundException{
//        Employee employee1 = employeeRepository.findByEmailId(employee)
//  }

      //  public List<Employee> getAllEmployees(@PathVariable String employee) {
     //   List<Employee> user = employeeRepository.findByEmailId("shaheryarnadeem@live.com");
     //   return employeeRepository.findAll();
   // }

//         public List<Employee> getLogin(){
//
//        String employee = "";
//        List<Employee> empLogin =employeeRepository.findByEmailId(employee);
//        return empLogin;
 //   }



/*
    @RequestMapping(value = "/employee" , method = RequestMethod.POST,consumes ="application/json" )
    public String addChat(@Valid @RequestBody Employee employee){
        try {
            employeeService.saveemployee(employee);

        }catch (Exception ex){
            //   response = new RestResponse(StatusCode.GENERIC_FAILED, false, env.getProperty(PropertyUtil.PROJECT_ERROR_MSG));
            ex.printStackTrace();
        }

        return "success";
    }
*/

}

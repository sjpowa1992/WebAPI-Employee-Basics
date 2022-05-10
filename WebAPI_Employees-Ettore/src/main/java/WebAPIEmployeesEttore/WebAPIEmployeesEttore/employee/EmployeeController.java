package WebAPIEmployeesEttore.WebAPIEmployeesEttore.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping(path = "/employees")
	public List<Employee> retrieveAllEmployees() {
		return employeeRepository.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public Optional<Employee> retrieveEmployee(@PathVariable int id) {
		return employeeRepository.findById(id);
	}
	
	@PostMapping("/employees/create-employee")
	public void createEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
	}
	
	@DeleteMapping("/employees/delete/{id}")
	public void deleteEmployee(@PathVariable int id) {
		employeeRepository.deleteById(id);
	}
	
	@PutMapping("/employees/modify-employee/{id}")
	public Employee replaceEmployee(@PathVariable int id, @RequestBody Employee newEmployee) {
	    return employeeRepository.findById(id)
	      .map(employee -> {
	        employee.setFirstName(newEmployee.getFirstName());
	        employee.setLastName(newEmployee.getLastName());
	        employee.setEmail(newEmployee.getEmail());
	        return employeeRepository.save(employee);
	      })
	      .orElseGet(() -> {
	        newEmployee.setId(id);
	        return employeeRepository.save(newEmployee);
	      });
	}
	
}

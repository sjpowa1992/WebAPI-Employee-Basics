package WebAPIEmployeesEttore.WebAPIEmployeesEttore.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name="Employee")
@Table(
		name="Dipendenti",
		uniqueConstraints = {
			@UniqueConstraint(name="unique_email", columnNames = "email")
		})
public class Employee {

	@Id
	@GeneratedValue
	@Column(name="Employee_ID")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;

	// EMPTY CTOR
	public Employee() {
		
	}
	
	// CTOR
	public Employee(String firstName,
					String lastName,
					String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	// GETTERS and SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// toString METHOD
	@Override
	public String toString() {
		return "Employee [id=" + id 
				+ ", firstName=" + firstName 
				+ ", lastName=" + lastName 
				+ ", email=" + email + "]";
	}
	
}

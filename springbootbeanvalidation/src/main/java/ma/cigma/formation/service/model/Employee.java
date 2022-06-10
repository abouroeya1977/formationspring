package ma.cigma.formation.service.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee implements Serializable {
	private static final long serialVersionUID = 5448552240001397099L;
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	private Double salary;
	private String email;
}

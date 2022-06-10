package ma.cigm.springmvcrestdatajpa.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Value Object (VO) <==> DTO : Data Transfer Object
//POJO : Plain Old Java Object
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpVo {
	private Long id;
	private String name;
	private Double salary;
	private String fonction;
	public EmpVo(String name, Double salary, String fonction) {
		super();
		this.name = name;
		this.salary = salary;
		this.fonction = fonction;
	}

}
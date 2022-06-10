package ma.cigm.springmvcrestdatajpa.service.modele;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Emp implements Serializable {
	@GeneratedValue
	@Id
	@Column(name = "IDENTIFIANT")
	private Long id;

	@Column(name = "NAME",unique=true,length=30)
	private String firstName;

	private Double salaire;

	private String fonction;
	
	@Transient
	private Date dateAnniversaire;

	public Emp(String name, Double salary, String fonction) {
		this.firstName = name;
		this.salaire = salary;
		this.fonction = fonction;
	}

}
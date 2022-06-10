package ma.cigm.springmvcrestdatajpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ma.cigm.springmvcrestdatajpa.service.modele.Emp;

/**
 * 
 * Ici, l'interface EmpRepository hérite de l'interface JpaRepository de Spring
 * DATA. Il faut juste préciser la classe "Modele" et le type de la classe qui
 * représente la clé primaire.
 * 
 * Spring Data prendra en charge l'implémentation des 04 méthode ci-dessous à
 * condition de réspecter la nomenclature supportée par Spring Data.
 * 
 * @Query offre la possinbilité d'exécuter des requêtes plus complexes.
 *
 */
//@Repository
public interface EmpRepository extends JpaRepository<Emp, Long> {
	//select * from Employe wehre salary=10000
	List<Emp> findBySalaire(Double salary);

	List<Emp> findByFonction(String designation);

	List<Emp> findBySalaireAndFonction(Double salary, String fonction);
	
	List<Emp> findByFirstName(String name);


	// Il s'agit ici du langage JPQL : JPA Query Language  <==> HQL (Hibernate Query Language)
	@Query(" SELECT e From Emp e where e.salaire=(select MAX(salaire) as salaire FROM Emp)")
	Emp getEmpHavaingMaxSalary();
}

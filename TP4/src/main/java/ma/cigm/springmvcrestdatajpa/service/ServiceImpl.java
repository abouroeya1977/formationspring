package ma.cigm.springmvcrestdatajpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.cigm.springmvcrestdatajpa.dao.EmpRepository;
import ma.cigm.springmvcrestdatajpa.domaine.EmpConverter;
import ma.cigm.springmvcrestdatajpa.domaine.EmpVo;
import ma.cigm.springmvcrestdatajpa.service.modele.Emp;


/**
 * 
 * @Transactional implémente l'AOP (Aspect Oriented Programming)
 * Permet de séparer les traitements techniques de la couche métier.
 *
 */
@Service


public class ServiceImpl implements IService {
	@Autowired
	private EmpRepository empRepository;
	
	@Override
	public List<EmpVo> findEmployeesByName(String name) {
		List<Emp> list = empRepository.findByFirstName(name);
		return EmpConverter.toListVo(list);
	}
	
	

	@Override
	public List<EmpVo> getEmployees() {
		List<Emp> list = empRepository.findAll();
		return EmpConverter.toListVo(list);
	}
	@Transactional
	@Override
	public void save(EmpVo vo) {
		empRepository.save(EmpConverter.toBo(vo));
	}

	@Override
	public EmpVo getEmpById(Long id) {
		boolean trouve = empRepository.existsById(id);
		if (!trouve)
			return null;
		return EmpConverter.toVo(empRepository.getOne(id));
	}
	@Transactional
	@Override
	public void delete(Long id) {
		empRepository.deleteById(id);
	}

	@Override
	public List<EmpVo> findBySalary(Double salaty) {
		List<Emp> list = empRepository.findBySalaire(salaty);
		return EmpConverter.toListVo(list);
	}

	@Override
	public List<EmpVo> findByFonction(String fonction) {
		List<Emp> list = empRepository.findByFonction(fonction);
		return EmpConverter.toListVo(list);
	}

	@Override
	public List<EmpVo> findBySalaryAndFonction(Double salary, String fonction) {
		List<Emp> list = empRepository.findBySalaireAndFonction(salary, fonction);
		return EmpConverter.toListVo(list);
	}

	@Override
	public EmpVo getEmpHavaingMaxSalary() {
		return EmpConverter.toVo(empRepository.getEmpHavaingMaxSalary());
	}

	@Override
	public List<EmpVo> findAll(int pageId, int size) {
//	Page<Emp> result = empRepository.findAll(PageRequest.of(pageId, size, Direction.DESC, "salaire","firstName"));
//		Page<Emp> result = empRepository.findAll(PageRequest.of(pageId, size));
//		Page<Emp> result = empRepository.findAll(PageRequest.of(pageId, size,Direction.ASC,"salaire","fonction","id"));
	Page<Emp> result = empRepository.findAll(PageRequest.of(pageId, size,Sort.by("salaire")));
		return EmpConverter.toListVo(result.getContent());
	}

	@Override
	public List<EmpVo> sortBy(String... fieldNames) {
		return EmpConverter.toListVo(empRepository.findAll(Sort.by(fieldNames)));
	}
	
//	@Override
//	public List<EmpVo> sortBy2(String fieldName1,String fieldName2) {
//		return EmpConverter.toListVo(empRepository.findAll(Sort.by(fieldName1,fieldName2)));
//	}

	/**
	 * Spring Boot lance cette méthode une fois l'application est démarré.
	 */
	@Transactional
	@Override
	public void deleteAll() {
		empRepository.deleteAll();
	}
	
}

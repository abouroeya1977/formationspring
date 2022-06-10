package ma.cigm.springmvcrestdatajpa.domaine;

import java.util.ArrayList;
import java.util.List;
import ma.cigm.springmvcrestdatajpa.service.modele.Emp;

/**
 * 
 * Créer le pont VO <=> BO
 * DTO : Data Transfer Object
 *
 */
public class EmpConverter {
	//BO : Business Object
	//VO : Value Object
	public static EmpVo toVo(Emp bo) {
		if (bo == null || bo.getId() ==null)
			return null;
		EmpVo vo = new EmpVo();
		vo.setId(bo.getId());
		vo.setName(bo.getFirstName());
		vo.setSalary(bo.getSalaire());
		vo.setFonction(bo.getFonction());
		return vo;
	}
	public static Emp toBo(EmpVo vo) {
		Emp bo = new Emp();
		bo.setId(vo.getId());
		bo.setFirstName(vo.getName());
		bo.setSalaire(vo.getSalary());
		bo.setFonction(vo.getFonction());
		return bo;
	}
	public static List<EmpVo> toListVo(List<Emp> listBo) {
		List<EmpVo> listVo = new ArrayList<>();
		for (Emp emp : listBo) {
			listVo.add(toVo(emp));
		}
		return listVo;
	}
}

package ma.cigma.springsecurity.presentation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ma.cigma.springsecurity.aop.Admin1Profile;
import ma.cigma.springsecurity.aop.LogExecutionTime;
import ma.cigma.springsecurity.aop.Tracabilite;
import ma.cigma.springsecurity.domaine.EmpVo;
import ma.cigma.springsecurity.service.IEmpService;
import ma.cigma.springsecurity.service.exception.BusinessException;

@Controller
@RequestMapping("/admin/emp")
@ControllerAdvice

public class EmpController {

	@Autowired
	private IEmpService service;

	@ExceptionHandler(value = BusinessException.class)
	public String exception(Model m) {
		m.addAttribute("excep", true);
		List<EmpVo> list = service.getEmployees();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		m.addAttribute("userName", "Welcome " + auth.getName());
		m.addAttribute("list", list);
		return "/admin/emp/list";
	}

	@RequestMapping("/form")
	@Tracabilite
	public String showform(Model m) {
		m.addAttribute("empVo", new EmpVo());
		return "/admin/emp/edit";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@LogExecutionTime
	@Tracabilite
	public String save(@ModelAttribute("empVo") EmpVo emp) {
		//le code source de l'aspet sera intégré ici.
//		long start = System.currentTimeMillis();
		service.save(emp);
//		long duree = System.currentTimeMillis() - start;
		
		return "redirect:/admin/emp/list";
	}

	@RequestMapping("/list")
	@LogExecutionTime
	@Tracabilite
	public String viewemp(Model m) {
		List<EmpVo> list = service.getEmployees();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		m.addAttribute("userName", "Welcome " + auth.getName());
		m.addAttribute("list", list);
		return "/admin/emp/list";
	}

	@RequestMapping(value = "/edit/{id}")
	@Tracabilite
	public String edit(@PathVariable Long id, Model m) {
		EmpVo emp = service.getEmpById(id);
		m.addAttribute("empVo", emp);
		return "/admin/emp/edit";
	}
	@Tracabilite
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("empVo") EmpVo emp) {
		service.save(emp);
		return "redirect:/admin/emp/view";
	}
	@Tracabilite
	@Admin1Profile(noms= {"admin1","admin2"})
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id) {
		service.delete(id);
		return "redirect:/admin/emp/list";
	}

	@RequestMapping("/emp/salary/{salary}")
	public String getBySalary(@PathVariable Double salary, Model m) {
		List<EmpVo> list = service.findBySalary(salary);
		m.addAttribute("list", list);
		return "/admin/emp/list";
	}

	/**
	 * Chercher la liste des employés ayant la même fonction
	 */
	@RequestMapping("/emp/fonction/{fonction}")
	public String getByFonction(@PathVariable String fonction, Model m) {
		List<EmpVo> list = service.findByFonction(fonction);
		m.addAttribute("list", list);
		return "/admin/emp/list";
	}

	/**
	 * Chercher la liste des employés ayant le même salaire et la même fonction
	 */
	@RequestMapping("/emp/salary_and_fonction/{salary}/{fonction}")
	public String getBySalaryAndFonction(@PathVariable Double salary, @PathVariable String fonction, Model m) {
		List<EmpVo> list = service.findBySalaryAndFonction(salary, fonction);
		m.addAttribute("list", list);
		return "/admin/emp/list";
	}

	/**
	 * Chercher l'employé qui le grand salaire
	 */
	@RequestMapping("/max_salary")
	public String getMaxSalary(Model m) {
		EmpVo empVo = service.getEmpHavaingMaxSalary();
		List<EmpVo> list = new ArrayList<>();
		list.add(empVo);
		m.addAttribute("list", list);
		return "/admin/emp/view";
	}

	/**
	 * Afficher la liste des employés en utilisant la pagination
	 */
	@RequestMapping("/pagination/{pageid}/{size}")
	public String pagination(@PathVariable int pageid, @PathVariable int size, Model m) {
		List<EmpVo> list = service.findAll(pageid, size);
		m.addAttribute("list", list);
		return "/admin/emp/view";
	}

	/**
	 * Trier les employés par le nom de champs qu'on passe dans l'URL
	 */
	@RequestMapping("/sort/{fieldName}")
	public String sortBy(@PathVariable String fieldName, Model m) {
		List<EmpVo> list = service.sortBy(fieldName);
		m.addAttribute("list", list);
		return "/admin/emp/view";
	}
}
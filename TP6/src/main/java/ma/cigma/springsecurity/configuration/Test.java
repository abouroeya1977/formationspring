package ma.cigma.springsecurity.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import ma.cigma.springsecurity.domaine.RoleVo;

public class Test {
public static void main(String[] args) {
	List<RoleVo> roles =new ArrayList<RoleVo>();
	roles.add(new RoleVo("dd"));
	roles.add(new RoleVo("ss"));
	List<String> liste=new ArrayList<>();
	
	Supplier<String[]> s=() -> {
		roles.forEach(r -> liste.add(r.getRole()));
		return liste.toArray(new String[liste.size()]);
	};
	
	t(s.get());
}

public static void t(String... e) {
	for(String a:e) {
		System.out.println(a);
	}
	
}
private String[] toTab(List<RoleVo> roles) {
	String[] tab = new String[roles.size()];
	int i = 0;
	for (RoleVo roleVo : roles) {
		tab[i] = roleVo.getRole();
		i++;
	}
	return tab;
}

}

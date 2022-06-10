package ma.cigma.springsecurity.configuration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import ma.cigma.springsecurity.domaine.MyActionVo;
import ma.cigma.springsecurity.domaine.RoleVo;
import ma.cigma.springsecurity.domaine.UserVo;
import ma.cigma.springsecurity.service.IMyActionService;
import ma.cigma.springsecurity.service.IUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter implements CommandLineRunner {

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private IUserService userService;

	@Autowired
	private IMyActionService actionService;

	@Override
	// L'authentification
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
//		 auth.inMemoryAuthentication().withUser("admin1").password("admin1").roles("ADMIN");
//		 auth.inMemoryAuthentication().withUser("client1").password("client1").roles("CLIENT");
//		 auth.inMemoryAuthentication().withUser("super").password("super").roles("SUPER_ADMIN");
	}

	@Override
	// L'authorisation
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/").permitAll();// http://localhost:7777/ sera accessible par tt le monde.
		http.authorizeRequests().antMatchers("/login").permitAll();// http://localhost:7777/login sera accessible par tt
																	// le monde.
//
//		List<MyActionVo> list = actionService.getAll();
//		for (MyActionVo vo : list) {
//			http.authorizeRequests().antMatchers(vo.getAction()).hasAnyAuthority(toTab(vo.getRoles()));
//
		http.authorizeRequests().antMatchers("/welcome").hasAnyAuthority("ADMIN", "CLIENT");
		http.authorizeRequests().antMatchers("/admin/**").hasAuthority("ADMIN");
		http.authorizeRequests().antMatchers("/client/**").hasAuthority("CLIENT");
		http.authorizeRequests().anyRequest().authenticated();

		// CROSS SITE REQUEST FORGERY
		// La falsification des requêtes inter sites.
		http.csrf().disable();

		http.formLogin().loginPage("/login");
		http.formLogin().failureUrl("/login?error=true");
		http.formLogin().defaultSuccessUrl("/welcome");
		http.formLogin().usernameParameter("username");
		http.formLogin().passwordParameter("password");
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		http.logout().logoutSuccessUrl("/");
		http.exceptionHandling().accessDeniedPage("/access-denied");

	}

	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

//	private String[] toTab(List<RoleVo> roles) {
//		String[] tab = new String[roles.size()];
//		int i = 0;
//		for (RoleVo roleVo : roles) {
//			tab[i] = roleVo.getRole();
//			i++;
//		}
//		return tab;
//	}

	@Override
	public void run(String... args) throws Exception {
//		boolean enabled = true;
//		boolean accountNonExpired = true;
//		boolean credentialsNonExpired = true;
//		boolean accountNonLocked = true;
//
//		userService.cleanDataBase();
//		userService.save(new RoleVo("ADMIN"));
//		userService.save(new RoleVo("CLIENT"));
//		userService.save(new RoleVo("SUPER_ADMIN"));
//
//		RoleVo roleAdmin = userService.getRoleByName("ADMIN");
//		RoleVo roleClient = userService.getRoleByName("CLIENT");
//		RoleVo superadmin = userService.getRoleByName("SUPER_ADMIN");
//
//		UserVo admin1 = new UserVo("admin1", "admin1", Arrays.asList(roleAdmin), enabled, accountNonExpired,
//				credentialsNonExpired, accountNonLocked);
//		UserVo client1 = new UserVo("client1", "client1", Arrays.asList(roleClient), enabled, accountNonExpired,
//				credentialsNonExpired, accountNonLocked);
//		UserVo admin2 = new UserVo("admin2", "admin2", Arrays.asList(roleAdmin), enabled, accountNonExpired,
//				credentialsNonExpired, accountNonLocked);
//
//		userService.save(admin1);
//		userService.save(client1);
//		userService.save(admin2);
//
//		MyActionVo adminAction = new MyActionVo("/admin/**", Arrays.asList(roleAdmin, superadmin));
//		MyActionVo clientAction = new MyActionVo("/client/**", Arrays.asList(roleClient, superadmin));
//		actionService.save(adminAction);
//		actionService.save(clientAction);
	}

}

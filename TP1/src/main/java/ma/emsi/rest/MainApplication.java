package ma.emsi.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @SpringBootApplication scanne le classpath, détecte les déppendance puis
 *                        effectue automatiquement toutes les configurations
 *                        nécessaires.
 */


@SpringBootApplication
public class MainApplication  {
//	@Autowired
//	private ApplicationContext appContext;

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("nombre de beans + " + appContext.getBeanDefinitionCount());
//		System.out.println("************************************************************");
//		String[] beans = appContext.getBeanDefinitionNames();
//		Arrays.sort(beans);
//		for (String bean : beans) {
//			System.out.println(bean);
//		}
//
//	}
}

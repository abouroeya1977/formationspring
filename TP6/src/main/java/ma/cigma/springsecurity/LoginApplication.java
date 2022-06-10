package ma.cigma.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LoginApplication implements CommandLineRunner {
	// Pour que le bean BCryptPasswordEncoder soit injectable
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	PasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// String password = "Passw@rd";
		//
		// for (int i = 0; i < 10; i++) {
		// String motdepassCrtypte = bCryptPasswordEncoder.encode(password);
		// System.out.println(motdepassCrtypte);
		// }

	}

}

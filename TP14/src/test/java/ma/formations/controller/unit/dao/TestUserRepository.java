package ma.formations.controller.unit.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ma.formations.dao.UserRepository;
import ma.formations.service.EmpServiceImpl;
import ma.formations.service.UserServiceImpl;
import ma.formations.service.model.Role;
import ma.formations.service.model.User;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Import(value= {UserServiceImpl.class,BCryptPasswordEncoder.class,EmpServiceImpl.class})

public class TestUserRepository {
	@Autowired
	UserRepository userRepository;
	
	static User userTest = new User();

	@BeforeAll
	static void init() {
		userTest.setUsername("test123");
		userTest.setPassword("P@sw@rd");
		userTest.setRoles(Arrays.asList(new Role("ADMIN")));
	}
	
	@BeforeEach
	void save() {
		userRepository.save(userTest);
	}

	@Test
	void testfindByUsername() {
		assertNotNull(userRepository.findByUsername(userTest.getUsername()));
		assertThat((userRepository.findByUsername(userTest.getUsername())).getUsername()).isEqualTo(userTest.getUsername());
		assertThat((userRepository.findByUsername(userTest.getUsername())).getPassword()).isEqualTo(userTest.getPassword());
		
	}
	@Test
	void testexistsByUsername() {
		assertThat(userRepository.existsByUsername(userTest.getUsername())).isTrue();
	}
	
	@Test
	void testDoesntexistsByUsername() {
		assertThat(userRepository.existsByUsername("wrong name")).isFalse();
	}

}

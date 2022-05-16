package com.das;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.das.repository.RolRepoJPA;
import com.das.repository.entity.Rol;

@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest
public class CheckearEntornoTest {
	
	private static Logger LOG = org.slf4j.LoggerFactory.getLogger(CheckearEntornoTest.class);
	
	@Autowired
	RolRepoJPA rolDAO;
	
	@Test
	void validarEntorno() {
		
		List<Rol> lr = rolDAO.findAll();
		LOG.info(" ========= ============ =========");
		LOG.info(" ========> " + lr.get(lr.size()-1).getRol() + " <========");		
		LOG.info(" ========= ============ =========");
	
		assertTrue ( lr.get(lr.size()-1).getRol().equals("ENTORNO TEST") );
	}	
}
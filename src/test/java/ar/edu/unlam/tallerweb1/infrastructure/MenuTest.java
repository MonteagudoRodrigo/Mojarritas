package ar.edu.unlam.tallerweb1.infrastructure;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.SpringTest;

public class MenuTest extends SpringTest {

	RepositorioMenuImpl repoMenu;
	
	@Test
	@Transactional @Rollback
	public void queSeGuardeUnaClaseMenu() {
		
		
	}

	
}

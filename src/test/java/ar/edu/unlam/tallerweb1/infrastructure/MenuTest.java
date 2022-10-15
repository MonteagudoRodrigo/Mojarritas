package ar.edu.unlam.tallerweb1.infrastructure;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.menu.Menu;

public class MenuTest extends SpringTest {

	RepositorioMenuImpl repoMenu;
	
	@Test
	@Transactional @Rollback
	public void queSeGuardeUnaClaseMenu() {
		Menu menu= new Menu();
		
	}

	
}

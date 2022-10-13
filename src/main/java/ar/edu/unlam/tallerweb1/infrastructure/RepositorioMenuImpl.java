package ar.edu.unlam.tallerweb1.infrastructure;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.domain.menu.RepositorioMenu;

@Repository("repositorioMenu")
public class RepositorioMenuImpl implements RepositorioMenu {
	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioMenuImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
    
    

}

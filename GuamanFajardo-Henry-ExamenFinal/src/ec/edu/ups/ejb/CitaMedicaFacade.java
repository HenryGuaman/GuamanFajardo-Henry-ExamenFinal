package ec.edu.ups.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.CitaMedica;

public class CitaMedicaFacade extends AbstractFacade<CitaMedica>{

	

	@PersistenceContext(unitName = "GuamanFajardo-Henry-ExamenFinal")
    private EntityManager em;

	public CitaMedicaFacade() {
		super(CitaMedica.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
		
}
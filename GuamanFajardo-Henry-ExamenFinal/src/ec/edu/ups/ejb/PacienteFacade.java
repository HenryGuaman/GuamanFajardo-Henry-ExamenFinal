package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.entidad.Paciente;
@Stateless
public class PacienteFacade extends AbstractFacade<Paciente>{

	

	@PersistenceContext(unitName = "GuamanFajardo-Henry-ExamenFinal")
    private EntityManager em;

	public PacienteFacade() {
		super(Paciente.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	
}

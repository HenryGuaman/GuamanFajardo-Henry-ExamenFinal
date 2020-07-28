package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.SignosVitales;
@Stateless
public class SignosVitalesFacade extends AbstractFacade<SignosVitales> {

	@PersistenceContext(unitName = "GuamanFajardo-Henry-ExamenFinal")
    private EntityManager em;
	
	public SignosVitalesFacade() {
		super(SignosVitales.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

	
}

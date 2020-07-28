package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.CitaMedicaFacade;
import ec.edu.ups.ejb.PacienteFacade;
import ec.edu.ups.ejb.SignosVitalesFacade;
import ec.edu.ups.entidad.CitaMedica;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class CitaMedicaBean implements Serializable{
	
	@EJB
	private CitaMedicaFacade ejbCitaMedicaFacade;
	private List<CitaMedica> list;
	@EJB
	private PacienteFacade ejbPacienteFacade;
	@EJB
	private SignosVitalesFacade ejbSignosVitalesFacade;
	
	private String sintomas;
	private String alergias;
	private String enfermedadesPrevias;
	private String fecha;
	private String hora;
	
	@PostConstruct
	public void init() {

		list = ejbCitaMedicaFacade.findAll();

	}

	public List<CitaMedica> getList() {
		return list;
	}

	public void setList(List<CitaMedica> list) {
		this.list = list;
	}

	
	
	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public String getAlergias() {
		return alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	public String getEnfermedadesPrevias() {
		return enfermedadesPrevias;
	}

	public void setEnfermedadesPrevias(String enfermedadesPrevias) {
		this.enfermedadesPrevias = enfermedadesPrevias;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	

	public CitaMedicaFacade getEjbCitaMedicaFacade() {
		return ejbCitaMedicaFacade;
	}

	public void setEjbCitaMedicaFacade(CitaMedicaFacade ejbCitaMedicaFacade) {
		this.ejbCitaMedicaFacade = ejbCitaMedicaFacade;
	}

	public PacienteFacade getEjbPacienteFacade() {
		return ejbPacienteFacade;
	}

	public void setEjbPacienteFacade(PacienteFacade ejbPacienteFacade) {
		this.ejbPacienteFacade = ejbPacienteFacade;
	}

	public SignosVitalesFacade getEjbSignosVitalesFacade() {
		return ejbSignosVitalesFacade;
	}

	public void setEjbSignosVitalesFacade(SignosVitalesFacade ejbSignosVitalesFacade) {
		this.ejbSignosVitalesFacade = ejbSignosVitalesFacade;
	}

	public String add() {

		
		ejbCitaMedicaFacade.create(new CitaMedica(this.sintomas,this.alergias,this.enfermedadesPrevias,this.fecha,this.hora));
		list = ejbCitaMedicaFacade.findAll();
		return null;

	}

	public String remove(CitaMedica p) {
		ejbCitaMedicaFacade.remove(p);
		list = ejbCitaMedicaFacade.findAll();
		return null;
	}

	public String edit(CitaMedica p) {
		p.setEditable(true);
		return null;
	}

	public String save(CitaMedica p) {
		ejbCitaMedicaFacade.edit(p);
		p.setEditable(false);
		return null;
	}
	
}

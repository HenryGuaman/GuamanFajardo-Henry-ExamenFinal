package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ec.edu.ups.ejb.CitaMedicaFacade;
import ec.edu.ups.ejb.PacienteFacade;
import ec.edu.ups.ejb.SignosVitalesFacade;
import ec.edu.ups.entidad.CitaMedica;

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
	
	private List<String> sintomas;
	private List<String> alergias;
	private List<String> enfermedadesPrevias;
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

	public List<String> getSintomas() {
		return sintomas;
	}

	public void setSintomas(List<String> sintomas) {
		this.sintomas = sintomas;
	}

	public List<String> getAlergias() {
		return alergias;
	}

	public void setAlergias(List<String> alergias) {
		this.alergias = alergias;
	}

	public List<String> getEnfermedadesPrevias() {
		return enfermedadesPrevias;
	}

	public void setEnfermedadesPrevias(List<String> enfermedadesPrevias) {
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

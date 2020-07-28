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
import ec.edu.ups.entidad.Paciente;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class PacienteBean implements Serializable{

	@EJB
	private PacienteFacade ejbPacienteFacade;
	private List<Paciente> list;
	@EJB
	private CitaMedicaFacade ejbCitaMedicaFacade;
	
	private String nombre;
	private String apellido;
	private String cedula;
	private String telefono;
	
	@PostConstruct
	public void init() {
		list= ejbPacienteFacade.findAll();
	}

	public PacienteFacade getEjbPacienteFacade() {
		return ejbPacienteFacade;
	}

	public void setEjbPacienteFacade(PacienteFacade ejbPacienteFacade) {
		this.ejbPacienteFacade = ejbPacienteFacade;
	}

	public List<Paciente> getList() {
		return list;
	}

	public void setList(List<Paciente> list) {
		this.list = list;
	}

	public CitaMedicaFacade getEjbCitaMedicaFacade() {
		return ejbCitaMedicaFacade;
	}

	public void setEjbCitaMedicaFacade(CitaMedicaFacade ejbCitaMedicaFacade) {
		this.ejbCitaMedicaFacade = ejbCitaMedicaFacade;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}

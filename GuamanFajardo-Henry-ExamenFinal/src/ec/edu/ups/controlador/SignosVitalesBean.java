package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ec.edu.ups.ejb.CitaMedicaFacade;
import ec.edu.ups.ejb.SignosVitalesFacade;
import ec.edu.ups.entidad.SignosVitales;

@Named
@SessionScoped
public class SignosVitalesBean implements Serializable{

	@EJB
	private SignosVitalesFacade ejbSignosVitalesFacade;
	private List<SignosVitales> list;
	
	private CitaMedicaFacade ejbCitaMedicaFacade;
	
	private String presion;
	private String frecuenciaCardiaca;
	private String frecuenciaRespiratoria;
	private String temperatua;
	private String saturacion;
	
	@PostConstruct
	public void init() {

		list = ejbSignosVitalesFacade.findAll();

	}

	public List<SignosVitales> getList() {
		return list;
	}

	public void setList(List<SignosVitales> list) {
		this.list = list;
	}

	public String getPresion() {
		return presion;
	}

	public void setPresion(String presion) {
		this.presion = presion;
	}

	public String getFrecuenciaCardiaca() {
		return frecuenciaCardiaca;
	}

	public void setFrecuenciaCardiaca(String frecuenciaCardiaca) {
		this.frecuenciaCardiaca = frecuenciaCardiaca;
	}

	public String getFrecuenciaRespiratoria() {
		return frecuenciaRespiratoria;
	}

	public void setFrecuenciaRespiratoria(String frecuenciaRespiratoria) {
		this.frecuenciaRespiratoria = frecuenciaRespiratoria;
	}

	public String getTemperatua() {
		return temperatua;
	}

	public void setTemperatua(String temperatua) {
		this.temperatua = temperatua;
	}

	public String getSaturacion() {
		return saturacion;
	}

	public void setSaturacion(String saturacion) {
		this.saturacion = saturacion;
	}
	
	public String add() {

		System.out.println("guardaas");
		ejbSignosVitalesFacade.create(new SignosVitales(this.presion,this.frecuenciaCardiaca, this.frecuenciaRespiratoria,this.temperatua,this.saturacion));
		list= ejbSignosVitalesFacade.findAll();
		return null;

	}

	public String remove(SignosVitales p) {
		ejbSignosVitalesFacade.remove(p);
		list = ejbSignosVitalesFacade.findAll();
		return null;
	}

	public String edit(SignosVitales p) {
		p.setEditable(true);
		return null;
	}

	public String save(SignosVitales p) {
		ejbSignosVitalesFacade.edit(p);
		p.setEditable(false);
		return null;
	}
	
}

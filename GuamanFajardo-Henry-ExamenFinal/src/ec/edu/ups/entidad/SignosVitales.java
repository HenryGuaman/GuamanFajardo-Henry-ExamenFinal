package ec.edu.ups.entidad;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class SignosVitales implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String presion;
	private String frecuenciaCardiaca;
	private String frecuenciaRespiratoria;
	private String temperatua;
	private String saturacion;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "signosVit")
	private CitaMedica citamedica;
	
	@Transient
	private boolean editable;
	
	/**
	 * @param presion
	 * @param frecuenciaCardiaca
	 * @param frecuenciaRespiratoria
	 * @param temperatua
	 * @param saturacion
	 */
	public SignosVitales(String presion, String frecuenciaCardiaca, String frecuenciaRespiratoria, String temperatua,
			String saturacion) {
		super();
		this.presion = presion;
		this.frecuenciaCardiaca = frecuenciaCardiaca;
		this.frecuenciaRespiratoria = frecuenciaRespiratoria;
		this.temperatua = temperatua;
		this.saturacion = saturacion;
	}
	/**
	 * 
	 */
	public SignosVitales() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
	
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	public CitaMedica getCitamedica() {
		return citamedica;
	}
	public void setCitamedica(CitaMedica citamedica) {
		this.citamedica = citamedica;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SignosVitales other = (SignosVitales) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SignosVitales [id=" + id + ", presion=" + presion + ", frecuenciaCardiaca=" + frecuenciaCardiaca
				+ ", frecuenciaRespiratoria=" + frecuenciaRespiratoria + ", temperatua=" + temperatua + ", saturacion="
				+ saturacion + "]";
	}
	
	
}

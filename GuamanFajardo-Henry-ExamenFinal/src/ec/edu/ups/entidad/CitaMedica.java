package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;


@Entity
public class CitaMedica implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	private List<String> sintomas;
	private List<String> alergias;
	private List<String> enfermedadesPrevias;
	private String fecha;
	private String hora;
	
	@OneToOne
	@JoinColumn
	private SignosVitales signosVit;
	
	@ManyToOne
	@JoinColumn
	private Paciente paciente;

	@Transient
	private boolean editable;
	
	
	
	/**
	 * @param sintomas
	 * @param alergias
	 * @param enfermedadesPrevias
	 * @param turno
	 */
	public CitaMedica(List<String> sintomas, List<String> alergias, List<String> enfermedadesPrevias,String fecha, String hora) {
		super();
		this.sintomas = sintomas;
		this.alergias = alergias;
		this.enfermedadesPrevias = enfermedadesPrevias;
		this.fecha = fecha;
		this.hora=hora;
	}

	/**
	 * 
	 */
	public CitaMedica() {
		
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public SignosVitales getSignosVit() {
		return signosVit;
	}

	public void setSignosVit(SignosVitales signosVit) {
		this.signosVit = signosVit;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	
	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
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
		CitaMedica other = (CitaMedica) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CitaMedica [id=" + id + ", sintomas=" + sintomas + ", alergias=" + alergias + ", enfermedadesPrevias="
				+ enfermedadesPrevias + ", fecha=" + fecha + ", hora=" + hora + ", signosVit=" + signosVit
				+ ", paciente=" + paciente + ", editable=" + editable + "]";
	}

	
	
	
}

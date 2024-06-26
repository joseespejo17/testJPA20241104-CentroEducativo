package testJPA20241104CentroEducativo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "valoracionmateria")
public class ValoracionMateria  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int idProfesor;
	private int idMateria;
	private int idEstudiante;
	private float valoracion;
	private Date fecha;
	
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdProfesor() {
		return idProfesor;
	}
	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}
	public int getIdMateria() {
		return idMateria;
	}
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
	public int getIdEstudiante() {
		return idEstudiante;
	}
	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	public float getValoracion() {
		return valoracion;
	}
	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}
	@Override
	public String toString() {
		return "ValoracionMateria [id=" + id + ", idProfesor=" + idProfesor + ", idMateria=" + idMateria
				+ ", idEstudiante=" + idEstudiante + ", valoracion=" + valoracion + "]";
	}
	
	
	
	
}

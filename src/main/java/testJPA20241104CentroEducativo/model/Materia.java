package testJPA20241104CentroEducativo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "materia")
public class Materia extends SuperEntidad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;

	
	
	public Materia() {
		super();
	}


	public Materia(int id, int cursoId, String nombre, String acronimo) {
		super();
		this.id = id;
		this.nombre = nombre;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	@Override
	public String toString() {
		return nombre;
	}
	
	
	
	
	
}

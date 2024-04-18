package testJPA20241104CentroEducativo.controladores;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import testJPA20241104CentroEducativo.model.Estudiante;
import testJPA20241104CentroEducativo.model.Materia;
import testJPA20241104CentroEducativo.model.Profesor;
import testJPA20241104CentroEducativo.model.SuperEntidad;
import testJPA20241104CentroEducativo.model.ValoracionMateria;

public class ControladorValoracionMateria extends SuperControladorJPA{

	private static ControladorValoracionMateria instance = null;
	private String NOMBRETABLA = "valoracionmateria";
	
	public ControladorValoracionMateria() {
		super("valoracionmateria", ValoracionMateria.class);
	}
	
	public static ControladorValoracionMateria getInstance() {
		if(instance == null) {
			instance = new ControladorValoracionMateria();
		}
		return instance;
	}
	
	public ValoracionMateria filtraVmPorMPE(Materia m, Profesor p, Estudiante e) {	
		
		EntityManager em = getEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM " + NOMBRETABLA + 
				" where idMateria = " + m.getId() + " and idProfesor = " + p.getId() + " and idEstudiante = " + e.getId(), ValoracionMateria.class);
	
		try {
			
			return (ValoracionMateria) q.getSingleResult();
	
		}catch (Exception ex) {
			return null;
		}
		
	}
	
	/**
	 * 
	 */
	public void persist(Profesor p, int nota, Materia m, Estudiante e, Date fecha) {
		EntityManager em = getEntityManager();
		ValoracionMateria vm = new ValoracionMateria();
		
		vm.setIdEstudiante(e.getId());
		vm.setIdMateria(m.getId());
		vm.setIdProfesor(p.getId());
		vm.setFecha(fecha);
		
		em.getTransaction().begin();
		em.persist(vm);
		em.getTransaction().commit();
	
	}
	

	public void update(ValoracionMateria vm, int nota, Date fecha) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		vm.setValoracion(nota);
		vm.setFecha(fecha);
		em.merge(vm);
		em.getTransaction().commit();
	
	}
}

package testJPA20241104CentroEducativo.controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import testJPA20241104CentroEducativo.model.SuperEntidad;





public class SuperControladorJPA {

	private EntityManager em = null;
	private String nombreTabla = "";
	private Class tipoEntidad;
	
	public SuperControladorJPA(String nombreTabla, Class tipoEntidad) {
		this.nombreTabla = nombreTabla;
		this.tipoEntidad = tipoEntidad;
	}
	
	protected EntityManager getEntityManager() {
		if(em == null) {
			em =Persistence.createEntityManagerFactory("centroeducativo")
					.createEntityManager();
		}
		return em;
	}
	
	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<? extends SuperEntidad> findAll () {	
	
		return (List<SuperEntidad>)  
				getEntityManager()
				.createNativeQuery("SELECT * FROM " + this.nombreTabla, this.tipoEntidad)
				.getResultList();
	}
	

}

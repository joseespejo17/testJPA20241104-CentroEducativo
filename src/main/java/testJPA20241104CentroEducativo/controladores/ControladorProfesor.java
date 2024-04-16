package testJPA20241104CentroEducativo.controladores;

import testJPA20241104CentroEducativo.model.Profesor;

public class ControladorProfesor extends SuperControladorJPA{

	private static ControladorProfesor instance = null;
	
	public ControladorProfesor() {
		super("profesor", Profesor.class);
	}
	
	public static ControladorProfesor getInstance() {
		if(instance == null) {
			instance = new ControladorProfesor();
		}
		return instance;
	}
	

}

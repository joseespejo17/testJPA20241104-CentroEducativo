package testJPA20241104CentroEducativo.controladores;

import java.util.List;

import testJPA20241104CentroEducativo.model.Estudiante;



public class ControladorEstudiante extends SuperControladorJPA{

	private static ControladorEstudiante instance = null;
	
	public ControladorEstudiante() {
		super("estudiante", Estudiante.class);
	}
	
	public static ControladorEstudiante getInstance() {
		if(instance == null) {
			instance = new ControladorEstudiante();
		}
		return instance;
	}
	

	
}

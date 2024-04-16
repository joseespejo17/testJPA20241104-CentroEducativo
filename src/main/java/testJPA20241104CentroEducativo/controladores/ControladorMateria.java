package testJPA20241104CentroEducativo.controladores;

import testJPA20241104CentroEducativo.model.Materia;

public class ControladorMateria extends SuperControladorJPA{

	private static ControladorMateria instance = null;
	
	public ControladorMateria() {
		super("materia", Materia.class);
	}
	
	public static ControladorMateria getInstance() {
		if(instance == null) {
			instance = new ControladorMateria();
		}
		return instance;
	}
	

}

package testJPA20241104CentroEducativo;

import javax.swing.JFrame;
import tutorialJava.capitulo9_AWT_SWING.utils.Apariencia;

public class VentanaPrincipal extends JFrame{

	// Establecer la apariencia típica de Windows
		static {
			Apariencia.setAparienciasOrdenadas(Apariencia.aparienciasOrdenadas);
		}

		public VentanaPrincipal() {
			super("Gestiona Ventana Principal");
			
			this.setBounds(0, 0, 800, 600);
			
			PanelPrincipal panel = new PanelPrincipal();
		}
		
		public static void main(String[] args) {
			VentanaPrincipal ventana = new VentanaPrincipal();
			ventana.setVisible(true);
		}
}

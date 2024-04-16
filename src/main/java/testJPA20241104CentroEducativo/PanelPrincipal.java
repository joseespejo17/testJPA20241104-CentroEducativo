package testJPA20241104CentroEducativo;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ImageIcon;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.SwingConstants;

import testJPA20241104CentroEducativo.controladores.ControladorEstudiante;
import testJPA20241104CentroEducativo.controladores.ControladorMateria;
import testJPA20241104CentroEducativo.controladores.ControladorProfesor;
import testJPA20241104CentroEducativo.controladores.ControladorValoracionMateria;
import testJPA20241104CentroEducativo.model.Estudiante;
import testJPA20241104CentroEducativo.model.Materia;
import testJPA20241104CentroEducativo.model.Profesor;
import testJPA20241104CentroEducativo.model.ValoracionMateria;



public class PanelPrincipal {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private DefaultListModel<Estudiante> listModelSeleccionado = new DefaultListModel<Estudiante>();
	private DefaultListModel<Estudiante> listModelNoSeleccionado = new DefaultListModel<Estudiante>();
	JComboBox<Materia> jcbMateria;
	JComboBox<Profesor> jcbProfesor;
	JComboBox<Integer> jcbNota;
	private JList listSeleccionado;
	private JList listNoSeleccionado;
	List<Estudiante> estudiante = (List<Estudiante>) ControladorEstudiante.getInstance().findAll();
	
	private Profesor pActual;
	private Materia mActual;
	private Estudiante eActual;
	private int nActual;
	
	JPanel panelEstudiantes;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelPrincipal window = new PanelPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public PanelPrincipal() {
		initialize();
	}

	/**
	 * Create the panel.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0};
		gridBagLayout.columnWeights = new double[]{1.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel panelProfesorMateria = new JPanel();
		GridBagConstraints gbc_panelProfesorMateria = new GridBagConstraints();
		gbc_panelProfesorMateria.insets = new Insets(0, 0, 5, 0);
		gbc_panelProfesorMateria.fill = GridBagConstraints.BOTH;
		gbc_panelProfesorMateria.gridx = 0;
		gbc_panelProfesorMateria.gridy = 0;
		frame.getContentPane().add(panelProfesorMateria, gbc_panelProfesorMateria);
		GridBagLayout gbl_panelProfesorMateria = new GridBagLayout();
		gbl_panelProfesorMateria.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panelProfesorMateria.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panelProfesorMateria.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelProfesorMateria.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelProfesorMateria.setLayout(gbl_panelProfesorMateria);
		
		JLabel lblNewLabel = new JLabel("Materia:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panelProfesorMateria.add(lblNewLabel, gbc_lblNewLabel);
		
		jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.gridwidth = 2;
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		panelProfesorMateria.add(jcbMateria, gbc_jcbMateria);
		
		JLabel lblNewLabel_1 = new JLabel("Profesor:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panelProfesorMateria.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbProfesor = new JComboBox<Profesor>();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.gridwidth = 2;
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		panelProfesorMateria.add(jcbProfesor, gbc_jcbProfesor);
		
		JButton btnActualizarAlumnado = new JButton("Actualizar Alumnado");
		btnActualizarAlumnado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizaAlumnado();
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Nota:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panelProfesorMateria.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbNota = new JComboBox();
		for (int i = 0; i <= 10; i++) {
			jcbNota.addItem(i);
		}
		
		GridBagConstraints gbc_jcbNota = new GridBagConstraints();
		gbc_jcbNota.gridwidth = 2;
		gbc_jcbNota.insets = new Insets(0, 0, 5, 5);
		gbc_jcbNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNota.gridx = 1;
		gbc_jcbNota.gridy = 2;
		panelProfesorMateria.add(jcbNota, gbc_jcbNota);
		GridBagConstraints gbc_btnActualizarAlumnado = new GridBagConstraints();
		gbc_btnActualizarAlumnado.gridx = 2;
		gbc_btnActualizarAlumnado.gridy = 3;
		panelProfesorMateria.add(btnActualizarAlumnado, gbc_btnActualizarAlumnado);
		
		panelEstudiantes = new JPanel();
		GridBagConstraints gbc_panelEstudiantes = new GridBagConstraints();
		gbc_panelEstudiantes.weighty = 1.0;
		gbc_panelEstudiantes.insets = new Insets(0, 0, 5, 0);
		gbc_panelEstudiantes.fill = GridBagConstraints.BOTH;
		gbc_panelEstudiantes.gridx = 0;
		gbc_panelEstudiantes.gridy = 1;
		frame.getContentPane().add(panelEstudiantes, gbc_panelEstudiantes);
		GridBagLayout gbl_panelEstudiantes = new GridBagLayout();
		gbl_panelEstudiantes.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelEstudiantes.rowHeights = new int[]{0, 0, 0};
		gbl_panelEstudiantes.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelEstudiantes.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panelEstudiantes.setLayout(gbl_panelEstudiantes);
		
		JLabel lblNewLabel_3 = new JLabel("Alumnado no seleccionado");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panelEstudiantes.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Alumnado Seleccionado");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.gridwidth = 2;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 9;
		gbc_lblNewLabel_4.gridy = 0;
		panelEstudiantes.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		listNoSeleccionado = new JList(listModelNoSeleccionado);
		GridBagConstraints gbc_listNoSeleccionado = new GridBagConstraints();
		gbc_listNoSeleccionado.gridwidth = 3;
		gbc_listNoSeleccionado.insets = new Insets(0, 0, 0, 5);
		gbc_listNoSeleccionado.fill = GridBagConstraints.BOTH;
		gbc_listNoSeleccionado.gridx = 0;
		gbc_listNoSeleccionado.gridy = 1;
		panelEstudiantes.add(listNoSeleccionado, gbc_listNoSeleccionado);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 6;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 1;
		panelEstudiantes.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoAllFeft();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/res/gotostart.png")));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 1;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoSelectLeft();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/res/previous.png")));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 2;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoSelectRight();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/res/next.png")));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 3;
		panel.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoAllRight();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/res/gotoend.png")));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 4;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		listSeleccionado = new JList(listModelSeleccionado);
		GridBagConstraints gbc_listSeleccionado = new GridBagConstraints();
		gbc_listSeleccionado.gridwidth = 4;
		gbc_listSeleccionado.fill = GridBagConstraints.BOTH;
		gbc_listSeleccionado.gridx = 9;
		gbc_listSeleccionado.gridy = 1;
		panelEstudiantes.add(listSeleccionado, gbc_listSeleccionado);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.EAST;
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 2;
		frame.getContentPane().add(btnGuardar, gbc_btnGuardar);
		
		cargarTodasMaterias();
		cargarTodasProfesor();
	}

	private void cargarTodasMaterias() {
		List<Materia> m = (List<Materia>) ControladorMateria.getInstance().findAll();
		
		for(Materia ma : m) {
			jcbMateria.addItem(ma);
		}
	}
	
	private void cargarTodasProfesor() {
		List<Profesor> m = (List<Profesor>) ControladorProfesor.getInstance().findAll();
		
		for(Profesor ma : m) {
			jcbProfesor.addItem(ma);
		}
	}
	
	private void actualizaAlumnado() {
		
		listModelNoSeleccionado.clear();
		listModelSeleccionado.clear();
		
		this.nActual = (int) jcbNota.getSelectedItem();
		this.mActual = (Materia) jcbMateria.getSelectedItem();
		this.pActual = (Profesor) jcbProfesor.getSelectedItem();
		
		for(Estudiante e : estudiante) {
			ValoracionMateria vm = ControladorValoracionMateria.getInstance().filtraVmPorMPE(mActual, pActual, e);
			
			if(vm != null && vm.getValoracion() == this.nActual) {
				listModelSeleccionado.addElement(e);
			}else {
				listModelNoSeleccionado.addElement(e);
			}
		}
	}
	
	private void GoAllFeft() {
		List<Estudiante> l = new ArrayList<Estudiante>();
		
		for (int i = 0; i < listModelSeleccionado.size(); i++) {
			l.add(listModelSeleccionado.getElementAt(i));
		}
		
		listModelSeleccionado.clear();
		
		for (int i = 0; i < l.size(); i++) {
			
			listModelNoSeleccionado.addElement(l.get(i));
			
		}
	}
	
	private void GoAllRight() {
		
		List<Estudiante> l = new ArrayList<Estudiante>();
		
		for (int i = 0; i < listModelNoSeleccionado.size(); i++) {
			l.add(listModelNoSeleccionado.getElementAt(i));
		}
		
		listModelNoSeleccionado.clear();
		
		for (int i = 0; i < l.size(); i++) {
			
			listModelSeleccionado.addElement(l.get(i));
			
		}
	}
	
	/**
	 * Paso los elementos seleccionados a la derecha mientras elimino los de la izquierda 
	 */
	private void GoSelectRight() {
		
		int [] seleccionados = listNoSeleccionado.getSelectedIndices();
		
		for (int i = seleccionados.length - 1; i >= 0; i--) {
			int indice = seleccionados[i];
			Estudiante e = listModelNoSeleccionado.getElementAt(indice);
			listModelSeleccionado.addElement(e);
			listModelNoSeleccionado.remove(indice);
		}
	}
	
	/**
	 * Paso los elementos seleccionados a la izquierda mientras elimino los de la derecha
	 */
	private void GoSelectLeft() {
		
		int [] seleccionados = listSeleccionado.getSelectedIndices();
		
		for (int i = seleccionados.length - 1; i >= 0; i--) {
			int indice = seleccionados[i];
			Estudiante e = listModelSeleccionado.getElementAt(indice);
			listModelNoSeleccionado.addElement(e);
			listModelSeleccionado.remove(indice);
		}
	}
	
	private void save() {
		
		List<Estudiante> l = new ArrayList<Estudiante>();
		
		for (int i = 0; i < listModelSeleccionado.size(); i++) {
			l.add(listModelSeleccionado.getElementAt(i));
		}
		
		if(l.size() > 0 ) {
			for(Estudiante estudiante : l) {
				ValoracionMateria vm = ControladorValoracionMateria.getInstance()
						.filtraVmPorMPE(mActual, pActual, estudiante);
				if(vm != null) {
					ControladorValoracionMateria.getInstance().update(vm, nActual);
				}else {
					ControladorValoracionMateria.getInstance().persist(pActual, nActual, mActual, estudiante);
				}
				
			}
		}
	}
}














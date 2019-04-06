package vista;
import controlador.AlumnoDAO;
import modelo.Alumno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


class VentanaPrincipal extends JFrame implements ActionListener{
	JMenu menuPrincipalAlumnos, menuPrincipalMaterias;
	JMenuItem itemAltaAlumno, itemBajaAlumno, itemModificaciones, itemConsultaAlumno, itemModificacionesAlumno;
	JInternalFrame internalFrameAltaAlumno, internalFrameBajaAlumno, internalFrameConsultaAlumno, internalFrameModificacionesAlumno;
	JTextField cajaNumControl, cajaNom, cajaApePaterno, cajaApeMaterno;
	JButton btnAgregar, btnRestablecer, btnCancelar, b1, b2, b3, b4;
	JRadioButton r1, r2, r3, r4, r5;
	JComboBox<String> comboSemestre, comboCarrera;
	JTable tablaA, tablaB;
	public VentanaPrincipal() {
		crearComponentes();
	}
	public void crearComponentes() {
		getContentPane().setLayout(new BorderLayout());
		setTitle("Registro Alumnos");
		setSize(710,650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		JMenuBar menuBar = new JMenuBar();
		//----------------------------------------------------
		menuPrincipalAlumnos = new JMenu("Menu Alumnos");
			itemAltaAlumno = new JMenuItem("Agregar");
				itemAltaAlumno.addActionListener(this);
				itemAltaAlumno.setMnemonic(KeyEvent.VK_ADD);
				itemAltaAlumno.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
			menuPrincipalAlumnos.add(itemAltaAlumno);
		
			itemBajaAlumno = new JMenuItem("Eliminar");
				itemBajaAlumno.addActionListener(this);
				itemBajaAlumno.setMnemonic(KeyEvent.VK_ADD);
				itemBajaAlumno.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
			menuPrincipalAlumnos.add(itemBajaAlumno);
			
			itemModificacionesAlumno = new JMenuItem("Modificar");
				itemModificacionesAlumno.addActionListener(this);
				itemModificacionesAlumno.setMnemonic(KeyEvent.VK_ADD);
				itemModificacionesAlumno.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.ALT_MASK));
			menuPrincipalAlumnos.add(itemModificacionesAlumno);
			
			itemConsultaAlumno = new JMenuItem("Consulta");
				itemConsultaAlumno.addActionListener(this);
				itemConsultaAlumno.setMnemonic(KeyEvent.VK_ADD);
				itemConsultaAlumno.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
			menuPrincipalAlumnos.add(itemConsultaAlumno);
			
		menuBar.add(menuPrincipalAlumnos);
		setJMenuBar(menuBar);
		//INTERNAL FRAME ---------------------------
		//=================================================>Alta Alumnos
		JDesktopPane desktopPane = new JDesktopPane();
			internalFrameAltaAlumno = new JInternalFrame("Agregar");
				internalFrameAltaAlumno.getContentPane().setLayout(null);;
				internalFrameAltaAlumno.setDefaultCloseOperation(HIDE_ON_CLOSE);
				internalFrameAltaAlumno.setClosable(true);
				internalFrameAltaAlumno.setMaximizable(true);
				internalFrameAltaAlumno.setIconifiable(true);
				internalFrameAltaAlumno.setResizable(true);
				
				internalFrameAltaAlumno.setSize(700, 595);
				//componentes del internalFrameAltaAlumnos
				Font f1 = new Font("Arial", Font.ITALIC, 12);
				JPanel panelIFAltaAlumnos1 = new JPanel();
					panelIFAltaAlumnos1.setBackground(new Color(124, 252, 0));;
					panelIFAltaAlumnos1.setPreferredSize(new Dimension(700, 190));
					panelIFAltaAlumnos1.setBounds(0,0,700,80);
					panelIFAltaAlumnos1.setLayout(null);
					
					JLabel lbl = new JLabel("Altas Alumnos");
					lbl.setFont(new Font("Arial", Font.BOLD, 24));
					lbl.setForeground(new Color(225, 225, 225));
					lbl.setBounds(30,30,400,20);
					panelIFAltaAlumnos1.add(lbl);
				internalFrameAltaAlumno.add(panelIFAltaAlumnos1);
			//--------------------------------------------------------------------
				Font f2 = new Font("Arial", Font.CENTER_BASELINE, 12);
				JPanel panelIFAltaAlumnos = new JPanel();
					panelIFAltaAlumnos.setLayout(null);
					panelIFAltaAlumnos.setPreferredSize(new Dimension(700,190));
					panelIFAltaAlumnos.setBounds(0, 80, 700, 330);
					//===================================
					JLabel lblNumControl = new JLabel("Numero de Control: ");
					lblNumControl.setFont(f2);
					lblNumControl.setBounds(100, 30, 400, 25);
					panelIFAltaAlumnos.add(lblNumControl);
					
					cajaNumControl = new JTextField(10);
					cajaNumControl.addActionListener(this);
					cajaNumControl.setFont(f2);
					cajaNumControl.setBounds(225, 30, 176, 23);
					panelIFAltaAlumnos.add(cajaNumControl);
					//===================================
					JLabel lblNombre = new JLabel("Nombre: ");
					lblNombre.setFont(f2);
					lblNombre.setBounds(100, 70, 300, 25);
					panelIFAltaAlumnos.add(lblNombre);
					
					cajaNom = new JTextField(10);
					cajaNom.addActionListener(this);
					cajaNom.setFont(f2);
					cajaNom.setBounds(200, 70, 230,23);
					panelIFAltaAlumnos.add(cajaNom);
					//==================================
					JLabel lblPApellido = new JLabel("Primer Apellido: ");
					lblPApellido.setFont(f2);
					lblPApellido.setBounds(100,110,300,25);
					panelIFAltaAlumnos.add(lblPApellido);
					
					cajaApePaterno = new JTextField(10);
					cajaApePaterno.addActionListener(this);
					cajaApePaterno.setFont(f2);
					cajaApePaterno.setBounds(225,110,176,23);
					panelIFAltaAlumnos.add(cajaApePaterno);
					//=================================
					JLabel lblSApellido = new JLabel("Segundo Apellido: ");
					lblSApellido.setFont(f2);
					lblSApellido.setBounds(100,150,300,25);
					panelIFAltaAlumnos.add(lblSApellido);
					
					cajaApeMaterno = new JTextField(10);
					cajaApeMaterno.addActionListener(this);
					cajaApeMaterno.setFont(f2);
					cajaApeMaterno.setBounds(225,150,176,23);
					panelIFAltaAlumnos.add(cajaApeMaterno);
					//==================================
					JLabel lblSemestre = new JLabel("Semestre: ");
					lblSemestre.setFont(f2);
					lblSemestre.setBounds(100,200,300,25);
					panelIFAltaAlumnos.add(lblSemestre);
					
					comboSemestre = new JComboBox<String>();
					comboSemestre.addActionListener(this);
					comboSemestre.setFont(f2);
					comboSemestre.addItem("Selecciona tu Semestre");
					comboSemestre.addItem("1");
					comboSemestre.addItem("2");
					comboSemestre.addItem("3");
					comboSemestre.addItem("4");
					comboSemestre.addItem("5");
					comboSemestre.addItem("6");
					comboSemestre.addItem("7");
					comboSemestre.addItem("8");
					comboSemestre.addItem("9");
					comboSemestre.addItem("10");
					comboSemestre.setBounds(225,200,175,23);
					panelIFAltaAlumnos.add(comboSemestre);
					//================================
					JLabel lblCarrera = new JLabel("Carrera: ");
					lblCarrera.setFont(f2);
					lblCarrera.setBounds(100, 240, 300, 25);
					panelIFAltaAlumnos.add(lblCarrera);
					
					comboCarrera = new JComboBox<String>();
					comboCarrera.addActionListener(this);
					comboCarrera.setFont(f2);
					comboCarrera.addItem("Selecciona tu Carrera");
					comboCarrera.addItem("ISC");
					comboCarrera.addItem("IIA");
					comboCarrera.addItem("IM");
					comboCarrera.addItem("CP");
					comboCarrera.addItem("LA");
					comboCarrera.setBounds(225, 240, 175, 23);
					panelIFAltaAlumnos.add(comboCarrera);
				
					//===============================
					btnAgregar = new JButton("Agregar");
					btnAgregar.addActionListener(this);
					btnAgregar.setFont(f2);
					btnAgregar.setBounds(460, 100, 120, 30);
					panelIFAltaAlumnos.add(btnAgregar);
					
					btnCancelar = new JButton("Cancelar");
					btnCancelar.addActionListener(this);
					btnCancelar.setFont(f2);
					btnCancelar.setBounds(460, 150, 120, 30);
					panelIFAltaAlumnos.add(btnCancelar);
					
					btnRestablecer = new JButton("Restablecer");
					btnRestablecer.addActionListener(this);
					btnRestablecer.setFont(f2);
					btnRestablecer.setBounds(255, 290, 174, 25);
					panelIFAltaAlumnos.add(btnRestablecer);
					//===============================
					
				internalFrameAltaAlumno.add(panelIFAltaAlumnos);
				JPanel panelTabla = new JPanel();
					panelTabla.setLayout(null);
					panelTabla.setPreferredSize(new Dimension(700,190));
					panelTabla.setBounds(0, 410, 700, 152);
					
					String columnas[] = {"Num Control", "Nombres", "Primer Ap", "Segundo Ap", "Edad", "Semestre",
												"Carrera"};
					String datos[][] = {{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
										{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
										{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
										{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
										{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""}};
					tablaA = new JTable(datos, columnas);
					JScrollPane scroll = new JScrollPane(tablaA);
					scroll.setBounds(5, 9, 678, 135);
					panelTabla.add(scroll);
				internalFrameAltaAlumno.add(panelTabla);
				desktopPane.add(internalFrameAltaAlumno);
				
				//=================================================================>Baja Alumno
				internalFrameBajaAlumno = new JInternalFrame("Eliminar");
					internalFrameBajaAlumno.getContentPane().setLayout(null);;
					internalFrameBajaAlumno.setDefaultCloseOperation(HIDE_ON_CLOSE);
					internalFrameBajaAlumno.setClosable(true);
					internalFrameBajaAlumno.setMaximizable(true);
					internalFrameBajaAlumno.setIconifiable(true);
					internalFrameBajaAlumno.setResizable(true);
					
					internalFrameBajaAlumno.setSize(700, 595);
					//componentes del InternalFrame Alumno Baja
					JPanel panelIFBajaAlumnos1 = new JPanel();
						panelIFBajaAlumnos1.setBackground(new Color(225,0,0));
						panelIFBajaAlumnos1.setPreferredSize(new Dimension (700, 190));
						panelIFBajaAlumnos1.setBounds(0, 0, 700, 80);
						panelIFBajaAlumnos1.setLayout(null);
						
						JLabel lbl2 = new JLabel("Bajas Alumnos");
						lbl2.setFont(new Font("Arial", Font.BOLD, 24));
						lbl2.setForeground(new Color(225, 225, 225));
						lbl2.setBounds(30, 30, 400, 20);
						panelIFBajaAlumnos1.add(lbl2);
					internalFrameBajaAlumno.add(panelIFBajaAlumnos1);
					JPanel panelIFBajaAlumnos = new JPanel();
						panelIFBajaAlumnos.setLayout(null);
						panelIFBajaAlumnos.setPreferredSize(new Dimension(700, 190));
						panelIFBajaAlumnos.setBounds(0, 80, 700, 80);
						//=================================
						JLabel lblNumControl2 = new JLabel("Numero Control:");
						lblNumControl2.setFont(f2);
						lblNumControl2.setBounds(80, 30, 400, 25);
						panelIFBajaAlumnos.add(lblNumControl2);
						
						JTextField NumControl2 = new JTextField(10);
						NumControl2.setFont(f2);
						NumControl2.setBounds(250, 30, 150, 23);
						panelIFBajaAlumnos.add(NumControl2);
						
						JButton btnBuscar = new JButton();
						btnBuscar.setBounds(420, 20, 50, 45);
						panelIFBajaAlumnos.add(btnBuscar);
						
						JButton btnBorrar2 = new JButton("Restablecer");
						btnBorrar2.setFont(f2);
						btnBorrar2.setBounds(510, 25, 140, 25);
						panelIFBajaAlumnos.add(btnBorrar2);
						
						JLabel lblLinea = new JLabel("_____________________________________________________________________________");
						lblLinea.setFont(f2); 
						lblLinea.setBounds(0, 60, 630, 20);
						panelIFBajaAlumnos.add(lblLinea);
						
					JPanel panelIFBajasAlumno = new JPanel();
						panelIFBajasAlumno.setLayout(null);
						panelIFBajasAlumno.setPreferredSize(new Dimension(700, 190));
						panelIFBajasAlumno.setBounds(0, 160, 700, 250);
						
						JLabel lblNombres2 = new JLabel("Nombre:");
						lblNombres2.setFont(f2);
						lblNombres2.setBounds(100, 30, 400, 25);
						panelIFBajasAlumno.add(lblNombres2);
						
						JTextField Nombres2 = new JTextField(10);
						Nombres2.setFont(f2);
						Nombres2.setBounds(280, 30, 176, 23);
						panelIFBajasAlumno.add(Nombres2);
						
						JLabel lblApePaterno2 = new JLabel("Apellido Paterno:");
						lblApePaterno2.setFont(f2);
						lblApePaterno2.setBounds(100, 70, 300, 25);
						panelIFBajasAlumno.add(lblApePaterno2);
						
						JTextField ApePaterno2 = new JTextField(10);
						ApePaterno2.setFont(f2);
						ApePaterno2.setBounds(280, 70, 176, 23);
						panelIFBajasAlumno.add(ApePaterno2);
						
						JLabel lblApeMaterno2 = new JLabel("Apellido Materno:");
						lblApeMaterno2.setFont(f2);
						lblApeMaterno2.setBounds(100, 110, 300, 25);
						panelIFBajasAlumno.add(lblApeMaterno2);
						
						JTextField ApeMaterno2 = new JTextField(10);
						ApeMaterno2.setFont(f2);
						ApeMaterno2.setBounds(280, 110, 176, 23);
						panelIFBajasAlumno.add(ApeMaterno2);
						
						JLabel lblSemestre2 = new JLabel("Semestre:");
						lblSemestre2.setFont(f2);
						lblSemestre2.setBounds(100, 150, 300, 25);
						panelIFBajasAlumno.add(lblSemestre2);
						
						JSpinner sprSemestre = new JSpinner();
						sprSemestre.setAutoscrolls(true);
						sprSemestre.setBounds(280, 150, 176, 23);
						panelIFBajasAlumno.add(sprSemestre);
						
						JLabel lblCarrera2 = new JLabel("Carrera:");
						lblCarrera2.setFont(f2);
						lblCarrera2.setBounds(100, 190, 300, 25);
						panelIFBajasAlumno.add(lblCarrera2);
						
						JComboBox<String> comboCarrera2 = new JComboBox<String>();
						comboCarrera2.addItem("Elige Carrera...");
						comboCarrera2.addItem("ISC");
						comboCarrera2.addItem("IIA");
						comboCarrera2.addItem("IM");
						comboCarrera2.addItem("LA");
						comboCarrera2.addItem("LCP");
						comboCarrera2.setFont(f1);
						comboCarrera2.setBounds(280, 190, 175, 23);
						panelIFBajasAlumno.add(comboCarrera2);
						
						JButton btnEliminar = new JButton("Eliminar");
						btnEliminar.setFont(f2);
						btnEliminar.setBounds(480, 45, 135, 25);
						panelIFBajasAlumno.add(btnEliminar);
						
						JButton btnRestablecer2 = new JButton("Restablecer");
						btnRestablecer2.setFont(f2);
						btnRestablecer2.setBounds(480, 170, 135, 25);
						panelIFBajasAlumno.add(btnRestablecer2);
						
						JButton btnCancelar2 = new JButton("Cancelar");
						btnCancelar2.setFont(f2);
						btnCancelar2.setBounds(480, 110, 135, 25);
						panelIFBajasAlumno.add(btnCancelar2);
						
					internalFrameBajaAlumno.add(panelIFBajasAlumno);	
					
					JPanel panelTabla2 = new JPanel();
						panelTabla2.setLayout(null);
						panelTabla2.setPreferredSize(new Dimension(700, 190));
						panelTabla2.setBounds(0, 410, 700, 152);
						
						String columnas2[] = {"Num Control", "Nombres", "Primer Ap", "Segundo Ap", "Edad", "Semestre",
										"Carrera"};
						String datos2[][] = {{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
										{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
										{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
										{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
										{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""}};
					
						JTable tabla2 = new JTable(datos, columnas);
						JScrollPane scroll2 = new JScrollPane(tabla2);
						scroll2.setBounds(5, 9, 678, 135);
					panelTabla2.add(scroll2);
					
				internalFrameBajaAlumno.add(panelIFBajaAlumnos);
				desktopPane.add(internalFrameBajaAlumno);
				//---------------------------------------------------------------------------------------- Modificaciones sAlumno
				internalFrameModificacionesAlumno = new JInternalFrame("Modificar");
					internalFrameModificacionesAlumno.getContentPane().setLayout(null);;
					internalFrameModificacionesAlumno.setDefaultCloseOperation(HIDE_ON_CLOSE);
					internalFrameModificacionesAlumno.setClosable(true);
					internalFrameModificacionesAlumno.setMaximizable(true);
					internalFrameModificacionesAlumno.setIconifiable(true);
					internalFrameModificacionesAlumno.setResizable(true);
				
					internalFrameModificacionesAlumno.setSize(700, 595);
					//===============================Componentes
					JPanel panelIFModificaciones1 = new JPanel();
						panelIFModificaciones1.setBackground(new Color(225,165,0));
						panelIFModificaciones1.setPreferredSize(new Dimension (700, 190));
						panelIFModificaciones1.setBounds(0, 0, 700, 80);
						panelIFModificaciones1.setLayout(null);
						
						JLabel lbl3 = new JLabel("Modificacion Alumnos");
						lbl3.setFont(new Font("Arial", Font.BOLD, 24));
						lbl3.setForeground(new Color(225, 225, 225));
						lbl3.setBounds(30, 30, 400, 20);
						panelIFModificaciones1.add(lbl3);
				internalFrameModificacionesAlumno.add(panelIFModificaciones1);
					JPanel panelIFModificaciones = new JPanel();
						panelIFModificaciones.setLayout(null);
						panelIFModificaciones.setPreferredSize(new Dimension(700, 190));
						panelIFModificaciones.setBounds(0, 80, 700, 80);
						//===============================================
						JLabel lblNumControl3 = new JLabel("Numero de Control:");
						lblNumControl3.setFont(f2);
						lblNumControl3.setBounds(80, 30, 400, 25);
						panelIFModificaciones.add(lblNumControl3);
						
						JTextField NumControl3 = new JTextField(10);
						NumControl3.setFont(f2);
						NumControl3.setBounds(250, 30, 150, 23);
						panelIFModificaciones.add(NumControl3);
						
						JButton btnBuscar2 = new JButton();
						btnBuscar2.setBounds(420, 20, 50, 45);
						panelIFModificaciones.add(btnBuscar2);
					
						JButton btnBorrar3 = new JButton("Restablecer");
						btnBorrar3.setFont(f2);
						btnBorrar3.setBounds(510, 25, 140, 25);
						panelIFModificaciones.add(btnBorrar3);
						
						JLabel lblLinea2 = new JLabel("_____________________________________________________________________________");
						lblLinea2.setFont(f2);
						lblLinea2.setBounds(0, 60, 630, 20);
						panelIFModificaciones.add(lblLinea2);
				
					internalFrameModificacionesAlumno.add(panelIFModificaciones);
						
						JPanel panelIFModificacion = new JPanel();
							panelIFModificacion.setLayout(null);
							panelIFModificacion.setPreferredSize(new Dimension(700, 190));
							panelIFModificacion.setBounds(0, 160, 700, 250);
						
							JLabel lblNombres3 = new JLabel("Nombre:");
							lblNombres3.setFont(f2);
							lblNombres3.setBounds(100, 30, 400, 25);
							panelIFModificacion.add(lblNombres3);
							
							JTextField Nombres3 = new JTextField(10);
							Nombres3.setFont(f2);
							Nombres3.setBounds(280, 30, 176, 23);
							panelIFModificacion.add(Nombres3);
							
							JLabel lblApePaterno3 = new JLabel("Apellido Paterno:");
							lblApePaterno3.setFont(f2);
							lblApePaterno3.setBounds(100, 70, 300, 25);
							panelIFModificacion.add(lblApePaterno3);
							
							JTextField ApePaterno3 = new JTextField(10);
							ApePaterno3.setFont(f2);
							ApePaterno3.setBounds(280, 70, 176, 23);
							panelIFModificacion.add(ApePaterno3);
							
							JLabel lblApeMaterno3 = new JLabel("Apellido Materno:");
							lblApeMaterno3.setFont(f2);
							lblApeMaterno3.setBounds(100, 110, 300, 25);
							panelIFModificacion.add(lblApeMaterno3);
							
							JTextField ApeMaterno3 = new JTextField(10);
							ApeMaterno3.setFont(f2);
							ApeMaterno3.setBounds(280, 110, 176, 23);
							panelIFModificacion.add(ApeMaterno3);
							
							JLabel lblSemestre3 = new JLabel("Semestre:");
							lblSemestre3.setFont(f2);
							lblSemestre3.setBounds(100, 150, 300, 25);
							panelIFModificacion.add(lblSemestre3);
							
							JSpinner sprSemestre2 = new JSpinner();
							sprSemestre2.setAutoscrolls(true);
							sprSemestre2.setBounds(280, 150, 176, 23);
							panelIFModificacion.add(sprSemestre2);
							
							JLabel lblCarrera3 = new JLabel("Carrera:");
							lblCarrera3.setFont(f2);
							lblCarrera3.setBounds(100, 190, 300, 25);
							panelIFModificacion.add(lblCarrera3);
							
							JComboBox<String> cboCarrera3 = new JComboBox<String>();
							cboCarrera3.addItem("Elige Carrera...");
							cboCarrera3.addItem("ISC");
							cboCarrera3.addItem("IIA");
							cboCarrera3.addItem("IM");
							cboCarrera3.addItem("LA");
							cboCarrera3.addItem("LCP");
							cboCarrera3.setFont(f1);
							cboCarrera3.setBounds(280, 190, 175, 23);
							panelIFModificacion.add(cboCarrera3);
							
							JButton btnEliminar2 = new JButton("Modificar");
							btnEliminar2.setFont(f2);
							btnEliminar2.setBounds(480, 45, 135, 25);
							panelIFModificacion.add(btnEliminar2);
							
							JButton btnRestablecer3 = new JButton("Reestablecer");
							btnRestablecer3.setFont(f2);
							btnRestablecer3.setBounds(480, 170, 135, 25);
							panelIFModificacion.add(btnRestablecer3);
							
							JButton btnCancelar3 = new JButton("Cancelar");
							btnCancelar3.setFont(f2);
							btnCancelar3.setBounds(480, 110, 135, 25);
							btnCancelar3.addActionListener(this);
							panelIFModificacion.add(btnCancelar3);
							
						internalFrameModificacionesAlumno.add(panelIFModificacion);
							
							JPanel paneltabla3 = new JPanel();
								paneltabla3.setLayout(null);
								paneltabla3.setPreferredSize(new Dimension(700, 190));
								paneltabla3.setBounds(0, 410, 700, 152);
								
								String columnas3[] = {"Num Control", "Nombres", "Primer Ap", "Segundo Ap", "Edad", "Semestre",
											"Carrera"};
								String datos3[][] = {{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
											{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
											{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
											{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
											{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""}};
								
								JTable table3 = new JTable(datos, columnas);
								JScrollPane scroll3 = new JScrollPane(table3);
								scroll3.setBounds(5, 9, 678, 135);
							paneltabla3.add(scroll3);
						
						internalFrameModificacionesAlumno.add(paneltabla3);
						desktopPane.add(internalFrameModificacionesAlumno);
						//---------------------------------------------------------------------Consultas
						internalFrameConsultaAlumno = new JInternalFrame();
							internalFrameConsultaAlumno.setDefaultCloseOperation(HIDE_ON_CLOSE);
							internalFrameConsultaAlumno.setLayout(null);
							internalFrameConsultaAlumno.setSize(700, 595);
							internalFrameConsultaAlumno.setTitle("CONSULTAS");
							internalFrameConsultaAlumno.setClosable(true);
							internalFrameConsultaAlumno.setIconifiable(true);
							internalFrameConsultaAlumno.setMaximizable(true);
							internalFrameConsultaAlumno.setResizable(true);
							
							JPanel panelIFConsultas1 = new JPanel();
								panelIFConsultas1.setBackground(new Color(0, 0, 255));
								panelIFConsultas1.setLayout(null);
								panelIFConsultas1.setPreferredSize(new Dimension(700, 190));
								panelIFConsultas1.setBounds(0, 0, 700, 80);
								
								JLabel lbl4 = new JLabel("CONSULTAS ALUMNOS");
								lbl4.setFont(new Font("Arial", Font.BOLD, 24));
								lbl4.setForeground(new Color(255, 255, 255));
								lbl4.setBounds(30, 30, 400, 20);
						
							panelIFConsultas1.add(lbl4);
							internalFrameConsultaAlumno.add(panelIFConsultas1);
						
						JPanel panelIFConsultas = new JPanel();
							panelIFConsultas.setLayout(null);
							panelIFConsultas.setPreferredSize(new Dimension(700, 190));
							panelIFConsultas.setBounds(0, 80, 700, 330);
							
							JLabel lblSeleccion = new JLabel("Selecciona Criterio de Busqueda:");
							lblSeleccion.setFont(f2);
							lblSeleccion.setBounds(10, 15, 300, 25);
							panelIFConsultas.add(lblSeleccion);
							
							JRadioButton rbtTodos = new JRadioButton("Todos");
							rbtTodos.setFont(f2);
							rbtTodos.setBounds(20, 70, 80, 25);
							panelIFConsultas.add(rbtTodos);
							
							JRadioButton rbtNombre = new JRadioButton("Nombre:");
							rbtNombre.setFont(f2);
							rbtNombre.setBounds(100, 70, 100, 25);
							panelIFConsultas.add(rbtNombre);
							
							JTextField Nombres4 = new JTextField(10);
							Nombres4.setFont(f2);
							Nombres4.setBounds(280, 70, 176, 23);
							panelIFConsultas.add(Nombres4);
							
							JRadioButton rbtApePaterno = new JRadioButton("Apellido Paterno:");
							rbtApePaterno.setFont(f2);
							rbtApePaterno.setBounds(100, 120, 180, 25);
							panelIFConsultas.add(rbtApePaterno);
							
							JTextField ApePaterno4 = new JTextField(10);
							ApePaterno4.setFont(f2);
							ApePaterno4.setBounds(280, 120, 176, 23);
							panelIFConsultas.add(ApePaterno4);
							
							JRadioButton rbtApeMaterno = new JRadioButton("Apellido Materno:");
							rbtApeMaterno.setFont(f2);
							rbtApeMaterno.setBounds(100, 170, 180, 25);
							panelIFConsultas.add(rbtApeMaterno);
							
							JTextField ApeMaterno4 = new JTextField(10);
							ApeMaterno4.setFont(f2);
							ApeMaterno4.setBounds(280, 170, 176, 23);
							panelIFConsultas.add(ApeMaterno4);
							
							JRadioButton rbtSemestre = new JRadioButton("Semestre:");
							rbtSemestre.setFont(f2);
							rbtSemestre.setBounds(100, 220, 180, 25);
							panelIFConsultas.add(rbtSemestre);
							
							JSpinner sprSemestre3 = new JSpinner();
							sprSemestre3.setAutoscrolls(true);
							sprSemestre3.setBounds(280, 220, 176, 23);
							panelIFConsultas.add(sprSemestre3);
							
							//-------------------------------------------------------------MODIFICACION EXAMEN
							JLabel lbCarrera = new JLabel("Carrera:");
							lbCarrera.setFont(f2);
							lbCarrera.setBounds(90, 270, 180, 25);
							panelIFConsultas.add(lbCarrera);
							
							JPanel panelNew = new JPanel();
							panelNew.setBounds(200, 270, 280, 100);
							ButtonGroup bGCarrera = new ButtonGroup();
								r1 = new JRadioButton("ISC");
								r1.addActionListener(this);
								bGCarrera.add(r1);
								panelNew.add(r1);
								
								r2 = new JRadioButton("IIA");
								r2.addActionListener(this);
								bGCarrera.add(r2);
								panelNew.add(r2);
								
								r3 = new JRadioButton("LA");
								r3.addActionListener(this);
								bGCarrera.add(r3);
								panelNew.add(r3);
								
								r4 = new JRadioButton("IM");
								r4.addActionListener(this);
								bGCarrera.add(r4);
								panelNew.add(r4);
								
								r5 = new JRadioButton("LCP");
								r5.addActionListener(this);
								bGCarrera.add(r5);
								panelNew.add(r5);
								//-----------------------------------------------
								b1 = new JButton("|<");
								b1.addActionListener(this);
								b1.setBounds(50, 186, 10, 10);
								panelNew.add(b1);
								
								b2 = new JButton("<");
								b2.addActionListener(this);
								b2.setBounds(70, 186, 10, 10);
								panelNew.add(b2);
								
								JTextField caja1 = new JTextField(3);
								caja1.addActionListener(this);
								caja1.setBounds(100, 186, 50, 10);
								panelNew.add(caja1);
								
								b3 = new JButton(">|");
								b3.addActionListener(this);
								b3.setBounds(150, 186, 10, 10);
								panelNew.add(b3);
								
								b4 = new JButton(">");
								b4.addActionListener(this);
								b4.setBounds(200, 186, 10, 10);
								panelNew.add(b4);
							
							panelIFConsultas.add(panelNew);
							//--------------------------------------------------------
							
							JButton btnBuscar3 = new JButton();
							btnBuscar3.setBounds(480, 85, 135, 45);
							panelIFConsultas.add(btnBuscar3);
							
							JButton btnRestablecer4 = new JButton("Restablecer");
							btnRestablecer4.setFont(f2);
							btnRestablecer4.setBounds(480, 170, 135, 35);
							panelIFConsultas.add(btnRestablecer4);
							
							JButton btnCancelar4 = new JButton("Cancelar");
							btnCancelar4.setFont(f2);
							btnCancelar4.setBounds(480, 245, 135, 35);
							btnCancelar4.addActionListener(this);
							panelIFConsultas.add(btnCancelar4);
							
						internalFrameConsultaAlumno.add(panelIFConsultas);
						
						JPanel panelTabla4 = new JPanel();
							panelTabla4.setLayout(null);
							panelTabla4.setPreferredSize(new Dimension(700, 190));
							panelTabla4.setBounds(0, 410, 700, 152);
							
							String columnas4[] = {"Num Control", "Nombres", "Primer Ap", "Segundo Ap", "Edad", "Semestre",
									"Carrera"};
							String datos4[][] = {{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
									{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
									{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
									{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
									{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""}};
							
							JTable table4 = new JTable(datos, columnas);
							JScrollPane scroll4 = new JScrollPane(table4);
							scroll4.setBounds(5, 9, 678, 135);
						panelTabla4.add(scroll4);

						internalFrameConsultaAlumno.add(panelTabla4);
						desktopPane.add(internalFrameConsultaAlumno);
						
			add(desktopPane, BorderLayout.CENTER);
					
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == itemAltaAlumno) {
			internalFrameAltaAlumno.setVisible(true);
			actualizarTablas(tablaA);
		} 
		if(e.getSource() == btnAgregar) {
			String num = cajaNumControl.getText();
			String nom = cajaNom.getText();
			String ap1 = cajaApePaterno.getText();
			String ap2 = cajaApeMaterno.getText();
			int sem = comboSemestre.getSelectedIndex();
			String carr = (String) comboCarrera.getSelectedItem();
			Alumno a1 = new Alumno(num, nom, ap1, ap2,(byte) sem,(byte) 19, carr);
			new AlumnoDAO().agregarAlumno(a1);
			actualizarTablas(tablaA);
			
		}/*else if(e.getSource()==itemConsultaAlumno) {
			internalFrameConsultaAlumno.setVisible(true);
		}else*/
		if(e.getSource() == itemModificaciones) {
			internalFrameModificacionesAlumno.setVisible(true);
		}
		//if(e.getSource() == )
			
	}
	public void actualizarTablas(JTable tabla) {
		String controlador = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost/BD_Escuela1?useTimezone=true&serverTimezone=UTC";
		String consulta = "SELECT * FROM alumnos";
		ResultSetTableModel modeloDatos = null;
		try {
			modeloDatos = new ResultSetTableModel(controlador, url,consulta);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		tabla.setModel(modeloDatos);
	}
	
	
}

public class VentanaInicio {
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VentanaPrincipal();
			}
			
		});
		Alumno a1 = new Alumno("3","3","3","3",(byte) 3,(byte) 3, "3");
		AlumnoDAO aDAO = new AlumnoDAO();
		if(aDAO.agregarAlumno(a1)) {
			System.out.println("VICTORIUSS !!!!!");
		}else {
			System.out.println("NEL, NO SE HACE");
		}

		System.out.println(aDAO.buscarAlumno("1"));
		System.out.println(aDAO.buscarAlumnos("1"));
	}
}


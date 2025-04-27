import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Ejercicio3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtHoras;
	private JPanel panelSistemaO;
	private JLabel lblSistemaO;
	private JRadioButton rdbtnWindows;
	private JRadioButton rdbtnMac;
	private JRadioButton rdbtnLinux;
	private JPanel panelEspecialidad;
	private JLabel lblEspecialidad;
	private JCheckBox chckbxProgramacion;
	private JCheckBox chckbxDisenio;
	private JCheckBox chckbxAdministracion;
	private JLabel lblCantidadH;

	public Ejercicio3() {
		setTitle("SELECCION MULTIPLE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 455, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelSistemaO = new JPanel();
		panelSistemaO.setBounds(10, 11, 414, 68);
		panelSistemaO.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		contentPane.add(panelSistemaO);
		panelSistemaO.setLayout(null);
		
		lblSistemaO = new JLabel("ELIGE UN SISTEMA OPERATIVO");
		lblSistemaO.setBounds(10, 27, 161, 14);
		panelSistemaO.add(lblSistemaO);
		
		rdbtnWindows = new JRadioButton("WINDOWS");
		rdbtnWindows.setBounds(177, 23, 86, 23);
		panelSistemaO.add(rdbtnWindows);
		
		rdbtnMac = new JRadioButton("MAC");
		rdbtnMac.setBounds(265, 23, 54, 23);
		panelSistemaO.add(rdbtnMac);
		
		rdbtnLinux = new JRadioButton("LINUX");
		rdbtnLinux.setBounds(321, 23, 62, 23);
		panelSistemaO.add(rdbtnLinux);
		
		panelEspecialidad = new JPanel();
		panelEspecialidad.setBounds(10, 90, 414, 95);
		panelEspecialidad.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		contentPane.add(panelEspecialidad);
		panelEspecialidad.setLayout(null);
		
		lblEspecialidad = new JLabel("ELIGE UNA ESPECIALIDAD");
		lblEspecialidad.setBounds(10, 45, 137, 14);
		panelEspecialidad.add(lblEspecialidad);
		
		chckbxProgramacion = new JCheckBox("PROGRAMACION");
		chckbxProgramacion.setBounds(174, 7, 119, 23);
		panelEspecialidad.add(chckbxProgramacion);
		
		chckbxAdministracion = new JCheckBox("ADMINISTRACION");
		chckbxAdministracion.setBounds(174, 33, 117, 23);
		panelEspecialidad.add(chckbxAdministracion);
		
		chckbxDisenio = new JCheckBox("DISEÑO GRAFICO");
		chckbxDisenio.setBounds(174, 59, 119, 23);
		panelEspecialidad.add(chckbxDisenio);
		
		lblCantidadH = new JLabel("CANTIDAD DE HORAS EN EL COMPUTADOR:");
		lblCantidadH.setBounds(20, 214, 255, 14);
		contentPane.add(lblCantidadH);
		
		txtHoras = new JTextField();
		txtHoras.setBounds(285, 211, 139, 20);
		contentPane.add(txtHoras);
		txtHoras.setColumns(10);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setBounds(285, 242, 139, 23);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionar();
			}
		});
		contentPane.add(btnAceptar);
	}
	
	public void seleccionar() {
		 String sistema = "";
         if (rdbtnWindows.isSelected()) {
             sistema = "Windows";
         } else if (rdbtnMac.isSelected()) {
             sistema = "Mac";
         } else if (rdbtnLinux.isSelected()) {
             sistema = "Linux";
         }
         
         String especialidades = "";
         if (chckbxProgramacion.isSelected()) {
             especialidades += "- Programación ";
         }
         if (chckbxAdministracion.isSelected()) {
             especialidades += "- Administración ";
         }
         if (chckbxDisenio.isSelected()) {
             especialidades += "- Diseño Gráfico ";
         }
         
         String horas = txtHoras.getText();
         
         String mensaje = sistema + " " + especialidades + "- " + horas + " Hs";
         
         JOptionPane.showMessageDialog(null, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
	}
}

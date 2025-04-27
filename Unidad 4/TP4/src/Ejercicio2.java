import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class Ejercicio2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNotaUno;
	private JTextField txtNotaDos;
	private JTextField txtNotaTres;
	private JTextField txtPromedio;
	private JTextField txtCondicion;
	private JLabel lblNotaUno;
	private JLabel lblNotaDos;
	private JLabel lblNotaTres;
	private JLabel lblPromedio;
	private JLabel lblCondicion;
	private JComboBox<String> cBoxTps;


	public Ejercicio2() {
		setTitle("PROMEDIO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 416, 341);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelNota = new JPanel();
		panelNota.setBounds(10, 11, 238, 175);
		panelNota.setBorder(new TitledBorder(null, "Notas del estudiante", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		contentPane.add(panelNota);
		panelNota.setLayout(null);
		
		lblNotaUno = new JLabel("NOTA 1:");
		lblNotaUno.setBounds(10, 27, 46, 14);
		panelNota.add(lblNotaUno);
		
		txtNotaUno = new JTextField();
		txtNotaUno.setBounds(66, 24, 154, 20);
		panelNota.add(txtNotaUno);
		txtNotaUno.setColumns(10);
		
		lblNotaDos = new JLabel("NOTA 2:");
		lblNotaDos.setBounds(10, 62, 46, 14);
		panelNota.add(lblNotaDos);
		
		txtNotaDos = new JTextField();
		txtNotaDos.setBounds(66, 59, 154, 20);
		panelNota.add(txtNotaDos);
		txtNotaDos.setColumns(10);
		
		lblNotaTres = new JLabel("NOTA 3:");
		lblNotaTres.setBounds(10, 98, 46, 14);
		panelNota.add(lblNotaTres);
		
		txtNotaTres = new JTextField();
		txtNotaTres.setBounds(66, 95, 154, 20);
		panelNota.add(txtNotaTres);
		txtNotaTres.setColumns(10);
		
		JLabel lblTps = new JLabel("TPS:");
		lblTps.setBounds(10, 140, 46, 14);
		panelNota.add(lblTps);
		
		cBoxTps = new JComboBox<String>(new String[] {"APROBADO", "DESAPROBADO"});
		cBoxTps.setBounds(66, 136, 154, 22);
		panelNota.add(cBoxTps);
		
		JPanel panelPromedio = new JPanel();
		panelPromedio.setBounds(10, 197, 238, 102);
		panelPromedio.setBorder(new TitledBorder(null, "Notas del estudiante", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		contentPane.add(panelPromedio);
		panelPromedio.setLayout(null);
		
		lblPromedio = new JLabel("PROMEDIO:");
		lblPromedio.setBounds(10, 29, 76, 14);
		panelPromedio.add(lblPromedio);
		
		txtPromedio = new JTextField();
		txtPromedio.setBounds(90, 26, 126, 20);
		panelPromedio.add(txtPromedio);
		txtPromedio.setColumns(10);
		
		lblCondicion = new JLabel("CONDICION:");
		lblCondicion.setBounds(10, 64, 76, 14);
		panelPromedio.add(lblCondicion);
		
		txtCondicion = new JTextField();
		txtCondicion.setText("");
		txtCondicion.setBounds(90, 61, 126, 20);
		panelPromedio.add(txtCondicion);
		txtCondicion.setColumns(10);
		
		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.setBounds(258, 54, 131, 36);
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularCondicion();
			}
		});
		contentPane.add(btnCalcular);
		
		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.setBounds(258, 101, 131, 36);
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarForm();
			}
		});
		contentPane.add(btnNuevo);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(258, 148, 131, 36);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarVentana();
			}
		});
		contentPane.add(btnSalir);

	}
	
	 public void calcularCondicion() {
	        try {
	            double nota1 = Double.parseDouble(txtNotaUno.getText());
	            double nota2 = Double.parseDouble(txtNotaDos.getText());
	            double nota3 = Double.parseDouble(txtNotaTres.getText());
	            String estadoTp = (String) cBoxTps.getSelectedItem();
	            
	            if (!notaValida(nota1) || !notaValida(nota2) || !notaValida(nota3)) {
	                JOptionPane.showMessageDialog(null, "Las notas deben estar entre 1 y 10.", "Error", JOptionPane.ERROR_MESSAGE);
	                return;
	            }

	            double promedio = (nota1 + nota2 + nota3) / 3;
	            txtPromedio.setText(String.format("%.2f", promedio));

	            String condicion;
	            if (estadoTp.equals("DESAPROBADO") || nota1 < 6 || nota2 < 6 || nota3 < 6) {
	                condicion = "LIBRE";
	            } else if (nota1 >= 8 && nota2 >= 8 && nota3 >= 8) {
	                condicion = "PROMOCIONADO";
	            } else {
	                condicion = "REGULAR";
	            }
	            txtCondicion.setText(condicion);

	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(null, "Por favor, ingrese notas válidas (números).", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	 
	 private boolean notaValida(double nota) {
		    return nota >= 1 && nota <= 10;
		}
	 
	 public void limpiarForm() {
	        txtNotaUno.setText("");
	        txtNotaDos.setText("");
	        txtNotaTres.setText("");
	        txtPromedio.setText("");
	        txtCondicion.setText("");
	        cBoxTps.setSelectedIndex(0);
	    }
	 
	 public void cerrarVentana() {
	        dispose();
	    }
}

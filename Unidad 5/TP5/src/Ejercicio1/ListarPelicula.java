package Ejercicio1;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Comparator;
import java.util.TreeSet;

import javax.swing.JList;

public class ListarPelicula extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JScrollPane scrollPane;
	private JList<Pelicula> listPeliculas;
	private DefaultListModel<Pelicula> listModel;

	public ListarPelicula() {
		dibujarPanel();
	}
	
	public void dibujarPanel() {
		setLayout(null);
		
		scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        scrollPane.setPreferredSize(new Dimension(220, 160));
        gbc_scrollPane.gridheight = 3;
        gbc_scrollPane.gridwidth = 3;
        gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 1;
        gbc_scrollPane.gridy = 1;
        add(scrollPane, gbc_scrollPane);
		
		JLabel lblNewLabel = new JLabel("PELICULAS:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 127, 90, 14);
		add(lblNewLabel);
		
		listPeliculas = new JList<Pelicula>();
		listPeliculas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		listPeliculas.setBounds(110, 11, 330, 278);
		add(listPeliculas);
	}
	
	public void setDefaultListModel(DefaultListModel<Pelicula> lista)
	{
		TreeSet<Pelicula> peliculasOrdenadas = new TreeSet<>(Comparator.comparing(p -> p.getNombre().toLowerCase()));
		 
        for (int i = 0; i < lista.size(); i++) {
            peliculasOrdenadas.add(lista.get(i));
        }
 
        DefaultListModel<Pelicula> modeloOrdenado = new DefaultListModel<>();
        for (Pelicula p : peliculasOrdenadas) {
            modeloOrdenado.addElement(p);
        }
 
        this.listModel = modeloOrdenado;
		listPeliculas.setModel(this.listModel);
	}
}

package aplicacion;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InterficieGrafica extends JFrame {
	  public InterficieGrafica() {
	    // Configuración de la ventana
	    setTitle("Práctica 3");
	    setSize(400, 300);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);

	    // Creación de los botones de opción
	    JRadioButton opcion1 = new JRadioButton("Cargar fichero");
	    JRadioButton opcion2 = new JRadioButton("Guardar fichero");
	    ButtonGroup grupoOpciones = new ButtonGroup();
	    grupoOpciones.add(opcion1);
	    grupoOpciones.add(opcion2);

	    // Creación del botón "Cargar fichero"
	    JButton botonCargar = new JButton(new AbstractAction("Cargar") {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	        // Llamada a la rutina "Carga programa"
	        //cargaPrograma();
	      }
	    });

	    // Creación del botón "Guardar fichero"
	    JButton botonGuardar = new JButton(new AbstractAction("Guardar") {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	        // Mostrar ventana de diálogo que pida un texto al usuario
	        String texto = JOptionPane.showInputDialog(null, "Introduce un texto:");
	        // Llamada a la rutina "Guarda programa"
	        //guardaPrograma(texto);
	      }
	    });

	    // Añadir componentes a la ventana utilizando un layout adecuado
	    setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    c.gridx = 0;
	    c.gridy = 0;
	    c.anchor = GridBagConstraints.WEST;
	    add(opcion1, c);
	    c.gridx = 1;
	    c.gridy = 0;
	    c.anchor = GridBagConstraints.EAST;
	    add(botonCargar, c);
	    c.gridx = 0;
	    c.gridy = 2;
	    c.anchor = GridBagConstraints.WEST;
	    add(opcion2, c);
	    c.gridx = 1;
	    c.gridy = 1;
	    c.anchor = GridBagConstraints.EAST;
	    add(botonGuardar, c);
	  }


  public static void main(String[] args) {
    // Crear un objeto de la clase y mostrar la ventana
    InterficieGrafica ventana = new InterficieGrafica();
    ventana.setVisible(true);
  }
}
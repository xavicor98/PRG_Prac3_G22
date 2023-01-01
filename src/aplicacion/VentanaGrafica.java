package aplicacion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaGrafica extends JFrame {
	
	  public VentanaGrafica() {
	    super("Aplicación intercambios grupo G22");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new FlowLayout(FlowLayout.LEFT));
	    
	    JLabel usuario = new JLabel("Bienvenido, " +  pideNombre());
	    
	    //Boton para ver la lista de productos
	    JButton verLista = new JButton("Ver lista de productos");
	    verLista.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	          mostrarLista(); // Llamada a la función mostrarLista
	        }
	      });
	    		
	    //Boton para cambiar el nombre del usuario
	    JButton cambiarNombre = new JButton("CambiarNombre");
	    cambiarNombre.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	          usuario.setText("Bienvenido, "+pideNombre());
	        }
	      });
	    
	    add(usuario, BorderLayout.BEFORE_FIRST_LINE);
	    add(verLista, BorderLayout.EAST);
	    add(cambiarNombre, BorderLayout.SOUTH);	

	  }
	  
	 
	  private String pideNombre() {
		  String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
		    while(nombre == null || nombre.isEmpty())
		    	nombre = JOptionPane.showInputDialog("Porfavor, ingrese su nombre:");
		   
		   return nombre;
	  }
	  
	  private void mostrarLista() {
		  
	  }
	  
}
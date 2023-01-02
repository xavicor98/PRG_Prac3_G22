package aplicacion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import datos.ListaPeticiones;
import datos.ListaProductos;
import datos.ListaUsuarios;
import datos.Productos;
import excepciones.ListaLlena;

public class VentanaGrafica extends JFrame {
	
	ListaProductos listaProductos = new ListaProductos();
	ListaUsuarios listaUsuarios = new ListaUsuarios();
	ListaPeticiones listaPeticiones = new ListaPeticiones();

	 //TODO revisar excepciones
	  public VentanaGrafica() throws IOException, ListaLlena {
		  super("Aplicación intercambios grupo G22");
		 
		  /*
		   * hace falta tener los archivos
		 //Cargar desde un archivo
		 listaProductos.LeerBien();//LeerBien? wtf
		 //Cargar Usuarios
		 listaPeticiones.leerFichero(getName());
		 */
		  for(int i=0; i<50;i++) {
			  Productos producto = new Productos("Producto"+i, ""+i, null);
			  listaProductos.AnadirProducto(producto);
		  }
		//Inicializar ventana
	    
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
		    JOptionPane optionPane = new JOptionPane(obtenerOfertas(), JOptionPane.PLAIN_MESSAGE);
		    optionPane.createDialog("Lista de ofertas").setVisible(true);
	  }
	  
	  private String obtenerOfertas() {
		  return listaProductos.getInfoLista();
	  }
	  
}
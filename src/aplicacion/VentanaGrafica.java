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
	
	//TODO generar un archivo para hacer juego de pruebasm revisar clase usuarios y clase productos
	
	ListaProductos listaProductos = new ListaProductos();
	ListaUsuarios listaUsuarios = new ListaUsuarios();
	ListaPeticiones listaPeticiones = new ListaPeticiones();
	String nombreUsuario;
	
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
		  //Creo temporalmente una lista de productos
		  for(int i=0; i<50;i++) {
			  Productos producto = new Productos("Producto:"+i, ""+i, null);
			  listaProductos.AnadirProducto(producto);
		  }
		  
		//Inicializar ventana<	    
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new BorderLayout());	   
	    
	    JLabel usuario = new JLabel("Bienvenido, " +  pideNombre()+", Seleccione un producto de la lista");
	    
	    JComboBox<String> desplegableProductos = new JComboBox<>();
	    String[] stringProductos = obtenerOfertas();
	   
	    for(int i=0; i<stringProductos.length; i++)
	    	desplegableProductos.addItem(stringProductos[i]);
	    		
	    //Boton para cambiar el nombre del usuario
	    JButton cambiarNombre = new JButton("CambiarNombre");
	    cambiarNombre.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	          usuario.setText("Bienvenido, "+pideNombre());
	        }
	      });
	    
	    //Añadir listado de productos que tiene el usuario actual
	    JComboBox<String> listadoProductos = new JComboBox<>();
	    
	    stringProductos = obtenerProductosUsuario();
	    
	    for(int i=0; i<stringProductos.length; i++)
	    	listadoProductos.addItem(stringProductos[i]);
	    
	    add(listadoProductos);
	    add(usuario, BorderLayout.PAGE_START);
	    add(cambiarNombre, BorderLayout.PAGE_END);	
	    add(desplegableProductos, BorderLayout.LINE_START);
	    
	  }
	  
	 
	  private String pideNombre() {
		  String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
		    while(nombre == null || nombre.isEmpty())
		    	nombre = JOptionPane.showInputDialog("Porfavor, ingrese su nombre:");
		    	nombreUsuario = nombre;
		   return nombre;
	  }
	  

	  
	  private String[] obtenerOfertas() {
		  return listaProductos.getInfoLista().split(";");
	  }
	  
	  private String[] obtenerProductosUsuario() {
		  return listaUsuarios.listaProductos(nombreUsuario).split(";");
	  }
}
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
	String[] listaProductosUsuario;
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
	    setLayout(new GridLayout(10, 10));	   
	    
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

	    add(usuario);
	    add(listadoProductos);
	    add(cambiarNombre);	
	    add(desplegableProductos);
	    
	   //He puesto estos valores porque no tengo la lista de productos de cada usuario

	    String[]intercambiosUsuario = obtenerIntercambiosUsuario();
	    //Aqui recibiria los intercambios que tiene el usuario y lo pondría en cada botón
	    int nlineas= intercambiosUsuario.length/2/4;
	    for(int i=0; i<4;i++) {
	    	for(int j=0; j<3;j++) {
	    		JButton boton = new JButton(j+"");
	    		boton.addActionListener(new ActionListener() {
	    	        @Override
	    	        public void actionPerformed(ActionEvent e) {
	    	        	boton.setBackground(Color.blue);
	    	        }
	    	      });
	    		this.add(boton);
	    	}
	    }
	    
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
	  
	  private String[] obtenerIntercambiosUsuario() {
		  return listaUsuarios.listaPeticiones(nombreUsuario).split(";");
	  }
}
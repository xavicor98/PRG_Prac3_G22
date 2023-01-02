package aplicacion;
import java.io.IOException;
import java.util.Scanner;
import datos.*;
import excepciones.ListaLlena;

/* Programador: Aitor Bernal Alcaraz */
public class main {
	static Scanner key = new Scanner(System.in);
	public static void main(String[] args) throws IOException, ListaLlena {
		int opcion;
		ListaProductos LP = new ListaProductos();
		
		for(int i=0; i<50; i++) {
			  Productos producto = new Productos("Producto"+i, ""+i, null);
			  LP.AnadirProducto(producto);
		}

/*
		mostraMenu();
		opcion = Integer.parseInt(key.nextLine());
		boolean sal = false;
		while (!sal) {
			switch (opcion) {
			case 1:
				opcion1(LP);
				break;
			case 2:
				opcion2(LP);
				break;
			case 3:
				opcion3(LP);
				break;
			case 4:
				opcion4();
				break;
			case 5:
				opcion5();
				break;
			case 6:
				opcion6(LP);
				break;
			case 7:
				opcion7(LP);
				break;
			case 8:
				opcion8(LP);
				break;
			case 9:
				salir(LP);
				sal = true;
				break;
				}
			if (!sal) {
				mostraMenu();
				opcion = Integer.parseInt(key.nextLine()); 
				}
			}
*/
		}
		/* Habra submenus dentro del propio menu, aqui se crean todos los menus */
		public static void mostraMenu() {
			System.out.println("\n\nOpciones del menu:");
			System.out.println("\n\t1. An1adir");
			System.out.println("\t2. Listar");
			System.out.println("\t3. Mostrar");
			System.out.println("\t4. Aceptar o rechazar una peticion de intercambio");
			System.out.println("\t5. Dar de alta un usuario");
			System.out.println("\t6. Dar de baja un bien");
			System.out.println("\t7. Desactivar un servicio");
			System.out.println("\t8. Cargar los datos");
			System.out.println("\t9. Salir");
			System.out.print("\n\t\t\tIndica una opcion:\n");
		}
		
		public static void mostraSubMenu1() {
			System.out.println("\n\nOpciones del menu:");
			System.out.println("\n\t1. Añadir un servicio");
			System.out.println("\t2. Añadir un bien");
			System.out.println("\t3. Añadir una peticion de intercambio");
			System.out.println("\t4. Atras");
			System.out.print("\n\t\t\tIndica una opcion:\n");
		}
		
		public static void mostraSubMenu2() {
			System.out.println("\n\nOpciones del menu:");
			System.out.println("\n\t1. Listar los datos de qualquier lista");
			System.out.println("\t2. Listar los servicios activos");
			System.out.println("\t3. Listar los bienes");
			System.out.println("\t4. Atras");
			System.out.print("\n\t\t\tIndica una opcion:\n");
		}
		
		public static void mostraSubMenu3() {
			System.out.println("\n\nOpciones del menu:");
			System.out.println("\n\t1. Mostrar las peticiones de intercambio pendientes");
			System.out.println("\t2. Mostrar las peticiones de intercambio aceptadas");
			System.out.println("\t3. Mostrar las peticiones de intercambio rechazadas");
			System.out.println("\t4. Mostrar los usuarios que tienen valoraciones superiores a un valor");
			System.out.println("\t5. Mostrar el servicio con el que se han hecho mas intercambios");
			System.out.println("\t6. Atras");
			System.out.print("\n\t\t\tIndica una opcion:\n");
		}
		/* En la opcion 1 mostrara el primer submenu */
		public static void opcion1(ListaProductos LP) throws ListaLlena {
			int opcion;
			mostraSubMenu1();
			opcion = Integer.parseInt(key.nextLine());
			while (opcion != 4) {
				switch (opcion) {
				case 1:
					opcion1_1(LP);
					break;
				case 2:
					opcion2_1(LP);
					break;
				case 3:
					opcion3_1();
					break;
				}
				mostraSubMenu1();
				opcion = Integer.parseInt(key.nextLine());
			}
		}
		/* En la opcion 2 mostrara el segundo submenu */
		public static void opcion2(ListaProductos LP) {
			int opcion;
			mostraSubMenu2();
			opcion = Integer.parseInt(key.nextLine());
			while (opcion != 4) {
				switch (opcion) {
				case 1:
					opcion1_2(LP);
					break;
				case 2:
					opcion2_2(LP);
					break;
				case 3:
					opcion3_2(LP);
					break;
				}
				mostraSubMenu2();
				opcion = Integer.parseInt(key.nextLine());
			}
		}
		/* En la opcion 3 mostrara el tercer submenu */
		public static void opcion3(ListaProductos LP) {
			int opcion;
			mostraSubMenu3();
			opcion = Integer.parseInt(key.nextLine());
			while (opcion != 6) {
				switch (opcion) {
				case 1:
					opcion1_3();
					break;
				case 2:
					opcion2_3();
					break;
				case 3:
					opcion3_3();
					break;
				case 4:
					opcion4_3();
					break;
				case 5:
					opcion5_3();
					break;
				}
				mostraSubMenu3();
				opcion = Integer.parseInt(key.nextLine());
			}
		}
		
		public static void opcion4() {
			
		}
		
		public static void opcion5() {
			
		}
		/* En la opcion 6 se elimina un bien de la lista de bienes */
		public static void opcion6(ListaProductos LP) {
			System.out.println("Que bien quieres eliminar?");
			String b1 = key.nextLine();
			LP.BorrarBienes(b1);
		}
		/* En la opcion 7 se desactiva un servicio de la lista de servicios */
		public static void opcion7(ListaProductos LP) {
			System.out.println("Que servicio quieres desactivar?");
			String n=key.nextLine();
			LP.DesactivarServicio(n);
		}
		/* En la opcion 8 se mostraran todas las listas (falta por poner la lista de servicios)*/
		public static void opcion8(ListaProductos LP) throws IOException, ListaLlena {
			LP.LeerServicio();
			try {
			LP.LeerBien();
			}catch(NumberFormatException e) {
				
			}
		}
		/* En la opcion 1 del submenu 1 se crea un servicio en la lista de servicios */
		public static void opcion1_1(ListaProductos LP) throws ListaLlena {
			System.out.println("Introduce los datos del servicio\n");
			System.out.println("Nombre:\n");
			String n=key.nextLine();
			System.out.println("Descripcion:\n");
			String d=key.nextLine();
			System.out.println("Fecha de oferta: (Formato: d/m/a)\n");
			String f1=key.nextLine();
			System.out.println("Fecha vigencia: (Formato: d/m/a)\n");
			String f2=key.nextLine();
			String[] d1 = f1.split("/");
			String[] d2 = f2.split("/");
			Data D1 = new Data(Integer.parseInt(d1[0]),Integer.parseInt(d1[1]),Integer.parseInt(d1[2]));
			Data D2 = new Data(Integer.parseInt(d2[0]),Integer.parseInt(d2[1]),Integer.parseInt(d2[2]));
			Productos p1 = new Servicios(n, d, D1, D2);
			try {
			LP.AnadirProducto(p1);
			}catch(ListaLlena exc){
				System.out.println(exc.toString());
				LP.AmpliarLista(p1);
				System.out.println("Hemos ampliado el tama�o de la lista i a�adido "+p1.toString());
			
			}
		}
		
		/* En la opcion 2 del submenu 1 se crea un bien y se añade a la lista */
		public static void opcion2_1(ListaProductos LP) throws ListaLlena , NumberFormatException {
			System.out.println("Introduce los datos del bien\n");
			System.out.println("Nombre:\n");
			String n=key.nextLine();
			System.out.println("Descripcion:\n");
			String d=key.nextLine();
			System.out.println("Fecha de oferta: (Formato: d/m/a)\n");
			String f1=key.nextLine();
			System.out.println("Fecha vigencia: (Formato: d/m/a)\n");
			String f2=key.nextLine();
			System.out.println("Amplitud:\n");
			String am=key.nextLine();
			System.out.println("Altura:\n");
			String al=key.nextLine();
			System.out.println("Profundidad:\n");
			String pr=key.nextLine();
			System.out.println("Peso:\n");
			String ps=key.nextLine();
			String[] d1 = f1.split("/");
			String[] d2 = f2.split("/");
			Data D1 = new Data(Integer.parseInt(d1[0]),Integer.parseInt(d1[1]),Integer.parseInt(d1[2]));
			Data D2 = new Data(Integer.parseInt(d2[0]),Integer.parseInt(d2[1]),Integer.parseInt(d2[2]));
			Productos p1 = new Bienes(n, d, D1, Integer.parseInt(am), Integer.parseInt(al), Integer.parseInt(pr), Double.parseDouble(ps), D2);
			try {
			LP.AnadirProducto(p1);
			}catch(ListaLlena exc){
				System.out.println(exc.toString());
				LP.AmpliarLista(p1);
				System.out.println("Hemos ampliado el tama�o de la lista i a�adido "+p1.toString());
			}
		
		}
		
		public static void opcion3_1() {
			
		}
		/* En la opcion 1 del submenu 2 se listan la lista de bienes y la lista de servicios (falta poner la lista de peticiones)*/
		public static void opcion1_2(ListaProductos LP) {
			System.out.println(LP.toString());
			
		}
		/* En la opcion 2 del submenu 2 se listan los servicios activos de la lista de servicios */
		public static void opcion2_2(ListaProductos LP) {
			LP.MostrarProductos();
		}
		/* En la opcion 3 del submenu 3 se litan todos los bienes de la lista de bienes */
		public static void opcion3_2(ListaProductos LP) {
			LP.MostrarBienes();
		}
		/* Este metodo se usa para que cuando salgas del programa dar la opcion al usuario de que se guarde o no las modificaciones que haya hecho */
		public static void salir(ListaProductos LP) throws IOException {
			System.out.println("Quieres guardar?");
			String g = key.nextLine();
			if (g.equalsIgnoreCase("Si")) {
				LP.EscribeServicio();
				LP.EscribeBien();
			}
		}
		
		public static void opcion1_3() {
			
		}
		
		public static void opcion2_3() {
			
		}
		
		public static void opcion3_3() {
			
		}
		
		public static void opcion4_3() {
			
		}
		
		public static void opcion5_3() {
			
		}
	}
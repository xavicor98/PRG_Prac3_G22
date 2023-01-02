package aplicacion;

import java.io.IOException;

import excepciones.ListaLlena;

public class UsaVentanaGrafica {

	public static void main(String[] args) throws IOException, ListaLlena {
		
		VentanaGrafica ventana = new VentanaGrafica();
		ventana.setSize(300, 300);
		ventana.setVisible(true);
		
	}

}

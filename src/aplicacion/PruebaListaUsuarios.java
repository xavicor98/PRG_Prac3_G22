package aplicacion;

import java.io.IOException;
import java.util.Random;

import datos.Usuario;
import datos.ListaUsuarios;

public class PruebaListaUsuarios {

	public static void main(String[] args) throws IOException {
		
		ListaUsuarios listausuarios = new ListaUsuarios();
		
		for(int i=0; i<50;i++) {
			Usuario usuario = new Usuario(generateRandomString(), null, i);
			listausuarios.anadirUsuario(usuario);
		}
		
		listausuarios.escribeFichero("Usuarios");
	}

    public static String generateRandomString() {
        // Crea una instancia de la clase Random
        Random random = new Random();

        // Crea una cadena vacía
        String randomString = "";

        // Genera cuatro caracteres aleatorios y los añade a la cadena
        for (int i = 0; i < 4; i++) {
            char c = (char)(random.nextInt(26) + 'a');
            randomString += c;
        }

        return randomString;
    }
	
}

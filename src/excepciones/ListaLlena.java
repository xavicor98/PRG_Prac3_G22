package excepciones;
import datos.*;

public class ListaLlena extends Exception {
	public ListaLlena (Productos i) {
		
		super("No puedo a�adir "+i.toString()+" porque la lista esta llena");
		
	
	}

}

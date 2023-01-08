package datos;
	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.StringTokenizer;

import excepciones.ListaLlena;

	/* Programador: Eloi Cuevas Marcos */
	public class ListaProductos{
		private int numProductos=0;
		private Productos[] lista;
		
		public ListaProductos() {
			lista = new Productos[50];
		}
		
		public int getNumProductos() {
			return numProductos;
		}
		
		public String toString() {
			String aux;
				aux= "ListaProductos numProductos=" + numProductos;
				for (int j = 0; j < numProductos; j++) {
					aux = aux + "\n\tProducto: " + (j + 1) + "\t " + lista[j];
				}
			    return	aux;
		}
		
		public void AnadirProducto(Productos p1) throws ListaLlena {
			if (numProductos < lista.length) {
				lista[numProductos]=p1;
				numProductos++;
				
			}
			else throw new ListaLlena(p1);{
				
				
			}
		}
		public void AmpliarLista(Productos p1) {
			Productos[] aux = new Productos[lista.length * 2];
			for (int i = 0; i < numProductos; i++) 
				aux[i] = lista[i];
			lista = aux;
		
		int pos = numProductos-1;
		while ((pos >= 0) ) {
			lista[pos + 1] = lista[pos];
			pos--;
		} 
		if(lista[pos+1] instanceof Servicios) {
		lista[pos + 1] = ((Servicios)p1).copia();
		}
		
		if(lista[pos+1] instanceof Bienes) {
			lista[pos + 1] = ((Bienes)p1).copia();
			numProductos++;
			}
		numProductos++;
		}
		
	
		public void MostrarProductos() {
		int p=0;
		   while(p<numProductos) {
			   if(lista[p] instanceof Servicios) {	
				   if(((Servicios)lista[p]).getEstado().equalsIgnoreCase("Activo")){
				   System.out.println(((Servicios)lista[p]).toString());
			   }
			   
		   }
			   p++;
		}
		}
		public void MostrarBienes() {
			int p=0;
			   while(p<numProductos) {
				   if(lista[p] instanceof Bienes) {	
					 
					   System.out.println(((Bienes)lista[p]).toString());
				   }
				   p++;
			   }
			
			}
		
		public void BorrarBienes(String s) {
			int i = 0;
			while (i < numProductos) {
				if(lista[i] instanceof Bienes) {
				  if (lista[i].getId().equalsIgnoreCase(s)) {
					for (int j = i; j < numProductos - 1; j++) {
						lista[j] = lista[j + 1];
					
					}
					numProductos--;
				} 
					
			}
				i++;
			}
		}
		
		public void okay
		(String s) {
			int p=0;
			   while(p<numProductos) {
				   if(lista[p].getId().equalsIgnoreCase(s)) {	
					   if(lista[p] instanceof Servicios) {	
					    ((Servicios)lista[p]).setEstado("Inactivo");
				   }
				   }
				   p++;
			   }
		}
		
		public void EscribeServicio () throws IOException{
			BufferedWriter g=new BufferedWriter(new FileWriter("Servicios.txt"));
			int i=0;
			while(i<numProductos) {
				if (lista[i] instanceof Servicios) {
			String frase=lista[i].getId()+";"+lista[i].getDes()+";"+lista[i].getDataOf()+";"+((Servicios)lista[i]).getFechaVigencia()+";"+((Servicios)lista [i]).getIntercanvioPrevio()+";"+((Servicios)lista[i]).getEstado();
			System.out.println("Se ha escrito la linea: "+ lista[i]);
		    g.write(frase);
		    g.newLine();
		     
			}
				i++;
			}
			g.close();
			
		}
		
		public void LeerServicio () throws IOException, ListaLlena{
			BufferedReader f=new BufferedReader(new FileReader("Servicios.txt"));
			String frase ;
			frase=f.readLine();
			while (frase!=null) {
			System.out.println("Se ha leido la linea: "+ frase);
			StringTokenizer st = new StringTokenizer(frase,";");
			String id=st.nextToken();
			String des=st.nextToken();
			String[] S=st.nextToken().split("/");
			String[] S2=st.nextToken().split("/");
			boolean in=Boolean.parseBoolean(st.nextToken());
			String e=st.nextToken();
			Data d1=new Data(0,0,0000) ;
			Data d2 =new Data(0,0,0000 );
			d1.setData(Integer.parseInt(S[0]), Integer.parseInt(S[1]), Integer.parseInt(S[2]));
			d2.setData(Integer.parseInt(S2[0]), Integer.parseInt(S2[1]), Integer.parseInt(S2[2]));
			Productos p=new Servicios(id, des, d1, d2);
			
			try {
				AnadirProducto(p);
				((Servicios)p).setEstado(e);
				((Servicios)p).setIntercanvioPrevio(in);
				}catch(ListaLlena exc){
					System.out.println(exc.toString());
					AmpliarLista(p);
					System.out.println("Hemos ampliado el tamano de la lista i anadido "+p.toString());
				 
				}
		    
			
			
			 frase=f.readLine();
			}
			f.close();
			}
		
		public void EscribeBien () throws IOException{
			BufferedWriter g=new BufferedWriter(new FileWriter("Bienes.txt"));
			int i=0;
			while(i<numProductos) {
				if (lista[i] instanceof Bienes) {
				String frase=lista[i].getId()+";"+lista[i].getDes()+";"+lista[i].getDataOf()+";"+((Bienes)lista[i]).getDimension(0)+";"+((Bienes)lista[i]).getDimension(1)+";"+((Bienes)lista[i]).getDimension(2)+";"+((Bienes)lista[i]).getPeso()+";"+((Bienes)lista[i]).getIntercambio();
				System.out.println("Se ha escrito la linea: "+ lista[i]);
			    g.write(frase);
			    g.newLine();
				}
			    i++;
			}
			g.close();	
		}
		
		public void LeerBien () throws IOException, ListaLlena{
			BufferedReader f=new BufferedReader(new FileReader("Bienes.txt"));
			String frase ;
			int d1=0,d2=0,d3=0;
			double p=0;
			frase=f.readLine();
			while (frase!=null) {
				System.out.println("Se ha leido la linea: "+ frase);
				StringTokenizer st = new StringTokenizer(frase,";");
				String id=st.nextToken();
				String des=st.nextToken();
				String[] S=st.nextToken().split("/");
				try {
				d1=Integer.parseInt(st.nextToken());
			     d2=Integer.parseInt(st.nextToken());
				 d3=Integer.parseInt(st.nextToken());
				  p=Double.parseDouble(st.nextToken());
				}catch(NumberFormatException e) {
					System.out.println("Error de formato introducido, no se puede anadir:"+e);
				}
				
				String[] S2=st.nextToken().split("/");
				Data D1=new Data(0,0,0000) ;
				Data D2 =new Data(0,0,0000 );
				D1.setData(Integer.parseInt(S[0]), Integer.parseInt(S[1]), Integer.parseInt(S[2]));
				D2.setData(Integer.parseInt(S2[0]), Integer.parseInt(S2[1]), Integer.parseInt(S2[2]));
				Productos B=new Bienes(id, des, D1, d1, d2, d3, p, D2);
				
				try {
					AnadirProducto(B);
					}catch(ListaLlena exc){
						System.out.println(exc.toString());
						AmpliarLista(B);
						System.out.println("Hemos ampliado el tama�o de la lista i a�adido "+B.toString());
					}
				
				
				frase=f.readLine();
			}
			f.close();
		}
		
		public String getInfoLista() {
			String listaProductos = "";
			
			for(int i=0; i<numProductos; i++) {
				listaProductos += (lista[i].getId()+"\n"+
						lista[i].getDes()+";\n"+
						"\n");
			}
			
			return listaProductos;
		}
	}




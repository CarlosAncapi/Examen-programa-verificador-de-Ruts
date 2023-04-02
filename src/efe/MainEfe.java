package efe;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainEfe {
	
	public static void main(String[] args) {
		try {
			//leer el archivo
			int cont=0;
			String ruta="src/efe/RutsParaComparar.txt";
			FileReader fr = new FileReader(ruta);
			BufferedReader br = new BufferedReader(fr);
			String str;
			
			List<String> rutLeidos = new ArrayList<>();
			
			while((str = br.readLine())!=null) {	
					rutLeidos.add(str);
					cont++;
			}
			br.close();
			System.out.println("hay una cantidad de "+cont+" ruts en el archivo leido");
			System.out.println("");
			System.out.println(rutLeidos);
			System.out.println("---------------------------------------------------------------------");
			System.out.println("");
			
			//ahora ante pondre un "0" a los ruts con menos de 10 digitos
			
			int cont2=0;
			do {
				if(rutLeidos.get(cont2).length()<10) {
					String cambio="0"+rutLeidos.get(cont2);
					rutLeidos.set(cont2,cambio);
				}
				cont2++;
			}while(cont2<cont);
			System.out.println("asi quedo el listado, modificando a los rut con 9 digitos anteponiendoles un 0:");
			System.out.println("");
			System.out.println(rutLeidos);
			System.out.println("---------------------------------------------------------------------");
			System.out.println("---------------------------------------------------------------------");
			System.out.println("");
			
			//aqui comprobare si los digitos validadores son correctos, y dependiendo si son correctos o no los agregare a una lista que les corresponda en cada caso
			
			List<String> rutDvCorrecto = new ArrayList<>();
			List<String> rutDvInCorrecto = new ArrayList<>();
			
			String dvString ="";
			Integer mult1,mult2,mult3,mult4,mult5,mult6,mult7,mult8;
			Integer suma=0;
			Integer residuoDivision;
			Integer dvInteger;
			
			for (int i = 0; i < rutLeidos.size(); i++) {
				
				mult1= 2*Integer.parseInt(String.valueOf(rutLeidos.get(i).charAt(7)));
				mult2= 3*Integer.parseInt(String.valueOf(rutLeidos.get(i).charAt(6)));
				mult3= 4*Integer.parseInt(String.valueOf(rutLeidos.get(i).charAt(5)));
				mult4= 5*Integer.parseInt(String.valueOf(rutLeidos.get(i).charAt(4)));
				mult5= 6*Integer.parseInt(String.valueOf(rutLeidos.get(i).charAt(3)));
				mult6= 7*Integer.parseInt(String.valueOf(rutLeidos.get(i).charAt(2)));
				mult7= 2*Integer.parseInt(String.valueOf(rutLeidos.get(i).charAt(1)));
				mult8= 3*Integer.parseInt(String.valueOf(rutLeidos.get(i).charAt(0)));
				
					
				suma =mult1+mult2+mult3+mult4+mult5+mult6+mult7+mult8;
				
				residuoDivision = suma%11;

				dvInteger = 11-residuoDivision;
				
				if(dvInteger==10) {
					dvString="k";
				}
				
				else {
					dvString = String.valueOf(dvInteger);
				}
				
				
				if(String.valueOf(rutLeidos.get(i).charAt(9)).equals(dvString)) {
					rutDvCorrecto.add(rutLeidos.get(i));
				}
				else {
					rutDvInCorrecto.add(rutLeidos.get(i));
				}
			}
			
			
			System.out.println("el arreglo con los rut correctos contiene: "+rutDvCorrecto.size()+" elementos");
			System.out.println("estos son los ruts que estan dentro de este arreglo:");
			System.out.println(rutDvCorrecto);
			System.out.println("");
			System.out.println("listado de ruts correctos ordenados de menor a mayor: ");
			Collections.sort(rutDvCorrecto);
			System.out.println(rutDvCorrecto);
			System.out.println("-----------------------------------------------------------");
			System.out.println("");
			System.out.println("el arreglo con los rut incorrectos contiene: "+rutDvInCorrecto.size()+" elementos");
			System.out.println("estos son los ruts que estan dentro de este arreglo:");
			System.out.println(rutDvInCorrecto);
			System.out.println("");
			System.out.println("listado de ruts incorrectos ordenados de menor a mayor: ");
			Collections.sort(rutDvInCorrecto);
			System.out.println(rutDvInCorrecto);
			System.out.println("-----------------------------------------------------------");
			System.out.println("");
			
			//escribir un nuevo archivo de texto el listado de ruts correctos
			String ruta2 = "src/efe/ListadoRutsCorrectos.txt";
			File file2 = new File(ruta2);
			//si es que el archivo lno existe el programa lo creara
			if (!file2.exists()) {
				file2.createNewFile();
			}
			FileWriter fw2 = new FileWriter(file2);
			BufferedWriter bw2 = new BufferedWriter(fw2);
			
			//a trave sde este ciclo for procedere a escribir los rut con su dv correcto
			for(int i=0; i<rutDvCorrecto.size();i++)
				bw2.write(rutDvCorrecto.get(i)+"\n");
			bw2.close();
			
			System.out.println("Se ha generado con exito la escritura del listado de los ruts");
			System.out.println("con el DV correcto en el archivo de texto 'ListadoRutsCorrectos'");
			System.out.println("");
			System.out.println("-----------------------------------------------------------------");
			
			
			
			//escribir un nuevo archivo de texto el listado de ruts Incorrectos
			String ruta3 = "src/efe/ListadoRutsInCorrectos.txt";
			File file3 = new File(ruta3);
			//si es que el archivo lno existe el programa lo creara
			if (!file3.exists()) {
				file3.createNewFile();
			}
			FileWriter fw3 = new FileWriter(file3);
			BufferedWriter bw3 = new BufferedWriter(fw3);
			
			//a trave sde este ciclo for procedere a escribir los rut con su dv correcto
			for(int i=0; i<rutDvInCorrecto.size();i++)
				bw3.write(rutDvInCorrecto.get(i)+"\n");
			bw3.close();
			
			System.out.println("Se ha generado con exito la escritura del listado de los ruts");
			System.out.println("con el DV incorrecto en el archivo de texto 'ListadoRutsInCorrectos'");
		}
		
		
		catch (Exception e) {
			System.out.println("hubo un error en la ejecucion del programa");
		}
	}
}

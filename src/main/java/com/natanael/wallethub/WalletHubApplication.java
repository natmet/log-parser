package com.natanael.wallethub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WalletHubApplication {

	
	
	public static void main(String[] args) {
		Parser parse = new Parser();
		String cadena = "2018-11-04 00:10:30.315|192.168.14.43|\"GET / HTTP/1.1\"|200|\"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)\"";
	
		//Donde se crea el Objeto?
		LineaArchivo ts= parse.convertirString(cadena);
		
		
		
		System.out.println("La fecha fue: "+ts.getFecha()+" La IP es: "+ts.getFecha()+" El metodo es :"+ts.getMetodoHttp()+" El estatus: "+ts.getCodigoEstatus()+" El navegador es: "+ts.getUserAgent());	
			
		
		
	}

}

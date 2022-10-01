package ar.edu.unlam.tallerweb1.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Archivos {
	
	public static String guardarArchivo(MultipartFile multipart, String ruta){
		
		//obtenemos el nombre original del archivo
		String nombreOriginal = multipart.getOriginalFilename();
		
		try {
			//formamos el nombre completo del archivo a guardar
			File imageFile = new File( ruta + "/" + nombreOriginal );
		
			System.out.println(imageFile.getAbsolutePath());
		
			//guardamos fisicamente
			multipart.transferTo(imageFile);
			
			return nombreOriginal;
		
		}catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		}
		
		
	}
		
	

}

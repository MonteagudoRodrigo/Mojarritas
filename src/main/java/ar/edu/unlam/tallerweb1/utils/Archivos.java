package ar.edu.unlam.tallerweb1.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.util.ResourceUtils;
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
	
	 public static String getResourceBasePath() {
	        // Obtener el directorio
	        File path = null;
	        try {
	            path = new File(ResourceUtils.getURL("classpath:").getPath());
	        } catch (FileNotFoundException e) {
	            // nothing to do
	        }
	        if (path == null || !path.exists()) {
	            path = new File("");
	        }

	        String pathStr = path.getAbsolutePath();
	        // Si se está ejecutando en eclipse, está al mismo nivel que el directorio de destino. Si se implementa en el servidor, está al mismo nivel que el paquete jar por defecto
	        pathStr = pathStr.replace("\\target\\classes", "");

	        return pathStr;
	    }
		
	

}

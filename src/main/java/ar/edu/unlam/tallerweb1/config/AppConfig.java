package ar.edu.unlam.tallerweb1.config;

import java.nio.file.Paths;

public class AppConfig {

	final static String DEF_PROFILE_IMG = "Default.png";
		
		public static String getDirRoot() {
			return System.getProperty("catalina.base") + "\\wtpwebapps\\Mojarritas\\";
		}
		
		public static String getUploadDir() {
			return Paths.get(getDirRoot() + "profiles\\").toFile().getAbsolutePath();
		}
		
		public static String getDefaultImageProfile() {
			return DEF_PROFILE_IMG;
		}
}

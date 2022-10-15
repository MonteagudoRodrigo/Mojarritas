package ar.edu.unlam.tallerweb1.domain.Security;


import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

@Service
public class ServicioSecurity{

	

	public String generarToken(Usuario user) throws Exception{
		
		//converitmos el objeto en string
		String strJson = ParseToJson(user).toString();
		
		JSONParser parser = new JSONParser();
	    
		//se parsea el String desencriptado en un JSONObject
	    JSONObject jsonResult = (JSONObject) parser.parse(strJson);
		  
	    //encriptamos en Base64
		byte [] jsonByte = strJson.getBytes(StandardCharsets.UTF_8);
		
		Encoder encoder = Base64.getEncoder();
		
		String token = encoder.encodeToString(jsonByte);
		
		return token; 
	}
	
	
	public boolean ValidaToken(String token) throws Exception {
		
		if(token.isEmpty()) return false;
		
		JSONObject tk = this.getJSONObjectFromToken(token);
		
		LocalDateTime validTo = LocalDateTime.parse(tk.get("expire_at").toString());
		
		LocalDateTime today = LocalDateTime.now();
		
		if (today.compareTo(validTo)<0) 
			return true;
		else
			return false;
		
	}
	
	
	private JSONObject ParseToJson(Usuario user) {
		JSONObject jso = new JSONObject();
		jso.put("id", user.getId());
		jso.put("username", user.getUsername());
		jso.put("create_at", LocalDateTime.now().toString());
		jso.put("expire_at", LocalDateTime.now().plusMinutes(5).toString());
		
		return jso;
	}

	public JSONObject getJSONObjectFromToken(String token) throws Exception {
		
		Decoder deco = Base64.getDecoder();
		//Sacamos los saltos de linea y lo decodificamos en un Array de Bytes
		byte[] decryptedBytes = deco.decode(token);
		
		String strTok = new String(decryptedBytes, StandardCharsets.UTF_8);

		JSONParser parser = new JSONParser();
	     //se parsea el String desencriptado en un JSONObject
	    JSONObject jsonResult = (JSONObject) parser.parse(strTok);
		
		return jsonResult;
	}
	

}

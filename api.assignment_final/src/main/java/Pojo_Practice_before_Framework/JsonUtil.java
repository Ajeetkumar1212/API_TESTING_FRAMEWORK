package Pojo_Practice_before_Framework;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	private static ObjectMapper mapper;
	
	static 
	{
		mapper = new ObjectMapper();
	}
   public static String convertJavaToJson(Object object) throws Throwable
   {
	   String jsonResult= "";
	 jsonResult= mapper.writeValueAsString(object); 
	 return jsonResult;
   }
   
   public static <T> T convertJsonToJava(String jsonString,Class<T> cls) throws Throwable, JsonMappingException, IOException
   {
	   T res = null;
	   res = mapper.readValue(jsonString,cls);
	   return res;
   }
   
}

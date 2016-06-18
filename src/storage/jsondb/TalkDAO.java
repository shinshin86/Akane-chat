package storage.jsondb;

import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import storage.adapter.JsonDatabaseAdapter;

public class TalkDAO {
	
	// Akane's reply word
	public TalkBean getWord(String key) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		TalkBean bean = mapper.readValue(JsonDatabaseAdapter.getJsonDBFile(), TalkBean.class);
		return bean;
	}
	
	public void addWord(TalkBean bean) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(bean);
		writeJsonDatabase(json);
	}
	
	public void updateWord(TalkBean bean, String word){
	}
	
	public void deleteWord(TalkBean bean){
	}
	
	public void writeJsonDatabase(String json){
		try(FileWriter fw = new FileWriter(JsonDatabaseAdapter.getJsonDBFile().getAbsolutePath(), true)){
			fw.write(",");
			fw.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

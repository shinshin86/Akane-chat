package main.akane;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import storage.adapter.JsonDatabaseAdapter;
import storage.jsondb.TalkBean;
import storage.jsondb.TalkDAO;

public class Akane {
    Deque<String> deque;
    private static Akane instance;
    
    public static synchronized Akane getInstance() {
        if (instance == null) {
            instance = new Akane();
            System.out.println("Hash : " + instance.hashCode());
            instance.deque = new ArrayDeque<String>();
            
            // Create Json DB - TODO
            JsonDatabaseAdapter.makeJsonDB();
        }
        return instance;
    }
    
    // Main Method
    public String toSay(String word) throws JsonProcessingException {
        // test
        if(word.equals("こんにちわ")){
            return toHello();
        }
        
        // Add a deque
        deque.add(word);
        
        // Add a jsondb
        TalkBean bean = new TalkBean();
        bean.setBean("sample", word);
        TalkDAO talkDao = new TalkDAO();
        talkDao.addWord(bean);
        try {
            return reply();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "ERROR!!!!!!!";
    }
    
    public String reply() throws InterruptedException, JsonParseException, JsonMappingException, IOException {
//        return deque.poll();
    	TalkDAO dao = new TalkDAO();
    	TalkBean bean =  dao.getWord("sample");
    	return bean.word;
    }
    
    // It's a test method
    public String toHello() {
        return "こんにちわ〜なんだか眠くなってきたよ〜";
    }
}
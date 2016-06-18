package storage.jsondb;

public class TalkBean{
	public String key;
	public String word;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public void setBean(String key, String word){
		this.key = key;
		this.word = word;
	}
	
}

package storage.adapter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class JsonDatabaseAdapter {
	private static String currentPath = new File(".").getAbsoluteFile().getName();
	private static final File DB_FILE = new File(currentPath + "/bin/storage/db/akane_database.json");
	
	// If not have a Json file.
	public static void makeJsonDB(){
		if(!DB_FILE.exists()){
			try(FileWriter fw = new FileWriter(DB_FILE.getAbsoluteFile())){
				System.out.println("Create  : " + DB_FILE);
				jsonDatabaseSetup(fw);
			}catch(IOException e){
				System.out.println(e.getMessage());
			}		
		}
	}
	
	public static File getJsonDBFile(){
		return DB_FILE.getAbsoluteFile();
	}
	
	public static void jsonDatabaseSetup(FileWriter fw) throws IOException{
	}	
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileIO {
	public static void fileHandler(String path) throws IOException{
		//read a file
		FileReader file = new FileReader(path);
		BufferedReader reader = new BufferedReader(file);
		String line = null;
		
		//write in a file
		//this will always overwrite this file it already exists
		//the path can be a relative or absolute path
		//PrintWriter writer1 = new PrintWriter("/Users/xinhe/Documents/workspace/Yodle/src/file.txt", "UTF-8");
		//writer1.println("The 1st line");
		//writer1.println("The 2nd line");
		//writer1.close();
		
		//every time create a new file called "file.txt"
		FileWriter fw=new FileWriter("/Users/xinhe/Documents/workspace/Yodle/src/file.txt");
		BufferedWriter writer2 = new BufferedWriter(fw); 
		//read file and write it in a new file
    while ((line= reader.readLine()) != null) {  
      System.out.println(line);  
      writer2.write(line);
      writer2.newLine(); 
      //writer2.flush();  
    }  
		writer2.close();
		
	}
	
	
	public static void main(String[] args){
		//path: is the absolute path to the file 
		String path = "/Users/xinhe/Documents/workspace/Yodle/src/newFile.txt";
		try{
			fileHandler(path);
		}catch(Exception e){
			System.out.println("Exceptions are caught");
			System.out.println(e.getMessage());
		}
	}
}

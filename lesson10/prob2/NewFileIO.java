package lesson10.labs.prob2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class NewFileIO {
	private static final Logger LOG = Logger.getLogger(OldFileIO.class.getName());
	public final static String FILE_LOCATION = System.getProperty("user.dir")
			+ "\\src\\lesson10\\labs\\prob2\\output.txt";
	public final static String TO_PRINT = "This is the string to print to file.";

	void writeText(String fileName, String text) {
		
		try(PrintWriter writer=new PrintWriter( new FileWriter(new File(fileName)))){
			writer.print(text);
			
		}catch(IOException e) {
			LOG.warning("IOException attempting to write a file: " + e.getMessage());
			List<Throwable> supressed= Arrays.asList(e.getSuppressed());
			supressed.forEach(warn->LOG.warning(warn.getMessage()));
		}
	}
	
	public static void main(String[] args) {
		NewFileIO nio=new NewFileIO();
		nio.writeText(TO_PRINT, FILE_LOCATION);
		
	}

}

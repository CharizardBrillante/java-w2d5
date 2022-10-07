package tools;
import java.io.*;
import java.util.ArrayList;


public class Reader {


	@SuppressWarnings("resource")
	public static void readFile(File file) throws IOException {
		try{
			FileReader f = new FileReader(file);			
			BufferedReader b;
			b = new BufferedReader(f);
			
			String s;

			while(true) {
				s=b.readLine();
				if(s==null)
					break;
				System.out.println(s);

					}
			
		} catch (FileNotFoundException e) {
			
		}
	}
	

}


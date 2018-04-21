
package timedemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class fileLinebylIne {
    
    public static void main(String args[]){
        
        
        try{
             File f=new File("newf.txt");
             File fo = new File("newfo.txt");
             
             readFile1(f,fo);
        }  
        catch(Exception ex){
            
        }
        
    }
    
    private static void readFile1(File fin,File fo) throws IOException {
	// Construct BufferedReader from FileReader
	BufferedReader br = new BufferedReader(new FileReader(fin));
       BufferedWriter bw = new BufferedWriter(new FileWriter(fo));
       
       String OPERATORS="+*/-=";
       
	String line = null;
	while ((line = br.readLine()) != null) {
            
            StringTokenizer tokens = new StringTokenizer(line, OPERATORS, true);
            
              while (tokens.hasMoreTokens()) {
                  
                String token = tokens.nextToken();
                
                System.out.println("total tokems "+tokens.countTokens());
                
                if (OPERATORS.contains(token))
                    handleOperator(token);
                else
                    handleNumber(token);
            }
         }
		
	
	br.close();
}
    
    
    
    private static void handleNumber(String token) {
System.out.println("number "+token);

   }

 private static void handleOperator(String token) {
System.out.println("operator"+token);

  }
    
    
}

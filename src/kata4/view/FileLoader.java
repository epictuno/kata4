
package kata4.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
//clase que implementa loader para cargar las lineas de un archivo
public class FileLoader implements Loader{
    private File file;
    public FileLoader(String file){
        this.file=new File("emails.txt");
    }
    @Override
    public Iterable<String> items() {
        return new Iterable<String>() {
        @Override 
        public Iterator<String> iterator(){
            return createIterator();
        }
    };
    }
    
    private Iterator<String> createIterator(){
        return new Iterator<String>(){
          BufferedReader reader= createReader();  
          String nextLine= nextLine();
          
          @Override
          public boolean hasNext(){
           return nextLine!=null;   
          }
          
          @Override
          public String next(){
              String line=nextLine;
              nextLine=nextLine();
              return line;
          }
          private BufferedReader createReader(){
              try{
                  return new BufferedReader(new FileReader(file));
              }
              catch (FileNotFoundException ex){
                  return null;
              }
          }
          private String nextLine(){
              try{
                  return reader.readLine();
              }
              catch (Exception ex){
                  return null;
              }
          }
        };
    }
}


package kata4.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kata4.model.Mail;

public class MailListReader{
    private Loader loader;
    private static final Pattern EmailPattern=Pattern.compile(
            "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    
    public List<Mail> read(String filename){
        List<Mail> ListaMail=new ArrayList<>();
        loader=new FileLoader(filename);
        Iterable<String> iteradormail = new Iterable<String>(){
            @Override
            public Iterator<String> iterator(){
                return createIterator();
            }
        };
        for (String line: iteradormail) {
            ListaMail.add(new Mail(line));
        }
        return ListaMail;
    }
       
    //crea un iterador que recorra las lineas extraidas por un loader
    private Iterator<String> createIterator(){
        return new Iterator<String>() {
         Iterator<String> iterator=loader.items().iterator();
         String nextmail=nextmail();
         @Override
         public boolean hasNext(){
          return nextmail!=null;      
         }
         @Override
         public String next(){
          String email=nextmail;
          nextmail=nextmail();
          return email;
         }
         private String nextmail(){
          while(true){
           String line=iterator.next();
           if(line==null) return null;
           if(isEmail(line)) return line;
          }
         }
         private boolean isEmail(String line){
             return EmailPattern.matcher(line).matches();
         }
        };
    }
}

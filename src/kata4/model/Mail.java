package kata4.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mail {
private final String mail;
private static final Pattern EmailPattern=Pattern.compile("@(.*?)$");
public Mail(String mail){
    this.mail=mail;
}
public String getDomain(){  
    Matcher matcher = EmailPattern.matcher(this.mail);
    if(matcher.find()){return matcher.group(1);}
    return null;
}
}

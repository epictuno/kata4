package kata4.main;

import kata4.view.HistogramDisplay;
import kata4.model.Histogram;
import kata4.view.MailListReader;
import java.util.List;
import kata4.model.Mail;
import kata4.view.MailHistogramBuilder;

/**
 *
 * @author tanay
 */
public class Main {

    
    public static void main(String[] args) {
        List<Mail> ListaMail=new MailListReader().read("emails.txt");
        Histogram builder=new MailHistogramBuilder().build(ListaMail);
        new HistogramDisplay("Histogram...",builder).execute();
        }
    }

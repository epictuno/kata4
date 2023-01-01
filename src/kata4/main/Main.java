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
    static List<Mail> ListaMail;
    static Histogram builder;
    static HistogramDisplay histoDisplay;
    public static void main(String[] args) {
        ListaMail=new MailListReader().read("emails.txt");
        builder=new MailHistogramBuilder().build(ListaMail);
        histoDisplay=new HistogramDisplay("Histogram...",builder);
        histoDisplay.execute();
        }
    }

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Show{
    Timer cheia;
    Esperando ct;
    private static final SimpleDateFormat format_date = new SimpleDateFormat("HH:mm:ss");
    
    public Show(){
        cheia = new Timer();
    }

    public void start(){       
        Date d = new Date();
        System.out.println("Hora de início: "+format_date.format(d));
        int sec = d.getSeconds();
        if(sec > 0){
            d = new Date(d.getTime()+(60-sec)*1000);
        }
        if(d.getMinutes()%2==0){
            ct = new Esperando();
        }
        cheia.schedule(new Cheia(), d, 1*60*1000);
    }
    
    public class Cheia extends TimerTask{
        @Override
        public void run(){
            Date date = new Date();
            System.out.println("Hora: "+format_date.format(date));
            if(date.getMinutes()%2!=0){
                ct = new Esperando();
                cheia.schedule(ct, 10000, 10000);
            }else{
                ct.cancel();
            }
        }
    }

    public class Esperando extends TimerTask{
        @Override
        public void run(){
            System.out.println("Esperando...");
        }
    }
    
    public void para(){
        cheia.cancel();
        System.out.println("Hora de término: "+format_date.format(new Date()));
    }
}
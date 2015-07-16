
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class RunMinSec extends TimerTask {
    
    private final Date atual = new Date();
    private final SimpleDateFormat date = new SimpleDateFormat("'Hora:' HH:mm:ss");
    private final long delay = 10000; // 10 segundos
    private final Timer segundos = new java.util.Timer("impar");
            
    @Override
    public void run() {
        atual.setTime(System.currentTimeMillis());
        System.out.println(date.format(atual));        
        if(((atual.getTime()/1000)/60)%2 != 0){
            segundos.schedule(
                    new java.util.TimerTask()
                    {
                        @Override
                        public void run() {
                            System.out.println("Esperando...");
                        }
                    }, delay, delay);
        }
        else{
            segundos.cancel();
        }
    }
}
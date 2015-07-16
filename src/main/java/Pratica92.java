
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná
 * DAINF - Departamento Acadêmico de Informática
 * 
 * Template de projeto de programa Java usando Maven.
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */
public class Pratica92 {
    private static final long hora_cheia = 60000;
    private static final long intervalo = 60000;
    private static final SimpleDateFormat date = new SimpleDateFormat("'Hora atual:' HH:mm:ss");
    
    public static void main(String[] args) throws IOException {
        
        System.out.println("Hora de início: "+date.format(new Date()));
        long atraso = hora_cheia - new Date().getTime() % hora_cheia;
       
        Timer t = new Timer("Hr_cheia");
        t.scheduleAtFixedRate(new RunMinSec(), atraso, intervalo);
        
        System.out.println("Pressione Enter para encerrar...");
        System.in.read();
        t.cancel();
        
        System.out.println("Hora de término "+date.format(new Date()));
        
    }
}    

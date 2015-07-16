
import java.io.IOException;
/**
 * UTFPR - Universidade Tecnológica Federal do Paraná
 * DAINF - Departamento Acadêmico de Informática
 *
 * Template de projeto de programa Java usando Maven.
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */
public class Pratica92 {
    
    public static void main(String[] args) throws IOException {
        Show s = new Show();
        
        System.out.println("Pressione enter para terminar...");
        s.start();
        System.in.read();
        s.para();
    }
}   
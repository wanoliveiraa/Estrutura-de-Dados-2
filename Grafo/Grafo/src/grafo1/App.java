
package grafo1;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Walderney Oliveira Azevedo
 * @brief
 *
 * @copyright Copyright (c) 2022
 *
 *
 */


public class App {
   
    public static void main(String[] args) {
        Grafo g = new Grafo();
        Scanner in = new Scanner(System.in);
        String teclado;

        //System.out.println("É ponderado? \n 0-SIM \n 1-NÃO");
        //teclado = in.nextLine();
        g = Leitor.Leitor();
        System.out.println(g);
        
     
       g.DFScont("0", "5");
        
        in.close();
    }
    
}

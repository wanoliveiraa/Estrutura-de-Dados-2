
package grafo1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Leitor {
 
    public static Grafo Leitor(){

        BufferedReader leitor;
        String linha = null;
        String numVertices = null; 
        int aux;
        Grafo g;
        g = new Grafo();
        try {
            leitor = new BufferedReader(new FileReader("arquivo.txt"));
            numVertices = leitor.readLine();
            aux = Integer.parseInt(numVertices);
            String []separar;
            String vertA;
            String vertB;
            String arest;

            while((linha = leitor.readLine())!=null){
                separar = linha.split(" ");
                vertA = separar[0]; 
                vertB = separar[1];
                if(separar.length>2){
                    arest = separar[2];
                }else{
                    arest = "1";
                }           
                
                g.adicionaVertice(vertA);
                g.adicionaVertice(vertB);
                g.adicionaAresta(Double.parseDouble(arest),vertA,vertB); 
              // g.adicionaAresta(Double.parseDouble(arest),vertB,vertA);  
            }
            leitor.close(); 
            return g;
            
        }catch(IOException a){
            System.out.println(a);
        }catch(NullPointerException s){
            System.out.println(s);
        }
        return g;
    }
    
}



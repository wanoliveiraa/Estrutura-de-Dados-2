import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Leitor {
    
    public static FloydWarshall LeitorGrafo(){
        BufferedReader leitor;
        String linha = null;
        String numVertices = null; 
        int aux;
        FloydWarshall fw;

        try {
            leitor = new BufferedReader(new FileReader("arquivo.txt"));
            numVertices = leitor.readLine();
            aux = Integer.parseInt(numVertices);
            String separar[];
            String de;
            String ate;
            String peso;

            fw = new FloydWarshall(aux);
           
            while((linha = leitor.readLine())!=null){
               
                separar = linha.split(" ");
                de = separar[0];
                ate = separar[1];
                peso = separar[2];
             
                fw.addPeso(Integer.parseInt(de),Integer.parseInt(ate),Double.parseDouble(peso));
                fw.floydWarshall();
            }
            
            leitor.close();    
            return fw;
        }catch(IOException a){
            System.out.println(a);
        }catch(NullPointerException s){
            System.out.println(s);
        }
       
        return null;
    }
}

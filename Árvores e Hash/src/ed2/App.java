
package ed2;

import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
     
        Scanner sc = new Scanner(System.in);
        String entrada=null ;
        int a = 2;
        Hash teste = new Hash(a);
        VerificadorPlagio b=new VerificadorPlagio();
        
        String frase = null;
        ArrayList<String> aux ;

        ArrayList<String> arquivos = new ArrayList();
        arquivos=Buffer.ReadDoc("textoComPla"); //Leitura e preenchimento.
        
        
        System.out.println("Informe o nome do Texto Base: ");
        
        entrada = sc.nextLine();
        aux =  Buffer.ReadDoc(entrada);
        b.InserirArquivoHash(entrada, teste, a);
        b.verificarHash(arquivos, teste, a);
        
        
        
    //------------------------BUSCAR------------------------------------------------------- 
    
    
    
    sc.close();
    }
}
    



package ed2;

import java.util.ArrayList;


public class VerificadorPlagio {
    public void InserirArquivoHash(String entrada,Hash teste,int n){
    ArrayList<String> aux;    
    aux =  Buffer.ReadDoc(entrada);
        for(int i = 0; i < aux.size()-n; i++){
            String frase = "";  
            for(int j = 0; j < n; j++){         
                frase += aux.get(i+j);
            }    
                teste.put(teste.hasMulti(frase),frase);    
        }
    }    
        
    public void InserirArquivoAvl(String entrada,Avl_Funcao teste,int n){
         ArrayList<String> aux;
        aux =  Buffer.ReadDoc(entrada);
        for(int i = 0; i < aux.size()-n; i++){
            String frase = "";  
            for(int j = 0; j < n; j++){         
                frase += aux.get(i+j);
            }    
            teste.insert(frase);
        }    
    }
    
    
    public void verificarHash(ArrayList<String> aux, Hash teste, int n){
        ArrayList<String> lista=new ArrayList();
        int sexo=0;
        for(int i = 0; i < aux.size()-n; i++){
            String frase = "";  
            for(int j = 0; j < n; j++){         
                frase += aux.get(i+j);
            }    
           lista=teste.findAll(teste.hasMulti(frase));   
            for(String l:lista){
                sexo++;
                if(frase.equals(l)){
                  
                  System.out.println(sexo);
                }    
            }
        }
        
    }
}

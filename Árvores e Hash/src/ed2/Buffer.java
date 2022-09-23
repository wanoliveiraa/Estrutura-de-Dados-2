
package ed2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Buffer {
    static BufferedReader leitor  ;
    public static ArrayList<String> ReadDoc(String a){
        
        try{
            ArrayList<String> l = new ArrayList<>();
            leitor =  new BufferedReader(new FileReader(a+".txt"));
            String linha = null;
            String separar[];
            while((linha = leitor.readLine())!=null){
                separar =  linha.split(" ");
                for(String s : separar){
                    l.add(s.trim());
                } 
            }
            return l;   
        }catch(FileNotFoundException c){
            System.out.println(a);
            
        }catch(IOException e){
            System.out.println(e);
        }
        return null;
    }
    
}
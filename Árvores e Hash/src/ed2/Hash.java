/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed2;

import java.util.ArrayList;

public class Hash {
    public ArrayList<HashValue> [] hash;
    public int len;

    //construtor
    Hash(Integer len){
        hash = new ArrayList[len];
        this.len = len;
    }
    //retorna um valor dentro do tamanho MÃ¡ximo

    public int hasMulti(String k)
    {
        double A = 0.6180339887;
        double val = k.hashCode()*A;
        val = (val - (int) val);  
        return Math.abs((int) (this.len * val));
    }

    /**
     *
     * @param k
     * @param v
     */
    public void put (int k, String v){
        int index = k%len;

        HashValue temp = new HashValue(k, v);

        if(hash[index] == null){
            ArrayList<HashValue> l = new ArrayList<HashValue>();
            hash[index] = l;
        }

        hash[index].add(temp);
    }

    public Boolean search(){
        
        return null;
    }

    public ArrayList<String> findAll(int k){
        int index = k%len;
        ArrayList<String> result = null;
        
        if (hash[index] != null){
            result = new ArrayList<String>();
        
            for(HashValue i: hash[index]){
                if(i.getKey() == k)
                    result.add(i.getData());
            }
        }

        return result; 
    }

    public void printList(int k){
        int index = k%len;
        ArrayList<HashValue> l = hash[index];

        for(HashValue i: l){
            if(i.getKey() == k)
                System.out.println(i);
        }

        System.out.println();   
    }
}

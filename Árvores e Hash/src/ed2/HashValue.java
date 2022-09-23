
package ed2;

public class HashValue {
    private int key;
    private String data;

    HashValue(int key, String data){
        this.key = key;
        this.data = data;
    }

    public String getData() {
        return data;
    }
    public int getKey() {
        return key;
    }

    @Override

    public String toString() {
        
        return data;
    }
}

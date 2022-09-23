import java.util.Arrays;

public class FloydWarshall {
    private double grafo[][];
    private boolean cicloNegativo;

    public FloydWarshall(int tam){
        this.grafo = new double [tam][tam];
        iniciarGrafo();
    }

    public void iniciarGrafo(){
        for(int i=0;i<grafo.length;i++){
            for(int j=0;j<grafo.length;j++){
                if(i==j){
                    grafo[i][j] = 0;
                }else{
                    grafo[i][j] = Double.POSITIVE_INFINITY;
                }
                    
            }
        }
    }

    public void printarGrafo(){
        for(int i=0;i<grafo.length;i++){
            System.out.print("|");
            for(int j=0;j<grafo.length;j++){
                System.out.print(grafo[i][j]+"   ");
            }
            System.out.println("|");
        }
       
    } 

    public boolean temCiclonegativo(){
        return this.cicloNegativo;
    }
// para GRAFOS PONDERADOS
    public void addPeso(int de, int para, double peso) {
        grafo[de][para] = peso;
    }
    

    public double[][] floydWarshall() {
        double[][] minDistances;
        //double[][] maxDistances;
        int n = this.grafo.length;
        minDistances = Arrays.copyOf(this.grafo,n);
        //maxDistances = Arrays.copyOf(this.grafo,n);
       
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    minDistances[i][j] = Math.min(minDistances[i][j],minDistances[i][k] + minDistances[k][j]);
                   // maxDistances[i][j] = Math.max(maxDistances[i][j], maxDistances[i][k] + maxDistances[k][j]);
                    // a distacia e um vetor 
                    // quando um vetor e impresso o valor que aparece e o endereco na memoria 
                    // System.out.println(distances);

                }
            }

            if (minDistances[k][k] < 0.0 /*|| maxDistances[k][k] < 0.0*/) {
                this.cicloNegativo = true;
            }
        }
       return minDistances;
    }

}

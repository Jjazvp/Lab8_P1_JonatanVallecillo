
package lab8_p1_jonatanvallecillo;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    static Random rand = new Random();
    static int [][] tablero;
    int rondas;

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }

    public Game(int[][] tablero, int rondas) {
        this.tablero = tablero;
        this.rondas = rondas;
    }
    
    public static void jugar(int rondas){
        int contador = 0;
        for(int m = 0; m < rondas + 1; m++){
            if(m == 0){
                System.out.println("Su tablero inicial: ");
                contador = 0;
                tablero = nextGen(tablero, rondas, contador);
                Print(tablero);
                System.out.println();
                contador += 1;
            }else{
                System.out.println("Ronda "+m+":");
                tablero = nextGen(tablero, rondas, contador);
                Print(tablero);
                System.out.println();
            }
        }
    }
    
    public static int [][] nextGen(int [][] tablero, int rondas, int contador){
        int contador2 = contador;
        int [][] temporal2 = tablero;
        int [][] temporal = tablero;
        int cont1 = 0; 
        int cont2 = 0;
        if(contador2 == 0){
            for(int i = 1; i < temporal.length - 1; i++){
                for(int j = 1; j < temporal.length - 1; j++){
                    temporal[i][j] = rand.nextInt(2-0)+0;
                }
            }
        }else{
            for(int i = 0; i < temporal.length; i++){
                for(int j = 0; j < temporal.length; j++){
                    int y = i;
                    int x = j;
                    if(temporal[i][j] == 1){
                        for(i = i - 1; i <= y + 1; i++){
                            for(j = j - 1; j <= x + 1; j++){
                                if(temporal[i][j] == 1){
                                   cont1 += 1;
                                }
                            }
                        }
                        if (cont1 > 3 || cont1 < 3){
                            temporal2[y][x] = 0;
                        }else{
                            temporal2[y][x] = temporal[i][j];
                        }    
                        
                    }else if(temporal[i][j] == 0 && i != 0 && j != 0 && i != temporal.length - 1 && j != temporal.length - 1){
                        for(i = i - 1; i <= y + 1; i++){
                            for(j = j - 1; j <= x + 1; j++){
                                if(temporal[i][j] == 1){
                                   cont2 += 1;
                                }
                            }
                        }
                        if (cont2 == 3){
                            temporal2[y][x] = 1;
                        }
                    }
                    i = y;
                    j = x;
                    
                }
            }
        }
        return temporal2;
    }
    
    public static void Print(int [][] tablero){
        ArrayList<String> temporal = new ArrayList<String>();
        for(int i = 0; i < tablero.length; i++){
            for(int j = 0; j < tablero.length; j++){
                if(tablero[i][j] == 1){
                    temporal.add(i+":"+j);
                }
            }
        }
        
        System.out.println("Coordenadas de las celdas vivas: ");
        System.out.print("[");
        for(int i = 0; i < temporal.size(); i++){
            if (i < temporal.size() - 1){
                System.out.print(temporal.get(i)+", ");
            }else{
                System.out.print(temporal.get(i));
            }
            
        }
        System.out.print("]");
        System.out.println();
        
        for(int i = 0; i < tablero.length; i++){
            for(int j = 0; j < tablero.length; j++){
                System.out.print("["+tablero[i][j]+"]");
            }
            System.out.println();
        }
    } 
}

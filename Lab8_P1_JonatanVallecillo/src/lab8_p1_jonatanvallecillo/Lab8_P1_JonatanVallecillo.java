
package lab8_p1_jonatanvallecillo;

import java.util.Random;
import java.util.Scanner;

public class Lab8_P1_JonatanVallecillo {
//fila 3, silla 7
    public static void main(String[] args) {
        Scanner zoro = new Scanner (System.in);
        Random rand = new Random();
        
        
        char s = 's';
        while(s == 'S' || s == 's'){
            System.out.println("**** Menu *****"); 
            System.out.println("1. Game of life");
            System.out.println("2. Salir");
            System.out.print("Ingrese su opcion: ");
            int opcion = zoro.nextInt();
            
                if (opcion == 1){
                        System.out.print("Ingrese el numero de rondas: "); 
                        int rondas = zoro.nextInt();
                        System.out.println();
                        int [][] tablero = tablero();
                        Game p = new Game(tablero, rondas);
                        p.jugar(rondas);
                        
                        
                        System.out.println();
                        System.out.println("Desea seguir jugando? (S/N)");
                        s = zoro.next().charAt(0);
                }else{
                    s = 'n';
                }
        }  
    }
    
    public static int [][] tablero(){
        int [][] temporal = new int[10][10];
        for(int i = 0; i < temporal.length; i++){
            for(int j = 0; j < temporal.length; j++){
                if(i == 0 || j == 0){
                    temporal[i][j] = 0;
                }
            }
        }
        return temporal;
    }
    
}

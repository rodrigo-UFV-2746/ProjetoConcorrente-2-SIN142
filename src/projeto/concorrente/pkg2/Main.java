/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.concorrente.pkg2;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

 
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner imput = new Scanner(System.in);
        int controlador;
        do{
            System.out.println(""
                        + "+++++++++++++++++++++++++\n"
                        + "+ Trabalho Prático 2:   +\n"
                        + "+-----------------------+\n"
                        + "+0 - Sair               +\n"
                        + "+1 - Atualizar Valores  +\n"
                        + "+++++++++++++++++++++++++\n");
                    controlador = imput.nextInt();
                switch(controlador) {
                    case 0:
                        System.out.println("Sair"); // encerra o programa
                    break;
                    case 1:
                        BufferedReader bf_Atualiza = new BufferedReader(new FileReader("atualizarValores.txt"));
                        BufferedReader bf_Diminuir = new BufferedReader(new FileReader("diminuirValores.txt"));
                        for (int i=0; i<1000; i++) {
                            String line = bf_Atualiza.readLine();
                            StringTokenizer st = new StringTokenizer (line);
                            String line1 = bf_Diminuir.readLine();
                            StringTokenizer st1 = new StringTokenizer (line1);
                            while (st.hasMoreTokens ()&& st1.hasMoreTokens ()) {
                                //variaveis temp para guarda valores atulizados.
                                int atu1=0,atu2=0,atu3=0;
                                int dim1=0,dim2=0,dim3=0;
                                //variaveis temp para guarda valores prontos.
                                int pro1=0,pro2=0,pro3=0;
                                //valores serem atualizador linha i;
                                 atu1 = Integer.parseInt(st.nextToken ());
                                 atu2 = Integer.parseInt(st.nextToken ());
                                 atu3 = Integer.parseInt(st.nextToken ());
                                // System.out.println("Atu1:"+atu1 +" Atu1:"+atu2 +" Atu1:"+atu3);
                                 //valores a serem diminuidos linha i;
                                 dim1 = Integer.parseInt(st1.nextToken ());
                                 dim2 = Integer.parseInt(st1.nextToken ());
                                 dim3 = Integer.parseInt(st1.nextToken ());
                                 //System.out.println("dim1:"+dim1 +" dim2:"+dim2 +" dim3:"+dim3);
                                 pro1 = (atu1+1)-dim1;
                                 pro2 = (atu2+1)-dim2;
                                 pro3 = (atu3+1)-dim3;
                                 System.out.println("pro1:"+pro1 +" pro2:"+pro2 +" pro3:"+pro3);
                                FileWriter arquivo;
                                String fileName = "Arquivo";
                                arquivo = new FileWriter(new File(fileName+".txt"),true);
                                arquivo.write(pro1+" "+pro2+" "+pro3+"\n");
                                arquivo.close();
                            }                                            
                        }
                        
                        
                        bf_Atualiza.close();
                        bf_Diminuir.close();
                    break;
                    default:
                        System.out.println("entrada inválida");
                    

                }
        }while(controlador != 0);
    }

}   

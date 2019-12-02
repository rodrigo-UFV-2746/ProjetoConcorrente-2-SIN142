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
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
        Scanner imput = new Scanner(System.in);
        int controlador;
        do {
            System.out.println(""
                    + "++++++++++++++++++++++++++++++++++++\n"
                    + "+        Trabalho Prático 2:       +\n"
                    + "+----------------------------------+\n"
                    + "+0 - Sair                          +\n"
                    + "+1 - Atualizar Valores Sequencial  +\n"
                    + "+2 - Atualizar Valores Concorrente +\n"
                    + "++++++++++++++++++++++++++++++++++++\n");

            controlador = imput.nextInt();
            switch (controlador) {
                case 0:
                    System.out.println("Sair"); // encerra o programa
                    break;
                case 1:
                    BufferedReader bf_Atualiza = new BufferedReader(new FileReader("atualizarValores.txt"));
                    BufferedReader bf_Diminuir = new BufferedReader(new FileReader("diminuirValores.txt"));
                    int [] valoresFinais = new int[3];
                    String [] valoresLidos = new String[3];
                    String linha;
                    while ((linha = bf_Atualiza.readLine()) != null) {
                        valoresLidos = linha.split(" ");
                        valoresFinais[0] += Integer.parseInt(valoresLidos[0]);
                        valoresFinais[1] += Integer.parseInt(valoresLidos[1]);
                        valoresFinais[2] += Integer.parseInt(valoresLidos[2]);
                    }
                    while ((linha = bf_Diminuir.readLine()) != null) {
                        valoresLidos = linha.split(" ");
                        valoresFinais[0] -= Integer.parseInt(valoresLidos[0]);
                        valoresFinais[1] -= Integer.parseInt(valoresLidos[1]);
                        valoresFinais[2] -= Integer.parseInt(valoresLidos[2]);                        
                    }
                    System.out.println(" Valores finais sequencial");
                    System.out.println(" Views: " + valoresFinais[0]);
                    System.out.println(" Likes: " + valoresFinais[1]);
                    System.out.println(" Dislikes: " + valoresFinais[2]);
                    
                    bf_Atualiza.close();
                    bf_Diminuir.close();
                    break;
                case 2:
                    AtualizaTread t[] = new AtualizaTread[10]; // Vetor de Threads
                    Semaphore s = new Semaphore(1);
                    int inicioDeLeitura = 0;
                    for (int i = 0; i < t.length; i++){
                        t[i] = new AtualizaTread(inicioDeLeitura, s); // start() no contrutor
                        inicioDeLeitura += 100;  // Cada thread le 100 linhas
                    }                                           
                    for (int i = 0; i < t.length; i++)
                        t[i].join();
                    valoresFinais = AtualizaTread.getValoresFinais();
                    System.out.println(" Valores finais com 10 Threads");
                    System.out.println(" Views: " + valoresFinais[0]);
                    System.out.println(" Likes: " + valoresFinais[1]);
                    System.out.println(" Dislikes: " + valoresFinais[2]);
                    break;

                default:
                    System.out.println("Entrada inválida");

            }
        } while (controlador != 0);
    }

}

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
                    for (int i = 0; i < 1000; i++) {
                        String line = bf_Atualiza.readLine();
                        StringTokenizer st = new StringTokenizer(line);
                        String line1 = bf_Diminuir.readLine();
                        StringTokenizer st1 = new StringTokenizer(line1);
                        while (st.hasMoreTokens() && st1.hasMoreTokens()) {
                            //variaveis temp para guarda valores atulizados.
                            int atu1 = 0, atu2 = 0, atu3 = 0;
                            int dim1 = 0, dim2 = 0, dim3 = 0;
                            //variaveis temp para guarda valores prontos.
                            int pro1 = 0, pro2 = 0, pro3 = 0;
                            //valores serem atualizador linha i;
                            atu1 = Integer.parseInt(st.nextToken());
                            atu2 = Integer.parseInt(st.nextToken());
                            atu3 = Integer.parseInt(st.nextToken());
                            System.out.println("Atu1:" + atu1 + " Atu1:" + atu2 + " Atu1:" + atu3);
                            //valores a serem diminuidos linha i;
                            dim1 = Integer.parseInt(st1.nextToken());
                            dim2 = Integer.parseInt(st1.nextToken());
                            dim3 = Integer.parseInt(st1.nextToken());
                            System.out.println("dim1:" + dim1 + " dim2:" + dim2 + " dim3:" + dim3);
                            pro1 = (atu1 + 1) - dim1;
                            pro2 = (atu2 + 1) - dim2;
                            pro3 = (atu3 + 1) - dim3;
                            System.out.println("pro1:" + pro1 + " pro2:" + pro2 + " pro3:" + pro3);
                            FileWriter arquivo;
                            String fileName = "Arquivo";
                            arquivo = new FileWriter(new File(fileName + ".txt"), true);
                            arquivo.write(pro1 + " " + pro2 + " " + pro3 + "\n");
                            arquivo.close();
                        }
                    }

                    bf_Atualiza.close();
                    bf_Diminuir.close();
                    break;
                case 2:
                    AtualizaTread t1 = new AtualizaTread(0);
                    AtualizaTread t2 = new AtualizaTread(1);
                    AtualizaTread t3 = new AtualizaTread(2);
                    AtualizaTread t4 = new AtualizaTread(3);
                    AtualizaTread t5 = new AtualizaTread(4);
                    AtualizaTread t6 = new AtualizaTread(5);
                    AtualizaTread t7 = new AtualizaTread(6);
                    AtualizaTread t8 = new AtualizaTread(7);
                    AtualizaTread t9 = new AtualizaTread(8);
                    AtualizaTread t10 = new AtualizaTread(9);
                    t1.start();
                    t1.join();
                    t2.start();
                    t2.join();
                    t3.start();
                    t3.join();
                    t4.start();
                    t4.join();
                    t5.start();
                    t5.join();
                    t6.start();
                    t6.join();
                    t7.start();
                    t7.join();
                    t8.start();
                    t8.join();
                    t9.start();
                    t9.join();
                    t10.start();
                    t10.join();
//tesgtre
                    break;

                default:
                    System.out.println("entrada inválida");

            }
        } while (controlador != 0);
    }

}

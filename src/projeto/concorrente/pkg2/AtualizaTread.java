/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.concorrente.pkg2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

/**
 *
 * @author RODRIGO-NOT
 */
public class AtualizaTread extends Thread {

    private int inicio;

    public AtualizaTread() {

    }

    public AtualizaTread(int inicio) {
        this.inicio = inicio;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public void run() {
        try {
            System.out.println(this.inicio);
            do {
                
                for (int i = 1; i <= this.inicio; i++) {
                    BufferedReader bf_AtualizaC = new BufferedReader(new FileReader("atualizarValores.txt"));
                    BufferedReader bf_DiminuirC = new BufferedReader(new FileReader("diminuirValores.txt"));
                    String line = bf_AtualizaC.readLine();
                    String line1 = bf_DiminuirC.readLine();
                    
                    if (this.getInicio() == i) {
                        StringTokenizer st = new StringTokenizer(line);
                        StringTokenizer st1 = new StringTokenizer(line1);
                        while (st.hasMoreTokens() && st1.hasMoreTokens()) {
                            System.out.println("teste");
                            //variaveis temp para guarda valores atulizados.
                            int atu1 = 0, atu2 = 0, atu3 = 0;
                            int dim1 = 0, dim2 = 0, dim3 = 0;
                            //variaveis temp para guarda valores prontos.
                            int pro1 = 0, pro2 = 0, pro3 = 0;
                            //valores serem atualizador linha i;
                            atu1 = Integer.parseInt(st.nextToken());
                            atu2 = Integer.parseInt(st.nextToken());
                            atu3 = Integer.parseInt(st.nextToken());
                            //System.out.println("Atu1:" + atu1 + " Atu1:" + atu2 + " Atu1:" + atu3);
                            //valores a serem diminuidos linha i;
                            dim1 = Integer.parseInt(st1.nextToken());
                            dim2 = Integer.parseInt(st1.nextToken());
                            dim3 = Integer.parseInt(st1.nextToken());
                            //System.out.println("dim1:" + dim1 + " dim2:" + dim2 + " dim3:" + dim3);
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
                }
                this.setInicio(this.getInicio()+10);
            
            } while (this.getInicio() < 1000);

        } catch (Exception e) {
            System.out.println("Thread terminada...");
        }
    }
}

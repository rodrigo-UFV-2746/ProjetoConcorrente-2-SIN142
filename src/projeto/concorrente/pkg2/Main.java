/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.concorrente.pkg2;

import java.util.Scanner;

public class Main {

 
    public static void main(String[] args) {
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
                         
                    break;
                    default:
                        System.out.println("entrada inválida");
                    

                }
        }while(controlador != 0);
    }

}   

package projeto.concorrente.pkg2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.concurrent.Semaphore;

public class AtualizaTread extends Thread {
    // Os arquivos têm 1000 linhas. Com 10 theads, 1000/10 linhas pra cada thread    
    private int inicioDeLeitura;
    // Todas as Thread atualizam os valores desse vetor compartilhado de inteiro
    private static int [] valoresFinais = new int[3];
    private Semaphore s;
    private boolean comSemaphore; // Controla se vão executar com semaforo ou não
    
    // Construtores
    public AtualizaTread( ){    }
    public AtualizaTread(int inicioDeLeitura, Semaphore s, boolean comSemaphore) {
        this.inicioDeLeitura = inicioDeLeitura;
        this.s = s;
        this.comSemaphore = comSemaphore;
        start();
    }
    
    // Gets e Sets
    public int getInicioDeLeitura() {
        return inicioDeLeitura;
    }
    public void setInicioDeLeitura(int inicioDeLeitura) {
        this.inicioDeLeitura = inicioDeLeitura;
    }
    public static int[] getValoresFinais() {
        return valoresFinais;
    }
    public static void setValoresFinais(int[] valoresFinais) {
        AtualizaTread.valoresFinais = valoresFinais;
    }
    public Semaphore getS() {
        return s;
    }
    public void setS(Semaphore s) {
        this.s = s;
    }
    public boolean isComSemaphore() {
        return comSemaphore;
    }
    public void setComSemaphore(boolean comSemaphore) {
        this.comSemaphore = comSemaphore;
    }       

    private void execucao(){
        try {
            BufferedReader bf_Atualiza = new BufferedReader(new FileReader("atualizarValores.txt"));
            BufferedReader bf_Diminuir = new BufferedReader(new FileReader("diminuirValores.txt"));            
            String [] valoresLidos = new String[3];
            String linha;
            // Pula as linhas que são de outras threads
            for(int i = 0; i < this.inicioDeLeitura; i++) {
                bf_Atualiza.readLine();
                bf_Diminuir.readLine();
            }
            // Cada thread le 100 linhas do arquivo e atualiza valores
            for (int i = 0; i < 100; i++) {  
                linha = bf_Atualiza.readLine();               
                valoresLidos = linha.split(" ");
                AtualizaTread.valoresFinais[0] += Integer.parseInt(valoresLidos[0]);
                AtualizaTread.valoresFinais[1] += Integer.parseInt(valoresLidos[1]);
                AtualizaTread.valoresFinais[2] += Integer.parseInt(valoresLidos[2]);
                
                linha = bf_Diminuir.readLine();
                valoresLidos = linha.split(" ");
                AtualizaTread.valoresFinais[0] -= Integer.parseInt(valoresLidos[0]);
                AtualizaTread.valoresFinais[1] -= Integer.parseInt(valoresLidos[1]);                        
                AtualizaTread.valoresFinais[2] -= Integer.parseInt(valoresLidos[2]);
            }            
            bf_Atualiza.close();
            bf_Diminuir.close();
            
        } catch(IOException ex) {
            System.out.println(" Erro inesperado, " + ex.getMessage());
        }
    }
    
    @Override
    public void run(){
        if( this.isComSemaphore() ){ // Executa com semaforo fazendo exclusão
            try {
                s.acquire();
                this.execucao();
                s.release();
            } catch (InterruptedException ex) {
                System.out.println(" Erro durante acquire do semaforo.");
            }
        }else{
            this.execucao(); 
        }        
    }
}

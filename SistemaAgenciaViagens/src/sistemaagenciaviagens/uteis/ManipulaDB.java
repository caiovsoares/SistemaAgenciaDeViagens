package sistemaagenciaviagens.uteis;

import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ManipulaDB {

    public static void salvarArquivo(ArrayList<Object> tabela, String nomeArquivo) throws IOException {
        File arquivo = new File(nomeArquivo);
        
        arquivo.delete();
        
        arquivo.createNewFile();
        
        FileOutputStream gravador = new FileOutputStream(arquivo);
        
        ObjectOutputStream buffer = new ObjectOutputStream(gravador);
        
        buffer.writeObject(tabela);
        
        buffer.close();
    }
    
    public static ArrayList<Object> recuperarArquivo(String nomeArquivo) throws FileNotFoundException, IOException, ClassNotFoundException{
        ArrayList<Object> tabela = null;
        
        File arquivo = new File(nomeArquivo);
        
        if(arquivo.exists()){
            // Lê os bytes e transforma em objeto, jogando em um buffer
            FileInputStream leitura = new FileInputStream(arquivo);
            
            ObjectInputStream buffer = new ObjectInputStream(leitura);
            
            tabela = (ArrayList<Object>) buffer.readObject();
            
            buffer.close();
        }
        
        return tabela;
    }
    
}

package sistemaagenciaviagens.model;

import java.util.ArrayList;
import java.io.Serializable;

public class LocalModel implements Serializable{

    //Atributos
    
    private int codigo;
    private String cepDestino;
    private String paisDestino;
    private String estadoDestino;
    private String cidadeDestino;
    
    //Construtor
    
    public LocalModel(){
        this.cepDestino = "";
        this.paisDestino = "";
        this.estadoDestino = "";
        this.cidadeDestino = "";
    }
    
    //Getters
    
    public int getCodigo(){
        return codigo;
    }
    
    public String getCepDestino(){
        return cepDestino;
    }
    
    public String getPaisDestino(){
        return paisDestino;
    }
    
    public String getEstadoDestino(){
        return estadoDestino;
    }
    
    public String getCidadeDestino(){
        return cidadeDestino;
    }
    
    //Setters
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    public void setCepDestino(String cepDestino) throws Exception{
        if(cepDestino.equals("")){
            throw new Exception("\nO CEP destino deve ser informado.");
        }
        
        this.cepDestino = cepDestino;
    }
    
    public void setPaisDestino(String paisDestino) throws Exception{
        if(paisDestino.equals("")){
            throw new Exception("\nO país destino deve ser informado.");
        }
        
        this.paisDestino = paisDestino;
    }
    
    public void setEstadoDestino(String estadoDestino) throws Exception{
        if(estadoDestino.equals("")){
            throw new Exception("\nO estado destino deve ser informado.");
        }
        
        this.estadoDestino = estadoDestino;
    }
    
    public void setCidadeDestino(String cidadeDestino) throws Exception{
        if(cidadeDestino.equals("")){
            throw new Exception("\nA cidade destino deve ser informada.");
        }
        
        this.cidadeDestino = cidadeDestino;
    }
    
}
package sistemaagenciaviagens.model;

import java.util.Calendar;
import java.util.ArrayList;
import java.io.Serializable;

public class HotelModel implements Serializable{

    //Atributos
    
    private int codigo;
    private String nomeHotel;
    private String classificacao;
    private String bairro;
    private String rua;
    private String numero;

    //Construtor
    
    public HotelModel(){
        this.nomeHotel = "";
        this.classificacao = "";
        this.bairro = "";
        this.rua = "";
        this.numero = "";
    }
    
    //Getters
    
    public int getCodigo(){
        return codigo;
    }

    public String getNomeHotel() {
        return nomeHotel;
    }
    
    public String getClassificacao(){
        return classificacao;
    }
    
    public String getBairro(){
        return bairro;
    }
    
    public String getRua(){
        return rua;
    }
    
    public String getNumero(){
        return numero;
    }
    
    //Setters
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    public void setNomeHotel(String nomeHotel) throws Exception{
        if(nomeHotel.equals("")){
            throw new Exception("\nO nome do hotel deve ser informado");
        }
        
        this.nomeHotel = nomeHotel;
    }
    
    public void setClassificacao(String classificacao){
        this.classificacao = classificacao;
    }
    
    public void setBairro(String bairro) throws Exception{
        if(bairro.equals("")){
            throw new Exception("\nO bairro do hotel deve ser informado.");
        }
        
        this.bairro = bairro;
    }
    
    public void setRua(String rua) throws Exception{
        if(rua.equals("")){
            throw new Exception("\nA rua do hotel deve ser informada.");
        }
        
        this.rua = rua;
    }
    
    public void setNumero(String numero) throws Exception{
        if(numero.equals("")){
            throw new Exception("\nO número do hotel deve ser informado.");
        }
        
        this.numero = numero;
    }
    
}
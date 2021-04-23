package sistemaagenciaviagens.model;

import java.io.Serializable;

public abstract class PessoaModel implements Serializable{
    
    //Atributos
    
    private int codigo;
    private String nome;
    private String telefone;
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    
    //Construtor

    public PessoaModel(){
        this.codigo = 0;
        this.nome = "";
        this.telefone = "";
        this.cep = "";
        this.estado = "";
        this.cidade = "";
        this.bairro = "";
        this.rua = "";
        this.numero = "";
    }
    
    //Getters
    
    public int getCodigo(){
        return codigo;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getTelefone(){
        return telefone;
    }
    
    public String getCep(){
        return cep;
    }
    
    public String getEstado(){
        return estado;
    }
    
    public String getCidade(){
        return cidade;
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
    
    public void setNome(String nome) throws Exception{
        if(nome.equals("")){
            throw new Exception("\nO nome deve ser informado.");
        }
            
        this.nome = nome;
    }
    
    public void setTelefone(String telefone) throws Exception{
        if(telefone.equals("")){
            throw new Exception("\nO telefone deve ser informado.");
        }
        
        this.telefone = telefone;
    }
    
    public void setCep(String cep) throws Exception{
        if(cep.equals("")){
            throw new Exception("\nO CEP deve ser informado.");
        }
        
        this.cep = cep;
    }
    
    public void setEstado(String estado) throws Exception{
        if(estado.equals("")){
            throw new Exception("\nO estado deve ser informado.");
        }
        
        this.estado = estado;
    }
    
    public void setCidade(String cidade) throws Exception{
        if(cidade.equals("")){
            throw new Exception("\nA cidade deve ser informada.");
        }
        
        this.cidade = cidade;
    }
    
    public void setBairro(String bairro) throws Exception{
        if(bairro.equals("")){
            throw new Exception("\nO bairro deve ser informado.");
        }
        
        this.bairro = bairro;
    }
    
    public void setRua(String rua) throws Exception{
        if(rua.equals("")){
            throw new Exception("\nA rua deve ser informada.");
        }
        
        this.rua = rua;
    }
    
    public void setNumero(String numero) throws Exception{
        if(numero.equals("")){
            throw new Exception("\nO número deve ser informado.");
        }
        
        this.numero = numero;
    }
    
}
package sistemaagenciaviagens.model;

import java.io.Serializable;

public class TransporteModel implements Serializable{
    
    //Atributos
    
    private int codigo;
    private String nomeEmpresa;
    private String veiculo;
    
    //Construtor
    
    public TransporteModel(){
        this.nomeEmpresa = "";
        this.veiculo = "";
    }
    
    //Getters
    
    public int getCodigo(){
        return codigo;
    }
    
    public String getNomeEmpresa(){
        return nomeEmpresa;
    }

    public String getVeiculo() {
        return veiculo;
    }
    
    //Setters
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    public void setNomeEmpresa(String nomeEmpresa){
        this.nomeEmpresa = nomeEmpresa;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }
    
}
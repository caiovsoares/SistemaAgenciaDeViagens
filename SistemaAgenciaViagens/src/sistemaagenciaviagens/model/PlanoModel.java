package sistemaagenciaviagens.model;

import java.util.Calendar;
import java.util.ArrayList;
import java.io.Serializable;

public class PlanoModel implements Serializable{

    //Atributos
    private int codigo;
    private double valor;
    private Calendar dataIda;
    private Calendar dataVolta;
    
    private FuncionarioModel funcionario;
    private LocalModel local;
    private HotelModel hotel;
    private TransporteModel transporte;

    //Construtor
    public PlanoModel() {
        this.valor = 0.0;
        this.dataIda = Calendar.getInstance();
        this.dataVolta = Calendar.getInstance();
    }

    //Getters

    public int getCodigo() {
        return codigo;
    }

    public double getValor() {
        return valor;
    }

    public Calendar getDataIda() {
        return dataIda;
    }

    public Calendar getDataVolta() {
        return dataVolta;
    }
    
    public FuncionarioModel getFuncionario(){
        return this.funcionario;
    }
    
    public LocalModel getLocal(){
        return this.local;
    }
    
    public HotelModel getHotel(){
        return this.hotel;
    }
    
    public TransporteModel getTransporte(){
        return this.transporte;
    }

    //Setters
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setValor(double valor) throws Exception {
        if (valor < 0) {
            throw new Exception("\nO valor do plano não pode ser negativo. "
                    + "Informe um valor correto");
        }

        this.valor = valor;
    }

    public void setDataIda(Calendar dataIda) throws Exception {
        if (dataIda.equals("")) {
            throw new Exception("\nA data de ida deve ser informada.");
        }

        this.dataIda = dataIda;
    }

    public void setDataVolta(Calendar dataVolta) throws Exception {
        // Se a data de volta vier antes da data de ida
        if (dataVolta.before(dataIda)) {
            throw new Exception("\nA data de volta não pode ser anterior à data "
                    + "de ida.");
        }
        if (dataVolta.equals("")) {
            throw new Exception("\nA data de volta deve ser informada.");
        }

        this.dataVolta = dataVolta;
    }
    
    public void setFuncionario(FuncionarioModel funcionario) throws Exception{
        if(funcionario == null){
            throw new Exception("Funcionário não informado");
        }
        
        this.funcionario = funcionario;
    }
    
    public void setLocal(LocalModel local) throws Exception{
        if(local == null){
            throw new Exception("Local não informado");
        }
        
        this.local = local;
    }
    
    public void setHotel(HotelModel hotel) throws Exception{
        if(hotel == null){
            throw new Exception("Hotel não informado");
        }
        
        this.hotel = hotel;
    }
    
    public void setTransporte(TransporteModel transporte) throws Exception{
        if(transporte == null){
            throw new Exception("Transporte não informado");
        }
        
        this.transporte = transporte;
    }

}

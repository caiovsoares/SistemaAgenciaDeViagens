package sistemaagenciaviagens.model;

import java.util.Calendar;
import java.util.ArrayList;
import java.io.Serializable;

public class FuncionarioModel extends PessoaModel implements Serializable{
    
    //Atributos
    
    private Calendar dataAdmissao;
    private Calendar dataDemissao;
    
    //Construtor
    
    public FuncionarioModel(){
        super();
        this.dataAdmissao = Calendar.getInstance();
        this.dataDemissao = null;
    }
    
    //Getters

    public Calendar getDataAdmissao(){
        return dataAdmissao;
    }
    
    public Calendar getDataDemissao(){
        return dataDemissao;
    }
    
    //Setters
    
    public void setDataAdmissao(Calendar dataAdmissao) throws Exception{
        if(dataAdmissao.equals("")){
            throw new Exception("A data de admissão deve ser preenchida.");
        }
        
        this.dataAdmissao = dataAdmissao;
    }
    
    public void setDataDemissao(Calendar dataDemissao) throws Exception{
        // Se a data de demissao vier antes da data de admissao
        if(dataDemissao.before(dataAdmissao)){
            throw new Exception("\nA data de demissão não pode ser anterior à "
                    + "data de admissão.");
        }
        
        this.dataDemissao = dataDemissao;
    }
    
}
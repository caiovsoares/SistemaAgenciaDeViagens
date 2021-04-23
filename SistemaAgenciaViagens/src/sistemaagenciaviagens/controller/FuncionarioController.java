package sistemaagenciaviagens.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import sistemaagenciaviagens.model.FuncionarioModel;
import sistemaagenciaviagens.dao.BD;
import sistemaagenciaviagens.dao.FuncionarioDAO;

public class FuncionarioController {
    
    private FuncionarioModel funcionario;
    private ArrayList<FuncionarioModel> listaDeFuncionarios;
    private BD db;
    
    public FuncionarioController(){
        this.db = new FuncionarioDAO();
    }
    
    public FuncionarioModel getFuncionario(){
        return this.funcionario;
    }
    
    public ArrayList<FuncionarioModel> getListaDeFuncionarios(){
        return this.listaDeFuncionarios;
    }
    
    public void salvar(int codigo, String nome, String telefone, String cep, 
            String estado, String cidade, String bairro, String rua,
            String numero, String dataAdmissao, String dataDemissao) throws Exception{
        FuncionarioModel func = new FuncionarioModel();
        
        // Formato da data
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        Calendar dataA = Calendar.getInstance();
        Calendar dataD = Calendar.getInstance();
        
        func.setNome(nome);
        func.setTelefone(telefone);
        func.setCep(cep);
        func.setEstado(estado);
        func.setCidade(cidade);
        func.setBairro(bairro);
        func.setRua(rua);
        func.setNumero(numero);
        
        // Converte dataAdmissao para o formato registrado anteriormente
        dataA.setTime(sdf.parse(dataAdmissao));
        
        func.setDataAdmissao(dataA);
        
        // Converte dataDemissao para o formato registrado anteriormente
        dataD.setTime(sdf.parse(dataDemissao));
        
        func.setDataDemissao(dataD);
        
        if(codigo == 0){
            this.db.salvar(func);
        }
        else{
            func.setCodigo(codigo);
            
            this.db.alterar(func);
        }
    }
    
    public void excluir(int codigo) throws Exception{
        this.db.excluir(codigo);
    }
    
    public void buscar(int codigo){
        Object o = this.db.buscar(codigo);
        
        this.funcionario = (FuncionarioModel) o;
    }
    
    public void buscarTodos(){
        this.listaDeFuncionarios = new ArrayList<FuncionarioModel>();
        
        for (Object o : this.db.buscarTodos()) {
            FuncionarioModel f = (FuncionarioModel) o;
            
            this.listaDeFuncionarios.add(f);
        }
    }
    
}

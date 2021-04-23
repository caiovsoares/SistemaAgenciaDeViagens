package sistemaagenciaviagens.controller;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import sistemaagenciaviagens.model.ClienteModel;
import sistemaagenciaviagens.dao.BD;
import sistemaagenciaviagens.dao.ClienteDAO;
import sistemaagenciaviagens.dao.PlanoDao;
import sistemaagenciaviagens.model.PlanoModel;

public class ClienteController {

    private ArrayList<ClienteModel> listaDeClientes;
    private BD db;
    private ClienteModel cliente;
    
    private PlanoDao planoDAO;
    private PlanoModel plano;
    
    public ClienteController(){
        this.planoDAO = new PlanoDao();
        
        this.db = new ClienteDAO();
    }
    
    public ClienteModel getCliente(){
        return this.cliente;
    }
    
    public ArrayList<ClienteModel> getListaDeClientes(){
        return this.listaDeClientes;
    }
    
    public PlanoModel getPlano(){
        return this.plano;
    }
    
    public void buscaPlanoCodigo(int codigo){
        Object o = this.planoDAO.buscar(codigo);
        
        this.plano = (PlanoModel) o;
    }
    
    public void salvar(int codigo, String nome, String telefone, String cep,
            String estado, String cidade, String bairro, String rua, 
            String numero, String rg, String cpf, String dataNascimento, 
            PlanoModel plano) throws Exception{
        SimpleDateFormat formatacao = new SimpleDateFormat("dd/MM/yyyy");
        
        Calendar dataN = Calendar.getInstance();
        
        ClienteModel cli;
        cli = new ClienteModel();
        
        cli.setNome(nome);
        cli.setTelefone(telefone);
        cli.setCep(cep);
        cli.setEstado(estado);
        cli.setCidade(cidade);
        cli.setBairro(bairro);
        cli.setRua(rua);
        cli.setNumero(numero);
        cli.setRg(rg);
        cli.setCpf(cpf);
        
        dataN.setTime(formatacao.parse(dataNascimento));
        
        cli.setDataNascimento(dataN);
        cli.setPlano(plano);
        
        if(codigo == 0){
            this.db.salvar(cli);
        }
        else{
            cli.setCodigo(codigo);
            
            this.db.alterar(cli);
        }
    }
    
    public void buscar(int codigo){
        Object object = this.db.buscar(codigo);
        
        this.cliente = (ClienteModel) object;
    }
    
    public void buscarTodos(){
        this.listaDeClientes = new ArrayList<ClienteModel>();
        
        for (Object object : this.db.buscarTodos()) {
            ClienteModel cli = (ClienteModel) object;
            
            this.listaDeClientes.add(cli);
        }
    }
    
    public void excluir(int codigo) throws Exception{
        this.db.excluir(codigo);
    }
    
}

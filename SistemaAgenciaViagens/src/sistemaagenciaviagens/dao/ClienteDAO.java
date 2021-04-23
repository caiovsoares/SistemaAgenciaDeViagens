package sistemaagenciaviagens.dao;

import java.util.ArrayList;

import sistemaagenciaviagens.model.ClienteModel;

public class ClienteDAO implements BD{

    @Override
    public void salvar(Object object) {
        ClienteModel cli = (ClienteModel) object;
        
        cli.setCodigo(BancoDeDados.getProximoCodigoCliente());
        
        BancoDeDados.getTabelaCliente().add(cli);
        
        BancoDeDados.atualizaProximoCodigoCliente();
    }

    @Override
    public void alterar(Object object) {
        ClienteModel cli = (ClienteModel) object;
        
        for (int i=0; i<BancoDeDados.getTabelaCliente().size(); i++) {
            ClienteModel c = BancoDeDados.getTabelaCliente().get(i);
            
            if(c.getCodigo() == cli.getCodigo()){
                BancoDeDados.getTabelaCliente().set(i, cli);
            }
        }
    }

    @Override
    public void excluir(int codigo) throws Exception {
        if(BancoDeDados.getTabelaCliente() == null){
            throw new Exception("Não existe nenhum cliente cadastrado ainda!\n");
        }
        
        for (int i=0; i<BancoDeDados.getTabelaCliente().size(); i++) {
            ClienteModel cli = BancoDeDados.getTabelaCliente().get(i);
            
            if(cli.getCodigo() == codigo){
                BancoDeDados.getTabelaCliente().remove(i);
                break;
            }
            else if((cli.getCodigo() == codigo) && (i == BancoDeDados.getTabelaCliente().size()-1)){
                throw new Exception("Esse código de cliente não existe!\n");
            }
        }
    }

    @Override
    public Object buscar(int valor) {
        for (ClienteModel cli : BancoDeDados.getTabelaCliente()) {
            if(cli.getCodigo() == valor){
                return cli;
            }
        }
        
        return null;
    }

    @Override
    public ArrayList<Object> buscarTodos() {
        ArrayList<Object> lista = new ArrayList<Object>();
        
        for (ClienteModel cli : BancoDeDados.getTabelaCliente()) {
            lista.add(cli);
        }
        
        return lista;
    }
    
}

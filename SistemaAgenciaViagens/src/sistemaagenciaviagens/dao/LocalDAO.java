package sistemaagenciaviagens.dao;

import java.util.ArrayList;
import sistemaagenciaviagens.model.LocalModel;

public class LocalDAO implements BD{

    public LocalDAO() {
    }

    @Override
    public void salvar(Object o){
        LocalModel local = (LocalModel) o;
        
        local.setCodigo(BancoDeDados.getProximoCodigoLocal());
        
        BancoDeDados.getTabelaLocal().add(local);
        
        BancoDeDados.atualizaProximoCodigoLocal();
    }

    @Override
    public void alterar(Object o) {
        LocalModel local = (LocalModel) o;
        
        for(int i=0; i<BancoDeDados.getTabelaLocal().size(); i++){
            LocalModel lcl = BancoDeDados.getTabelaLocal().get(i);
            
            if(lcl.getCodigo() == local.getCodigo()){
                BancoDeDados.getTabelaLocal().set(i, local);
                break;
            }
        }
    }

    @Override
    public void excluir(int codigo) throws Exception{
        if(BancoDeDados.getTabelaLocal() == null){
            throw new Exception("Não existe nenhum local cadastrado ainda!\n");
        }
        
        for(int i=0; i<BancoDeDados.getTabelaLocal().size(); i++){
            LocalModel lcl = BancoDeDados.getTabelaLocal().get(i);
            
            if(lcl.getCodigo() == codigo){
                BancoDeDados.getTabelaLocal().remove(i);
                break;
            }
            else if((lcl.getCodigo() != codigo) && (i == BancoDeDados.getTabelaLocal().size() - 1)){
                throw new Exception("Esse local não existe!\n");
            }
        }
    }

    @Override
    public Object buscar(int cep) {
        Object lcl = new Object();
        
        for (LocalModel local : BancoDeDados.getTabelaLocal()) {
            if(local.getCepDestino().equals(Integer.toString(cep))){
                lcl = local;
                
                return lcl;
            }
        }
        
        return null;
    }

    @Override
    public ArrayList<Object> buscarTodos() {
        ArrayList<Object> lista = new ArrayList<Object>();
        
        for (LocalModel l : BancoDeDados.getTabelaLocal()) {
            lista.add(l);
        }
        
        return lista;
    }
    
}

package sistemaagenciaviagens.dao;

import java.util.ArrayList;

import sistemaagenciaviagens.model.FuncionarioModel;

public class FuncionarioDAO implements BD{

    @Override
    public void salvar(Object object) {
        FuncionarioModel func = (FuncionarioModel) object;
        
        func.setCodigo(BancoDeDados.getProximoCodigoFuncionario());
        
        BancoDeDados.getTabelaFuncionario().add(func);
        
        BancoDeDados.atualizaProximoCodigoFuncionario();
    }

    @Override
    public void alterar(Object object) {
        FuncionarioModel func = (FuncionarioModel) object;
        
        for(int i=0; i<BancoDeDados.getTabelaFuncionario().size(); i++){
            FuncionarioModel f = BancoDeDados.getTabelaFuncionario().get(i);
            
            if(f.getCodigo() == func.getCodigo()){
                BancoDeDados.getTabelaFuncionario().set(i, func);
                break;
            }
        }
    }

    @Override
    public void excluir(int codigo) throws Exception {
        if(BancoDeDados.getTabelaFuncionario() == null){
            throw new Exception("Não existe nenhum funcionário cadastrado ainda!\n");
        }
        
        for (int i=0; i<BancoDeDados.getTabelaFuncionario().size(); i++) {
            FuncionarioModel f = BancoDeDados.getTabelaFuncionario().get(i);
            
            if(f.getCodigo() == codigo){
                BancoDeDados.getTabelaFuncionario().remove(i);
                break;
            }
            else if((f.getCodigo() != codigo) && (i == BancoDeDados.getTabelaFuncionario().size()-1)){
                throw new Exception("Esse código de funcionário não existe!\n");
            }
        }
    }

    @Override
    public Object buscar(int codigo) {
        for (FuncionarioModel funcionario : BancoDeDados.getTabelaFuncionario()) {
            if(funcionario.getCodigo() == codigo){
                Object f;
                f = funcionario;
                
                return f;
            }
        }
        
        return null;
    }

    @Override
    public ArrayList<Object> buscarTodos() {
        ArrayList<Object> lista = new ArrayList<Object>();
        
        for (FuncionarioModel f : BancoDeDados.getTabelaFuncionario()) {
            lista.add(f);
        }
        
        return lista;
    }
    
}

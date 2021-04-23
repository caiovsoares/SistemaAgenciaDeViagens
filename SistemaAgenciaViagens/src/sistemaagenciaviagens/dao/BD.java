package sistemaagenciaviagens.dao;

import java.util.ArrayList;

public interface BD {

    public abstract void salvar(Object object);
    
    public abstract void alterar(Object object);
    
    public abstract void excluir(int codigo) throws Exception;
    
    public abstract Object buscar(int valor);
    
    public abstract ArrayList<Object> buscarTodos();
    
}

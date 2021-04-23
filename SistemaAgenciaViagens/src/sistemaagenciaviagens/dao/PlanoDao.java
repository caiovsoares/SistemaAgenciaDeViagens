package sistemaagenciaviagens.dao;

import java.util.ArrayList;

import sistemaagenciaviagens.model.LocalModel;
import sistemaagenciaviagens.model.PlanoModel;

public class PlanoDao implements BD {

    @Override
    public void salvar(Object o) {
        PlanoModel p = (PlanoModel) o;
        p.setCodigo(BancoDeDados.getProximoCodigoPlano());
        BancoDeDados.getPlanoTable().add(p);
        BancoDeDados.atualizaProximoCodigoPlano();
    }

    @Override
    public void alterar(Object o) {
        PlanoModel p = (PlanoModel) o;
        for (int i = 0; i < BancoDeDados.getPlanoTable().size(); i++) {
            PlanoModel pl = BancoDeDados.getPlanoTable().get(i);

            if (pl.getCodigo() == p.getCodigo()) {
                BancoDeDados.getPlanoTable().set(i, p);
            }
        }

    }

    @Override
    public void excluir(int cod) throws Exception {

        if (BancoDeDados.getPlanoTable() == null) {
            throw new Exception("Nao a planos cadastrados");
        }
        for (int i = 0; i < BancoDeDados.getPlanoTable().size(); i++) {
            PlanoModel p = BancoDeDados.getPlanoTable().get(i);

            if (p.getCodigo() == cod) {
                BancoDeDados.getPlanoTable().remove(i);
            }
            else if(i == BancoDeDados.getPlanoTable().size()-1){
                throw new Exception("Esse codigo nao existe");
            }
        }

    }

    @Override
    public Object buscar(int cod) {
        Object p = new Object();

        for (int i = 0; i < BancoDeDados.getPlanoTable().size(); i++) {
            PlanoModel pla = BancoDeDados.getPlanoTable().get(i);

            if (pla.getCodigo() == cod) {
                p = pla;
                return p;
            }
        }

        return null;
    }

    @Override
    public ArrayList<Object> buscarTodos() {
        ArrayList<Object> lista = new ArrayList<Object>();

        for (PlanoModel p : BancoDeDados.getPlanoTable()) {
            lista.add(p);
        }

        return lista;
    }

}

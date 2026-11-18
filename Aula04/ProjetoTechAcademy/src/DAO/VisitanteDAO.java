package DAO;

import Dominio.Visitante;
import FakeDB.VisitanteFakeDB;

public class VisitanteDAO extends BaseGenericaDAO<Visitante> {

    @Override
    public Visitante create(Visitante novo) {
        int codigoAtual = this.repositorio.isEmpty() ? 0 : this.repositorio.getLast().getCodigo();
        int codigoNovo = codigoAtual + 1;
        novo.setCodigo(codigoNovo);
        this.repositorio.add(novo);
        return novo;
    }

    @Override
    public Visitante readOne(int codigo) {
        for (Visitante item : this.repositorio) {
            if (item.getCodigo() == codigo) {
                return item;
            }
        }
        return null;
    }

    @Override
    public Visitante update(Visitante alterado) {
        for (int i = 0; i < this.repositorio.size(); i++) {
            if (this.repositorio.get(i).getCodigo() == alterado.getCodigo()) {
                this.repositorio.set(i, alterado);
                return alterado;
            }
        }
        return null;
    }

    @Override
    public Visitante delete(Visitante apagado) {
        if (this.repositorio.remove(apagado)) {
            return apagado;
        }
        return null;
    }

    @Override
    public Visitante deletePorID(int codigo) {
        for (Visitante item : this.repositorio) {
            if (item.getCodigo() == codigo) {
                this.repositorio.remove(item);
                return item;
            }
        }
        return null;
    }

    public VisitanteDAO() {
        this.fonteDados = new VisitanteFakeDB();
        this.repositorio = this.fonteDados.getDados();
    }
}
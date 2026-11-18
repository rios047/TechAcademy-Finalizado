package DAO;

import Dominio.Egresso;
import FakeDB.EgressoFakeDB;

public class EgressoDAO extends BaseGenericaDAO<Egresso> {

    @Override
    public Egresso create(Egresso novo) {
        int codigoAtual = this.repositorio.isEmpty() ? 0 : this.repositorio.getLast().getCodigo();
        int codigoNovo = codigoAtual + 1;
        novo.setCodigo(codigoNovo);
        this.repositorio.add(novo);
        return novo;
    }

    @Override
    public Egresso readOne(int codigo) {
        for (Egresso item : this.repositorio) {
            if (item.getCodigo() == codigo) {
                return item;
            }
        }
        return null;
    }

    @Override
    public Egresso update(Egresso alterado) {
        for (int i = 0; i < this.repositorio.size(); i++) {
            if (this.repositorio.get(i).getCodigo() == alterado.getCodigo()) {
                this.repositorio.set(i, alterado);
                return alterado;
            }
        }
        return null;
    }

    @Override
    public Egresso delete(Egresso apagado) {
        if (this.repositorio.remove(apagado)) {
            return apagado;
        }
        return null;
    }

    @Override
    public Egresso deletePorID(int codigo) {
        for (Egresso item : this.repositorio) {
            if (item.getCodigo() == codigo) {
                this.repositorio.remove(item);
                return item;
            }
        }
        return null;
    }

    public EgressoDAO() {
        this.fonteDados = new EgressoFakeDB();
        this.repositorio = this.fonteDados.getDados();
    }
}
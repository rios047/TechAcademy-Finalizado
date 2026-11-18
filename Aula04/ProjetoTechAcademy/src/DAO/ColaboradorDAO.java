
package DAO;

import Dominio.Colaborador;
import FakeDB.ColaboradorFakeDB;

public class ColaboradorDAO
    extends BaseGenericaDAO<Colaborador> {

    @Override
    public Colaborador create(Colaborador novo) {
        int codigoAtual = this.repositorio.getLast().getCodigo();
        int codigoNovo = codigoAtual + 1;
        novo.setCodigo(codigoNovo);
        this.repositorio.add(novo);
        return novo;
    }

    @Override
    public Colaborador readOne(int codigo) {

        for (Colaborador item : this.repositorio) {

            if (item.getCodigo() == codigo) {
                return item;
            }

        }

        return null;
    }

   @Override
public Colaborador update(Colaborador alterado) {

    for (int i = 0; i < this.repositorio.size(); i++) {

        if (this.repositorio.get(i).getCodigo() == alterado.getCodigo()) {

            this.repositorio.set(i, alterado);

            return alterado;
        }
    }

    return null;
}

    @Override
    public Colaborador delete(Colaborador apagado) {

        return null;
    }

    @Override
    public Colaborador deletePorID(int codigo) {

        for (Colaborador item : this.repositorio) {

            if (item.getCodigo() == codigo) {

                this.repositorio.remove(item);

                return item;
            }

        }

        return null;
    }

    public ColaboradorDAO() {
        this.fonteDados = new ColaboradorFakeDB();
        this.repositorio = this.fonteDados.getDados();
    }
}

package FakeDB;

import java.util.ArrayList;
import Dominio.Visitante;

public class VisitanteFakeDB extends BaseGenericaFakeDB<Visitante> {

    @Override
    protected void autoPreencher() {
        this.dados.add(new Visitante(1, "João Silva", "12345678901", "joao@email.com", "(67) 99999-1111", "Rua A, 100", "Reunião de Negócios", 101, "Financeiro"));
        this.dados.add(new Visitante(2, "Maria Oliveira", "98765432109", "maria@email.com", "(67) 98888-2222", "Rua B, 200", "Entrevista de Emprego", 102, "Recursos Humanos"));
        this.dados.add(new Visitante(3, "Pedro Santos", "45678912345", "pedro@email.com", "(67) 97777-3333", "Rua C, 300", "Manutenção de Equipamentos", 103, "TI"));
    }

    public VisitanteFakeDB() {
        this.dados = new ArrayList<>();
        this.autoPreencher();
    }
}
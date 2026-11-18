package FakeDB;

import java.util.ArrayList;
import Dominio.Egresso;

public class EgressoFakeDB extends BaseGenericaFakeDB<Egresso> {
    
    @Override
    protected void autoPreencher() {
        this.dados.add(new Egresso(1, "Ana Souza", "11122233344", 2023, "Ciência da Computação", "Desenvolvimento Software"));
        this.dados.add(new Egresso(2, "Carlos Lima", "22233344455", 2024, "Análise e Desenvolvimento de Sistemas", "Suporte TI"));
        this.dados.add(new Egresso(3, "Beatriz Mendes", "33344455666", 2025, "Engenharia de Software", "Banco de Dados"));
    }

    public EgressoFakeDB() {
        this.dados = new ArrayList<>();
        this.autoPreencher();
    }
}
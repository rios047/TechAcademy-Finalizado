package Visao;

import java.util.Scanner;
import Dominio.Visitante;
import Servico.VisitanteSRV; // Certifique-se de ter criado o VisitanteSRV

public class VisitanteMenu extends BaseMenu implements IMenu {

    private VisitanteSRV servico;
    private Visitante visitanteSelecionado;

    public void iniciar() {
        this.exibirMenuPrincipal();
    }

    private void exibirMenuPrincipal() {
        this.scan = new Scanner(System.in);
        int opcao = 0;
        while (opcao != 9) {
            opcao = this.exibirMenuPai("VISITANTE");
            switch (opcao) {
                case 1:
                    this.listarTodos();
                    break;
                case 2:
                    this.pesquisarPorCodigo();
                    break;
                case 3:
                    this.incluir();
                    break;
                case 4:
                    this.alterar();
                    break;
                case 5:
                    this.excluir();
                    break;
                case 9:
                    System.out.println("Saindo do Menu de Visitantes...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
                    this.pausar();
                    break;
            }
        }
    }

    @Override
    public void listarTodos() {
        System.out.println("\n\n***** LISTAR TODOS OS VISITANTES *****");
        for (Visitante item : this.servico.listar()) {
            item.exibir();
        }
        this.pausar();
    }

    @Override
    public void pesquisarPorCodigo() {
        System.out.println("\n\n***** PESQUISAR POR CÓDIGO *****");
        System.out.print("Informe o código: ");
        int codigo = this.scan.nextInt();
        this.scan.nextLine();
        this.visitanteSelecionado = this.servico.buscar(codigo);
        if (this.visitanteSelecionado == null) {
            System.out.println("ERRO - Código inválido ou não encontrado.");
            this.pausar();
        } else {
            this.visitanteSelecionado.exibir();
        }
    }

    @Override
    public void incluir() {
        System.out.println("\n\n***** INCLUIR VISITANTE *****");
        System.out.print("Nome: ");
        String nome = this.scan.nextLine();
        System.out.print("CPF: ");
        String cpf = this.scan.nextLine();
        System.out.print("Email: ");
        String email = this.scan.nextLine();
        System.out.print("Telefone: ");
        String telefone = this.scan.nextLine();
        System.out.print("Endereço: ");
        String endereco = this.scan.nextLine();
        System.out.print("Motivo da Visita: ");
        String motivo = this.scan.nextLine();
        System.out.print("Número do Crachá: ");
        int cracha = this.scan.nextInt();
        this.scan.nextLine();
        System.out.print("Setor de Visita: ");
        String setor = this.scan.nextLine();

        Visitante novo = new Visitante(0, nome, cpf, email, telefone, endereco, motivo, cracha, setor);
        novo = this.servico.criar(novo);
        System.out.println("Visitante cadastrado com sucesso!");
        novo.exibir();
        this.pausar();
    }

    @Override
    public void alterar() {
        System.out.println("\n\n***** ALTERAR VISITANTE *****");
        this.pesquisarPorCodigo();
        if (this.visitanteSelecionado != null) {
            int escolha = 0;
            while (escolha != 9) {
                System.out.println("\n##### CAMPOS DISPONÍVEIS #####");
                System.out.println("1 - Nome");
                System.out.println("2 - Motivo da Visita");
                System.out.println("3 - Setor de Visita");
                System.out.println("9 - Salvar e Sair");
                System.out.print("Escolha uma opção: ");
                escolha = this.scan.nextInt();
                this.scan.nextLine();
                switch (escolha) {
                    case 1:
                        System.out.print("Novo Nome: ");
                        this.visitanteSelecionado.setNome(this.scan.nextLine());
                        break;
                    case 2:
                        System.out.print("Novo Motivo: ");
                        this.visitanteSelecionado.setMotivoVisita(this.scan.nextLine());
                        break;
                    case 3:
                        System.out.print("Novo Setor: ");
                        this.visitanteSelecionado.setSetorVisita(this.scan.nextLine());
                        break;
                    case 9:
                        this.visitanteSelecionado = this.servico.alterar(this.visitanteSelecionado);
                        System.out.println("Atualizado com sucesso!");
                        this.visitanteSelecionado.exibir();
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            }
        }
        this.pausar();
    }

    @Override
    public void excluir() {
        System.out.println("\n\n***** EXCLUIR VISITANTE *****");
        this.pesquisarPorCodigo();
        if (this.visitanteSelecionado != null) {
            int codigo = this.visitanteSelecionado.getCodigo();
            this.servico.excluirPorID(codigo);
            System.out.println("Visitante excluído com sucesso!");
        }
        this.pausar();
    }

    public VisitanteMenu() {
        this.servico = new VisitanteSRV();
    }
}

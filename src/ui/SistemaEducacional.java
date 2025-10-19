package ui;

import service.SistemaService;
import java.util.Scanner;

public class SistemaEducacional {

    private static final Scanner scanner = new Scanner(System.in);
    private static final SistemaService service = new SistemaService();

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Sistema de Gestão Educacional EduConnect!");
        int opcao = -1;

        while (opcao != 0) {
            exibirMenu();
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                processarOpcao(opcao);
            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, digite um número válido.");
            }
        }
        System.out.println("Obrigado por usar o sistema EduConnect!");
    }

    private static void exibirMenu() {
        System.out.println("\n===== MENU PRINCIPAL =====");
        System.out.println("1. Cadastrar Aluno");
        System.out.println("2. Cadastrar Professor");
        System.out.println("3. Cadastrar Curso");
        System.out.println("4. Criar Turma");
        System.out.println("5. Adicionar Aluno à Turma");
        System.out.println("6. Registrar Avaliação de Aluno");
        System.out.println("7. Gerar Relatório Geral");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1: cadastrarAluno(); break;
            case 2: cadastrarProfessor(); break;
            case 3: cadastrarCurso(); break;
            case 4: criarTurma(); break;
            case 5: adicionarAlunoNaTurma(); break;
            case 6: registrarAvaliacao(); break;
            case 7: service.gerarRelatoriosGerais(); break;
            case 0: break;
            default: System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void cadastrarAluno() {
        System.out.println("\n--- Cadastro de Aluno ---");
        System.out.print("Nome: "); String nome = scanner.nextLine();
        System.out.print("Matrícula: "); String matricula = scanner.nextLine();
        System.out.print("Login: "); String login = scanner.nextLine();
        System.out.print("Senha: "); String senha = scanner.nextLine();
        service.cadastrarAluno(nome, matricula, login, senha);
    }

    private static void cadastrarProfessor() {
        System.out.println("\n--- Cadastro de Professor ---");
        System.out.print("Nome: "); String nome = scanner.nextLine();
        System.out.print("Especialidade: "); String esp = scanner.nextLine();
        System.out.print("Registro: "); String reg = scanner.nextLine();
        System.out.print("Login: "); String login = scanner.nextLine();
        System.out.print("Senha: "); String senha = scanner.nextLine();
        service.cadastrarProfessor(nome, esp, reg, login, senha);
    }

    private static void cadastrarCurso() {
        System.out.println("\n--- Cadastro de Curso ---");
        System.out.print("Nome: "); String nome = scanner.nextLine();
        System.out.print("Código: "); String cod = scanner.nextLine();
        System.out.print("Carga Horária: "); int ch = Integer.parseInt(scanner.nextLine());
        System.out.print("Tipo (1-Presencial, 2-EAD): "); int tipo = Integer.parseInt(scanner.nextLine());
        String extra = "";
        if (tipo == 1) {
            System.out.print("Sala de Aula: ");
            extra = scanner.nextLine();
        } else {
            System.out.print("Plataforma Virtual: ");
            extra = scanner.nextLine();
        }
        service.cadastrarCurso(nome, cod, ch, tipo, extra);
    }

    private static void criarTurma() {
        System.out.println("\n--- Criação de Turma ---");
        System.out.print("Código da Turma: "); String codTurma = scanner.nextLine();
        System.out.print("Registro do Professor: "); String regProf = scanner.nextLine();
        System.out.print("Código do Curso: "); String codCurso = scanner.nextLine();
        service.criarTurma(codTurma, regProf, codCurso);
    }

    private static void adicionarAlunoNaTurma() {
        System.out.println("\n--- Adicionar Aluno à Turma ---");
        System.out.print("Matrícula do Aluno: "); String matAluno = scanner.nextLine();
        System.out.print("Código da Turma: "); String codTurma = scanner.nextLine();
        service.adicionarAlunoNaTurma(matAluno, codTurma);
    }

    private static void registrarAvaliacao() {
        System.out.println("\n--- Registrar Avaliação ---");
        System.out.print("Código da Turma: "); String codTurma = scanner.nextLine();
        System.out.print("Matrícula do Aluno: "); String matAluno = scanner.nextLine();
        System.out.print("Descrição da Avaliação (Ex: Prova 1): "); String desc = scanner.nextLine();
        System.out.print("Nota (0 a 10): "); double nota = Double.parseDouble(scanner.nextLine());
        service.registrarAvaliacao(matAluno, codTurma, desc, nota);
    }
}
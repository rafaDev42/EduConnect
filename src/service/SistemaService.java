package service;

import model.*;
import repository.RepositorioGeral;

public class SistemaService {
    private final RepositorioGeral repositorio = new RepositorioGeral();

    public void cadastrarAluno(String nome, String matricula, String login, String senha) {
        if (repositorio.buscarAlunoPorMatricula(matricula) != null) {
            System.out.println("Erro: Já existe um aluno com esta matrícula.");
            return;
        }
        Aluno novoAluno = new Aluno(nome, matricula, login, senha);
        repositorio.salvarAluno(novoAluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    public void cadastrarProfessor(String nome, String esp, String reg, String login, String senha) {
        Professor novoProfessor = new Professor(nome, esp, reg, login, senha);
        repositorio.salvarProfessor(novoProfessor);
        System.out.println("Professor cadastrado com sucesso!");
    }

    public void cadastrarCurso(String nome, String cod, int ch, int tipo, String extra) {
        Curso novoCurso;
        if (tipo == 1) {
            novoCurso = new CursoPresencial(nome, cod, ch, extra);
        } else {
            novoCurso = new CursoEAD(nome, cod, ch, extra);
        }
        repositorio.salvarCurso(novoCurso);
        System.out.println("Curso cadastrado com sucesso!");
    }

    public void criarTurma(String codTurma, String regProf, String codCurso) {
        Professor prof = repositorio.buscarProfessorPorRegistro(regProf);
        Curso curso = repositorio.buscarCursoPorCodigo(codCurso);
        if (prof != null && curso != null) {
            Turma novaTurma = new Turma(codTurma, prof, curso);
            repositorio.salvarTurma(novaTurma);
            System.out.println("Turma criada com sucesso!");
        } else {
            System.out.println("Erro: Professor ou curso não encontrado.");
        }
    }

    public void adicionarAlunoNaTurma(String matAluno, String codTurma) {
        Aluno aluno = repositorio.buscarAlunoPorMatricula(matAluno);
        Turma turma = repositorio.buscarTurmaPorCodigo(codTurma);
        if (aluno != null && turma != null) {
            turma.adicionarAluno(aluno);
            System.out.println("Aluno " + aluno.getNome() + " adicionado à turma " + turma.getCodigo());
        } else {
            System.out.println("Erro: Aluno ou turma não encontrado.");
        }
    }

    public void registrarAvaliacao(String matAluno, String codTurma, String desc, double nota) {
        Turma turma = repositorio.buscarTurmaPorCodigo(codTurma);
        if (turma == null) { System.out.println("Erro: Turma não encontrada."); return; }

        Aluno aluno = turma.getListaAlunos().stream()
                .filter(a -> a.getMatricula().equals(matAluno))
                .findFirst().orElse(null);

        if (aluno == null) { System.out.println("Erro: Aluno não está nesta turma."); return; }

        Avaliacao avaliacao = new Avaliacao(desc);
        if (avaliacao.atribuirNota(nota)) {
            aluno.adicionarAvaliacao(avaliacao);
            System.out.println("Avaliação registrada com sucesso para o aluno " + aluno.getNome());
        } else {
            System.out.println("Erro: A nota é inválida (deve ser entre 0 e 10).");
        }
    }

    public void gerarRelatoriosGerais() {
        System.out.println("\n--- RELATÓRIO GERAL DO SISTEMA ---");
        System.out.println("\n--- PROFESSORES ---");
        repositorio.listarTodosProfessores().forEach(p -> System.out.println(p.gerarRelatorio()));

        System.out.println("\n--- ALUNOS ---");
        repositorio.listarTodosAlunos().forEach(a -> System.out.println(a.gerarRelatorio()));

        System.out.println("\n--- CURSOS ---");
        repositorio.listarTodosCursos().forEach(c -> System.out.println(c.detalharCurso()));

        System.out.println("\n--- TURMAS ---");
        repositorio.listarTodasTurmas().forEach(t -> System.out.println(t.mostrarResumo()));

        System.out.println("--- FIM DO RELATÓRIO ---");
    }
}
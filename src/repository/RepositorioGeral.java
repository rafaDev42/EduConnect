package repository;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioGeral {
    private final List<Aluno> alunos = new ArrayList<>();
    private final List<Professor> professores = new ArrayList<>();
    private final List<Curso> cursos = new ArrayList<>();
    private final List<Turma> turmas = new ArrayList<>();

    public void salvarAluno(Aluno aluno) { alunos.add(aluno); }
    public Aluno buscarAlunoPorMatricula(String matricula) {
        return alunos.stream().filter(a -> a.getMatricula().equals(matricula)).findFirst().orElse(null);
    }
    public List<Aluno> listarTodosAlunos() { return alunos; }

    public void salvarProfessor(Professor prof) { professores.add(prof); }
    public Professor buscarProfessorPorRegistro(String registro) {
        return professores.stream().filter(p -> p.getRegistro().equals(registro)).findFirst().orElse(null);
    }
    public List<Professor> listarTodosProfessores() { return professores; }

    public void salvarCurso(Curso curso) { cursos.add(curso); }
    public Curso buscarCursoPorCodigo(String codigo) {
        return cursos.stream().filter(c -> c.getCodigo().equals(codigo)).findFirst().orElse(null);
    }
    public List<Curso> listarTodosCursos() { return cursos; }

    public void salvarTurma(Turma turma) { turmas.add(turma); }
    public Turma buscarTurmaPorCodigo(String codigo) {
        return turmas.stream().filter(t -> t.getCodigo().equals(codigo)).findFirst().orElse(null);
    }
    public List<Turma> listarTodasTurmas() { return turmas; }
}
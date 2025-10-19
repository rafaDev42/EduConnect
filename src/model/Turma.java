package model;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String codigo;
    private Professor professor;
    private Curso curso;
    private List<Aluno> listaAlunos;

    public Turma(String codigo, Professor professor, Curso curso) {
        this.codigo = codigo;
        this.professor = professor;
        this.curso = curso;
        this.listaAlunos = new ArrayList<>();
    }

    public String getCodigo() { return codigo; }
    public List<Aluno> getListaAlunos() { return listaAlunos; }

    public void adicionarAluno(Aluno aluno) {
        if (!listaAlunos.contains(aluno)) {
            listaAlunos.add(aluno);
        }
    }

    public String mostrarResumo() {
        return String.format("--- Resumo da Turma: %s ---\nCurso: %s\nProfessor: %s\nAlunos: %d\n",
                codigo, curso.getNome(), professor.getNome(), listaAlunos.size());
    }
}
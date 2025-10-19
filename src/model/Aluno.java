package model;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario implements Autenticavel, GeradorDeRelatorio {
    private String matricula;
    private List<Avaliacao> avaliacoes;

    public Aluno(String nome, String matricula, String login, String senha) {
        super(nome, login, senha);
        this.matricula = matricula;
        this.avaliacoes = new ArrayList<>();
    }

    public String getMatricula() { return matricula; }
    public void adicionarAvaliacao(Avaliacao avaliacao) { this.avaliacoes.add(avaliacao); }

    @Override
    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }

    @Override
    public String gerarRelatorio() {
        return String.format("[ALUNO] Nome: %s | Matrícula: %s", nome, matricula);
    }
}
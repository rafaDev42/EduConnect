package model;

public class Professor extends Usuario implements Autenticavel, GeradorDeRelatorio {
    private String especialidade;
    private String registro;

    public Professor(String nome, String especialidade, String registro, String login, String senha) {
        super(nome, login, senha);
        this.especialidade = especialidade;
        this.registro = registro;
    }

    public String getRegistro() { return registro; }

    @Override
    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }

    @Override
    public String gerarRelatorio() {
        return String.format("[PROFESSOR] Nome: %s | Especialidade: %s | Registro: %s", nome, especialidade, registro);
    }
}
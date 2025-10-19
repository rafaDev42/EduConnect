package model;

public class Curso implements GeradorDeRelatorio {
    protected String nome;
    protected String codigo;
    protected int cargaHoraria;

    public Curso(String nome, String codigo, int cargaHoraria) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() { return nome; }
    public String getCodigo() { return codigo; }

    public String detalharCurso() {
        return String.format("Curso: %s | Código: %s | Carga Horária: %d h", nome, codigo, cargaHoraria);
    }

    @Override
    public String gerarRelatorio() {
        return String.format("[CURSO] %s (%s)", nome, codigo);
    }
}
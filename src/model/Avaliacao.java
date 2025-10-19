package model;

public class Avaliacao {
    private double nota;
    private String descricao;

    public Avaliacao(String descricao) {
        this.descricao = descricao;
        this.nota = -1;
    }

    public boolean atribuirNota(double valor) {
        if (valor >= 0 && valor <= 10) {
            this.nota = valor;
            return true;
        } else {
            return false;
        }
    }
}

package model;

/**
 * FASE 5: Interface que define um "contrato" de autenticação.
 */
public interface Autenticavel {
    boolean autenticar(String login, String senha);
}
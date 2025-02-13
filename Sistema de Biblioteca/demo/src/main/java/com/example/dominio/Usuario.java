package com.example.dominio;

public class Usuario {
    private String nome;
    private String cpf;
    private String email;
    private String preferenciaNotificacao;
   
    

    public Usuario(String nome, String cpf, String email, String preferenciaNotificacao) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.preferenciaNotificacao = preferenciaNotificacao;
       
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email; 
    }

    public String getPreferenciaNotificacao() {
        return preferenciaNotificacao;
    }

    public void setPreferenciaNotificacao(String preferenciaNotificacao) {
        this.preferenciaNotificacao = preferenciaNotificacao;
    }


    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf + ", Email: " + email + ", Preferência de Notificação: " + preferenciaNotificacao;
    }
}



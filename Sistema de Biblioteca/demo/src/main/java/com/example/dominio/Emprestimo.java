package com.example.dominio;
import java.util.Date;

public class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private String dataEmprestimo;
    private Date dataDevolucao;

    public Emprestimo(Livro livro, Usuario usuario, Date dataEmprestimo, Date dataDevolucao2) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = new java.util.Date().toString();
        this.dataDevolucao = dataDevolucao2;
    }

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        return "Livro: " + livro.getTitulo() + ", Usuario: " + usuario.getNome() + ", Data Empréstimo: " + dataEmprestimo + ", Data Devolução: " + dataDevolucao;
    }
}

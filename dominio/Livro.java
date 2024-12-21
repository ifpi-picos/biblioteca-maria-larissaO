public class Livro {
    private String autor;
    private String titulo;
    private String editora;
    private int ano;
    private boolean emprestado;

    public Livro(String autor, String titulo, String editora, int ano) {
        this.autor = autor;
        this.titulo = titulo;
        this.editora = editora;
        this.ano = ano;
        this.emprestado = false;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor){
        this.autor = autor; 
    }

    public String getTitulo() {
        return titulo;
    }

    public void getTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
        
    }
    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Ano: " + ano + ", Editora: " + editora + ", Emprestado: " + (emprestado ? "Sim" : "Não");
    }
}


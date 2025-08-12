package dev.marques.jspproject.model;

public class JavaBeans {

    private String idcon;

    private String nome;

    private String fone;

    private String email;

    public JavaBeans() {
        super();
    }

    public JavaBeans(String idcon, String nome, String fone, String email) {
        this.idcon = idcon;
        this.nome = nome;
        this.fone = fone;
        this.email = email;
    }

    public String getIdcon() {
        return idcon;
    }

    public JavaBeans setIdcon(String idcon) {
        this.idcon = idcon;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public JavaBeans setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getFone() {
        return fone;
    }

    public JavaBeans setFone(String fone) {
        this.fone = fone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public JavaBeans setEmail(String email) {
        this.email = email;
        return this;
    }
}

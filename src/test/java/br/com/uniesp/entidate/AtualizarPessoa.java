package br.com.uniesp.entidate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AtualizarPessoa {

    private String nome;
    private String job;
    @JsonProperty("updatedAt")
    private String updatedAt;

    public AtualizarPessoa(String nome, String job, String updatedAt) {
        super();
        this.nome = nome;
        this.job = job;
        this.updatedAt = updatedAt;
    }


    public String getCreatedAt() {
        return updatedAt;
    }

    public void setCreatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public AtualizarPessoa() {
        super();
        // TODO Auto-generated constructor stub
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
}

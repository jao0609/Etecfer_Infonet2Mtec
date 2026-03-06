package br.com.etecfer.etecfer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Aluno {

    // definição dos atributos da entidade aluno
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAluno;

    @Column(nullable = false, length = 40)
    private String nomeAluno;

    @Column(length = 40)
    private String emailAluno;

    @Column(nullable = false, length = 11)
    private String telefoneAluno;

    @Column(nullable = false)
    private Integer raAluno;

    @Column(nullable = false, length = 11)
    private String cpfAluno;


    // metodos construtores

    public Aluno() {
    }


    public Aluno(Integer idAluno, String nomeAluno, String emailAluno, String telefoneAluno, Integer raAluno,
            String cpfAluno) {
        this.idAluno = idAluno;
        this.nomeAluno = nomeAluno;
        this.emailAluno = emailAluno;
        this.telefoneAluno = telefoneAluno;
        this.raAluno = raAluno;
        this.cpfAluno = cpfAluno;
    }


}

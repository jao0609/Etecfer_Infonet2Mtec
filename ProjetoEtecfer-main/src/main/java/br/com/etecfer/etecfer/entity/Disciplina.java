package br.com.etecfer.etecfer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Disciplina {
    
    //DEfinição dos atributos da entidade Aluno
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idDisciplina;
    
    @Column(nullable = false,length = 40)
    private String nomeDisciplina;

    @Column(length = 3)
    private String siglaDisciplina;

    @Column(nullable = false)
    private String chDisciplina;
      
}
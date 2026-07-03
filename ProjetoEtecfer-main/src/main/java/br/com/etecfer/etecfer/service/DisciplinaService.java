package br.com.etecfer.etecfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etecfer.etecfer.entity.Disciplina;
import br.com.etecfer.etecfer.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

    //injeção de dependência para a classe curso
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    //Método para salvar um curso
    public Disciplina save(Disciplina disciplina){
        return disciplinaRepository.save(disciplina);
    }

    //Método para listar todos os curso
    public List<Disciplina> findAll(){
        return disciplinaRepository.findAll();
    }

    //Método para excluir um curso pelo id
    public void deleteById(Integer id){
        disciplinaRepository.deleteById(id);
    }

    //Método para buscar o curso pelo id
    public Disciplina findById(Integer id){
        return disciplinaRepository.findById(id).orElse(null);
    }

    
}
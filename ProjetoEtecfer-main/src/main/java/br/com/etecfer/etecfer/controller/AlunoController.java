package br.com.etecfer.etecfer.controller;
//Esse é o certo
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import br.com.etecfer.etecfer.entity.Aluno;
import br.com.etecfer.etecfer.entity.Curso;
import br.com.etecfer.etecfer.service.AlunoService;
import br.com.etecfer.etecfer.service.CursoService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
    @RequestMapping("/alunos")
    public class AlunoController{

        //Injeção de dependência da service para a classe aluno
        @Autowired
        private AlunoService alunoService;

        @Autowired
        private CursoService cursoService;

        //Método para salvar um aluno
        @PostMapping("/salvar")
        public String salvar(@ModelAttribute Aluno aluno,
            @RequestParam("foto") MultipartFile foto) {
            try{
                if(!foto.isEmpty()){
                    aluno.setFotoaluno(foto.getBytes());
                }else if(aluno.getIdAluno() != null){
                    Aluno alunoExistente = alunoService.findById(aluno.getIdAluno());
                    if(alunoExistente != null){
                        aluno.setFotoaluno(alunoExistente.getFotoaluno());
                        aluno.setTipofoto(alunoExistente.getTipofoto());
                    }
                }
                alunoService.save(aluno);
            } catch (Exception e){
                e.printStackTrace();
            }
            return "redirect:/alunos/listar";
        }

        //Método para listar todos os alunos
        @GetMapping("/listar")
        public String listar(Model model) {
            List <Aluno> alunos = alunoService.findAll();
            model.addAttribute("alunos", alunos);
            return "aluno/ListarAlunos.html";
        }

        //Método para criar um formulário com um novo objeto aluno
        @GetMapping("/criar")
        public String criarForm(Model model) {
            model.addAttribute("aluno", new Aluno());
            List<Curso> cursos = cursoService.findAll();
            model.addAttribute("cursos", cursos);
            return "aluno/formularioAluno";
        }

        //Método para excluir um aluno
        @GetMapping("/excluir/{id}")
        public String excluir(@PathVariable("id") Integer id) {
            alunoService.deleteById(id);
            return "redirect:/alunos/listar";
        }

        //Método para abrir o formulario de edição de alunos
        @GetMapping("/editar/{id}")
        public String editarForm(@PathVariable("id") Integer id, Model model) {
            Aluno aluno = alunoService.findById(id);
            model.addAttribute("aluno", aluno);
            List<Curso> cursos = cursoService.findAll();
            model.addAttribute("cursos", cursos);
            return "aluno/formularioAluno";
        }



        
    }
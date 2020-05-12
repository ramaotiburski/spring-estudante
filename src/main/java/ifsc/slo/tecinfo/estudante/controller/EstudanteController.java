/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsc.slo.tecinfo.estudante.controller;

import ifsc.slo.tecinfo.estudante.modelo.Curso;
import ifsc.slo.tecinfo.estudante.modelo.Estudante;
import ifsc.slo.tecinfo.estudante.repositorio.CursoRepositorio;
import ifsc.slo.tecinfo.estudante.repositorio.EstudanteRepositorio;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ramao
 */
@Controller
@RequestMapping("/estudantes/")
public class EstudanteController {

    private List<Estudante> estudantes = new ArrayList<>();

    private EstudanteRepositorio repositorio;
    @Autowired
    private CursoRepositorio cursoRepositorio;

    @Autowired
    public EstudanteController(EstudanteRepositorio repositorio) {
        this.repositorio = repositorio;
    }


    @GetMapping("cadastrar")
    public String showSignUpForm(Estudante student, Model model) {
        
        List<Curso> cursosNoBanco = (List) cursoRepositorio.findAll();
        
        if(cursosNoBanco.isEmpty()){
            setCursos();
        }        
        model.addAttribute("cursos", cursoRepositorio.findAll());
        return "add-student";
    }

    @GetMapping("mostrar")
    public String showUpdateForm(Model model) {
        //model.addAttribute("estudantes", estudantes);
        model.addAttribute("estudantes", repositorio.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addStudent(@Valid Estudante estudante, BindingResult result, Model model) {

        //System.out.println("ANTES:" + estudante.getCurso().getCargaHoraria());

        //estudante.setCurso(procurarCurso(estudante.getCurso().getCodCurso()));

        //System.out.println("DEPOIS:" + estudante.getCurso().getCargaHoraria());

        repositorio.save(estudante);
        
        //estudantes.add(estudante);
        return "redirect:mostrar";
    }

    @GetMapping("editar/{matricula}")
    public String showUpdateForm(@PathVariable("matricula") long matricula, Model model) {
        Estudante estudante = repositorio.findById(matricula)
				.orElseThrow(() -> new IllegalArgumentException("Matrícula de estudante inválida:" + matricula));
        model.addAttribute("estudante", estudante);
        model.addAttribute("cursos", cursoRepositorio.findAll());
        return "update-student";
    }

    @PostMapping("update/{matricula}")
    public String updateStudent(@PathVariable("matricula") long matricula, @Valid Estudante estudante, Model model) {

        repositorio.save(estudante);
        return "redirect:/estudantes/mostrar";
    }

    @GetMapping("apagar/{matricula}")
    public String deleteStudent(@PathVariable("matricula") long matricula, Model model) {
        Estudante estudante = repositorio.findById(matricula)
				.orElseThrow(() -> new IllegalArgumentException("Matrícula de estudante inválida:" + matricula));
        repositorio.delete(estudante);
        //model.addAttribute("estudantes", estudantes);
        return "redirect:/estudantes/mostrar";
    }


    public void setCursos() {
            cursoRepositorio.save(new Curso(1, "Logística", 800));
            cursoRepositorio.save(new Curso(2, "Administração", 1200));
            cursoRepositorio.save(new Curso(3, "Agronegócio", 1200));
            cursoRepositorio.save(new Curso(4, "Informática", 1200));
            cursoRepositorio.save(new Curso(5, "Inglês", 60));
    }

}

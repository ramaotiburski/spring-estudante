/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsc.slo.tecinfo.estudante.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ramao
 */
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codCurso;
    private String nome;
    private int cargaHoraria;

    public Curso() {
    }
    /*
    public Curso(int codCurso, String nome) {
        this.codCurso = codCurso;
        this.nome = nome;
    }*/

    public Curso(int codCurso, String nome, int cargaHoraria) {
        this.codCurso = codCurso;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "O curso é de " + nome + " e possui carga horária de " + cargaHoraria + " horas";
    }
    
    

    

    

    
    
    
    
}

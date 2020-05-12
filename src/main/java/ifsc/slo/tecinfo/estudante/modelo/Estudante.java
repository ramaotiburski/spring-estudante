package ifsc.slo.tecinfo.estudante.modelo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Estudante {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long matricula;
    private String nome;
    private String email;
    private String telefone;
    @OneToOne
    private Curso curso;

    public Estudante(long matricula, String nome, String email, String telefone, Curso curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.curso = curso;
    }

    public Estudante() {
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Estudante{" + "matricula=" + matricula + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", curso=" + curso + '}';
    }

    
    
    
    
    
    
    
}
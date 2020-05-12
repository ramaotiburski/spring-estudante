/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsc.slo.tecinfo.estudante.repositorio;

import ifsc.slo.tecinfo.estudante.modelo.Curso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ramao
 */
@Repository
public interface CursoRepositorio extends CrudRepository<Curso, Integer>{
    
}

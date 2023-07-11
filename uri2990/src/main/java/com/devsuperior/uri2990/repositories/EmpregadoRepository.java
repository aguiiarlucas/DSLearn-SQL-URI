package com.devsuperior.uri2990.repositories;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.entities.Empregado;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {


    @Query(nativeQuery = true, value =
            "SELECT empregados.cpf,empregados.enome,departamentos.dnome " +
                    "FROM empregados " +
                    "INNER JOIN departamentos on empregados.dnumero = departamentos.dnumero " +
                    "WHERE empregados.cpf NOT IN ( " +
                    "SELECT empregados.cpf " +
                    "FROM empregados " +
                    "INNER JOIN trabalha on trabalha.cpf_emp = empregados.cpf " +
                    ") " +
                    "ORDER BY empregados.cpf")
    List<EmpregadoDeptProjection> search1();

    @Query("SELECT new com.devsuperior.uri2990.dto.EmpregadoDeptDTO(obj.cpf, obj.enome, obj.departamento.dnome) " +
            "FROM Empregado obj " +
            "WHERE obj.cpf NOT IN ( " +
                "SELECT obj.cpf " +
                "FROM Empregado obj " +
            "INNER JOIN obj.projetosOndeTrabalha" +
            ") " +
            "ORDER BY obj.cpf")
    List<EmpregadoDeptDTO> search2();
}
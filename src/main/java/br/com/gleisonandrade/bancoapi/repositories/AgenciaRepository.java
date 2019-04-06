/**
 * 
 */
package br.com.gleisonandrade.bancoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gleisonandrade.bancoapi.domain.Agencia;

/**
 * @author <a href="malito:gleisondeandradeesilva@gmail.com">Gleison Andrade</a>
 *
 */
public interface AgenciaRepository extends JpaRepository<Agencia, Long> {

}

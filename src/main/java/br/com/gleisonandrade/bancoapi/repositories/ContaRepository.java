/**
 * 
 */
package br.com.gleisonandrade.bancoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gleisonandrade.bancoapi.domain.Conta;

/**
 * @author <a href="malito:gleisondeandradeesilva@gmail.com">Gleison Andrade</a>
 *
 */
public interface ContaRepository extends JpaRepository<Conta, Long> {

}
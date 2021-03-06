/**
 * 
 */
package br.com.gleisonandrade.bancoapi.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author <a href="malito:gleisondeandradeesilva@gmail.com">Gleison Andrade</a>
 *
 */
@ApiModel(description="Todos os dados sobre a Conta necessários para realizar saque. ")
public class SaqueDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Id do banco que a conta pertence. ")
	@NotNull(message="Preenchimento obrigatório")
	private Long bancoId;
	
	@ApiModelProperty(notes = "Número da Agencia que a conta pertence. ")
	@NotEmpty(message="Preenchimento obrigatório")
	private String agenciaNumero;
	
	@ApiModelProperty(notes = "Número da conta. ")
	@NotEmpty(message="Preenchimento obrigatório")
	@Pattern(regexp="\\d{5}-\\d{1}", message="O número da conta deve possuir o seguinte formato 00000-0 e ser formado apenas por números!")
	private String contaNumero;
	
	@ApiModelProperty(notes = "O tipo de conta. (CORRENTE ou POUPANCA)")
	@NotEmpty(message="Preenchimento obrigatório")
//	@Pattern(regexp="/([POUPANCA|CORRENTE])/g", message="O valor informado é inválido, era esperado CORRENTE ou POUPANCA")
	private String tipo;
	
	@ApiModelProperty(notes = "Valor que será sacado da conta. ")
	@PositiveOrZero(message="O valor deve ser maior ou igual a zero")
	@NotNull(message="Preenchimento obrigatório")
	private Double valor;

	public Long getBancoId() {
		return bancoId;
	}

	public void setBancoId(Long bancoId) {
		this.bancoId = bancoId;
	}

	public String getAgenciaNumero() {
		return agenciaNumero;
	}

	public void setAgenciaNumero(String agenciaNumero) {
		this.agenciaNumero = agenciaNumero;
	}

	public String getContaNumero() {
		return contaNumero;
	}

	public void setContaNumero(String contaNumero) {
		this.contaNumero = contaNumero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}

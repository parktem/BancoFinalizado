package es.salesianos.model;

public class User implements IEntity<String> {

	String numero;
	Integer saldo;

	

	@Override
	public String getId() {
		return null;
	}

	@Override
	public void setId(String id) {

	}


	/**
	 * @return the saldo
	 */
	public Integer getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

}

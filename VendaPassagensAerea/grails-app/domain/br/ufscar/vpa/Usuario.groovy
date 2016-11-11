package br.ufscar.vpa

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class Usuario implements Serializable {

	private static final long serialVersionUID = 1

	transient springSecurityService

	String username
	String password
	
	//String nome
	//String sobreNome
	//String email
	//Date dataNascimento
	//String passaporte
	
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	//talvez deverá alterar o construtor passando os parametros adicionados manualmente
	Usuario(String username, String password) {
		this()
		this.username = username
		this.password = password
	}

	Set<Papel> getAuthorities() {
		UsuarioPapel.findAllByUsuario(this)*.papel
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}

	static transients = ['springSecurityService']

	static constraints = {
		username blank: false, unique: true
		password blank: false
	//	nome (blank: false, size:1..20)
	//	sobreNome (blank: false, size:1..20)
		//email (blank: false, unique: true, email: true)
		//dataNascimento (blank: false)
		//passaporte (blank: false)
	}

	static mapping = {
		password column: '`password`'
	}
}

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
	String nomeCompleto
	
	
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	Usuario(String username, String password, String nomeCompleto) {
		this()
		this.username = username
		this.password = password
		this.nomeCompleto = nomeCompleto
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
		password blank: false, password: true
		nomeCompleto blank: false
	}

	static mapping = {
		password column: '`password`'
	}
}

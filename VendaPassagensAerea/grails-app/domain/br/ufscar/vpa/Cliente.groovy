package br.ufscar.vpa

class Cliente extends Usuario{

    static constraints = {
    	nome (blank: false, size:1..20)
		sobreNome (blank: false, size:1..20)
		email (blank: false, unique: true, email: true)
		dataNascimento (blank: false)
		passaporte (blank: false)
		username blank: false, unique: true
		password blank: false, password: true
    }
    
    String nome
	String sobreNome
	String email
	Date dataNascimento
	String passaporte
	
	@Override
	String toString(){
		return nome + " " + sobreNome
	}
}

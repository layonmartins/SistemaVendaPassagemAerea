package br.ufscar.vpa

class Compra {

	static hasMany=[compravoo: CompraVoo]
    static constraints = {
    	data(nullable: false)
    	cliente nullable: false
    }
    
    Date data
    Cliente cliente
}

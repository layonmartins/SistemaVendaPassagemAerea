package br.ufscar.vpa

class Voo {

	static hasMany = [compravoo:CompraVoo]
    static constraints = {
    	numeroVoo(nullable:false, min: 0)
    	data(nullable: false)
    	lugaresDisponiveis(nullable:false, min: 0)
    	aviao(nullable: false)
    }
    
    int numeroVoo
    Date data
    int lugaresDisponiveis
    
    Aviao aviao
    Especificacao especificacao
    
}

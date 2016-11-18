package br.ufscar.vpa

class Voo {

	static hasMany = [compravoo:CompraVoo]
    static constraints = {
    	numeroVoo(blank:false)
    	data(nullable: false)
    	lugaresDisponiveis(nullable:false, min: 0)
    	aviao(nullable: false)
    }
    
    String numeroVoo
    Date data
    int lugaresDisponiveis
    
    Aviao aviao
    Especificacao especificacao
    
}

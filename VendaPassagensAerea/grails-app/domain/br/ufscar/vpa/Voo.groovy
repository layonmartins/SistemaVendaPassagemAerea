package br.ufscar.vpa

class Voo {

	static hasMany = [compravoo:CompraVoo]
    static constraints = {
    	numeroVoo(blank:false)
    	data(nullable: false)
    	lugaresDisponiveis(nullable:false, min: 0)
    	aviao(nullable: false)
    	especificacao(nullable: false)
    }
    
    String numeroVoo
    Date data
    int lugaresDisponiveis
    
    Aviao aviao
    Especificacao especificacao
    
    @Override
	String toString(){
		return 'Voo_id.: [ ' + id + '] - Voo: [' + especificacao.origem + ' >> ' + especificacao.destino + '] - data: [' + data +']'
	}
    
}

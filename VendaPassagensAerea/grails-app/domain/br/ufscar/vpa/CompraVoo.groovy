package br.ufscar.vpa

class CompraVoo {

    static constraints = {
    	compra(nullable:true)
    	voo(nullable:true)
    	passageiro(nullable:false)
    	passaporte(nullable:false)
    	index(display: false)
    }
    
    int index
    String passageiro
    String passaporte
    
    Compra compra
    Voo voo

	@Override
	String toString(){
		return 'Passag.: [ ' + passageiro + '] - Voo: [' + voo.especificacao.origem + ' >> ' + voo.especificacao.destino + ']'
	}
}

package br.ufscar.vpa

class CompraVoo {

    static constraints = {
    	passageiro(nullable:false)
    	index(display: false)
    }
    
    int index
    String passageiro
    
    Compra compra
    Voo voo

}

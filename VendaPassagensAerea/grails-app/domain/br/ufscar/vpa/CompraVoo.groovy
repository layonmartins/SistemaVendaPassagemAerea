package br.ufscar.vpa

class CompraVoo {

    static constraints = {
    	numeroPoltrona(nullable:false, min:1)
    	nomePassageiro(nullable:false)
    }
    
    int numeroPoltrona
    String nomePassageiro
    
    Compra compra
    Voo voo

}

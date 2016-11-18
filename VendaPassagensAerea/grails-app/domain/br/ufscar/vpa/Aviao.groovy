package br.ufscar.vpa

class Aviao {

    static constraints = {
    	linhaAerea(blank: false, size:1..20)
    	modelo(blank: false, size:1..20)
    	quantidadePoltrona(nullable:false, min: 1)
    }
    
    String linhaAerea
    String modelo
    int quantidadePoltrona
    
    @Override
    String toString(){
    	return modelo + " - " + linhaAerea
    }
}

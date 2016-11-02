package br.ufscar.vpa

class Aviao {

    static constraints = {
    	numeroAviao(min: 1, unique: true)
    	linhaAerea(blank: false, size:1..20)
    	modelo(blank: false, size:1..20)
    	quantidadePoltrona(min: 1)
    }
    
    int numeroAviao
    String linhaAerea
    String modelo
    int quantidadePoltrona
    
}

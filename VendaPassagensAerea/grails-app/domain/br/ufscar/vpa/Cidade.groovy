package br.ufscar.vpa

class Cidade {

    static constraints = {
    	nome(blank:false, size:1..20)
    	estado(blank:false, size:1..20)
    	pais(blank:false, size:1..20)
    }
    
    String nome
    String estado
    String pais
}

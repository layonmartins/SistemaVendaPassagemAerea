package br.ufscar.vpa

class Especificacao {

    static constraints = {
    	custo(nullable:false, min: 200)
    	horaPartida(nullable:false)
    	horaChegada(nullable:false)
    	tipo(nullable:false, inList: ["Direto", "Escala"])
    	origem(nullable:false)
    	destino(nullable:false)
    }
    
    double custo
    Date horaPartida
    Date horaChegada
    String tipo //[Direto ou Escala]
    
    Cidade origem
    Cidade destino
}

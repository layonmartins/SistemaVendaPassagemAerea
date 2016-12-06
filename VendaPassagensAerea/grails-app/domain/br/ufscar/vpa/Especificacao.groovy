package br.ufscar.vpa

class Especificacao {

    static constraints = {
    	numEspecificacao(nullable:false)
    	origem(nullable:false)
    	destino(nullable:false)
    	horaPartida(blank:false, matches:"([01]?[0-9]|2[0-3]):[0-5][0-9]")
    	horaChegada(blank:false, matches:"([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]")
    	tempoVoo(blank:false, matches:"([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]")
    	tipo(nullable:false, inList: ["DIRETO", "ESCALA"])
    	custo(nullable:false, min: 1d)
    }
    
    String numEspecificacao
    double custo
    String horaPartida
    String horaChegada
    String tempoVoo
    String tipo //[Direto ou Escala]
    
    Cidade origem
    Cidade destino
    
    @Override
    String toString(){
    	return origem.toString() + " > " + destino.toString() + " - " + horaPartida + " - " + tipo
    }
}

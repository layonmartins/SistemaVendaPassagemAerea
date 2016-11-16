package br.ufscar.vpa

class Especificacao {

    static constraints = {
    	custo(nullable:false, min: 1d)
    	horaPartida(blank:false, matches:"([01]?[0-9]|2[0-3]):[0-5][0-9]")
    	horaChegada(blank:false, matches:"([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]")
    	tempoVoo(blank:false, matches:"([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]")
    	//teste(nullable:false, format: "hh:mm")
    	tipo(nullable:false, inList: ["DIRETO", "ESCALA"])
    	origem(nullable:false)
    	destino(nullable:false)
    }
    
    double custo
    String horaPartida
    String horaChegada
    String tempoVoo
   // Date teste
    String tipo //[Direto ou Escala]
    
    Cidade origem
    Cidade destino
    
    @Override
    String toString(){
    	return origem.toString() + " > " + destino.toString() + " - " + horaPartida + " - " + tipo
    }
}

package br.ufscar.vpa

import org.springframework.security.access.annotation.Secured

@Secured(['ROLE_CLIENTE'])
class ComprarController {

//Criando uma compra, e uma lista de itens de compras
   	def minhaCompra = new Compra()
   	def compravoos = []
   	def index = 0
   	def springSecurityService
   	
    def index() {
    	
    	render(view:"/comprar/index")
    }
    
    def buscar(){
    
    	def query = "from Voo as v where v.especificacao.origem.nome=? and v.especificacao.destino.nome=? and v.data>=?"
    	def lista = Voo.findAll(query, [params.origem, params.destino, Date.parse('yyyy-MM-dd', params.data)])
    	render(template: "/comprar/listaVoo", model: [voos: lista])
    }
    
    def comprar(){
    	render(template:"/comprar/formComprar", model: [id: params.id])
    }
    
    
    
    def comprarPassagem(){
    
    	def compravoo = new CompraVoo()
    	compravoo.passageiro = params.passageiro
    	compravoo.compra = minhaCompra
    	compravoo.voo = Voo.get(params.id)
    	index++ //faz parte da gambi do id
    	compravoo.index = index
    	compravoos << compravoo
    	
    	//remover uma poltrona do Voo
    	def voo = Voo.get(params.id)
    	if(voo.especificacao.tipo == 'DIRETO'){
    	voo.lugaresDisponiveis--
    	voo.save(flush:true)
    	}else{
    		def NumVoo = voo.numeroVoo
    		def listaVoo = Voo.list()
    		listaVoo.each{voo2 ->
    			if(voo2.numeroVoo == NumVoo){
    				voo2.lugaresDisponiveis--
		    		voo2.save(flush:true)
    			}
    		}
    		
    	}
  		
    	render(template:"/comprar/listaCompras", model: ['compravoos': compravoos])
    }
    
    
    
      def remover(){
    	def indeceDaLista
    	compravoos.eachWithIndex{ compravoo, i ->
    		if(compravoo.index == params.id.toInteger()){
    			indeceDaLista = i
    			//liberar uma poltrona
    			def voo = Voo.get(compravoo.voo.id) 
    			if(voo.especificacao.tipo == 'DIRETO'){
					voo.lugaresDisponiveis++
					voo.save(flush:true)
				} else{
					def NumVoo = voo.numeroVoo
					def listaVoo = Voo.list()
					listaVoo.each{voo2 ->
						if(voo2.numeroVoo == NumVoo){
							voo2.lugaresDisponiveis++
							voo2.save(flush:true)
						}
    				}
				}
    		}
    	}
    	//remover compravoo da lista
    	compravoos.remove(indeceDaLista)   
    	
    	render(template:"/comprar/listaCompras", model: ['compravoos': compravoos])
    }
    
   
    def finalizarCompra(){
    	//Salvar um cliente. Este passo devera pegar o cliente autenticado.
    	//porém como eu não sei fazer isso vou criar um provisorio
    	def idCliente = springSecurityService.currentUser.id
    	def cliente = Cliente.get(idCliente)
        
        
        
    	//salvar compra
    	minhaCompra.data = new Date().clearTime()
    	minhaCompra.cliente = cliente
    	minhaCompra.save(flush:true)
    	println 'compra salva: ' + minhaCompra
    	println 'id compra: ' + minhaCompra.id
    	
    	//Salvar itens
    	compravoos.each{compravoo ->
    		compravoo.save(flush:true)			
    	}
    	
    	minhaCompra = new Compra()
    	compravoos = []	
    	render(template:"/comprar/finalizada")
    }
    
    
    def cancelarTotal(){
    	compravoos.each{compravoo ->
    		def voo = Voo.get(compravoo.voo.id) 
    			if(voo.especificacao.tipo == 'DIRETO'){
					voo.lugaresDisponiveis++
					voo.save(flush:true)
				} else{
					def NumVoo = voo.numeroVoo
					def listaVoo = Voo.list()
					listaVoo.each{voo2 ->
						if(voo2.numeroVoo == NumVoo){
							voo2.lugaresDisponiveis++
							voo2.save(flush:true)
						}
    				}
				}
    	}
    	minhaCompra = new Compra()
    	compravoos = []
    	render("<h1>Compra Cancelada!</h1>")
    }
}

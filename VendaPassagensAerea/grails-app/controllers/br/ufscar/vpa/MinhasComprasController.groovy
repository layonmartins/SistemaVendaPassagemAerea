package br.ufscar.vpa

class MinhasComprasController {

	def springSecurityService
	
    def index() {
    	
    	render(view:"/minhasCompras/index")
    	
    	
    }
    
    def exibir(){
    	//pegar cliente autenticado
    	def idCliente = springSecurityService.currentUser.id
    	//Buscar compras deste cliente
    	def query = "from CompraVoo as cv where cv.compra.cliente.id=?"
    	def lista = CompraVoo.findAll(query, idCliente)
    	render(template: "/minhasCompras/listaCompras", model: [compravoos: lista])
    }
}

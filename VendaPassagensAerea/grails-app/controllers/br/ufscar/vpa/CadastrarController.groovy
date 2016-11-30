package br.ufscar.vpa

class CadastrarController {

    def index() { 
    	render(view:"/cadastrar/index")
    }
    
    def cadastrar(){
    	def cliente = new Cliente(
            nome: params.nome,
            sobreNome: params.sobreNome,
            email: params.email,
            dataNascimento: Date.parse('yyyy-MM-dd', params.data),
            username: params.username,
            password: params.password,
            enabled : true
        )
        
        cliente.save()
        if (cliente.hasErrors()) {
            println cliente.errors
        }
        
        def clientePapel = Papel.findByAuthority("ROLE_CLIENTE") ?:
        new Papel(authority: "ROLE_CLIENTE").save()
        
         UsuarioPapel.create(cliente,clientePapel)
    
    	render("<h1>Cadastrado com Sucesso!</h1>")
    	
    }
}

import br.ufscar.vpa.Usuario
import br.ufscar.vpa.Papel
import br.ufscar.vpa.UsuarioPapel
import br.ufscar.vpa.Aviao
import br.ufscar.vpa.Cidade
import br.ufscar.vpa.Compra
import br.ufscar.vpa.CompraVoo
import br.ufscar.vpa.Especificacao
import br.ufscar.vpa.Voo


class BootStrap {

    def init = { servletContext ->
    
    	def adminPapel = Papel.findByAuthority("ROLE_ADMIN") ?:
        new Papel(authority: "ROLE_ADMIN").save()
                
        def admin = new Usuario(
            username: "admin",
            password: "admin",
         //   nome: "Administrador",
            enabled : true
        )
        
        admin.save()
        if (admin.hasErrors()) {
            println admin.errors
        }
        
        UsuarioPapel.create(admin,adminPapel)
       
        println 'populando usuário admin - ok'
        
        
        def aviao1 = new Aviao(
        	linhaAerea: "Gol",
        	modelo: "Antonov An-225 Mriya",
        	quantidadePoltrona: 6
        )
        aviao1.save()
        if(aviao1.hasErrors())
        	println aviao1.errors
        
        def aviao2 = new Aviao(
        	linhaAerea: "Tam",
        	modelo: "Boing-007",
        	quantidadePoltrona: 120
        )
        aviao2.save()
        if(aviao2.hasErrors())
        	println aviao2.errors
        
        println 'populando aviões'
        
    }
    def destroy = {
    }
}

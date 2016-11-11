import br.ufscar.vpa.Usuario
import br.ufscar.vpa.Papel
import br.ufscar.vpa.UsuarioPapel

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
    }
    def destroy = {
    }
}

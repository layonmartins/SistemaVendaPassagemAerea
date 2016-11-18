import br.ufscar.vpa.Usuario
import br.ufscar.vpa.Papel
import br.ufscar.vpa.UsuarioPapel
import br.ufscar.vpa.Aviao
import br.ufscar.vpa.Cidade
import br.ufscar.vpa.Compra
import br.ufscar.vpa.CompraVoo
import br.ufscar.vpa.Especificacao
import br.ufscar.vpa.Voo
import br.ufscar.vpa.Cliente


class BootStrap {

    def init = { servletContext ->
    
    	def adminPapel = Papel.findByAuthority("ROLE_ADMIN") ?:
        new Papel(authority: "ROLE_ADMIN").save()
                
        def admin = new Usuario(
            username: "a",
            password: "a",
            enabled : true
        )
        
        admin.save()
        if (admin.hasErrors()) {
            println admin.errors
        }
        
        UsuarioPapel.create(admin,adminPapel)
       
        println 'populando usuário admin - ok'
        
        
        def clientePapel = Papel.findByAuthority("ROLE_CLIENTE") ?:
        new Papel(authority: "ROLE_CLIENTE").save()
                
        def cliente = new Cliente(
            nome: "Cliente",
            sobreNome: "Teste",
            email: "cliente@cliente.com",
            dataNascimento: new Date(),
            passaporte: "0001.00001.000-03",
            username: "c",
            password: "c",
            enabled : true
        )
        
        cliente.save()
        if (cliente.hasErrors()) {
            println cliente.errors
        }
        
        UsuarioPapel.create(cliente,clientePapel)
       
        println 'populando cliente  - ok'
        
        
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
        
        
        def passos = new Cidade(
        	nome: "Passos",
        	estado: "MG",
        	pais: "Brasil"
        )
        passos.save()
        if(passos.hasErrors())
        	println passos.errors
        	
        def sanca = new Cidade(
        	nome: "São Carlos",
        	estado: "SP",
        	pais: "Brasil"
        )
        sanca.save()
        if(sanca.hasErrors())
        	println sanca.errors
        	
        def ponte = new Cidade(
        	nome: "Ponte Arta",
        	estado: "MG",
        	pais: "Brasil"
        )
        ponte.save()
        if(ponte.hasErrors())
        	println ponte.errors
        	
        def bogota = new Cidade(
        	nome: "Bogotá",
        	estado: "BG",
        	pais: "Colômbia"
        )
        bogota.save()
        if(bogota.hasErrors())
        	println bogota.errors
        	
        println 'populando cidades'
        
        
        
        
        //ESCALA (Ponte > Bogota) Parada(Sanca)
        def ponteBogota = new Especificacao(
        	custo: 500d,
        	horaPartida: "01:00",
        	horaChegada: "10:00",
        	tempoVoo: "09:00",
			tipo: "ESCALA",
			origem: ponte,
			destino: bogota
        )
        ponteBogota.save()
        if(ponteBogota.hasErrors())
        	println ponteBogota.errors
        
        //Pertence(Escala(Ponte > Bogota))
        //DIRETO (Ponte > Sanca)
        def ponteSanca = new Especificacao(
        	custo: 100d,
        	horaPartida: "01:00",
        	horaChegada: "03:30",
        	tempoVoo: "02:30",
			tipo: "DIRETO",
			origem: ponte,
			destino: sanca
        )
        ponteSanca.save()
        if(ponteSanca.hasErrors())
        	println ponteSanca.errors
        	
         //Pertence(Escala(Ponte > Bogota))
          //DIRETO (Sanca > Bogota)
        def sancaBogota = new Especificacao(
        	custo: 400d,
        	horaPartida: "04:30",
        	horaChegada: "10:00",
        	tempoVoo: "05:30",
			tipo: "DIRETO",
			origem: sanca,
			destino: bogota 
        )
        sancaBogota.save()
        if(sancaBogota.hasErrors())
        	println sancaBogota.errors
        	
        	
        //--------------------------------------
        
        
         //ESCALA (Bogota > Passos) Parada(Sanca)
        def bogotaPassos = new Especificacao(
        	custo: 600d,
        	horaPartida: "13:00",
        	horaChegada: "20:00",
        	tempoVoo: "07:00",
			tipo: "ESCALA",
			origem: bogota,
			destino: passos 
        )
        bogotaPassos.save()
        if(bogotaPassos.hasErrors())
        	println bogotaPassos.errors
        
        //Pertence(Escala(Bogota > Passos))	
        //DIRETO (Bogota> Sanca)
        def bogotaSanca = new Especificacao(
        	custo: 450d,
        	horaPartida: "13:00",
        	horaChegada: "17:00",
        	tempoVoo: "04:00",
			tipo: "DIRETO",
			origem: bogota,
			destino: sanca
        )
        bogotaSanca.save()
        if(bogotaSanca.hasErrors())
        	println bogotaSanca.errors	
        
        //Pertence(Escala(Bogota > Passos))
         //DIRETO (Sanca > Passos)
        def sancaPassos = new Especificacao(
        	custo: 450d,
        	horaPartida: "18:00",
        	horaChegada: "20:00",
        	tempoVoo: "02:30",
			tipo: "DIRETO",
			origem: sanca,
			destino: passos
        )
        sancaPassos.save()
        if(sancaPassos.hasErrors())
        	println sancaPassos.errors
        	
        	
        //DIRETO (Passos > Sanca)
        def passosSanca = new Especificacao(
        	custo: 100d,
        	horaPartida: "02:00",
        	horaChegada: "03:30",
        	tempoVoo: "01:30",
        	//teste: new Date().parse("hh:mm", '01:15'),
			tipo: "DIRETO",
			origem: passos,
			destino: sanca
        )
        passosSanca.save()
        if(passosSanca.hasErrors())
        	println passosSanca.errors
        	
        	
        //DIRETO (Passos > Ponte)
        def passosPonte = new Especificacao(
        	custo: 50d,
        	horaPartida: "13:00",
        	horaChegada: "13:05",
        	tempoVoo: "00:05",
			tipo: "DIRETO",
			origem: passos,
			destino: ponte
        )
        passosPonte.save()
        if(passosPonte.hasErrors())
        	println passosPonte.errors
        	
        	
        
        println 'populando especificacoes ESCALA e DIRETA'
        
        
        
        //Criando voo de Escala Bogota > Passos
        def Voo01Escala = new Voo(
        	numeroVoo: "Voo" + bogotaPassos.origem + bogotaPassos.destino + new Date().format("dd_MM_yy"),
        	data: new Date(),
        	lugaresDisponiveis: aviao2.quantidadePoltrona,
        	aviao: aviao2,
        	especificacao: bogotaPassos
        )
        Voo01Escala.save()
        if(Voo01Escala.hasErrors())
        	println Voo01Escala.errors
        	
        //Criando Voo direto, derivado da escala assima Bogota > Sanca
        def Voo01DiretoA = new Voo(
        	numeroVoo: "Voo" + bogotaSanca.origem + bogotaSanca.destino + new Date().format("dd_MM_yy"),
        	data: new Date(),
        	lugaresDisponiveis: aviao2.quantidadePoltrona,
        	aviao: aviao2,
        	especificacao: bogotaSanca
        )
        Voo01DiretoA.save()
        if(Voo01DiretoA.hasErrors())
        	println Voo01DiretoA.errors
        	
        	
        //Criando Voo direto, derivado da escala assima Sanca > Passos
        def Voo01DiretoB = new Voo(
        	numeroVoo: "Voo" + sancaPassos.origem + sancaPassos.destino + new Date().format("dd_MM_yy"),
        	data: new Date(),
        	lugaresDisponiveis: aviao2.quantidadePoltrona,
        	aviao: aviao2,
        	especificacao: sancaPassos
        )
        Voo01DiretoB.save()
        if(Voo01DiretoB.hasErrors())
        	println Voo01DiretoB.errors
        
        println 'Populando Voo'
        
        
        
    }
    def destroy = {
    }
}

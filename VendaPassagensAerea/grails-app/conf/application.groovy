

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'br.ufscar.vpa.Usuario'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'br.ufscar.vpa.UsuarioPapel'
grails.plugin.springsecurity.authority.className = 'br.ufscar.vpa.Papel'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']],
	[pattern: '/aviao/*', access: ['ROLE_ADMIN']],
	[pattern: '/cadastrar/*', access: ['permitAll']],
	[pattern: '/cidade/*', access: ['ROLE_ADMIN']],
	[pattern: '/cliente/index', access: ['ROLE_ADMIN']],
	[pattern: '/cliente/show', access: ['ROLE_ADMIN']],
	[pattern: '/cliente/edit', access: ['ROLE_ADMIN']],
	[pattern: '/cliente/update', access: ['ROLE_ADMIN']],
	[pattern: '/compra/index*', access: ['ROLE_ADMIN']],
	[pattern: '/compra/show*', access: ['ROLE_ADMIN']],
	[pattern: '/comprar/*', access: ['ROLE_CLIENTE']],
	[pattern: '/compraVoo/index', access: ['ROLE_ADMIN']],
	[pattern: '/compraVoo/show', access: ['ROLE_ADMIN']],
	[pattern: '/especificacao/*', access: ['ROLE_ADMIN']],
	[pattern: '/minhascompras/*', access: ['ROLE_CLIENTE']],
	[pattern: '/voo/*', access: ['ROLE_ADMIN']],
	[pattern: '/main/index', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

grails.plugin.springsecurity.logout.postOnly = false



package br.ufscar.vpa

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EspecificacaoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Especificacao.list(params), model:[especificacaoCount: Especificacao.count()]
    }

    def show(Especificacao especificacao) {
        respond especificacao
    }

    def create() {
        respond new Especificacao(params)
    }

    @Transactional
    def save(Especificacao especificacao) {
        if (especificacao == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (especificacao.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond especificacao.errors, view:'create'
            return
        }

        especificacao.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'especificacao.label', default: 'Especificacao'), especificacao.id])
                redirect especificacao
            }
            '*' { respond especificacao, [status: CREATED] }
        }
    }

    def edit(Especificacao especificacao) {
        respond especificacao
    }

    @Transactional
    def update(Especificacao especificacao) {
        if (especificacao == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (especificacao.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond especificacao.errors, view:'edit'
            return
        }

        especificacao.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'especificacao.label', default: 'Especificacao'), especificacao.id])
                redirect especificacao
            }
            '*'{ respond especificacao, [status: OK] }
        }
    }

    @Transactional
    def delete(Especificacao especificacao) {

        if (especificacao == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        especificacao.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'especificacao.label', default: 'Especificacao'), especificacao.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'especificacao.label', default: 'Especificacao'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

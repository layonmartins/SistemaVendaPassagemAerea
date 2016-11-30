package br.ufscar.vpa

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AviaoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Aviao.list(params), model:[aviaoCount: Aviao.count()]
    }

    def show(Aviao aviao) {
        respond aviao
    }

    def create() {
        respond new Aviao(params)
    }

    @Transactional
    def save(Aviao aviao) {
        if (aviao == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (aviao.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond aviao.errors, view:'create'
            return
        }

        aviao.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'aviao.label', default: 'Aviao'), aviao.id])
                redirect aviao
            }
            '*' { respond aviao, [status: CREATED] }
        }
    }

    def edit(Aviao aviao) {
        respond aviao
    }

    @Transactional
    def update(Aviao aviao) {
        if (aviao == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (aviao.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond aviao.errors, view:'edit'
            return
        }

        aviao.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'aviao.label', default: 'Aviao'), aviao.id])
                redirect aviao
            }
            '*'{ respond aviao, [status: OK] }
        }
    }

    @Transactional
    def delete(Aviao aviao) {

        if (aviao == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        aviao.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'aviao.label', default: 'Aviao'), aviao.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'aviao.label', default: 'Aviao'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

package br.ufscar.vpa

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class VooController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Voo.list(params), model:[vooCount: Voo.count()]
    }

    def show(Voo voo) {
        respond voo
    }

    def create() {
        respond new Voo(params)
    }

    @Transactional
    def save(Voo voo) {
        if (voo == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (voo.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond voo.errors, view:'create'
            return
        }

        voo.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'voo.label', default: 'Voo'), voo.id])
                redirect voo
            }
            '*' { respond voo, [status: CREATED] }
        }
    }

    def edit(Voo voo) {
        respond voo
    }

    @Transactional
    def update(Voo voo) {
        if (voo == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (voo.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond voo.errors, view:'edit'
            return
        }

        voo.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'voo.label', default: 'Voo'), voo.id])
                redirect voo
            }
            '*'{ respond voo, [status: OK] }
        }
    }

    @Transactional
    def delete(Voo voo) {

        if (voo == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        voo.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'voo.label', default: 'Voo'), voo.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'voo.label', default: 'Voo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

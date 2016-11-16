package br.ufscar.vpa

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.springframework.security.access.annotation.Secured


@Transactional(readOnly = true)
@Secured(['ROLE_ADMIN'])
class CompraVooController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CompraVoo.list(params), model:[compraVooCount: CompraVoo.count()]
    }

    def show(CompraVoo compraVoo) {
        respond compraVoo
    }

    def create() {
        respond new CompraVoo(params)
    }

    @Transactional
    def save(CompraVoo compraVoo) {
        if (compraVoo == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (compraVoo.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond compraVoo.errors, view:'create'
            return
        }

        compraVoo.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'compraVoo.label', default: 'CompraVoo'), compraVoo.id])
                redirect compraVoo
            }
            '*' { respond compraVoo, [status: CREATED] }
        }
    }

    def edit(CompraVoo compraVoo) {
        respond compraVoo
    }

    @Transactional
    def update(CompraVoo compraVoo) {
        if (compraVoo == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (compraVoo.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond compraVoo.errors, view:'edit'
            return
        }

        compraVoo.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'compraVoo.label', default: 'CompraVoo'), compraVoo.id])
                redirect compraVoo
            }
            '*'{ respond compraVoo, [status: OK] }
        }
    }

    @Transactional
    def delete(CompraVoo compraVoo) {

        if (compraVoo == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        compraVoo.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'compraVoo.label', default: 'CompraVoo'), compraVoo.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'compraVoo.label', default: 'CompraVoo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

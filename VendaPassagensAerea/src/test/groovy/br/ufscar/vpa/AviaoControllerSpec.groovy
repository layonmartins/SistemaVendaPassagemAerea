package br.ufscar.vpa

import grails.test.mixin.*
import spock.lang.*

@TestFor(AviaoController)
@Mock(Aviao)
class AviaoControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        assert false, "TODO: Provide a populateValidParams() implementation for this generated test suite"
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.aviaoList
            model.aviaoCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.aviao!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def aviao = new Aviao()
            aviao.validate()
            controller.save(aviao)

        then:"The create view is rendered again with the correct model"
            model.aviao!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            aviao = new Aviao(params)

            controller.save(aviao)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/aviao/show/1'
            controller.flash.message != null
            Aviao.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def aviao = new Aviao(params)
            controller.show(aviao)

        then:"A model is populated containing the domain instance"
            model.aviao == aviao
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def aviao = new Aviao(params)
            controller.edit(aviao)

        then:"A model is populated containing the domain instance"
            model.aviao == aviao
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/aviao/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def aviao = new Aviao()
            aviao.validate()
            controller.update(aviao)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.aviao == aviao

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            aviao = new Aviao(params).save(flush: true)
            controller.update(aviao)

        then:"A redirect is issued to the show action"
            aviao != null
            response.redirectedUrl == "/aviao/show/$aviao.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/aviao/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def aviao = new Aviao(params).save(flush: true)

        then:"It exists"
            Aviao.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(aviao)

        then:"The instance is deleted"
            Aviao.count() == 0
            response.redirectedUrl == '/aviao/index'
            flash.message != null
    }
}

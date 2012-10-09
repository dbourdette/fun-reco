package fun.reco

import org.bson.types.ObjectId
import org.springframework.dao.DataIntegrityViolationException

class PersistenceController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [persistenceInstanceList: Persistence.list(params), persistenceInstanceTotal: Persistence.count()]
    }

    def create() {
        [persistenceInstance: new Persistence(params)]
    }

    def save() {
        def persistenceInstance = new Persistence(params)
        if (!persistenceInstance.save(flush: true)) {
            render(view: "create", model: [persistenceInstance: persistenceInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'persistence.label', default: 'Persistence'), persistenceInstance.id])
        redirect(action: "show", id: persistenceInstance.id)
    }

    def show(String id) {
        def persistenceInstance = Persistence.get(new ObjectId(id))
        if (!persistenceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'persistence.label', default: 'Persistence'), id])
            redirect(action: "list")
            return
        }

        [persistenceInstance: persistenceInstance]
    }

    def edit(String id) {
		def persistenceInstance = Persistence.get(new ObjectId(id))
        if (!persistenceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'persistence.label', default: 'Persistence'), id])
            redirect(action: "list")
            return
        }

        [persistenceInstance: persistenceInstance]
    }

    def update(String id, Long version) {
        def persistenceInstance = Persistence.get(new ObjectId(id))
        if (!persistenceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'persistence.label', default: 'Persistence'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (persistenceInstance.version > version) {
                persistenceInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'persistence.label', default: 'Persistence')] as Object[],
                          "Another user has updated this Persistence while you were editing")
                render(view: "edit", model: [persistenceInstance: persistenceInstance])
                return
            }
        }

        persistenceInstance.properties = params

        if (!persistenceInstance.save(flush: true)) {
            render(view: "edit", model: [persistenceInstance: persistenceInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'persistence.label', default: 'Persistence'), persistenceInstance.id])
        redirect(action: "show", id: persistenceInstance.id)
    }

    def delete(String id) {
        def persistenceInstance = Persistence.get(new ObjectId(id))
        if (!persistenceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'persistence.label', default: 'Persistence'), id])
            redirect(action: "list")
            return
        }

        try {
            persistenceInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'persistence.label', default: 'Persistence'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'persistence.label', default: 'Persistence'), id])
            redirect(action: "show", id: id)
        }
    }
}

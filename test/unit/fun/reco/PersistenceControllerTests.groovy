package fun.reco



import org.junit.*
import grails.test.mixin.*

@TestFor(PersistenceController)
@Mock(Persistence)
class PersistenceControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/persistence/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.persistenceInstanceList.size() == 0
        assert model.persistenceInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.persistenceInstance != null
    }

    void testSave() {
        controller.save()

        assert model.persistenceInstance != null
        assert view == '/persistence/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/persistence/show/1'
        assert controller.flash.message != null
        assert Persistence.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/persistence/list'

        populateValidParams(params)
        def persistence = new Persistence(params)

        assert persistence.save() != null

        params.id = persistence.id

        def model = controller.show()

        assert model.persistenceInstance == persistence
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/persistence/list'

        populateValidParams(params)
        def persistence = new Persistence(params)

        assert persistence.save() != null

        params.id = persistence.id

        def model = controller.edit()

        assert model.persistenceInstance == persistence
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/persistence/list'

        response.reset()

        populateValidParams(params)
        def persistence = new Persistence(params)

        assert persistence.save() != null

        // test invalid parameters in update
        params.id = persistence.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/persistence/edit"
        assert model.persistenceInstance != null

        persistence.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/persistence/show/$persistence.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        persistence.clearErrors()

        populateValidParams(params)
        params.id = persistence.id
        params.version = -1
        controller.update()

        assert view == "/persistence/edit"
        assert model.persistenceInstance != null
        assert model.persistenceInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/persistence/list'

        response.reset()

        populateValidParams(params)
        def persistence = new Persistence(params)

        assert persistence.save() != null
        assert Persistence.count() == 1

        params.id = persistence.id

        controller.delete()

        assert Persistence.count() == 0
        assert Persistence.get(persistence.id) == null
        assert response.redirectedUrl == '/persistence/list'
    }
}

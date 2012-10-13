
import com.mongodb.Mongo

class BootStrap {

	def init = { servletContext ->
		environments {
			test {
				new Mongo().getDB("fun-reco-test").dropDatabase();
			}
		}
	}
	
    def destroy = {
    }
}

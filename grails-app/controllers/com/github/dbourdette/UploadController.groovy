package com.github.dbourdette

import org.codehaus.jackson.map.ObjectMapper;
import com.lucastex.grails.fileuploader.UFile

import com.github.dbourdette.api.Action;
import com.github.dbourdette.api.Object;
import com.github.dbourdette.api.Profile;
import com.github.dbourdette.api.RecommendationFacade;

class UploadController {
	
	ObjectMapper mapper = new ObjectMapper()
	RecommendationFacade recommendationFacade

    def index() {

	}
	
	def upload_error() {
		flash.error = "There's been an error with your upload. Check your file extension, only .zip are allowed."
		redirect(uri: "/upload")
	}
	
	def upload_success() {
		def ufile = UFile.get(params.ufileId)
		def zipFile = new java.util.zip.ZipFile(new File(ufile.path))
		def textToProcess, fileName
		def importedClass, importedObject, uploadFunction
		def uploadErrorCount = 0
		for (entry in zipFile.entries()){
			fileName =  entry.getName()
			fileName  = fileName.replaceFirst(~/\.[^\.]+$/, '')
			if (fileName == 'action') {
				importedClass = Action.class
				uploadFunction = { Action action -> return recommendationFacade.pushAction(action) }
			}else if (fileName == 'profile') {
				importedClass = Profile.class
				uploadFunction = { Profile profile -> return recommendationFacade.updateProfile(profile) }
			}else{
				continue
			}
			textToProcess = zipFile.getInputStream(entry).text
			textToProcess.eachLine { line, lineNumber ->
				try {
					importedObject = mapper.readValue(line, importedClass);
					uploadFunction(importedObject)
				}
				catch(Throwable e) {
					uploadErrorCount += 1
				}
			}
		}
		if (uploadErrorCount == 0){
			flash.success = "Your data has been succesfully imported."
		}else{
			flash.error = "There's been " + uploadErrorCount + " errors in the import."
		}
		redirect(uri: "index")
	}
}



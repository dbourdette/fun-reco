package com.github.dbourdette

import com.lucastex.grails.fileuploader.UFile

class UploadController {

    def index() {
//		def zipFile = new java.util.zip.ZipFile(new File('some.zip'))
//		
//		zipFile.entries().each {
//		   println zipFile.getInputStream(it).text
//		}
	}
	
	def upload_error() {
		flash.error = "There's been an error with your upload. Check your file extension, only .zip are allowed."
		redirect(uri: "/upload")
	}
	
	def upload_success() {
		flash.success = "Your file has been succesfully uploaded."
		redirect(uri: "index")
	}
}

package multiple.ui.application

import org.junit.internal.runners.statements.FailOnTimeout;

import grails.transaction.Transactional

@Transactional
class UserService {

    def serviceMethod() {

    }
	
	def userCount() {
		return User.count() 
	}
	
	def allUsers() {
		return User.list()
	}
	
	def User add(String name) {
		User user = new User()
		user.name = name 
		
		
		user.save( failOnError: true ) 
		return user 
	}
}

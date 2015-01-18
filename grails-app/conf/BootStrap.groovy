import multiple.ui.application.User

class BootStrap {

    def init = { servletContext ->
		User user1 = new User()
		user1.name = "Sara"
		user1.save(failOnError: true )
		
		User user2 = new User()
		user2.name = "Esther"
		user2.save(failOnError: true )
		
		println( "Total user: " + User.count())
    }
    def destroy = {
    }
}

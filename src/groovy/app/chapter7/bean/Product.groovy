package app.chapter7.bean

class Product {
	int code
	String name 
	double price
	Date date  = new Date() 
	
	
	public Product( int code, String name, double price) {
		this.code = code
		this.name = name 
		this.price =price
	}
}

class SingletonClass{

	static private SingletonClass connection;

	private SingletonClass(){

	}


// To make thread safe we have to lock connection object for any upcoming threads 
	static SingletonClass getSingletonObject(){
		synchronized(connection){
			if(connection == null){
				connection = new SingletonClass();
			}	
			return connection;	
		}
		
	}



}



class SingletonClass{

	static private SingletonClass connection;

	private SingletonClass(){

	}

	static SingletonClass getSingletonObject(){
		if(connection == null){
			connection = new SingletonClass();
		}
		return connection;
	}



}



class ParkingLot{




// use abstract class if methods are too much repetitive 
	interface Vehicle{



	}


	class Car implements Vehicle{

		float size;
		String color;
		String reg;


	}

	class Motorcycle implements Vehicle{

		float size;
		String color;
		String reg;

	}

	interface ParkingSpace{


	}

	class FourWheelerParking implements ParkingSpace{

		// Create Search Algo for Parking

		Map<String,Integer> fourWheelerParking;
		int size;

		public FourWheelerParking(int size ){
			this.fourWheelerParking = new HashMap<String,Integer>(size);
			this.size = size;
		}


		public Integer assignParking(){



		}


	}

	class TwoWheelerParking implements ParkingSpace{

		int capacity;
		public TwoWheelerParking(int capacity){
			this.capacity = capacity;
		}

	}

	class Ticket{
		float amount;
		String reg;
		Date currentDate;
		String ticketId;
		String ParkingId;
	}


	static class TicketService{

		private static Ticket t;

		private TicketService(){

		}

		public Ticket getTicket(Vehicle v){

			if(v instanceof Car){
				return priceCalculation(v.size,"Car");
			}else if(v instanceof Motorcycle){
				return priceCalculation(v.size,"Motorcycle");
			}



		}


		private static float priceCalculation(float size,String type){

			if(type.equals("Motorcycle")){
				return 30.0;
			}else {
				return size * 100;
			}

		}


	}

}
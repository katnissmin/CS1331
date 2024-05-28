public class FuelTripPlanner{
	public static void main(String args[]){
		int backRoadMiles = 25;
		int highwayMiles = 60;
		int hillyMiles = 10;
		int currentGasGallons = 20;
		int numberOfPeople = 5;
		double gallonsPerPerson = 0;
		gallonsPerPerson = (backRoadMiles * 2 + highwayMiles*1 + hillyMiles*5 - currentGasGallons)/5;
		System.out.printf("Each passenger is responsible for %.1f gallons of gas.\n", gallonsPerPerson);
	}

}
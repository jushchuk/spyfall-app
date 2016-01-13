package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;



public class Game extends Observable{
	//variables independent of specific game
	///private Locations locationsClass;
	private String[] locations;
	private String[][] locationRoles;

	//variables dependent on game
	private int index;
	private int numPlayers;
	private String currentLocation;
	private String[] currentRoles;
	private List<String> tempRolesList;

	//creates the lists of potential locations and corresponding roles
	public Game(){
		locations = new String[] {
				"Airplane",
				"Bank",
				"Beach",
				"Casino",
				"Cathedral",
				"Circus Tent",
				"Corporate Party",
				"Crusader Army",
				"Day Spa",
				"Embassy",
				"Hospital",
				"Hotel",
				"Military Base",
				"Movie Studio",
				"Ocean Liner",
				"Passenger Train",
				"Pirate Ship",
				"Polar Station",
				"Police Station",
				"Restaurant",
				"School",
				"Service Station",
				"Space Station",
				"Submarine",
				"Supermarket",
				"Broadway Theater",
				"University"	
		};
		locationRoles  = new String[][] {
				{
					"First Class Passenger",
					"Mechanic",						
					"Stewardess",
					"Captain",
					"Air Marshall",
					"Economy Class Passenger",
					"Co-Pilot",
					"Flight Attendant"
				},
				{
					"Armored Car Driver",
					"Manager",						
					"Consultant",
					"Customer",
					"Robber",
					"Security Guard",
					"Teller",
					"Finacial Advisor"					
				},
				{
					"Beach Waitress",
					"Kite Surfer",						
					"Thief",
					"Lifeguard",
					"Beach Photographer",
					"Beach Goer",
					"Ice Cream Truck Driver",
					"Surfer"					
				},
				{
					"Bartender",
					"Head Security Guard",						
					"Bouncer",
					"Manager",
					"Dealer",
					"Hustler",
					"Gambler",
					"Teller"					
				},	
				{
					"Priest",
					"Beggar",						
					"Sinner",
					"Parishioner",
					"Tourist",
					"Sponsor",
					"Choir Singer",
					"Visitor"					
				},
				{
					"Acrobat",
					"Animal Trainer",						
					"Visitor",
					"Magician",
					"Fire Eater",
					"Clown",
					"Juggler",
					"Director"					
				},
				{
					"Entertainer",
					"Manager",						
					"Owner",
					"Unwelcomed Guest",
					"Secretary",
					"Accountant",
					"Delivery Boy",
					"Worker"					
				},	
				{
					"Monk",
					"Imprisoned Arab",						
					"Bishop",
					"Servant",
					"Squire",
					"Archer",
					"Knight",
					"General"					
				},	
				{
					"Customer",
					"Stylist",						
					"Masseuse",
					"Manicurist",
					"Makeup Artist",
					"Dermatologist",
					"Beautician",
					"Front Desk Worker"					
				},	
				{
					"Security Guard",
					"Secretary",						
					"Ambassador",
					"Government Official",
					"Refugee",
					"Tourist",
					"Diplomat",
					""					
				},
				{
					"Nurse",
					"Doctor",						
					"Intern",
					"Anesthesiologist",
					"Therapist",
					"Patient",
					"Surgeon",
					"Janitor"					
				},	
				{
					"Manager",
					"Housekeeper",						
					"Customer",
					"Bartender",
					"Bellman",
					"Security Guard",
					"Doorman",
					"Receptionist"					
				},	
				{
					"Colonel",
					"Deserter",						
					"Soldier",
					"Medic",
					"Officer",
					"Sniper",
					"Tank Engineer",
					"Gunsmith"					
				},
				{
					"Stuntman",
					"Sound Engineer",						
					"Director",
					"Cameraman",
					"Actor",
					"Costume Artist",
					"Producer",
					"Actress"					
				},	
				{
					"Rich Passenger",
					"Cook",						
					"Bartender",
					"Captain",
					"Waiter",
					"Musician",
					"Mechanic",
					"Housekeeper"					
				},
				{
					"Mechanic",
					"Border Patrol",						
					"Passenger",
					"Train Attendant",
					"Restaurant Chef",
					"Engineer",
					"Stoker",
					"Conductor"					
				},
				{
					"Cook",
					"Sailor",						
					"Cannoneer",
					"Slave",
					"Bound Prisoner",
					"Cabin Boy",
					"Brave Captain",
					"Deckhand"					
				},
				{
					"Medic",
					"Geologist",						
					"Biologist",
					"Expedition Leader",
					"Radioman",
					"Hydrologist",
					"Meteorologist",
					"Researcher"					
				},
				{
					"Detective",
					"Lawyer",						
					"Criminalist",
					"Archivist",
					"Journalist",
					"Patrol Officer",
					"Criminal",
					"Deputy"					
				},
				{
					"Musician",
					"Customer",						
					"Bouncer",
					"Hostess",
					"Head Chef",
					"Food Critic",
					"Waiter",
					"Sous Chef"					
				},
				{
					"Gym Teacher",
					"Student",						
					"Security Guard",
					"Principal",
					"Lunch Lady",
					"Janitor",
					"English Teacher",
					"Math Teacher"					
				},
				{
					"Manager",
					"Tire Specialist",						
					"Car Owner",
					"Biker",
					"Electrician",
					"Car Wash Operator",
					"Auto Mechanic",
					"Bike Mechanic"					
				},
				{
					"Engineer",
					"Alien",						
					"Pilot",
					"Space Tourist",
					"Commander",
					"Scientist",
					"Doctor",
					"Astronaut"					
				},	
				{
					"Cook",
					"Commander",						
					"Electronics Technician",
					"Sonar Technician",
					"Sailor",
					"Radioman",
					"Navigator",
					"Engineer"					
				},
				{
					"Customer",
					"Cashier",						
					"Butcher",
					"Janitor",
					"Security Guard",
					"Food Sample Demonstrator",
					"Shelf Stocker",
					"Flower Specialist"					
				},
				{
					"Coat Check Lady",
					"Prompter",						
					"Visitor",
					"Cashier",
					"Actor",
					"Director",
					"Crewman",
					"Musician"					
				},
				{
					"Graduate Student",
					"Professor",						
					"Psychologist",
					"Dean",
					"Student",
					"Maintenance Man",
					"Athlete",
					"Janitor"					
				},
		};

	}


	//here the program will receive a number of players and from that create a game specific location 
	//and a list of roles that includes one spy
	//each time this is run it should be able to update and create a new game
	public void createNewGame(int numPlayers){
		this.numPlayers = numPlayers;
		index = getNewIndex();
		currentLocation = locations[index];
		currentRoles = new String[numPlayers];

		tempRolesList = new ArrayList<String>();
		for(int i=0;i<8;i++){
			tempRolesList.add(locationRoles[index][i]);
		}
		shuffle();
		createSpy();
		//now there is a location and a list of roles with a spy
		//this should be accessible to the gui who will go through it
	}

	public String getCurrentLocation(){
		return currentLocation;
	}

	public String[] getCurrentRoles(){
		return currentRoles;
	}

	public String[] getLocation(){
		return locations;
	}

	public String[][] getLocationRole(){
		return locationRoles;
	}

	private int getNewIndex(){
		return (int) (Math.random()*locations.length);
	}

	private void shuffle(){
		Collections.shuffle(tempRolesList);
		copyArray();
	}

	private void copyArray(){
		for(int i = 0; i<numPlayers; i++){
			currentRoles[i] = tempRolesList.get(i);
		}
	}

	private void createSpy(){
		currentRoles[(int) (Math.random()*currentRoles.length)] = "You are the SPY";
	}

}

import java.util.Scanner;

public class AirlineSystem
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        String userName;
        String userAddress;
        String passportNumber;
        long userContact;
        int airLineChoice;
        int sourceChoice;
        int destChoice;
        int finalChoice;
        boolean loop = false;
        int loopChoice;

        // Locations
        String[] locs1 =
        { "Kochi", "Banglore", "Chennai", "Hyderabad", "New Delhi" };
        String[] locs2 =
        { "Mumbai", "Pune", "Goa", "Ahmedabad", "Surat" };
        String[] locs3 =
        { "Jaipur", "Udaipur", "Jodhpur", "Bikaner", "Ajmer" };
        String[] locs4 =
        { "Kolkata", "Durgapur", "Asansol", "Siliguri", "Howrah" };
        String[] locs5 =
        { "Chandigarh", "Shimla", "Dehradun", "Haridwar", "Amritsar" };

        Airline[] airLineArray = new Airline[5];
        airLineArray[0] = new Airline("Air India", locs1, 200);
        airLineArray[1] = new Airline("Vistara", locs2, 400);
        airLineArray[2] = new Airline("Spice Jet ", locs3, 300);
        airLineArray[3] = new Airline("Indigo", locs4, 150);
        airLineArray[4] = new Airline("Go First ", locs5, 70);

        while (!loop)
        {
            System.out.println("Welcome to the VEE BEE flight booking system");
            System.out.println("Please Enter your details");
            System.out.println("******************");
            System.out.println("Enter User Name");
            userName = sc.nextLine();
            System.out.println("Enter Phone Number");
            userContact = sc.nextLong();
            sc.nextLine();
            System.out.println("Enter Address");
            userAddress = sc.nextLine();
            System.out.println("Enter Passport Number");
            passportNumber = sc.nextLine();

            User user = new User(userName, userContact, userAddress, passportNumber);

            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Choose A Flight");
            for (int i = 0; i < airLineArray.length; i++)
            {
                System.out.println("Enter " + i + " for " + airLineArray[i].getAirLineName());
            }
            airLineChoice = sc.nextInt();
            if (airLineChoice < 0 || airLineChoice > 4)
            {
                System.out.println("Invalid Airline choice");
            } else
            {
                Airline choice = airLineArray[airLineChoice];
                System.out.println("You have chosen " + choice.getAirLineName());
                System.out.println(" ");
                System.out.println("Chose a 'From' Airport");
                for (int i = 0; i < choice.getSources().length; i++)
                {
                    System.out.println("Choose " + i + " for " + choice.getSource(i));
                }
                sourceChoice = sc.nextInt();
                if (sourceChoice < 0 || sourceChoice > 4)
                {
                    System.out.println("Invalid Source");
                } else
                {
                    String sourceAirport = choice.getSource(sourceChoice);
                    System.out.println("You have chosen " + sourceAirport);
                    System.out.println(" ");
                    String destinations[] = choice.getDestinations(sourceAirport);
                    System.out.println("Please Enter a Destination Airport");
                    for (int i = 0; i < destinations.length; i++)
                    {
                        System.out.println("Enter " + i + " for " + destinations[i]);
                    }
                    destChoice = sc.nextInt();
                    if (destChoice < 0 || destChoice > destinations.length - 1)
                    {
                        System.out.println("Invalid Destination");
                    } else
                    {
                        String destination = destinations[destChoice];
                        System.out.println("Your chosen destination is " + destination);
                        System.out.println(" ");
                        System.out.println(" ");
                        int fare = choice.getFare(sourceChoice, destChoice);
                        System.out.println(
                                "Your fare to travel from " + sourceAirport + " to " + destination + " is " + fare);
                        System.out.println("Press 1 to Pay amount and Continue Press 2 to exit");
                        finalChoice = sc.nextInt();
                        System.out.println("");
                        switch (finalChoice)
                        {
                            case 1:
                                System.out.println("Booking Success");
                                System.out.println("Your Booking ID is " + user.getBookingId(choice.getAirLineId()));
                                user.printUserDetails();
                                System.out.println("Your Source is " + sourceAirport);
                                System.out.println("Your Destination is " + destination);
                                System.out.println("Total Amount Paid in Rs " + fare);
                                System.out.println("Thank you for using VEE BEE please visit again");
                                break;

                            default:
                                System.out.println("Invalid Choice");
                                break;
                        }

                    }
                }
            }
            System.out.println("Enter1 to book again or 2 to exit");
            loopChoice = sc.nextInt();
            if (loopChoice == 2)
            {
                loop = true;
            }
            sc.nextLine();
        }

        sc.close();
    }
}

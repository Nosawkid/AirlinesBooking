class User
{
    private static int counter;
    private String userId;
    private String userName;
    private long userContact;
    private String userAddress;
    private String passportNumber;

    // Static Variable Initialization
    static
    {
        counter = 0;
    }

    // Constructer
    public User(String userName, long userContact, String userAddress, String passportNumber)
    {
        counter++;
        this.userId = "A100" + counter;
        this.userName = userName;
        this.userContact = userContact;
        this.userAddress = userAddress;
        this.passportNumber = passportNumber;
    }

    // Getters
    public String getUserId()
    {
        return this.userId;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public long getUserContact()
    {
        return this.userContact;
    }

    public String getUserAddress()
    {
        return this.userAddress;
    }

    public String getPassportNumber()
    {
        return this.passportNumber;
    }

    // Setters

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public void setUserContact(long userContact)
    {
        this.userContact = userContact;
    }

    public void setUserAddress(String userAddress)
    {
        this.userAddress = userAddress;
    }

    public void setPassportNumber(String passportNumber)
    {
        this.passportNumber = passportNumber;
    }

    public void printUserDetails()
    {
        System.out.println("userId " + this.userId);
        System.out.println("Name " + this.userName);
        System.out.println("Contact " + this.userContact);
        System.out.println("Address " + this.userAddress);
        System.out.println("Passport Number " + this.passportNumber);
    }

    public String getBookingId(String airLineId)
    {
        return airLineId.toUpperCase() + this.userId.toUpperCase();
    }

}
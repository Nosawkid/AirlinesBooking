class Airline
{
    private String airLineId;
    private String airLineName;
    private String[] sources;
    private static int counter;
    private String[] destinations;
    private int airLineCharge;

    static
    {
        counter = 0;

    }

    public Airline(String airLineName, String[] sources, int airLineCharge)
    {
        counter++;
        this.airLineName = airLineName;
        this.airLineId = this.airLineName.substring(0, 2).toUpperCase() + "000" + counter;
        this.sources = sources;
        this.airLineCharge = airLineCharge;

    }

    // Getters
    public String getAirLineId()
    {
        return this.airLineId;
    }

    public String getAirLineName()
    {
        return this.airLineName;
    }

    public String[] getSources()
    {
        return this.sources;
    }

    // Method to get a single source
    public String getSource(int choice)
    {
        return this.sources[choice];
    }

    // Method to get Destinations
    public String[] getDestinations(String source)
    {
        int count = 0;
        for (String s : sources)
        {
            if (!source.equalsIgnoreCase(s))
            {
                count++;
            }
        }

        destinations = new String[count];
        int index = 0;
        for (String s : sources)
        {
            if (!source.equalsIgnoreCase(s))
            {
                destinations[index] = s;
                index++;
            }
        }
        return destinations;
    }

    // Method to Calculate fare
    public int getFare(int sourceIndex, int destIndex)
    {
        int absoluteDifference = Math.abs(destIndex - sourceIndex);
        if (absoluteDifference == 0)
            return this.airLineCharge;

        return this.airLineCharge * absoluteDifference;

    }
}

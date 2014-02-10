package Veterinarians;

public class Address
{
    private String address;
    private String zipCode;
    private String city;

    public Address()
    {
        address = "";
        zipCode = "";
        city = "";
    }

    public Address(String address, String city, String zipCode)
    {
        this.address = address;
        this.city = city;
        this.zipCode = zipCode; 
    }

   public String getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }
}

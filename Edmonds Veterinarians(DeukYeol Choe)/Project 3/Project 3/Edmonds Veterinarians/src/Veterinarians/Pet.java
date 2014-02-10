package Veterinarians;
public class Pet extends Animal{

    private String petName;
    private String petType;

    public Pet()
    {
        petName = "";
        petType = "";
    }

    public Pet(String petType)
    {
        this.petType = petType;
    }

    public Pet(String petName, String petType)
    {
        this.petName = petName;
        this.petType = petType;
    }

// Return the pet name
    public String getPetName()
    {
        return petName;
    }

     public void setPetName(String name)
    {
        petName = name;
    }

    // Return the pet type
    public String getPetType()
    {
        return petType;
    }

    public void setPetType(String type)
    {
        petType = type;
    }

    public boolean needRabies()
    {
        if(petType.equals("Dog"))
            return true;
        else
            return false;
    }

    public boolean needTeeth()
    {
        if(petType.equals("Dog") || petType.equals("Cat") || petType.equals("Snake"))
            return true;
        else
            return false;
    }

     public boolean needFleas()
    {
        if(petType.equals("Dog") || petType.equals("Cat") || petType.equals("Bird"))
            return true;
        else
            return false;
    }

}
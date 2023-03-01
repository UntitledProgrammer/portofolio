package Mathematics;

public enum VectorComponent
{
    //Enumerations:
    X(0),
    Y(1),
    Z(2),
    W(3);

    //Attributes:
    private final int value;

    //Methods:
    public int toInteger()  { return value; }

    //Constructor:
    VectorComponent(int value) { this.value = value;}

}

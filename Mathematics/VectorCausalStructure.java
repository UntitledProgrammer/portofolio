package Mathematics;

public enum VectorCausalStructure
{
    //Enumeration:
    LIGHT_LIKE(0),
    SPACE_LIKE(1),
    TIME_LIKE(1);

    //Attributes:
    int value;

    //Constructor:
    VectorCausalStructure(int i)
    {
        value = i;
    }

    //Methods:
    static VectorCausalStructure get(double product)
    {
        if(product < 0) return SPACE_LIKE;
        else if(product > 0) return TIME_LIKE;

        return LIGHT_LIKE;
    }

    static VectorCausalStructure get(FourVector vector) { return get(FourVector.dot(vector, vector)); }
}

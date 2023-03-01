package Mathematics;

//Challenge: https://edabit.com/challenge/cPxexgGxmCMi4kas8

public class FourVector
{
    //Attributes:
    double[] components;
    public static final int LENGTH = 4;

    //Constructor:
    public FourVector()
    {
        //Initialise components
        components = new double[LENGTH];
    }

    public FourVector(double x, double y, double z, double w) { components = new double[]{x, y, z, w}; }

    //Methods:
    public double getComponent(VectorComponent position) { return components[position.toInteger()]; }

    public double getX() { return components[VectorComponent.X.toInteger()]; }
    public double getY() { return components[VectorComponent.Y.toInteger()]; }
    public double getZ() { return components[VectorComponent.Z.toInteger()]; }
    public double getW() { return components[VectorComponent.W.toInteger()]; }

    public void setX(double value) { components[VectorComponent.X.toInteger()] = value; }
    public void setY(double value) { components[VectorComponent.Y.toInteger()] = value; }
    public void setZ(double value) { components[VectorComponent.Z.toInteger()] = value; }
    public void setW(double value) { components[VectorComponent.W.toInteger()] = value; }

    private int kroneckerDelta(int i, int j) { if(i == j) return 1; return 0;}
    private int leviCivitaSymbol(int i, int j, int k)
    {
        if(i == j || i == k || j == k) return 0;

        int[][]  permutations = new int[][]{ new int[] {1,2,3}, new int[]{2,3,1}, new int[]{3,1,2} };

        for(int index = 0; index < permutations.length; index++) { if(permutations[index] == new int[] {i,j,k} ) return 1; }

        return -1;
    }

    //Operations:
    public void multiply(double value){ for(int i = 0; i < components[LENGTH]; i++) components[i] *= value; }
    public void multiply(FourVector right) { for(int i = 0 ; i < LENGTH; i++) { components[i] *= right.components[i]; } }
    public static double dot(FourVector left, FourVector right)
    {
        double result = left.getX() * right.getX();
        for(int i = 1; i < LENGTH; i++) result -= left.components[i] * right.components[i];

        return result;
    }
    public double getLength() { return (Math.sqrt(Math.abs(dot(this, this)))); }
    public VectorCausalStructure causalStructure() { return VectorCausalStructure.get(dot(this,this)); }
}

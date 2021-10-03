public class PointCP2
{
    private char typeCoord;

    private double xOrRho;

    private double yOrTheta;

    public PointCP2(char type, double xOrRho, double yOrTheta)
    {
        if(type != 'C' && type != 'P')
            throw new IllegalArgumentException();
        if (type == 'P')
            this.xOrRho = xOrRho;
            this.yOrTheta = yOrTheta;
            typeCoord = type;

        convertStorageToCartesian(); 
            
    }

    public double getX()
    {
        if(typeCoord == 'C') 
        return xOrRho;
        else 
        return (Math.cos(Math.toRadians(yOrTheta)) * xOrRho);
    }
  
    public double getY()
    {
        if(typeCoord == 'C') 
        return yOrTheta;
        else 
        return (Math.sin(Math.toRadians(yOrTheta)) * xOrRho);
    }
    
    
  
    public void convertStorageToCartesian()
    {
        if(typeCoord != 'C')
        {
            //Calculate X and Y
            double temp = getX();
            yOrTheta = getY();
            xOrRho = temp;
        
            typeCoord = 'C';	//Change coord type identifier
        }
    }

    public double getDistance(PointCP pointB)
    {
        // Obtain differences in X and Y, sign is not important as these values
        // will be squared later.
        double deltaX = getX() - pointB.getX();
        double deltaY = getY() - pointB.getY();
        
        return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
    }


    public PointCP rotatePoint(double rotation)
    {
        double radRotation = Math.toRadians(rotation);
        double X = getX();
        double Y = getY();
            
        return new PointCP('C',
        (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
        (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
    }

    public String toString()
    {
        return "Stored as " + (typeCoord == 'C' 
        ? "Cartesian  (" + getX() + "," + getY() + ")"
        : "Polar [" + getRho() + "," + getTheta() + "]") + "\n";
    }


    
	
}

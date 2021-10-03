public class PointCP3{

    private char typeCoord;

    private double xOrRho;

    private double yOrTheta;

    public PointCP3(char type, double xOrRho, double yOrTheta)
    {
        if(type != 'C' && type != 'P')
            throw new IllegalArgumentException();
        if (type == 'C')
            this.xOrRho = xOrRho;
            this.yOrTheta = yOrTheta;
            typeCoord = type;

        convertStorageToPolar(); 
            
    }


    public void convertStorageToPolar()
  {
    if(typeCoord != 'P')
    {
      //Calculate RHO and THETA
      double temp = getRho();
      yOrTheta = getTheta();
      xOrRho = temp;
      
      typeCoord = 'P';  //Change coord type identifier
    }
  }

}
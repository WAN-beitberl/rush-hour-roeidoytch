public class RushHourBoard {
    char matrix[][]=new char[6][6];
    RushHourCar car = new RushHourCar(0,2,'r',2,'r');
    RushHourCar cars[]=new RushHourCar[5];

    public RushHourBoard()
    {
        for(int i=0;i<6;i++)
            for(int j=0;j<6;j++)
                matrix[i][j]='.';
    }
    public void PrintBoard()
    {
        System.out.println("---------------");
        for(int i=0;i<6;i++) {
            System.out.print("| ");
            for (int j = 0; j < 6; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            if(i!=2)
                System.out.println("|");
            else
                System.out.println();
        }
        System.out.println("---------------");
    }
    public void putCarOnBoard(RushHourCar c)
    {
        for(int i=0;i<c.size;i++)
        {
            if(c.dir=='r') {
                matrix[c.y][c.x + i] = c.name;
            }
            if(c.dir=='d') {
                matrix[c.y+i][c.x] = c.name;
            }
        }
    }
    public void deleteCarFromBoard(RushHourCar c)
    {
        for(int i=0;i<c.size;i++)
        {
            if(c.dir=='r') {
                matrix[c.y][c.x + i] = '.';
            }
            if(c.dir=='d') {
                matrix[c.y+i][c.x] = '.';
            }
        }
    }
    public void buildProblem()
    {
        cars[0]=new RushHourCar(2,0,'d',2,'1');
        cars[1]=new RushHourCar(4,0,'r',2,'2');
        cars[2]=new RushHourCar(3,1,'d',3,'3');
        cars[3]=new RushHourCar(4,1,'d',2,'4');
        cars[4]=new RushHourCar(4,3,'r',2,'5');
        putCarOnBoard(car);
        putCarOnBoard(cars[0]);
        putCarOnBoard(cars[1]);
        putCarOnBoard(cars[2]);
        putCarOnBoard(cars[3]);
        putCarOnBoard(cars[4]);
    }
}

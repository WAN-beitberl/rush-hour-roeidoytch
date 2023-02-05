import java.util.Scanner;

public class RushHourGame {
    RushHourBoard board=new RushHourBoard();

    public RushHourGame()
    {
        board.buildProblem();
        //board.PrintBoard();
        //board.deleteCarFromBoard(board.car);
        //board.PrintBoard();
        LetsPlay();
    }
    public void LetsPlay()
    {
        Scanner scanner = new Scanner(System.in);
        char name;
        char dir;
        int steps;
        int result;
        while(IsGmaeEnd()==false) {
            board.PrintBoard();
            System.out.println("please enter the name of the car that you want to move");
            name = scanner.next().charAt(0);
            System.out.println("please enter the number of steps that you want to move");
            steps = scanner.nextInt();
            System.out.println("please enter the dir that you want to move from d,u,r,l");
            dir = scanner.next().charAt(0);
            if (name =='r')
                {
                    board.deleteCarFromBoard(board.car);
                    if(moveCar(board.car,dir,steps)!=69)
                        board.putCarOnBoard(board.car);
                }
            if (name <='5'&&name >='1')
            {
                int numName=name-49;
                board.deleteCarFromBoard(board.cars[numName]);
                moveCar(board.cars[numName],dir,steps);
                board.putCarOnBoard(board.cars[numName]);
            }
        }
        board.PrintBoard();
        System.out.println("You have won");

    }
    public int moveCar(RushHourCar c,char dir,int steps)
    {
        int counter=0;
        if((c.dir=='d'&&(dir=='r'||dir=='l'))||(c.dir=='r'&&(dir=='d'||dir=='u')))
        {
            System.out.println("something went wrong");
            return 0;
        }

        for (int i=0;i<steps;i++)
        {
            if(dir=='r')
            {
                if((c.x+c.size<6)&&board.matrix[c.y][c.x+c.size]=='.')
                {
                    counter++;
                    c.x++;
                }
                else {
                    boolean flag =true;
                    for(int j =0;j<6;j++)
                    {
                        if(board.matrix[2][j]=='.'||board.matrix[2][j]=='r')
                            continue;
                        else
                            flag =false;
                    }
                    if (c.name == 'r' && c.x + c.size + steps > 6 && flag)
                        return 69;
                }
            }
            if(dir=='l')
            {
                if((c.x-1>=0)&&board.matrix[c.y][c.x-1]=='.')
                {
                    counter++;
                    c.x--;
                }
            }
            if(dir=='d')
            {
                if((c.y+c.size<6)&&board.matrix[c.y+c.size][c.x]=='.')
                {
                    counter++;
                    c.y++;
                }
            }
            if(dir=='u')
            {
                if((c.y-1>=0)&&board.matrix[c.y-1][c.x]=='.')
                {
                    counter++;
                    c.y--;
                }
            }
        }
        return counter;
    }
    public boolean IsGmaeEnd(){
        for(int i=0;i<6;i++)
            for(int j=0;j<6;j++)
                if(board.matrix[i][j]=='r')
                    return false;
        return true;
    }
}

import java.util.*;

public class Main
{
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter player 1's name : ");
    String play1=sc.nextLine();
    System.out.println("Enter player 1's name : ");
    String play2=sc.nextLine();
    Random r=new Random();
    int pick = r.nextInt(1,2);
    System.out.printf("The first player to play is %d",pick);
    
}
}
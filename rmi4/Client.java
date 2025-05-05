import java.rmi.*;
import java.util.Scanner;

public class Client{
public static void main(String[] args)
{
Scanner sc=new Scanner (System.in);
try{
String serverUrl="rmi://localhost/Server";
ServerInterface SerIntf = (ServerInterface) Naming.lookup(serverUrl);

System.out.println("Enter year");
int year=sc.nextInt();

boolean result=SerIntf.IsLeapYear(year);

if(result){
System.out.println(year+"is a leap year");

}
else{
System.out.println(year+"is not a leap year");
}

}
catch(Exception e){
System.out.println("exception occured at client side"+e.getMessage());
}
}
}

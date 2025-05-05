import java.rmi.*;
import java.rmi.server.*;

public class ServerImplementation extends UnicastRemoteObject implements ServerInterface{

public ServerImplementation() throws RemoteException{
super();
}
public boolean IsLeapYear(int year) throws RemoteException{
return(year%4==0&&year%100!=0)||(year%400==0);
}
}

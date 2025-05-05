import java.rmi.*;

public interface ServerInterface extends Remote{
public boolean IsLeapYear(int year) throws RemoteException;

}


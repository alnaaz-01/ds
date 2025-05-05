import java.rmi.*;

public class Server{

public static void main(String[] args){

try{
   ServerImplementation serImpl = new  ServerImplementation();
   Naming.rebind("Server" , serImpl);
   System.out.println("server is ready.......");
}
catch(Exception e){
  System.out.println("exception occured at server"+e.getMessage());
}

}
}

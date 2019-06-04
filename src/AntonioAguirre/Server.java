package AntonioAguirre;

import com.db4o.ObjectServer;
import com.db4o.cs.Db4oClientServer;

import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        ObjectServer sv = Db4oClientServer.openServer(Db4oClientServer. newServerConfiguration(),
                "DDBB/BDRemota.db4o", 7000);


        Scanner in = new Scanner (System.in);
        System.out.println("Pitja [Q] per tancar el servidor.");

        while (in.hasNext()) {
            if ("Q".equalsIgnoreCase(in.next())) break;
        }


    }
}

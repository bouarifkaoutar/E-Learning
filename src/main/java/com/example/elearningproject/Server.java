package com.example.elearningproject;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static  void main(String args[]) throws RemoteException, MalformedURLException {
     ServicesImpl objet=new ServicesImpl();
        LocateRegistry.createRegistry(1099);

        Naming.rebind("remote",objet);

    }
}

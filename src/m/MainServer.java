package m;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import rmi.Calculator;
import rmi.RMI;

public class MainServer {

	public static void main(String[] args) {
		try {
			System.out.println("Iniciando Servidor...");
		
			//Instanciar Servidor RMI que implementa interfaz
			RMI cal = new RMI();		
			//Crear objeto stub del la clase remota
			Calculator stub = (Calculator) UnicastRemoteObject.exportObject(cal,0);
			//creamos canal de comunicación indicando puerto de transmisión
			Registry registry = LocateRegistry.createRegistry(1025);
			//enlazamos...
			registry.bind("Calculator", stub);
			System.out.println("Servidor OK...");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Clase que implementa la interfaz {@link Calculator}, contiene métodos con operaciones
 * matemáticas básicas
 * @author Bryan Ti
 *
 */
public class RMI implements Calculator{
	

	@Override
	public int equal(int x, int y) throws RemoteException {
		// TODO Auto-generated method stub
		return x+y;
	}

	@Override
	public int sustract(int x, int y) throws RemoteException {
		// TODO Auto-generated method stub
		return x-y;
	}

	@Override
	public int multiply(int x, int y) throws RemoteException {
		// TODO Auto-generated method stub
		return x*y;
	}

	@Override
	public int divide(int x, int y) throws RemoteException {
		// TODO Auto-generated method stub
		return x/y;
	}

}

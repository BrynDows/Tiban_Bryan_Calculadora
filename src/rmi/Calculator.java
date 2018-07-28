package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *	Clase que hereda de {@link Remote}, contiene m�todos que ser�n podr�n ser llamados desde otro host
 * @author Bryan Ti
 *
 */
public interface Calculator extends Remote {

	/**
	 * M�todo que debe sumar dos n�meros enteros y devolver el resultado.
	 * @param x n�mero
	 * @param y n�mero
	 * @return Resultado de la suma
	 * @throws RemoteException
	 */
	public int equal(int x, int y) throws RemoteException;
	
	/**
	 * M�todo que debe restar dos n�meros y devolver el resultado.
	 * @param x N�mero
	 * @param y N�mero
	 * @return Resultado de la resta
	 * @throws RemoteException
	 */
	public int sustract(int x, int y) throws RemoteException;
	
	/**
	 * M�todo que multiplica dos n�meros y devuelve el resultado.
	 * @param x N�mero
	 * @param y N�mero
	 * @return Resultado de la multiplicaci�n
	 * @throws RemoteException
	 */
	public int multiply(int x, int y) throws RemoteException;
	
	/**
	 * M�todo que divide dos n�meros y devuelve el resultado.
	 * @param x N�mero
	 * @param y N�mero
	 * @return Resultado de la divisi�n
	 * @throws RemoteException
	 */
	public int divide(int x, int y) throws RemoteException;
	
	
	
	
}

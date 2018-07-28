package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *	Clase que hereda de {@link Remote}, contiene métodos que serán podrán ser llamados desde otro host
 * @author Bryan Ti
 *
 */
public interface Calculator extends Remote {

	/**
	 * Método que debe sumar dos números enteros y devolver el resultado.
	 * @param x número
	 * @param y número
	 * @return Resultado de la suma
	 * @throws RemoteException
	 */
	public int equal(int x, int y) throws RemoteException;
	
	/**
	 * Método que debe restar dos números y devolver el resultado.
	 * @param x Número
	 * @param y Número
	 * @return Resultado de la resta
	 * @throws RemoteException
	 */
	public int sustract(int x, int y) throws RemoteException;
	
	/**
	 * Método que multiplica dos números y devuelve el resultado.
	 * @param x Número
	 * @param y Número
	 * @return Resultado de la multiplicación
	 * @throws RemoteException
	 */
	public int multiply(int x, int y) throws RemoteException;
	
	/**
	 * Método que divide dos números y devuelve el resultado.
	 * @param x Número
	 * @param y Número
	 * @return Resultado de la división
	 * @throws RemoteException
	 */
	public int divide(int x, int y) throws RemoteException;
	
	
	
	
}

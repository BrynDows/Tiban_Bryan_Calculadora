package m;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi.Calculator;
import v.JFCalculator;

/**
 * Esta clase es utilizada por {@link JFCalculator}, permite la conexi�n con el servidor.
 * da acceso al objeto remoto, de manera que con el m�todo {@link getCalculator()}
 * podemos obtener el objeto remoto.
 * @author Bryan Ti
 *
 */
public class Client {

	/**
	 * objeto remoto
	 */
	private Calculator calculator;
	
	/**
	 * Constructor por defecto, instancia la clase Client de manera que realiza una conexi�n con el servidor RMI y da valor
	 * a la variable {@link calculator} de esta clase
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public Client() throws RemoteException, NotBoundException {
		//canal
		Registry reg = LocateRegistry.getRegistry("127.0.0.1",1025);
		//objeto remoto
		calculator = (Calculator) reg.lookup("Calculator");
		
	}
	
	/**
	 * Con este m�todo tenemos acceso a la clase remota y a todos su m�todos.
	 * @return Ojeto remoto.
	 */
	public Calculator getCalculator() {
		return calculator;
	}
	
	

}

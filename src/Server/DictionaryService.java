package Server;

import java.io.FileNotFoundException;
import java.rmi.*;
import java.util.ArrayList;

public interface DictionaryService extends Remote{
	
	public ArrayList<String> getWords() throws RemoteException, FileNotFoundException;
	
	public String lookup(String s) throws RemoteException;
	
}

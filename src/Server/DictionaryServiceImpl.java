package Server;

import java.io.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class DictionaryServiceImpl  extends UnicastRemoteObject implements DictionaryService {
	private static final long serialVersionUID = 1L;
	ArrayList<String> words = new ArrayList<String>();

	public DictionaryServiceImpl() throws RemoteException{
		super();
	}

	@Override
	public String lookup(String s) throws RemoteException {
		System.out.println(words);
		return null;
	}

	@SuppressWarnings("resource")
	@Override
	public ArrayList<String> getWords() throws RemoteException, FileNotFoundException {
		File f = new File("dictionary.csv");
		Scanner in = new Scanner(f);
	    while (in.hasNextLine()){
	        words.add(in.nextLine());
	    }
	    
	    return words;
	}
}

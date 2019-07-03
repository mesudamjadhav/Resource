package com.yash.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

public class RmiClient {
	
	private static RmiInterface rmiInterface;
	
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		rmiInterface = (RmiInterface) Naming.lookup("//localhost/MyServer");
		String txt = JOptionPane.showInputDialog("What is your name?");
		String response = rmiInterface.hello(txt);
		JOptionPane.showMessageDialog(null, response);
	}

}

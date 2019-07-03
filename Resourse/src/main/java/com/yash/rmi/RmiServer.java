package com.yash.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiServer extends UnicastRemoteObject implements RmiInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RmiServer() throws RemoteException {
		super();
	}
	
	@Override
	public String hello(String s) {
		 System.err.println(s + " is trying to contact!");
		return "Hellow "+s;
	}

	public static void main(String[] args) {
	
		try {
			Naming.rebind("//localhost/myserver", new RmiServer());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

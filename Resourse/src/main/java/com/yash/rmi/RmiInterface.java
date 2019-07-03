package com.yash.rmi;

import java.rmi.Remote;

public interface RmiInterface extends Remote {
	String hello(String s);
}

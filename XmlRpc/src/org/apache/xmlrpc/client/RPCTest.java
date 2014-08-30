package org.apache.xmlrpc.client;
import java.net.URL;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class RPCTest {
	
	public static void main(String[] args)throws Exception {
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		config.setServerURL(new URL("http://api.tcshenghuo.org:8888/XmlRpc/xmlrpc"));
		XmlRpcClient client = new XmlRpcClient();
		client.setConfig(config);
		//Object[] params = new Object[]{};  
		
		//client.execute("Whome.play_begin", params);
		
		
		//System.out.println(result);
		
		Object[] params = new Object[]{new Integer(31)};  
		//client.execute("LampControl.powerOn", params);
		Integer result = (Integer) client.execute("LampControl.getHue", params);
		System.out.println(result);
	}
}
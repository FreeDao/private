package com.marck.common;

import org.json.JSONException;

import javapns.back.PushNotificationManager;
import javapns.back.SSLConnectionHelper;
import javapns.data.Device;
import javapns.data.PayLoad;

public class Push {

	/**
	 * 发送给单个对象
	 * @throws Exception 
	 */
	public static void pushUser(String path,String password,String deviceToken,String content) throws Exception{
	     //被推送的iphone应用程序标示符      
	     PayLoad payLoad = new PayLoad();
	     payLoad.addAlert(content);
	     payLoad.addBadge(1);
	     payLoad.addSound("default");
	              
	     PushNotificationManager pushManager = PushNotificationManager.getInstance();
	     pushManager.addDevice("iphone", deviceToken);
	    
	  //Device c = pushManager.getDevice("iphone");
	     String host= "gateway.push.apple.com";  
	     int port = 2195;
	    
	     path += "/dml.p12";
	     System.out.println(path);
	     pushManager.initializeConnection(host, port, path,password, SSLConnectionHelper.KEYSTORE_TYPE_PKCS12);//初始化tcp连接，公司网络代理上网，不能连上外网的tcp连接，坑死人
	               
	     //Send Push
	     Device client = pushManager.getDevice("iphone");
	     pushManager.sendNotification(client, payLoad); //推送消息
	     pushManager.stopConnection();
	     pushManager.removeDevice("iphone");
	}
	
	/**
	 * 发送给单个对象
	 */
	public static void pushAll(){
		
	}
	
	
	public static void main(String[] args) {
		try {
			
		String token = "ffd4d3df4a29b4fe5db9ffab01a9d71de1eb19725ecd2163e832cf9e3798d9d5";
		
		 PayLoad payLoad = new PayLoad();
	     payLoad.addAlert("收到没？");
	     payLoad.addBadge(1);
	     payLoad.addSound("default");
	              
	     PushNotificationManager pushManager = PushNotificationManager.getInstance();
	     pushManager.addDevice("iphone", token);
	    
	  //Device c = pushManager.getDevice("iphone");
	     String host= "gateway.push.apple.com";  
	     int port = 2195;
	    
	     pushManager.initializeConnection(host, port, "e:/dml.p12","123456", SSLConnectionHelper.KEYSTORE_TYPE_PKCS12);//初始化tcp连接，公司网络代理上网，不能连上外网的tcp连接，坑死人
	               
	     //Send Push
	     Device client = pushManager.getDevice("iphone");
	     pushManager.sendNotification(client, payLoad); //推送消息
	     pushManager.stopConnection();
	     pushManager.removeDevice("iphone");
	     
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}

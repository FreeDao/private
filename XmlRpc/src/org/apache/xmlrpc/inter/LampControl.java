package org.apache.xmlrpc.inter;

    public class LampControl {
    	
    	public void powerOn(int light_no){
    		System.out.println("powerOn");
    	}
    	public void powerOff( int light_no){
    		System.out.println("powerOff");
    	}
    	public void setHue( int light_no,  int rgb){
    		System.out.println("setHue");
    	}
    	public void setBrightness( int light_no,  int brightness){
    		System.out.println("setBrightness");
    	}
    	public void setStyle( int style){
    		System.out.println("setStyle");
    	}
    	public boolean isPowerOn( int light_no){
			return false;
    	}
    	public int getHue(int light_no){
    		return 1;
    	}
    	public int getBrightness(int light_no){
    		return 2;
    	}
    	public int getStyle(){
    		return 3;
    	}
    	
    }

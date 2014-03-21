package com.databb;

public class Axis2WB {  
    /** 
     * 提供了一个说Hello的服务 
     * @return 
     */  
    public String sayHello(String name){  
        return "Hello "+name;  
    }  
      
    /** 
     * 提供了一个做加法的服务 
     * @param a 
     * @param b 
     * @return 
     */  
    public int add(int a,int b){  
        return a + b;  
    }  
    public static void main(String[] args)
    {
    	DataBBMain mainF = new DataBBMain();
    	if (mainF.checkUser("usaer1", "142") )
    		System.out.println("ok");
    }
    
}  
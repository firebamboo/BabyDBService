package com.databb;

public class Axis2WB {  
    /** 
     * �ṩ��һ��˵Hello�ķ��� 
     * @return 
     */  
    public String sayHello(String name){  
        return "Hello "+name;  
    }  
      
    /** 
     * �ṩ��һ�����ӷ��ķ��� 
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
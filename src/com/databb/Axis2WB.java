package com.databb;
import java.io.IOException;
import java.io.Reader;
import java.sql.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.databb.dao.BasicinfoMapper;
import com.databb.entity.Basicinfo;

public class Axis2WB {  
    /** 
     * 提供了一个说Hello的服务 
     * @return 
     */ 
	private  SqlSessionFactory sqlSessionFactory; 
    { 
       String resource = "resource/mybatis-config.xml"; 
       Reader reader = null; 
       try { 
           reader = Resources.getResourceAsReader(resource); 
       } catch (IOException e) { 
           System.out.println(e.getMessage()); 
           
       } 
       sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader); 
    } 
    
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
     
    

    
}  
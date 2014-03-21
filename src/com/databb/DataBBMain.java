package com.databb;
import org.apache.ibatis.session.SqlSession; 
import org.apache.ibatis.session.SqlSessionFactory; 
//import org.junit.Test; 

import com.databb.dao.BasicinfoMapper;
import com.databb.entity.*;
  
public class DataBBMain { 
    static SqlSessionFactory sqlSessionFactory = null; 
    { 
       sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
    } 
    
    public  int getUser(String username) {
    	if(sqlSessionFactory == null)
    		return 0;
       SqlSession sqlSession = sqlSessionFactory.openSession(); 
       try { 
    	   BasicinfoMapper userMapper = sqlSession.getMapper(BasicinfoMapper.class);
    	   //Basicinfo user = userMapper.selectByPrimaryKey(10);
    	   Basicinfo user = userMapper.selectByUsername(username);
    	   
           System.out.println("name: "+user.getName()+"|age: "+user.getId()+"|birth: "+user.getBirth());
           return 2;
       } finally { 
           sqlSession.close(); 
       } 
    } 
    public String insertBasicInfo(Basicinfo info)
    {
    	if(sqlSessionFactory == null)
    		return "DB Error";
    	SqlSession sqlSession = sqlSessionFactory.openSession(); 
    	try{
    		BasicinfoMapper userMapper = sqlSession.getMapper(BasicinfoMapper.class);
    		Basicinfo user = userMapper.selectByUsername(info.getUsername());
     	   	if(user != null)
     		   return "User Exist";
    		userMapper.insert(info);
    		sqlSession.commit();
    	}
    	finally{
    		sqlSession.close(); 
    	}
    	return "success";
    }
    
    public boolean checkUser(String username, String passowrd)
    {
    	if(sqlSessionFactory == null)
    		return true;
       SqlSession sqlSession = sqlSessionFactory.openSession(); 
       try { 
    	   BasicinfoMapper userMapper = sqlSession.getMapper(BasicinfoMapper.class);
    	   Basicinfo user = userMapper.selectByUsername(username);
    	   if(user == null)
    		   return false;
    	   if(user.getPassword().equals(passowrd))
    		   return true;
       } finally { 
           sqlSession.close(); 
       } 
    	return false;
    }

} 
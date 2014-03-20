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
    
    public  int testAdd() { 
    	if(sqlSessionFactory == null)
    		return 0;
       SqlSession sqlSession = sqlSessionFactory.openSession(); 
       try { 
           BasicinfoMapper userMapper = sqlSession.getMapper(BasicinfoMapper.class); 
           Basicinfo user = new Basicinfo();
           user.setId(10);
           user.setName("name1");
           
           userMapper.insert(user);
           sqlSession.commit();//这里一定要提交，不然数据进不去数据库中 
           return 1;
       } finally { 
           sqlSession.close(); 
       } 
    } 
    
    public int insertBasicInfo(Basicinfo info)
    {
    	if(sqlSessionFactory == null)
    		return 0;
    	SqlSession sqlSession = sqlSessionFactory.openSession(); 
    	try{
    		BasicinfoMapper userMapper = sqlSession.getMapper(BasicinfoMapper.class);
    		userMapper.insert(info);
    		sqlSession.commit();
    	}
    	finally{
    		sqlSession.close(); 
    	}
    	return 1;
    }
    
    public  int getUser() {
    	if(sqlSessionFactory == null)
    		return 0;
       SqlSession sqlSession = sqlSessionFactory.openSession(); 
       try { 
    	   BasicinfoMapper userMapper = sqlSession.getMapper(BasicinfoMapper.class);
    	   //Basicinfo user = userMapper.selectByPrimaryKey(10);
    	   Basicinfo user = userMapper.selectByName("name1");
    	   Basicinfo info = new Basicinfo();
    	   info.setName("name");
    	   
           System.out.println("name: "+user.getName()+"|age: "+user.getId()+"|birth: "+user.getBirth());
           return 2;
       } finally { 
           sqlSession.close(); 
       } 
    } 

    
} 
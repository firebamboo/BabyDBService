package com.databb;
/*
import java.sql.*;
public class DataBBMain {

	public static void main(String[] args) {
		// ����������
		String driver = "com.mysql.jdbc.Driver";
		// URLָ��Ҫ���ʵ����ݿ���game
		String url = "jdbc:mysql://127.0.0.1:3306/babycenter";
		// MySQL����ʱ���û���
		String user = "root";
		// MySQL����ʱ������
		String password = "1qaz2wsx";
		try {
		// ������������
		Class.forName(driver);
		// �������ݿ�
		Connection conn = DriverManager.getConnection(url, user, password);
		if(!conn.isClosed())
		System.out.println("Succeeded connecting to the Database!");
		// statement����ִ��SQL���
		Statement statement = conn.createStatement();
		// Ҫִ�е�SQL���
		String sql = "select * from basicinfo";
		// �����
		ResultSet rs = statement.executeQuery(sql);
		System.out.println("-----------------");
		System.out.println("ִ�н��������ʾ:");
		System.out.println("-----------------");
		System.out.println(" id" + "\t" + " �û���");
		System.out.println("-----------------");
		String name = null;
		while(rs.next()) {
		// ѡ��username��������
		name = rs.getString("Name");
		// ����ʹ��ISO-8859-1�ַ�����name����Ϊ�ֽ����в�������洢�µ��ֽ������С�
		// Ȼ��ʹ��GB2312�ַ�������ָ�����ֽ�����
		name = new String(name.getBytes("ISO-8859-1"),"GB2312");
		// ������
		System.out.println(rs.getString("id") + "\t" + name);
		}
		rs.close();
		conn.close();
		} catch(ClassNotFoundException e) {
		System.out.println("Sorry,can`t find the Driver!");
		e.printStackTrace();
		} catch(SQLException e) {
		e.printStackTrace();
		} catch(Exception e) {
		e.printStackTrace();
		}
		}
	}
*/
import org.apache.ibatis.session.SqlSession; 
import org.apache.ibatis.session.SqlSessionFactory; 
//import org.junit.Test; 

import com.databb.dao.BasicinfoMapper;
import com.databb.entity.*;
  
public class DataBBMain { 
    static SqlSessionFactory sqlSessionFactory = null; 
    static { 
       sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
    } 
    
    public static void testAdd() { 
       SqlSession sqlSession = sqlSessionFactory.openSession(); 
       try { 
           BasicinfoMapper userMapper = sqlSession.getMapper(BasicinfoMapper.class); 
           Basicinfo user = new Basicinfo();
           user.setId(10);
           user.setName("name1");
           
           userMapper.insert(user);
           sqlSession.commit();//����һ��Ҫ�ύ����Ȼ���ݽ���ȥ���ݿ��� 
       } finally { 
           sqlSession.close(); 
       } 
    } 
    

    public static void getUser() { 
       SqlSession sqlSession = sqlSessionFactory.openSession(); 
       try { 
    	   BasicinfoMapper userMapper = sqlSession.getMapper(BasicinfoMapper.class);
    	   //Basicinfo user = userMapper.selectByPrimaryKey(10);
    	   Basicinfo user = userMapper.selectByName("name1");
    	   Basicinfo info = new Basicinfo();
    	   info.setName("name");
    	   
           System.out.println("name: "+user.getName()+"|age: "+user.getId()+"|birth: "+user.getBirth()); 
       } finally { 
           sqlSession.close(); 
       } 
    } 
    public static void main(String[] args) {
    	testAdd();
    }
    
} 
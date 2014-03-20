package com.databb;
/*
import java.sql.*;
public class DataBBMain {

	public static void main(String[] args) {
		// 驱动程序名
		String driver = "com.mysql.jdbc.Driver";
		// URL指向要访问的数据库名game
		String url = "jdbc:mysql://127.0.0.1:3306/babycenter";
		// MySQL配置时的用户名
		String user = "root";
		// MySQL配置时的密码
		String password = "1qaz2wsx";
		try {
		// 加载驱动程序
		Class.forName(driver);
		// 连续数据库
		Connection conn = DriverManager.getConnection(url, user, password);
		if(!conn.isClosed())
		System.out.println("Succeeded connecting to the Database!");
		// statement用来执行SQL语句
		Statement statement = conn.createStatement();
		// 要执行的SQL语句
		String sql = "select * from basicinfo";
		// 结果集
		ResultSet rs = statement.executeQuery(sql);
		System.out.println("-----------------");
		System.out.println("执行结果如下所示:");
		System.out.println("-----------------");
		System.out.println(" id" + "\t" + " 用户名");
		System.out.println("-----------------");
		String name = null;
		while(rs.next()) {
		// 选择username这列数据
		name = rs.getString("Name");
		// 首先使用ISO-8859-1字符集将name解码为字节序列并将结果存储新的字节数组中。
		// 然后使用GB2312字符集解码指定的字节数组
		name = new String(name.getBytes("ISO-8859-1"),"GB2312");
		// 输出结果
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
import java.sql.Date;

import org.apache.ibatis.session.SqlSession; 
import org.apache.ibatis.session.SqlSessionFactory; 
//import org.junit.Test; 

import com.databb.dao.BasicinfoMapper;
import com.databb.entity.*;
  
public class DataBBMain { 
    static SqlSessionFactory sqlSessionFactory = null; 
    MyBatisUtil util = new MyBatisUtil();
    { 
       sqlSessionFactory = util.getSqlSessionFactory();
    } 
    
    public static int testAdd() { 
       SqlSession sqlSession = sqlSessionFactory.openSession(); 
       try { 
           BasicinfoMapper userMapper = sqlSession.getMapper(BasicinfoMapper.class); 
           Basicinfo user = new Basicinfo();
           user.setId(10);
           user.setName("name1");
           
           int ret = userMapper.insert(user);
           sqlSession.commit();//这里一定要提交，不然数据进不去数据库中
           return ret;
       } finally { 
           sqlSession.close(); 
       } 
    } 
    

    public static java.util.Date getUser() { 
       SqlSession sqlSession = sqlSessionFactory.openSession(); 
       try { 
    	   BasicinfoMapper userMapper = sqlSession.getMapper(BasicinfoMapper.class);
    	   //Basicinfo user = userMapper.selectByPrimaryKey(10);
    	   Basicinfo user = userMapper.selectByName("name1");
    	   Basicinfo info = new Basicinfo();
    	   info.setName("name");
    	   
           System.out.println("name: "+user.getName()+"|age: "+user.getId()+"|birth: "+user.getBirth());
           return user.getBirth();
       } finally { 
           sqlSession.close(); 
       } 
    } 
    /*public static void main(String[] args) {
    	testAdd();
    }
    */
} 
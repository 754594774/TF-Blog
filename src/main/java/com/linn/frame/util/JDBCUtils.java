package com.linn.frame.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
	private static Logger logger = LoggerFactory.getLogger(JDBCUtils.class);
	static Properties pros = null;   //可以帮助读取和处理资源文件中的信息
	static {   //加载JDBCUtil类的时候调用
		pros = new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			logger.error("初始化失败",e);
		}
	}
	public static Connection getMysqlConn(){
		try {
			Class.forName(pros.getProperty("mysqlDriver"));
			return DriverManager.getConnection(pros.getProperty("mysqlURL"),
					pros.getProperty("mysqlUser"),pros.getProperty("mysqlPwd"));
		} catch (Exception e) {
			logger.error("连接数据库失败",e);
			return null;
		}
	}

	public static void close(ResultSet rs,Statement ps,Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			logger.error("关闭数据库",e);
		}
		try {
			if(ps!=null){
				ps.close();
			}
		} catch (SQLException e) {
			logger.error("关闭数据库",e);
		}
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			logger.error("关闭数据库",e);
		}
	}
	
	public static void close(Statement ps,Connection conn){
		try {
			if(ps!=null){
				ps.close();
			}
		} catch (SQLException e) {
			logger.error("关闭数据库",e);
		}
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			logger.error("关闭数据库",e);
		}
	}
	
	public static void close(Connection conn){
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			logger.error("关闭数据库",e);
		}
	}
}

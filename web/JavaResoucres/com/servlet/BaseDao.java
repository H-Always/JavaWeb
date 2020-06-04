package com.servlet;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//import org.apache.commons.beanutils.BeanUtils;

public class BaseDao {
	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	public void getConnection() {

		try {
			/*
			 * 数据源 负责建立与数据库的连接，当在应用程序中访问数据库时
			 * 不必编写连接数据库的代码，直接引用DataSource获取数据库的连接对象即可。 用于获取操作数据Connection对象。
			 */
			// 获取与逻辑名相关联的数据源对象
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/news");

			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public <T> List<T> exeQu(String sql, Object[] objects, Class<T> clazz) {
		getConnection();
		List<T> list = new ArrayList<T>();
		try {
			pst = conn.prepareStatement(sql);
			if (objects != null) {
				for (int i = 0; i < objects.length; i++) {
					pst.setObject(i + 1, objects[i]);
				}
			}
			System.out.println(pst.toString());

			rs = pst.executeQuery();
			// 创建集合

			ResultSetMetaData rsmd = rs.getMetaData();
			// 遍历结果集
			while (rs.next()) {

				T obj = clazz.newInstance(); // 实例化对象
				// 得到结果集的列数
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					// 得到列名 RS
					String colName = rsmd.getColumnName(i + 1);
					// 列号从1开始，得到每1列的值
					Object value = rs.getObject(colName);
					// 把名字和值赋值到对象中 对象类型 属性 值
					//BeanUtils.setProperty(obj, colName, value);
				}
				// 添加到列表中
				list.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} /*catch (InvocationTargetException e) {
			e.printStackTrace();
		}*/ finally {
			closeAll();
		}
		return list;
	}

	//单个查询
		public Object executeQuery(String sql, Object[] objects) {
			getConnection();
			Object object = null;
			try {
				pst = conn.prepareStatement(sql);
				if (objects != null) {
					for (int i = 0; i < objects.length; i++) {
						pst.setObject(i + 1, objects[i]);
					}
				}
				rs = pst.executeQuery();
				System.out.println(pst.toString());
				while (rs.next()) {
					object = rs.getObject(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeAll();
			}
			return object;

		}
	public int exeUp(String sql, Object[] objects,boolean bool) {
		getConnection();
		int row = 0;
		try {
			pst = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			if (objects != null) {
				for (int i = 0; i < objects.length; i++) {
					pst.setObject(i + 1, objects[i]);
				}
			}
			row = pst.executeUpdate();
			if(bool){
				rs = pst.getGeneratedKeys();
				while(rs.next()){
					row = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return row;

	}

	private void closeAll() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

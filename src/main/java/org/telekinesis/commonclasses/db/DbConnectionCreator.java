package org.telekinesis.commonclasses.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * Remember to Class.forName() or new to load the jdbc implementation class
 * before instantiating this class
 */
public class DbConnectionCreator
{
    private final String url;
    private final String user;
    private final String password;

    public DbConnectionCreator(String url, String user, String password)
    {
	this.url = url;
	this.user = user;
	this.password = password;
    }

    public <T> List<T> query(String sql, RowConverter<T> converter)
	    throws SQLException
    {
	Connection c = DriverManager.getConnection(url, user, password);
	List<T> objects = new ArrayList<T>();
	try
	{
	    PreparedStatement statement = c.prepareStatement(sql);
	    ResultSet result = statement.executeQuery();
	    while (result.next())
	    {
		T object = converter.convert(result);
		objects.add(object);
	    }

	}
	catch (SQLException e)
	{

	}
	finally
	{
	    c.close();
	}
	return objects;
    }
}

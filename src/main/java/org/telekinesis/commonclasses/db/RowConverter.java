package org.telekinesis.commonclasses.db;

import java.sql.ResultSet;

public interface RowConverter<T>
{
    public T convert(ResultSet row);
}

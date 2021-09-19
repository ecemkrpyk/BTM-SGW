package com.example.springbootweblogic.repository.abstracts;

import org.apache.hadoop.hbase.client.Connection;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public interface HBaseDao<T> {

    public List<T> getAll (Connection connection, String tableName) throws IOException;
    public String getRows(Connection connection, String tableName, String rowkey);
    public void deleteRows(Connection connection,String tableName,String rowkey) throws IOException;

}
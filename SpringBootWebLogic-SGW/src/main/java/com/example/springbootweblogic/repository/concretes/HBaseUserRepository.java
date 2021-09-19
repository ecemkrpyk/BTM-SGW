package com.example.springbootweblogic.repository.concretes;

import com.example.springbootweblogic.model.User;
import com.example.springbootweblogic.repository.abstracts.HBaseDao;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class HBaseUserRepository implements HBaseDao {
    Logger logger = LoggerFactory.getLogger(HBaseUserRepository.class);


    @Override
    @Async
    public List<User> getAll(Connection connection, String tableName) throws IOException {
        byte[] Name = Bytes.toBytes("name");
        byte[] Surname = Bytes.toBytes("surname");
        byte[] Gender = Bytes.toBytes("gender");
        byte[] Age = Bytes.toBytes("age");
        byte[] CF_INFO = Bytes.toBytes("personal_info");
        List<User> userList = new ArrayList<>();
        Table table = connection.getTable(TableName.valueOf("user"));
        Scan scan1 = new Scan();
        ResultScanner scanner1 = table.getScanner(scan1);


        if (scanner1 != null) {


            for (Result res : scanner1) { //tüm satır ve sütunlardaki veriyi tarayıp getirecek
                String name = Bytes.toString(res.getValue(CF_INFO, Name));
                String surname = Bytes.toString(res.getValue(CF_INFO, Surname));
                String gender = Bytes.toString(res.getValue(CF_INFO, Gender));
                int age = Integer.valueOf(Bytes.toString(res.getValue(CF_INFO, Age)));
                String row = Bytes.toString(res.getRow());
                userList.add(new User(name, surname, age, gender, row));
                logger.info(row + " " + name + " " + surname + " " + age + " " + gender);


            }
            scanner1.close();

            return userList;
        } else {
            scanner1.close();
            return null;
        }
    }

    @Override
    public String getRows(Connection connection, String tableName, String rowkey) {
        return null;
    }

    @Override
    public void deleteRows(Connection connection, String tableName, String rowkey) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Delete delete = new Delete(Bytes.toBytes(rowkey));
        table.delete(delete);
    }
}

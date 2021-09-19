package com.argelastaj.springbootweblogicbtm.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.security.UserGroupInformation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@org.springframework.context.annotation.Configuration
public class HBaseConfig {
    //application.propertiesden  alınan veriler connection oluşturmak için kullanılır.
    @Value("${sr.hbase.zk.quorum}")
    private String ZK_QUORUM;//Zookeeper sunucusu
    @Value("${sr.hbase.zk.node}")
    private String ZK_ZNODE;//Zookeeper dizini
    @Value("${sr.hbase.zk.port}")
    private String ZK_PORT;//Zookeeper portu
    @Value("${sr.hbase.super.user}")
    private String SUPER_USER;//Zookeeper kullanıcısı


    @Bean
    public Configuration getConfiguration() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", ZK_QUORUM);
        conf.set("zookeeper.znode.parent", ZK_ZNODE);
        conf.set("hbase.zookeeper.property.clientPort", ZK_PORT);
        return conf;
    }

    public Configuration setUser(Configuration conf, String user) {
        UserGroupInformation.setConfiguration(conf);
        UserGroupInformation remoteUser = UserGroupInformation.createRemoteUser(user);
        UserGroupInformation.setLoginUser(remoteUser);
        return conf;
    }

    @Bean
    public Connection createConnection() throws IOException {
        Configuration configuration = setUser(getConfiguration(), SUPER_USER);
        Connection connection = ConnectionFactory.createConnection(configuration);
        return connection;
    }
}

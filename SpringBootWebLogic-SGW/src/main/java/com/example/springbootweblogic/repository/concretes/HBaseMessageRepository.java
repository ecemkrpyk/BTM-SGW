package com.example.springbootweblogic.repository.concretes;

import java.io.IOException;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.springbootweblogic.model.Incoming_MessageHB;
import com.example.springbootweblogic.repository.abstracts.HBaseDao;

@Service
public class HBaseMessageRepository implements HBaseDao {
	 Logger logger = LoggerFactory.getLogger(HBaseMessageRepository.class);


	    @Override
	    @Async
	    public List<Incoming_MessageHB> getAll(Connection connection, String tableName) throws IOException {
	        byte[] messageId = Bytes.toBytes("messageId");
	        byte[] lifecycleStatusId = Bytes.toBytes("lifecycleStatusId");
	        byte[] messageContentId = Bytes.toBytes("messageContentId");
	        byte[] bulkTransactionId = Bytes.toBytes("bulkTransactionId");
	        byte[] recipientAddress = Bytes.toBytes("recipientAddress");
	        byte[] lastUpdateTime = Bytes.toBytes("lastUpdateTime");
	        byte[] retryCount = Bytes.toBytes("retryCount");
	        byte[] sessionGroupId = Bytes.toBytes("sessionGroupId");
	        byte[] messageSegmentCount = Bytes.toBytes("messageSegmentCount");
	        byte[] totalSegmentCount = Bytes.toBytes("totalSegmentCount");
	        byte[] cdrCount = Bytes.toBytes("cdrCount");
	        byte[] restartTime = Bytes.toBytes("restartTime");
	        byte[] stopTime = Bytes.toBytes("stopTime");
	        byte[] hostId = Bytes.toBytes("hostId");
	        byte[] endDateTime = Bytes.toBytes("endDateTime");
	        byte[] cqIdListString = Bytes.toBytes("cqIdListString");
	        byte[] partitionPart = Bytes.toBytes("partitionPart");
	        byte[] isInternational = Bytes.toBytes("isInternational");
	        
	        

	        byte[] CF_INFO = Bytes.toBytes("message_info");
	        List<Incoming_MessageHB> messageList = new ArrayList<>();
	        Table table = connection.getTable(TableName.valueOf("message"));
	        Scan scan1 = new Scan();
	        ResultScanner scanner1 = table.getScanner(scan1);


	        if (scanner1 != null) {


	            for (Result res : scanner1) { 
	            	int MessageId = Integer.valueOf(Bytes.toString(res.getValue(CF_INFO, messageId)));
	            	int LifecycleStatusId = Integer.valueOf(Bytes.toString(res.getValue(CF_INFO, lifecycleStatusId)));
	            	int MessageContentId = Integer.valueOf(Bytes.toString(res.getValue(CF_INFO, messageContentId)));
	            	int BulkTransactionId = Integer.valueOf(Bytes.toString(res.getValue(CF_INFO, bulkTransactionId)));
	            	int RecipientAddress = Integer.valueOf(Bytes.toString(res.getValue(CF_INFO, recipientAddress))); 
	            	Long LastUpdateTime = Long.valueOf(Bytes.toString(res.getValue(CF_INFO, lastUpdateTime)));
	            	int RetryCount = Integer.valueOf(Bytes.toString(res.getValue(CF_INFO, retryCount)));
	            	int SessionGroupId = Integer.valueOf(Bytes.toString(res.getValue(CF_INFO, sessionGroupId)));
	            	int MessageSegmentCount = Integer.valueOf(Bytes.toString(res.getValue(CF_INFO, messageSegmentCount)));
	            	int TotalSegmentCount = Integer.valueOf(Bytes.toString(res.getValue(CF_INFO, totalSegmentCount)));
	            	int CdrCount = Integer.valueOf(Bytes.toString(res.getValue(CF_INFO, cdrCount)));
	            	int RestartTime = Integer.valueOf(Bytes.toString(res.getValue(CF_INFO, restartTime)));
	            	int StopTime = Integer.valueOf(Bytes.toString(res.getValue(CF_INFO, stopTime)));
	            	int HostId = Integer.valueOf(Bytes.toString(res.getValue(CF_INFO, hostId)));
	            	int EndDateTime = Integer.valueOf(Bytes.toString(res.getValue(CF_INFO, endDateTime)));
	            	String CqIdListString = Bytes.toString(res.getValue(CF_INFO, cqIdListString));
	            	int PartitionPart = Integer.valueOf(Bytes.toString(res.getValue(CF_INFO, partitionPart)));
	            	int IsInternational = Integer.valueOf(Bytes.toString(res.getValue(CF_INFO, isInternational)));
	           
	            	String uuid = Bytes.toString(res.getRow());
	            	
	            	
	                
	                
	                messageList.add(new Incoming_MessageHB(
	                		uuid,RecipientAddress,LastUpdateTime,RetryCount,
	                		MessageSegmentCount,TotalSegmentCount,CdrCount,RestartTime,
	                		StopTime,HostId,EndDateTime,CqIdListString,
	                		PartitionPart,IsInternational,MessageId, LifecycleStatusId, 
	                		MessageContentId, BulkTransactionId,SessionGroupId));
	                
	                logger.info(uuid + " " + RecipientAddress + " " + LastUpdateTime + " " + RetryCount + " " + MessageSegmentCount
	                		+ " " +  " " + TotalSegmentCount+ " " + CdrCount+ " " + RestartTime+ " " + StopTime
	                		+ " " + HostId+ " " + EndDateTime
	                		+ " " + CqIdListString+ " " + PartitionPart+ " " + IsInternational+ " " + MessageId+ " " + LifecycleStatusId
	                		+ " " + MessageContentId+ " " + BulkTransactionId+ " " + SessionGroupId
	                		
	                		);


	            }
	            scanner1.close();

	            return messageList;
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

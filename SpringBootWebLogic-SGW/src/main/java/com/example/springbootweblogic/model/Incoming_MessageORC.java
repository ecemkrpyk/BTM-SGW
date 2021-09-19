package com.example.springbootweblogic.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="INCOMING_MESSAGE")
public class Incoming_MessageORC {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="MESSAGE_ID")
	private int messageId;
	
	@Column(name="LIFECYCLE_STATUS_ID")
	private int lifecycleStatusId;
	
	@Column(name="MESSAGE_CONTENT_ID")
	private int messageContentId;
	
	@Column(name="BULK_TRANSACTION_ID")
	private int bulkTransactionId;
	
	@Column(name="RECIPIENT_ADDRESS")
	private int recipientAddress;
	
	@Column(name="LAST_UPDATE_TIME")
	private Timestamp lastUpdateTime;
	
	@Column(name="RETRY_COUNT")
	private int retryCount;
	
	@Column(name="SESSION_GROUP_ID")
	private int sessionGroupId;
	
	@Column(name="MESSAGE_SEGMENT_COUNT")
	private int messageSegmentCount;
	
	@Column(name="TOTAL_SEGMENT_COUNT")
	private int totalSegmentCount;
	
	@Column(name="CDR_COUNT")
	private int cdrCount;
	
	@Column(name="RESTART_TIME")
	private int restartTime;
	
	@Column(name="STOP_TIME")
	private int stopTime;
	
	@Column(name="HOST_ID")
	private int hostId;
	
	@Column(name="END_DATE_TIME")
	private int endDateTime;
	
	@Column(name="CQ_ID_LIST_STRING")
	private String cqIdListString;
	
	@Column(name="PARTITION_PART")
	private int partitionPart;
	
	@Column(name="IS_INTERNATIONAL")
	private int isInternational;
	
	public Incoming_MessageORC() {
		
	}

	public Incoming_MessageORC(int recipientAddress, Timestamp lastUpdateTime, int retryCount,
			int messageSegmentCount, int totalSegmentCount, int cdrCount, int restartTime,
			int stopTime, int hostId, int endDateTime, String cqIdListString, int partitionPart, int isInternational, 
			int messageId, int lifecycleStatusId,int messageContentId,int bulkTransactionId,int sessionGroupId) {
		
		this.messageId=messageId;
		this.lifecycleStatusId =lifecycleStatusId;
		this.messageContentId = messageContentId;
		this.bulkTransactionId =bulkTransactionId;
		this.sessionGroupId = sessionGroupId;
		
		this.recipientAddress = recipientAddress;
		this.lastUpdateTime = lastUpdateTime;
		this.retryCount = retryCount;
		this.messageSegmentCount = messageSegmentCount;
		this.totalSegmentCount = totalSegmentCount;
		this.cdrCount = cdrCount;
		this.restartTime = restartTime;
		this.stopTime = stopTime;
		this.hostId = hostId;
		this.endDateTime = endDateTime;
		this.cqIdListString = cqIdListString;
		this.partitionPart = partitionPart;
		this.isInternational = isInternational;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public int getLifecycleStatusId() {
		return lifecycleStatusId;
	}

	public void setLifecycleStatusId(int lifecycleStatusId) {
		this.lifecycleStatusId = lifecycleStatusId;
	}

	public int getMessageContentId() {
		return messageContentId;
	}

	public void setMessageContentId(int messageContentId) {
		this.messageContentId = messageContentId;
	}

	public int getBulkTransactionId() {
		return bulkTransactionId;
	}

	public void setBulkTransactionId(int bulkTransactionId) {
		this.bulkTransactionId = bulkTransactionId;
	}

	public int getRecipientAddress() {
		return recipientAddress;
	}

	public void setRecipientAddress(int recipientAddress) {
		this.recipientAddress = recipientAddress;
	}

	public Timestamp getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public int getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
	}

	public int getSessionGroupId() {
		return sessionGroupId;
	}

	public void setSessionGroupId(int sessionGroupId) {
		this.sessionGroupId = sessionGroupId;
	}

	public int getMessageSegmentCount() {
		return messageSegmentCount;
	}

	public void setMessageSegmentCount(int messageSegmentCount) {
		this.messageSegmentCount = messageSegmentCount;
	}

	public int getTotalSegmentCount() {
		return totalSegmentCount;
	}

	public void setTotalSegmentCount(int totalSegmentCount) {
		this.totalSegmentCount = totalSegmentCount;
	}

	public int getCdrCount() {
		return cdrCount;
	}

	public void setCdrCount(int cdrCount) {
		this.cdrCount = cdrCount;
	}

	public int getRestartTime() {
		return restartTime;
	}

	public void setRestartTime(int restartTime) {
		this.restartTime = restartTime;
	}

	public int getStopTime() {
		return stopTime;
	}

	public void setStopTime(int stopTime) {
		this.stopTime = stopTime;
	}

	public int getHostId() {
		return hostId;
	}

	public void setHostId(int hostId) {
		this.hostId = hostId;
	}

	public int getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(int endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getCqIdListString() {
		return cqIdListString;
	}

	public void setCqIdListString(String cqIdListString) {
		this.cqIdListString = cqIdListString;
	}

	public int getPartitionPart() {
		return partitionPart;
	}

	public void setPartitionPart(int partitionPart) {
		this.partitionPart = partitionPart;
	}

	public int getIsInternational() {
		return isInternational;
	}

	public void setIsInternational(int isInternational) {
		this.isInternational = isInternational;
	}

	@Override
	public String toString() {
		return "Incoming_Message [messageId=" + messageId + ", lifecycleStatusId=" + lifecycleStatusId
				+ ", messageContentId=" + messageContentId + ", bulkTransactionId=" + bulkTransactionId
				+ ", recipientAddress=" + recipientAddress + ", lastUpdateTime=" + lastUpdateTime + ", retryCount="
				+ retryCount + ", sessionGroupId=" + sessionGroupId + ", messageSegmentCount=" + messageSegmentCount
				+ ", totalSegmentCount=" + totalSegmentCount + ", cdrCount=" + cdrCount + ", restartTime=" + restartTime
				+ ", stopTime=" + stopTime + ", hostId=" + hostId + ", endDateTime=" + endDateTime + ", cqIdListString="
				+ cqIdListString + ", partitionPart=" + partitionPart + ", isInternational=" + isInternational + "]";
	}

	
}


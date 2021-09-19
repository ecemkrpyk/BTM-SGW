package com.example.springbootweblogic.model;


import com.fasterxml.jackson.annotation.JsonFormat;

public class Incoming_MessageHB {
	
	private String uuid;
	
	private int messageId;
	private int lifecycleStatusId;
	private int messageContentId;
	private int bulkTransactionId;
	private int recipientAddress;
	
	//@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
	private Long lastUpdateTime;
	
	private int retryCount;
	private int sessionGroupId;
	private int messageSegmentCount;
	private int totalSegmentCount;
	private int cdrCount;
	private int restartTime;
	private int stopTime;
	private int hostId;
	private int endDateTime;
	private String cqIdListString;
	private int partitionPart;
	private int isInternational;
	
	public Incoming_MessageHB() {
		
	}

	public Incoming_MessageHB(String uuid,int recipientAddress, Long lastUpdateTime, int retryCount,
			int messageSegmentCount, int totalSegmentCount, int cdrCount, int restartTime,
			int stopTime, int hostId, int endDateTime, String cqIdListString, int partitionPart, int isInternational,
			int messageId, int lifecycleStatusId,int messageContentId,int bulkTransactionId,int sessionGroupId) {
		
		this.uuid=uuid;
		
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

	public String getUuid() {
		return uuid;
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

	public Long getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Long lastUpdateTime) {
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



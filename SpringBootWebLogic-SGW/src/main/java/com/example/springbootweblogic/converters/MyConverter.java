package com.example.springbootweblogic.converters;

import com.example.springbootweblogic.model.Incoming_MessageHB;
import com.example.springbootweblogic.model.Incoming_MessageORC;
import com.example.springbootweblogic.model.User;
import com.example.springbootweblogic.model.UserORC;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.UUID;

@Component
public class MyConverter implements Converter {
    @Override
    public UserORC convert(User user) {
        return new UserORC(user.getName(), user.getSurname(), user.getAge(), user.getGender());
    }

    @Override
    public User convert(UserORC userORC) {
        return new User(userORC.getName(), userORC.getSurname(), userORC.getAge(), userORC.getGender(), UUID.randomUUID().toString());
    }

	@Override
	public Incoming_MessageORC convert(Incoming_MessageHB messageHB){
	
	
			
		
		
		return new Incoming_MessageORC(
				
				
				messageHB.getRecipientAddress(),
				new Timestamp(messageHB.getLastUpdateTime()),
				messageHB.getRetryCount(),
				messageHB.getMessageSegmentCount(),
				messageHB.getTotalSegmentCount(),
				messageHB.getCdrCount(),
				messageHB.getRestartTime(),
				messageHB.getStopTime(),
				messageHB.getHostId(),
				messageHB.getEndDateTime(),
				messageHB.getCqIdListString(),
				messageHB.getPartitionPart(),
				messageHB.getIsInternational(),
				messageHB.getMessageId(),
				messageHB.getLifecycleStatusId(),
				messageHB.getMessageContentId(),
				messageHB.getBulkTransactionId(),
				messageHB.getSessionGroupId());
		}

	@Override
	public Incoming_MessageHB convert(Incoming_MessageORC messageORC) {
	
		return new Incoming_MessageHB(
				UUID.randomUUID().toString(),
				messageORC.getRecipientAddress(),
				messageORC.getLastUpdateTime().getTime(),
				messageORC.getRetryCount(),
				messageORC.getMessageSegmentCount(),
				messageORC.getTotalSegmentCount(),
				messageORC.getCdrCount(),
				messageORC.getRestartTime(),
				messageORC.getStopTime(),
				messageORC.getHostId(),
				messageORC.getEndDateTime(),
				messageORC.getCqIdListString(),
				messageORC.getPartitionPart(),
				messageORC.getIsInternational(),
				messageORC.getMessageId(),
				messageORC.getLifecycleStatusId(),
				messageORC.getMessageContentId(),
				messageORC.getBulkTransactionId(),
				messageORC.getSessionGroupId());
				
				
	}
    
    
}

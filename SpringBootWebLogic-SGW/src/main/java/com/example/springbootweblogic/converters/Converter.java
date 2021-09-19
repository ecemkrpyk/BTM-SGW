package com.example.springbootweblogic.converters;

import com.example.springbootweblogic.model.Incoming_MessageHB;
import com.example.springbootweblogic.model.Incoming_MessageORC;
import com.example.springbootweblogic.model.User;
import com.example.springbootweblogic.model.UserORC;

public interface Converter {
    UserORC convert(User user);

    User convert(UserORC userORC);
    
    Incoming_MessageORC convert(Incoming_MessageHB messageHB);
    
    Incoming_MessageHB convert(Incoming_MessageORC messageORC);
}

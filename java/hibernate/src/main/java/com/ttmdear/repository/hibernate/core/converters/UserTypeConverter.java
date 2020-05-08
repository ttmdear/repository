package com.ttmdear.repository.hibernate.core.converters;


import com.ttmdear.repository.hibernate.core.domain.UserType;

import javax.persistence.AttributeConverter;

public class UserTypeConverter implements AttributeConverter<UserType, String> {

    @Override
    public String convertToDatabaseColumn(UserType userType) {
        if (userType.equals(UserType.ADMIN)) {
            return "a";
        } else if (userType.equals(UserType.EMPLOYEE)) {
            return "e";
        } else if (userType.equals(UserType.CUSTOMER)) {
            return "c";
        }

        return null;
    }

    @Override
    public UserType convertToEntityAttribute(String s) {
        if (s.equals("a")) {
            return UserType.ADMIN;
        } else if (s.equals("e")) {
            return UserType.EMPLOYEE;
        } else if (s.equals("c")) {
            return UserType.CUSTOMER;
        }

        return null;
    }
}

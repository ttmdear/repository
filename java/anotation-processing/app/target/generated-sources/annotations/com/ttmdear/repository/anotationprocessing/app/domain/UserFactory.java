package com.ttmdear.repository.anotationprocessing.app.domain;public class UserFactory {
private java.lang.String id;

public UserFactory setId(java.lang.String id) { this.id = id; return this;}
private java.lang.String firstName;

public UserFactory setFirstName(java.lang.String firstName) { this.firstName = firstName; return this;}
private java.lang.String lastName;

public UserFactory setLastName(java.lang.String lastName) { this.lastName = lastName; return this;}
private java.util.Date birthDate;

public UserFactory setBirthDate(java.util.Date birthDate) { this.birthDate = birthDate; return this;}









public com.ttmdear.repository.anotationprocessing.app.domain.User create() {
com.ttmdear.repository.anotationprocessing.app.domain.User ob = new com.ttmdear.repository.anotationprocessing.app.domain.User();
ob.setId(id);
ob.setFirstName(firstName);
ob.setLastName(lastName);
ob.setBirthDate(birthDate);
return ob;
}}
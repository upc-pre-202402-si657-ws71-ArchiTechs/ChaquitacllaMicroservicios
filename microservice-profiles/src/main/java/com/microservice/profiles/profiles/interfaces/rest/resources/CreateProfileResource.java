package com.microservice.profiles.profiles.interfaces.rest.resources;

public record CreateProfileResource(String firstName, String lastName, String username,String email,
    String street, String number, String city, String postalCode, String country) {
}

package com.springactuator.SpringActuatorProject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "user-stats")
public class UserStatsEndpoint {

    @Autowired
    private UserRepository userRepository;

    @ReadOperation
    public String totalUsers() {
        long count = userRepository.count();
        return "Total users: " + count;
    }
}

package com.stock.stockindicator.testingburp.controller;

import com.stock.stockindicator.testingburp.bsefcl.FetchUsers;
import com.stock.stockindicator.testingburp.logging.LogToFile;
import com.stock.stockindicator.testingburp.logging.LogUsers;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class APIController {

    private final FetchUsers fetchUsers;
    private final LogToFile logToFile;
    private final LogUsers logUsers;

    public APIController(FetchUsers fetchUsers, LogToFile logToFile, LogUsers logUsers) {
        this.fetchUsers = fetchUsers;
        this.logToFile = logToFile;
        this.logUsers = logUsers;
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable int id) {
        return fetchUsers.fetchUserById(id).toString();
    }

    @GetMapping("/activeusers")
    public String getActiveUsers() {
        return logToFile.LogToFileUsers();
    }

}

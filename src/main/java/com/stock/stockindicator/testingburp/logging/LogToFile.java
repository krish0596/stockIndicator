package com.stock.stockindicator.testingburp.logging;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class LogToFile {

    LogUsers logUsers;
    int start = 5228489;
    int end = start + 100;
    public LogToFile(LogUsers logUsers) {
        this.logUsers = logUsers;
    }

    public String LogToFileUsers(){
        return logUsers.logUsersInRange(start, end);
    }
}

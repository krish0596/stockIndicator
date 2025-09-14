package com.stock.stockindicator.testingburp.logging;


import com.stock.stockindicator.testingburp.bsefcl.FetchUsers;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;

@Service
public class LogUsers {

    private FetchUsers fetchUsers;
    public LogUsers(FetchUsers fetchUsers) {
        this.fetchUsers = fetchUsers;
    }

    public boolean userExists( int id) {
        return !fetchUsers.fetchUserById(id).get("errorMessage").toString().isEmpty();
    }

    public String logUsersInRange(int start, int end){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = start; i < end; i++){
            var user = fetchUsers.fetchUserById(i);
            if(!user.get("errorMessage").toString().isEmpty()){
                System.out.println(user.get("name").toString());
                System.out.println("===============================");
                stringBuilder.append(user.get("name").toString());
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return stringBuilder.toString();
    }

}

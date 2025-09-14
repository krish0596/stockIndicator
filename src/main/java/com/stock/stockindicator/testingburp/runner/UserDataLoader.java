package com.stock.stockindicator.testingburp.runner;

import com.fasterxml.jackson.databind.JsonNode;
import com.stock.stockindicator.testingburp.bsefcl.FetchUsers;
import com.stock.stockindicator.testingburp.persistence.entity.RegisteredUsersEntity;
import com.stock.stockindicator.testingburp.service.RegisteredUsersService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserDataLoader implements CommandLineRunner {

    private final RegisteredUsersService userService;
    private final FetchUsers fetchUsers;

    public UserDataLoader(RegisteredUsersService userService, FetchUsers fetchUsers) {
        this.userService = userService;
        this.fetchUsers = fetchUsers;
    }

//    @Override
//    public void run(String... args) throws Exception {
//        // 1. Call external API
//        RestTemplate restTemplate = new RestTemplate();
//        String apiUrl = "https://example.com/api/users"; // replace with your API URL
//
//        RegisteredUsersEntity[] users = restTemplate.getForObject(apiUrl, RegisteredUsersEntity[].class);
//
//        if (users != null) {
//            for (RegisteredUsersEntity user : users) {
//                // 2. Save each user into the database
//                userService.saveUser(user);
//                System.out.println("Saved user: " + user.getName());
//            }
//        } else {
//            System.out.println("No users found from API.");
//        }
//    }
    @Override
    public void run(String... args) throws Exception {
        int start = 5240268;
        int end = 6000000;
        for(int i = start; i <= end; i++){
            System.out.println("At user : " + i);
            JsonNode jsonNode =fetchUsers.fetchUserById(i);
            if(jsonNode.get("errorMessage").asText().isEmpty()){
                RegisteredUsersEntity user = new RegisteredUsersEntity();
                user.setId(String.valueOf(i));  // or generate your own ID
                user.setName(jsonNode.path("name").asText());
                user.setPhone(jsonNode.path("phoneNo").asText());
                user.setEmail(jsonNode.path("emailId").asText());
                user.setRoll(jsonNode.path("rollNo").asText());
                user.setInstituteName(jsonNode.path("instituteName").asText());
                user.setAadhar(jsonNode.path("aadhaarNo").asText());
                user.setValidationStatus(jsonNode.path("validationStatus").asText());
                user.setCourseDuration(jsonNode.path("courseDuration").asText());
                user.setAddress(jsonNode.path("address").asText());
                user.setBranchName(jsonNode.path("branchName").asText());
                user.setInstituteAddress(jsonNode.path("instituteAddress").asText());
                user.setCourseName(jsonNode.path("courseName").asText());
                user.setCoappContact(jsonNode.path("coappContact").asText());
                user.setInstituteContact(jsonNode.path("instituteContact").asText());
                user.setCoApplicantName(jsonNode.path("coApplicantName").asText());
                user.setCoApplicantAddress(jsonNode.path("coApplicantAddress").asText());

                userService.saveUser(user);
                System.out.println("Saved User: " + user.getId() + " with name: " + user.getName());
            }

        }

    }

}

//sdd
// 5228490 to 5230931
 // 5231869
 // 5232261
 // 5238783
 //5240268
//5241240


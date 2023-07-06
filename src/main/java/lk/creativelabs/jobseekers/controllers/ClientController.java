package lk.creativelabs.jobseekers.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lk.creativelabs.jobseekers.dto.ClientDTO;
import lk.creativelabs.jobseekers.dto.EmployeeDTO;
import lk.creativelabs.jobseekers.entity.enums.ApprovalStatus;
import lk.creativelabs.jobseekers.service.ClientService;
import lk.creativelabs.jobseekers.service.EmployeeService;
import lk.creativelabs.jobseekers.util.FileServer;
import lk.creativelabs.jobseekers.util.ResponseUtil;
import lk.creativelabs.jobseekers.util.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("client")
@CrossOrigin
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    EmployeeService employeeService;

    @PostMapping(value = "/createNew", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUtil createNewClient(@RequestParam String client, @RequestParam MultipartFile profileImage, @RequestParam MultipartFile businessDoc, @RequestHeader String role) throws Exception {

        ClientDTO clientDto = new ObjectMapper().readValue(client, ClientDTO.class);

        System.out.println(clientDto);
        System.out.println(role);

        String rootFolder = "./assets";

        String assetsFolderPath = rootFolder;
        String clientFolderPath = rootFolder + "/client";

        FileServer.createDrictory(assetsFolderPath);

        //saved file locations
        String profilePath = FileServer.createDrictoryAndSaveFile(clientFolderPath, profileImage);
        String businessDocPath = FileServer.saveFile(businessDoc, clientFolderPath);

        if (role.equals(UserRole.CLIENT.getAuthority())) {
            clientDto.setRole(UserRole.CLIENT.getAuthority());
            clientDto.setProfileImageUri(profilePath);
            clientDto.setBusinessRegistrationDocUri(businessDocPath);
            clientDto.setApprovalStatus(ApprovalStatus.APPROVED);

            System.out.println(clientDto);
            return new ResponseUtil(200, "save_success", clientService.createNewClient(clientDto));

        } else {
            return new ResponseUtil(400, "user role is not valid", null);
        }
    }



    @GetMapping(value = "/getclient", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUtil getRegisteredClient(@RequestHeader(required = true) String userId,
                                            @RequestHeader(required = true) String role) throws Exception {
        System.out.println(userId + " " + role);
        if (role.equals(UserRole.CLIENT.getAuthority())) {
            Object client = clientService.getClient(userId, role);
            if (client instanceof String) {
                return new ResponseUtil(200, client.toString(), null);
            } else if (client instanceof ClientDTO) {
                return new ResponseUtil(200, "get_client_success", client);
            }
        }
        return new ResponseUtil(400, "user role is not valid", null);
    }


    @PostMapping(value = "/update", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUtil updateClient(@RequestBody ClientDTO clientDTO, @RequestHeader String userId) throws Exception {

        System.out.println(clientDTO + " BBBBBBBBB ");
        return new ResponseUtil(200, "client update success ", clientService.updateClient(clientDTO, userId));

    }

    @PostMapping(value = "/delete", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUtil deleteClient(@RequestBody String userId) {

        return null;
    }


    //send message to the client
    @GetMapping(value = "/get/employees/by/clientId", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUtil getEmployeeDetailsForEachClient(@RequestHeader(required = true) String userId,
                                                        @RequestHeader(required = true) String role) throws Exception {
        if (role.equals(UserRole.EMPLOYEE.getAuthority())) {
            return new ResponseUtil(200, "get_user_success", clientService.getAllEmployeesByClientUserId(userId));
        } else {
            return new ResponseUtil(400, "user role is not valid", null);
        }

    }

    @GetMapping(value = "/get/employee/jobTypes", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUtil getAllJobsTypes(@RequestHeader(required = true) String userId,
                                        @RequestHeader(required = true) String role) throws Exception {
        if (role.equals(UserRole.EMPLOYEE.getAuthority())) {
            return new ResponseUtil(200, "get_user_success", clientService.getFilteredAllJobTypes(userId));
        } else {
            return new ResponseUtil(400, "user role is not valid", null);
        }

    }

}

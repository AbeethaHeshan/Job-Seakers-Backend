package lk.creativelabs.jobseekers.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lk.creativelabs.jobseekers.dto.ApplicationDTO;
import lk.creativelabs.jobseekers.dto.EmployeeDTO;
import lk.creativelabs.jobseekers.service.ApplicationService;
import lk.creativelabs.jobseekers.util.FileServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("jobApplication")
public class JobApplicationController {
    @Autowired
    ApplicationService applicationService;


     @PostMapping("/create/new")
     public void createNewApplication(@RequestParam String application, @RequestHeader String clientUserId, @RequestHeader String employeeUserId, @RequestParam MultipartFile cv) throws Exception {
         JsonMapper jsonMapper = new JsonMapper();
         jsonMapper.registerModule(new JavaTimeModule());
         ApplicationDTO applicationDto = jsonMapper.readValue(application, ApplicationDTO.class);


         String rootFolder = "./assets";
         String assetsFolderPath = rootFolder;
         String applicationFolderPath = rootFolder + "/applications";
         FileServer.createDrictory(assetsFolderPath);

         //saved file locations
         String profilePath = FileServer.createDrictoryAndSaveFile(applicationFolderPath, cv);
         applicationDto.setCvUri(profilePath);
         applicationDto.setUserId(employeeUserId);

         applicationService.createNewApplication(clientUserId,employeeUserId,applicationDto);

     }

    @PostMapping("/get/status")
    public void getApplicationStatus(){

    }

    @PostMapping("/get")
    public void getApplication(){

    }

    @PostMapping("/approval/status")
    public void updateApprovalStatus(){

    }

    @PostMapping("/getAll")
    public void getAllApplications(){

    }

}

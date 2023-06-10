package lk.creativelabs.jobseekers.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jobApplication")
public class JobApplicationController {

     @PostMapping("/create/new")
     public void createNewApplication(){

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

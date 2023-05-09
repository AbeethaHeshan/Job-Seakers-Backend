package lk.creativelabs.jobseekers.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categories")
public class JobCategoryController {

            @PostMapping(value = "/createNew",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
            public void createNewCategory(){

            }

            @PostMapping(value = "/update",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
            public void updateCategory(){

            }

            @PostMapping(value = "/delete",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
            public void deleteCategory(){

            }

            @GetMapping(value = "/getAll",produces = {MediaType.APPLICATION_JSON_VALUE})
            public String getAllCategories(){
              return "Hi CCCCCC";
            }

}

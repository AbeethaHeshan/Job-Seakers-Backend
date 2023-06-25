package lk.creativelabs.jobseekers.controllers;

import lk.creativelabs.jobseekers.dto.JobCategoryDTO;
import lk.creativelabs.jobseekers.service.JobCatogaryService;
import lk.creativelabs.jobseekers.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("jobcategories")
@CrossOrigin
public class JobCategoryController {

          @Autowired
          JobCatogaryService jobCatogaryService;

            @PostMapping(value = "/createnew",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
            public ResponseUtil createNewCategory(@RequestBody JobCategoryDTO jobCategoryDTO){
                        return new ResponseUtil(200,"save success",jobCatogaryService.createNewCatogary(jobCategoryDTO));
            }

            @PostMapping(value = "/update",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
            public void updateCategory(){

            }

            @PostMapping(value = "/delete",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
            public void deleteCategory(){

            }

            @GetMapping(value = "/getAll",produces = {MediaType.APPLICATION_JSON_VALUE})
            public ResponseUtil getAllCategories(){
              return new ResponseUtil(200,"save success",jobCatogaryService.getAll());
            }

        @GetMapping(value = "/getAll/job/type/roles",produces = {MediaType.APPLICATION_JSON_VALUE})
        public ResponseUtil getAllRoles(){
          return new ResponseUtil(200,"save success",jobCatogaryService.getAllRoleTypes());
        }

        @PostMapping(value = "/getAll/job/type/roles/catagory",produces = {MediaType.APPLICATION_JSON_VALUE})
        public ResponseUtil getAllJobRoleTypeByCategary(@RequestParam(value = "catogary") String catogary) throws Exception {
            System.out.println(catogary);
          return new ResponseUtil(200,"save success",jobCatogaryService.getAllRoleTypesByCatogary(catogary));
        }

}

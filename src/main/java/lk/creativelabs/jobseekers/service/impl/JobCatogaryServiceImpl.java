package lk.creativelabs.jobseekers.service.impl;

import lk.creativelabs.jobseekers.dto.JobCategoryDTO;
import lk.creativelabs.jobseekers.entity.JobCategory;
import lk.creativelabs.jobseekers.repo.JobCategoryRepo;
import lk.creativelabs.jobseekers.service.JobCatogaryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobCatogaryServiceImpl implements JobCatogaryService {


    @Autowired
    ModelMapper mapper;

    @Autowired
    JobCategoryRepo jobCategoryRepo;

    @Override
    public JobCategoryDTO createNewCatogary(JobCategoryDTO jobCategoryDetails) {
       return mapper.map(jobCategoryRepo.save(mapper.map(jobCategoryDetails, JobCategory.class)),JobCategoryDTO.class);
    }

    @Override
    public ArrayList<String> getAll() {
        return new ArrayList<>(jobCategoryRepo.findAllJobTypes());
    }

    @Override
    public ArrayList<String> getAllRoleTypes() {
        return new ArrayList<>(jobCategoryRepo.findAllServiceTypes());
    }

    @Override
    public ArrayList<String> getAllRoleTypesByCatogary(String catogary) throws Exception {
        System.out.println(catogary);
        try{
            List<String> allServiceTypesByJobType = jobCategoryRepo.findAllServiceTypesByJobType(catogary);
            return new ArrayList<>(allServiceTypesByJobType);

        }
         catch (Exception e){
             System.out.println(e.getMessage());
             throw new Exception(e);
         }
    }

}

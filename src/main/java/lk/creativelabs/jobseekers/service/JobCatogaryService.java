package lk.creativelabs.jobseekers.service;

import lk.creativelabs.jobseekers.dto.JobCategoryDTO;

import java.util.ArrayList;

public interface JobCatogaryService {

     JobCategoryDTO createNewCatogary(JobCategoryDTO jobCategoryDetails);
     ArrayList<String> getAll();
}

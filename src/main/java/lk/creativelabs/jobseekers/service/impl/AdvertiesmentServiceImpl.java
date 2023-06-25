package lk.creativelabs.jobseekers.service.impl;

import lk.creativelabs.jobseekers.dto.AdvertiesmentDTO;
import lk.creativelabs.jobseekers.entity.Advertisement;
import lk.creativelabs.jobseekers.entity.Client;
import lk.creativelabs.jobseekers.entity.JobCategory;
import lk.creativelabs.jobseekers.repo.AdvertisementRepo;
import lk.creativelabs.jobseekers.repo.ClientRepo;
import lk.creativelabs.jobseekers.repo.JobCategoryRepo;
import lk.creativelabs.jobseekers.service.AdvertiesmentService;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdvertiesmentServiceImpl implements AdvertiesmentService {

    @Autowired
    AdvertisementRepo advertisementRepo;

    @Autowired
    ModelMapper mapper;

    @Autowired
    ClientRepo clientRepo;

    @Autowired
    JobCategoryRepo jobCategoryRepo ;

    @Override
    public AdvertiesmentDTO createNewAdvertiesment(AdvertiesmentDTO advertiesmentDTO,String userId) throws Exception {
        try{
            long categoryId = jobCategoryRepo.findCategoryIdByJobType(advertiesmentDTO.getClarification());

            Client client = clientRepo.getClientByUserId(userId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid client ID"));

            Optional<JobCategory> jobCategoryOptional = jobCategoryRepo.getJobCategoryByCategoryId(categoryId);
            JobCategory jobCategory = jobCategoryOptional.orElseThrow(() -> new IllegalArgumentException("Invalid category ID"));

            Advertisement advertisement = mapper.map(advertiesmentDTO, Advertisement.class);
             advertisement.setClient(client);
             advertisement.setJobCategory(jobCategory);

            return  mapper.map(advertisementRepo.save(advertisement),AdvertiesmentDTO.class);
        }catch (Exception e) {
            throw new Exception(e);
        }

    }

    @Override
    public AdvertiesmentDTO updateAdvertiesment(AdvertiesmentDTO advertiesmentDTO, String userId) {

        return null;
    }

    @Override
    public boolean deleteAdvertiesment(String userId) {

        return false;
    }

    @Override
    public ArrayList<AdvertiesmentDTO> getAllAdvertiesmentsByClientId(String userId) {
        long clientId = clientRepo.findClientIdByUserId(userId);

        List<Advertisement> advertisementsByClient = advertisementRepo.getAdvertisementsByClient(clientId);
        List<AdvertiesmentDTO> advertisementDTOs = advertisementsByClient.stream()
                .map(advertisement -> mapper.map(advertisement, AdvertiesmentDTO.class))
                .collect(Collectors.toList());
        return new ArrayList<>(advertisementDTOs);
    }

    @Override
    public ArrayList<AdvertiesmentDTO> getAllAdvertiesmentsByEmployeeJobType(String jobType) {

        return null;
    }

    @Override
    public void deleteByDate(LocalDate localDate) {
        boolean b = advertisementRepo.deleteAllByEndDate(localDate);
        System.out.println(b + " DELETE ADS");
    }

    @Override
    public ArrayList<AdvertiesmentDTO> getAllAdvertiesments() {
        List<Advertisement> all = advertisementRepo.findAll();
        List<AdvertiesmentDTO> advertisementDTOs = all.stream()
                .map(advertisement -> mapper.map(advertisement, AdvertiesmentDTO.class))
                .collect(Collectors.toList());
        return new ArrayList<>(advertisementDTOs);
    }
}

package lk.creativelabs.jobseekers.service;

import lk.creativelabs.jobseekers.dto.RatingDTO;

public interface RatingService {
         int getRatingForEmployee(String employeeId);
         int getRatingForClient(String clientId);
         boolean createRate(RatingDTO ratingDetails);

}

package lk.creativelabs.jobseekers.service;

import lk.creativelabs.jobseekers.dto.UserCredentialsDTO;
import lk.creativelabs.jobseekers.entity.UserCredentials;

public interface UserCredentialService {
    UserCredentialsDTO getUserDetails(String username , String password);

    UserCredentialsDTO getUser(String userId);


}

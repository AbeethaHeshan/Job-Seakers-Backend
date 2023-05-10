package lk.creativelabs.jobseekers.service;

import lk.creativelabs.jobseekers.dto.UserCredentialsDTO;

public interface UserCredentialService {
    UserCredentialsDTO getUserDetails(String username , String password);

}

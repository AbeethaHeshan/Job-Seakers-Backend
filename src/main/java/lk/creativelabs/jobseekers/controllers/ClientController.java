package lk.creativelabs.jobseekers.controllers;
import lk.creativelabs.jobseekers.dto.ClientDTO;
import lk.creativelabs.jobseekers.service.ClientService;
import lk.creativelabs.jobseekers.util.ResponseUtil;
import lk.creativelabs.jobseekers.util.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("client")
@CrossOrigin
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping(value = "/createNew",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUtil createNewClient(@RequestBody ClientDTO clientDTO,@RequestHeader String role){

        if(role.equals(UserRole.CLIENT.getAuthority())){
            clientDTO.setRole(UserRole.CLIENT.getAuthority());
            return new ResponseUtil(200,"save_success",clientService.createNewClient(clientDTO));
        }else{
            return new ResponseUtil(400,"user role is not valid",null);
        }
<<<<<<< HEAD
=======

>>>>>>> origin/main
    }

    @PostMapping(value = "/getAll",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public void getAllDetails(){

    }

<<<<<<< HEAD
=======

>>>>>>> origin/main
    @PostMapping(value = "/update",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public void update(){

    }

    @PostMapping(value = "/delete",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public void delete(){

    }


<<<<<<< HEAD
=======

>>>>>>> origin/main
}

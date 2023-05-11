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

    }



    @PostMapping(value ="/getclient" ,produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUtil getEmployeeDetails(@RequestHeader(required = true) String userId,
                                           @RequestHeader(required = true) String role) throws Exception {

        if (role.equals(UserRole.CLIENT.getAuthority())) {
            Object client = clientService.getClient(userId, role);
            if(client instanceof String){
                return new ResponseUtil(200,client.toString(),null);
            } else if (client instanceof ClientDTO) {
                return new ResponseUtil(200,"get_client_success",client);
            }

        }
            return new ResponseUtil(400,"user role is not valid",null);
    }

    @PostMapping(value = "/getAll",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public void getAllDetails(){

    }


    @PostMapping(value = "/update",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public void update(){

    }

    @PostMapping(value = "/delete",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public void delete(){

    }


}

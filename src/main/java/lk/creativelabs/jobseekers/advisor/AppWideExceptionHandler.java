package lk.creativelabs.jobseekers.advisor;



import lk.creativelabs.jobseekers.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestControllerAdvice
@CrossOrigin
public class AppWideExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({Exception.class, SQLException.class})
    public ResponseUtil exceptionHandler(Exception e,SQLException exception) {
        return new ResponseUtil(500, e.getMessage(),exception.getMessage());
    }


}


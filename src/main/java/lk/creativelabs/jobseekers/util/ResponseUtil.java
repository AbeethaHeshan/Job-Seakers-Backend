package lk.creativelabs.jobseekers.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@Data
public class ResponseUtil {
     private int code;
     private String message;
     private Object data;

     public ResponseUtil(int code, String message, Object data) {
          this.code = code;
          this.message = message;
          this.data = data;
     }

     public ResponseUtil() {

     }



}


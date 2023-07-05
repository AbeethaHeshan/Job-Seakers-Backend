package lk.creativelabs.jobseekers.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class FileServer {



    public static void createDrictory(String folderPath){
        File assetsFolder  = new File(folderPath);

        if(!assetsFolder.exists()){
            boolean mkdir = assetsFolder.mkdir();
            if(!mkdir){
                //new Exeption();
            }
        }
    }




    public static String createDrictoryAndSaveFile(String folderPath,MultipartFile file) throws Exception {
        File assetsFolder  = new File(folderPath);

        try {
            if(!assetsFolder.exists()){
                boolean mkdir = assetsFolder.mkdir();
                if(!mkdir){
                    //new Exeption();
                }
            }
            return saveFile(file,folderPath);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }


    public static String saveFile(MultipartFile file,String destinationDirPath) throws Exception {

        try {
            byte[] fileBytes = file.getBytes();
            String randomId = UUID.randomUUID().toString();
            Path filePath = Paths.get(destinationDirPath ,randomId+"-"+file.getOriginalFilename());
            Files.write(filePath, fileBytes);
            return  filePath.toUri().toString(); //toUri().toString()
        } catch (IOException e) {
            throw new Exception(e.getMessage());
        }
    }


}

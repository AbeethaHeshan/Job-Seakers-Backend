package lk.creativelabs.jobseekers.controllers.components;

import lk.creativelabs.jobseekers.service.AdvertiesmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
public class AutoTableActions {

    @Autowired
    AdvertiesmentService advertiesmentService;

    @Scheduled(cron = "0 0 0 * * *") // Runs daily at midnight
    public void deleteRowsByTodayDate() {
        Date today = new Date();
        LocalDate localDate = today.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        advertiesmentService.deleteByDate(localDate);
    }
}

package lk.creativelabs.jobseekers.util;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;


public class UserIdGenerator {
    private static final String PREFIX = "usr";
    private static final AtomicLong counter = new AtomicLong(0);

    public static String generateUserId() {
        long sequentialNumber = counter.incrementAndGet();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 7);
        return PREFIX + uuid + sequentialNumber;
    }


}
package lk.creativelabs.jobseekers.util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import java.io.Serializable;

public class RandomIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        String randomChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int randomIndex = (int) (Math.random() * randomChars.length());
            sb.append(randomChars.charAt(randomIndex));
        }
        return sb;
    }
}
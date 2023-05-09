package lk.creativelabs.jobseekers.util;

public enum UserRole {
    ADMIN,
    EMPLOYEE,
    CLIENT;
    public String getAuthority() {
        return name();
    }
}

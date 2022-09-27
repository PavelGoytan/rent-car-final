package by.hoitan.rent.bean;

import java.util.Objects;

public class User {
    private int id;
    private String emailLogin;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private RoleUser roleUser;
    private StatusUser statusUser;

    private User(UserBuilder userBuilder) {
        this.id = userBuilder.id;
        this.emailLogin = userBuilder.emailLogin;
        this.firstName = userBuilder.firstName;
        this.lastName = userBuilder.lastName;
        this.password = userBuilder.password;
        this.phoneNumber = userBuilder.phoneNumber;
        this.roleUser = userBuilder.roleUser;
        this.statusUser = userBuilder.statusUser;
    }

    public static UserBuilder builder(){
        return new UserBuilder();
    }

    public int getId() {
        return id;
    }

    public String getEmailLogin() {
        return emailLogin;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public RoleUser getRoleUser() {
        return roleUser;
    }

    public StatusUser getStatusUser() {
        return statusUser;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmailLogin(String emailLogin) {
        this.emailLogin = emailLogin;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setRoleUser(RoleUser roleUser) {
        this.roleUser = roleUser;
    }

    public void setStatusUser(StatusUser statusUser) {
        this.statusUser = statusUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", emailLogin='" + emailLogin + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", roleUser=" + roleUser +
                ", statusUser=" + statusUser +
                '}';
    }

    public static class UserBuilder {
        private int id;
        private String emailLogin;
        private String firstName;
        private String lastName;
        private String password;
        private String phoneNumber;
        private RoleUser roleUser;
        private StatusUser statusUser;

        public UserBuilder() {
        }

        public UserBuilder id(int id){
            this.id = id;
            return this;
        }
        public UserBuilder emailLogin (String emailLogin){
            this.emailLogin = emailLogin;
            return this;
        }
        public UserBuilder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }
        public UserBuilder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        public UserBuilder password(String password){
            this.password = password;
            return this;
        }
        public UserBuilder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }
        public UserBuilder roleUser(RoleUser roleUser){
            this.roleUser = roleUser;
            return this;
        }
        public UserBuilder statusUser(StatusUser statusUser){
            this.statusUser = statusUser;
            return this;
        }

        public User build(){
            return  new User(this);
        }

    }
}

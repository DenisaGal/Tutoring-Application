package TA.model;

public class User {

    private String username;
    private String email_address;
    private String phone_number;
    private String password;
    private String role;
    private String subject;

    public User() {
    }

    public User(String username, String email_address, String phone_number, String password, String role) {
        this.username = username;
        this.email_address = email_address;
        this.phone_number = phone_number;
        this.password = password;
        this.role = role;
    }

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSubject(){ return subject;}

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o)
    {
        return (o instanceof User) && ( ((User) o).username.equals(this.username) && ((User) o).password.equals(this.password) && ((User) o).role.equals(this.role));
    }
    /*public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!username.equals(user.username)) return false;
        if (!password.equals(user.password)) return false;
        return role.equals(user.role);
    }*/

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 9 * result + password.hashCode();
        result = 9 * result + role.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

package cybersoft.java18.crm.model;

public class UserModel {
    private int id;
    private String email;
    private String password;
    private String fullName;
    private String avatar;
    private int role_id;

    public UserModel(int id, String email, String password, String fullName, String avatar, int role_id) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.avatar = avatar;
        this.role_id = role_id;
    }

    public UserModel(int id, String fullName, int role_id) {
        this.id = id;
        this.fullName = fullName;
        this.role_id = role_id;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAvatar() {
        return avatar;
    }

    public int getRole_id() {
        return role_id;
    }
}

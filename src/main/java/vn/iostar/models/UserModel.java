package vn.iostar.models;


import java.sql.Date;

public class UserModel {
    private int id;
    private String userName;
    private String email;
    private String password;
    private String fullName;
    private String image;
    private int roleID;
    private String phone;
    private Date createDate;

    public UserModel() {
        super();
    }

    public UserModel(int id, String userName, String email, String password, String fullName, String image, int roleID,
                     String phone, Date createDate) {
        super();
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.image = image;
        this.roleID = roleID;
        this.phone = phone;
        this.createDate = createDate;
    }



    public UserModel(String userName, String email, String password, String fullName, String image, int roleID,
                     String phone, Date createDate) {
        super();
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.image = image;
        this.roleID = roleID;
        this.phone = phone;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public int getRoleID() {
        return roleID;
    }
    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "UserModel [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password
                + ", fullName=" + fullName + ", image=" + image + ", roleID=" + roleID + ", phone=" + phone
                + ", createDate=" + createDate + "]";
    }
}

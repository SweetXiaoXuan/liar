package com.liar.server.user.user.daoBean;

public class User {
    private int id;
    private String username;
    private String mobile;
    private String email;
    private String nickname;
    private String headpic;
    private String createtime;
    private String status;
    private String password;
    private Integer gender;
    private String givename;
    private Integer type;
    private String IDNumber;

    public User() {
    }

    public int getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getHeadpic() {
        return this.headpic;
    }

    public String getCreatetime() {
        return this.createtime;
    }

    public String getStatus() {
        return this.status;
    }

    public String getPassword() {
        return this.password;
    }

    public Integer getGender() {
        return this.gender;
    }

    public String getGivename() {
        return this.givename;
    }

    public Integer getType() {
        return this.type;
    }

    public String getIDNumber() {
        return this.IDNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public void setGivename(String givename) {
        this.givename = givename;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

}

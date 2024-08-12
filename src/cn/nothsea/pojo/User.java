package cn.nothsea.pojo;


import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String address;

    public User() {
    }
    public User(Integer id, String username, String password,String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.address = address;
    }
}
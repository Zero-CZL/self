package cn.nothsea.pojo;

import lombok.Data;

@Data
public class Emp {
    private Integer eid;
    private String ename;
    private String sex;
    private double salary;
    private String hobby;
    private String photo;
    private int object_id;

    public Emp() {

    }
    public Emp(Integer eid, String ename, String sex, double salary,String hobby, String photo, int object_id){
        this.eid = eid;
        this.ename = ename;
        this.sex = sex;
        this.salary = salary;
        this.hobby = hobby;
        this.photo = photo;
        this.object_id = object_id;
    }
}

package com.example.aply3;

public class Student {
    private Integer id;
    private String group_name;
    private String name;

    private String email;
    private String phone;

    public Integer getId() {
        return id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public void setId(Integer id)
    {
          this.id = id;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;                                                                       // a.getId();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString()
    {
        String res;
        res = id.toString()+" ";
        res += group_name+" ";
        res += name+" ";
        res += email+" ";
        return res;
    }
}

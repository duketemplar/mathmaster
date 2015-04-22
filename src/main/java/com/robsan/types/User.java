package com.robsan.types;

import java.util.Date;

/**
 * Created by lordofeverything on 08/02/15.
 */
public class User {

    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String userpwd;
    private Integer cstno;
    private Date create_time;   // Default
    private Date tstamp;        // Default
    private Date dereg_date;
    private String country;
    private Integer status;
    private String status_text;
    private String user_ref;

    public User(){
        //
    }

    public User(String firstname, String lastname, String email, String username,
                String userpwd, Integer cstno, Date create_time, Date tstamp,
                Date dereg_date, String country, Integer status, String status_text,
                String user_ref) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.userpwd = userpwd;
        this.cstno = cstno;
        this.create_time = create_time;
        this.tstamp = tstamp;
        this.dereg_date = dereg_date;
        this.country = country;
        this.status = status;
        this.status_text = status_text;
        this.user_ref = user_ref;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public Integer getCstno() {
        return cstno;
    }

    public void setCstno(Integer cstno) {
        this.cstno = cstno;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getTstamp() {
        return tstamp;
    }

    public void setTstamp(Date tstamp) {
        this.tstamp = tstamp;
    }

    public Date getDereg_date() {
        return dereg_date;
    }

    public void setDereg_date(Date dereg_date) {
        this.dereg_date = dereg_date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatus_text() {
        return status_text;
    }

    public void setStatus_text(String status_text) {
        this.status_text = status_text;
    }

    public String getUser_ref() {
        return user_ref;
    }

    public void setUser_ref(String user_ref) {
        this.user_ref = user_ref;
    }


    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", userpwd='" + userpwd + '\'' +
                ", cstno=" + cstno +
                ", create_time=" + create_time +
                ", tstamp=" + tstamp +
                ", dereg_date=" + dereg_date +
                ", country='" + country + '\'' +
                ", status=" + status +
                ", status_text='" + status_text + '\'' +
                ", user_ref='" + user_ref + '\'' +
                '}';
    }
}

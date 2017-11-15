package com.serlvet.controller.reqdata;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ReqUser {

    @NotNull
    @Size(min = 1, max = 140)
    private String username;
    @NotNull
    @Size(min = 1, max = 140)
    private String password;
    @NotNull
    @Size(min = 1, max = 140)
    private String name;
    @NotNull
    @Size(min = 1, max = 140)
    private String role;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }
}

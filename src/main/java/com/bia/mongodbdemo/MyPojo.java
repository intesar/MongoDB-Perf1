/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.mongodbdemo;

/**
 *
 * @author intesar
 */
public class MyPojo {

    private String name;
    private String email;
    
    public MyPojo(){}
    
    public MyPojo(String n, String e){
        name = n;
        email = e;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MyPojo other = (MyPojo) obj;
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (this.email != null ? this.email.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "MyPojo{" + "name=" + name + ", email=" + email + '}';
    }
}

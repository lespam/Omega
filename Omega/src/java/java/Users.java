/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java;

import java.util.ArrayList;

/**
 *
 * @author LesPam
 */
public class Users {
    public static ArrayList<String> username, password;
    

    public Users() {
        username = new ArrayList<String>();
        password = new ArrayList<String>();
        
        username.add("admin");
        password.add("admin");
        
        
    }
    
    public void addUser(String username, String password) {
        this.username.add(username);
        this.password.add(password);
        
    }
    
    public int searchUser(String username)
    {
        return this.username.indexOf(username);
    }

    @Override
    public String toString() {
        return "Users{" +username.toString()+ '}';
    }
    
    
    
}

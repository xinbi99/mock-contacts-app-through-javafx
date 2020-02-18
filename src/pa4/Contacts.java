/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa4;

/**
 *
 * @author bixin
 */
public class Contacts {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String image;
    public Contacts(String fn, String ln, String em, String ph, String add, String im){
        this.firstName = fn;
        this.lastName = ln;
        this.email = em;
        this.phone = ph;
        this.address = add;
        this.image = im;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setImage(String image){
        this.image = image;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getFullName(){
        return firstName + " " + lastName;
    }
    public String getEmail(){
        return email;
    }
    public String getPhone(){
        return phone;
    }
    public String getAddress(){
        return address;
    }
    public String getImage(){
        return image;
    }
    @Override
    public String toString(){
        return getFullName();
    }
}



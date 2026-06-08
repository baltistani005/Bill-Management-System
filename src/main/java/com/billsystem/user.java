
package com.billsystem;


public abstract class user {
    protected final String userid;
    protected String name;
    protected String password;
    //CONSTRUCTOR
    public user(String id,String name,String password){
        this.userid=id;
        this.name=name;
        this.password=password;
    }
    // LOGIN METHOD
        public boolean login(String enteredPassword){
        return this.password.equals(enteredPassword);
}
    //ABSTRACT METHOD
    public abstract void displayinfo();
    //SETTER
    public void setName(String name){
        this.name=name;
    }
    //GETTERS
    public String getId(){
        return this.userid;
    }
    public String getName(){
        return this.name;
    }
    @Override
    public String toString(){
        return "UserId: "+this.userid+"  | Name: "+this.name;
    }
    public boolean Login(String enteredPassword){
    return this.password.equals(enteredPassword);
}
}

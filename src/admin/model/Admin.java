package admin.model;

public class Admin {

    private int id;
    private String user;
    private String password;

    public Admin (int id, String user, String password) {
        this.id = id;
        this.user = user;
        this.password = password;
    }

    public Admin(String text){
        String[] tokens = text.split(",");
        this.id = Integer.parseInt(tokens[0]);
        this.user = tokens[1];
        this.password = tokens[2];
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getUser() {return user;}
    public void setUser(String user) {this.user = user;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

}

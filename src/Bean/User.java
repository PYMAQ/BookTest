package Bean;

/**
 * @Author: ym
 * @Date: 2019/3/2 21:45
 * @Version 1.0
 */
public class User {
    public int id;
    public  String name;
    public String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public User() {}
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package d250616.dto;

public class _10Member {
    private int id;
    private String name;
    private String email;
    private String password;
    private String reg_date;

    public _10Member(int id, String name, String email, String password, String reg_date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.reg_date = reg_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    @Override
    public String toString() {
        return "_10Member [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", reg_date="
                + reg_date + "]";
    }

}

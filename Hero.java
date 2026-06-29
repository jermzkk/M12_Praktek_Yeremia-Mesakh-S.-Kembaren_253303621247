public class Hero {

    private int id;
    private String nama;
    private String role;
    private int level;

    public Hero() {

    }

    public Hero(int id, String nama, String role, int level) {
        this.id = id;
        this.nama = nama;
        this.role = role;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
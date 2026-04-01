package vcube.Model;

public class Attendance {

    private int id;
    private String username;
    private String subject;
    private int present;
    private int total;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public int getPresent() { return present; }
    public void setPresent(int present) { this.present = present; }

    public int getTotal() { return total; }
    public void setTotal(int total) { this.total = total; }

    public int getPercentage() {
        if (total == 0) return 0;
        return (present * 100) / total;
    }
}

package data.models;

import java.util.ArrayList;
import java.util.List;

public class Diary {
    private String username;
    private String password;
    private int id;
    List<Entry> entries = new ArrayList<>();

    public List<Entry> getEntries() {
        return entries;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLocked() {
        return isLocked;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", entries=" + entries +
                ", isLocked=" + isLocked +
                '}';
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    private boolean isLocked;
}

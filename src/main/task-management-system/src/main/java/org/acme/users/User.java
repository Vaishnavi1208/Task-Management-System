package org.acme.users;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

import org.acme.task.Task;
import org.acme.comments.Comment;

@Entity
@Table(name = "users", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;

    private String password;

    @OneToMany(mappedBy = "creator")
    private List<Task> createdTasks = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "assignees")
    private Set<Task> assignedTasks = new HashSet<>();

    @OneToMany(mappedBy = "author")
    private List<Comment> comments = new ArrayList<>();

    // Constructors
    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

}

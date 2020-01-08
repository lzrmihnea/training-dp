package eu.training.dp.composite;

import java.util.Objects;

public class User {

    private Long id;
    private Long hierarchicalLevel;
    private Long teamId;

    public User() {
    }

    public User(Long id, Long hierarchicalLevel, Long teamId) {
        this.id = id;
        this.hierarchicalLevel = hierarchicalLevel;
        this.teamId = teamId;
    }

    public Long getId() {
        return id;
    }

    public Long getHierarchicalLevel() {
        return hierarchicalLevel;
    }

    public Long getTeamId() {
        return teamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", hierarchicalLevel=" + hierarchicalLevel +
                ", teamId=" + teamId +
                '}';
    }
}

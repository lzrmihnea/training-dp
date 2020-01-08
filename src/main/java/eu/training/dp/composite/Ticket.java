package eu.training.dp.composite;

import java.util.Objects;

public class Ticket {

    private Long id;
    private User createdBy;
    private User assignedTo;
    private PrivacyLevel privacy;

    public Ticket() {
    }

    public Ticket(Long id,
                  User createdBy, User assignedTo,
                  PrivacyLevel privacy) {
        this.id = id;
        this.createdBy = createdBy;
        this.assignedTo = assignedTo;
        this.privacy = privacy;
    }

    public Long getId() {
        return id;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public PrivacyLevel getPrivacy() {
        return privacy;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", createdBy=" + createdBy +
                ", assignedTo=" + assignedTo +
                ", privacy=" + privacy +
                '}';
    }
}

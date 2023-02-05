package ca.owenpeterson.web.api.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "server_status")
public class ServerStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

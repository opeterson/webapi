package ca.owenpeterson.web.api.domain;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "server_status")
public class ServerStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "startUpTime")
    private LocalDateTime startUpTime;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getStartUpTime() {
        return startUpTime;
    }

    public void setStartUpTime(LocalDateTime startUpTime) {
        this.startUpTime = startUpTime;
    }
}

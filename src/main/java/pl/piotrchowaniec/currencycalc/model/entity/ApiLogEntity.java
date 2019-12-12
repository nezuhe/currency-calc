package pl.piotrchowaniec.currencycalc.model.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "api_logs")
@Data
public class ApiLogEntity {

    @Id
    @GeneratedValue
    private int id;

    private String api;

    @Column(name = "http_method")
    private String httpMethod;

    private String url;

    @Column(name = "calling_time")
    @CreationTimestamp
    private LocalDateTime callingTime;
}

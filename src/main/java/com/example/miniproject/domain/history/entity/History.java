package com.example.miniproject.domain.history.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "WIFI_HISTORY")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String latitude;
    private String longitude;

    @Column(name = "search_date")
    private LocalDateTime searchDate;

    @Column(name = "create_date")
    private LocalDateTime createDate;
    @Column(name = "create_by")
    private String createBy;
    @Column(name = "update_date")
    private LocalDateTime updateDate;
    @Column(name = "update_by")
    private String updateBy;

}

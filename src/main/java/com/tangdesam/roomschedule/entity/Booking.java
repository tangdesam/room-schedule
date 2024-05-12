package com.tangdesam.roomschedule.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Data
@Entity
public class Booking {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;

    @NotEmpty
    private String meetingTopic;

    @NotEmpty
    private String pic;

    @NotNull
    private LocalDateTime startTime;

    private LocalDateTime endTime;

}

package com.tangdesam.roomschedule.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
public class Room {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotEmpty
    @Column(unique = true)
    private String name;

    @Min(value = 2)
    private int capacity;
}

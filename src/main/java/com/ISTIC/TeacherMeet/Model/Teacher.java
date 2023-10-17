package com.ISTIC.TeacherMeet.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Teacher implements Serializable {


    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(updatable = false,nullable = false)
    private long id;

    @Column(updatable = false,nullable = false)
    @Setter
    private String name;

    @Setter
    private String email;

    @Setter
    @OneToMany(mappedBy = "teacher",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Timeslot> meets = new ArrayList<Timeslot>();
}

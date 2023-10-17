package com.ISTIC.TeacherMeet.Repository;

import com.ISTIC.TeacherMeet.Model.Teacher;
import com.ISTIC.TeacherMeet.Model.Timeslot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher,Long> {
}

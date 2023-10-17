package com.ISTIC.TeacherMeet.Services;

import com.ISTIC.TeacherMeet.Model.Student;
import com.ISTIC.TeacherMeet.Model.Teacher;
import com.ISTIC.TeacherMeet.Model.Timeslot;
import com.ISTIC.TeacherMeet.Repository.StudentRepo;
import com.ISTIC.TeacherMeet.Repository.TeacherMeetRepository;
import com.ISTIC.TeacherMeet.Repository.TeacherRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherMeetService {

    private final TeacherMeetRepository teacherMeetRepository;
    private final StudentRepo studentRepo;
    private final TeacherRepo teacherRepo;

    @Autowired
    public TeacherMeetService(TeacherMeetRepository teacherMeetRepository, TeacherRepo teacherRepo, StudentRepo studentRepo)
    {
        this.teacherMeetRepository = teacherMeetRepository;
        this.teacherRepo = teacherRepo;
        this.studentRepo = studentRepo;
    }

   public Timeslot bookAMeet(Long idTeacher, Long idStudent, Timeslot timeslot){

        Teacher teacher = this.teacherRepo.getReferenceById(idTeacher);
        Student student = this.studentRepo.getReferenceById(idStudent);


            timeslot.setAvailable(false);
            teacher.getMeets().add(timeslot);
            student.getMeetsTaken().add(timeslot);
            this.teacherMeetRepository.save(timeslot);
            this.teacherRepo.save(teacher);
            this.studentRepo.save(student);
        return timeslot;
   }

    public void cancelAMeet(Long Id){
        Optional<Timeslot> timeslot =  this.teacherMeetRepository.findById(Id);
        if(timeslot.isPresent()){
            Timeslot saveGetCall = timeslot.get();
            /*saveGetCall.setAvailable(true);
            saveGetCall.getTeacher().getMeets().remove(saveGetCall);
            saveGetCall.getStudent().getMeetsTaken().remove(saveGetCall);*/
            this.teacherMeetRepository.deleteById(Id);
        }
    }

    public List<Timeslot> findAllMeet(){
        return this.teacherMeetRepository.findAll();
    }

    public boolean addStudent(Student student){
        if(!this.studentRepo.existsById(student.getId())){
            this.studentRepo.save(student);
            return true;
        }
       return false;
    }

    public void deleteStudent(Long Id){
        if(this.studentRepo.existsById(Id)){
            this.studentRepo.deleteById(Id);
        }
    }

    public List<Student> findAllStudent(){
        return this.studentRepo.findAll();
    }

    public boolean addTeacher(Teacher teacher){
        if(!this.teacherRepo.existsById(teacher.getId())){
            this.teacherRepo.save(teacher);
            return true;
        }
        return false;
    }

    public void deleteTeacher(Long Id){
        if(this.teacherRepo.existsById(Id)){
            this.teacherRepo.deleteById(Id);
        }
    }

    public List<Teacher> findAllTeacher(){
        return this.teacherRepo.findAll();
    }
}

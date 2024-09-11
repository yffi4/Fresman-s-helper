package kz.kuleshov.restSpring.services.impl;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import kz.kuleshov.restSpring.dtos.StudentDTO;
import kz.kuleshov.restSpring.entities.Student;
import kz.kuleshov.restSpring.mapper.StudentMapper;
import kz.kuleshov.restSpring.repositories.StudentRepository;
import kz.kuleshov.restSpring.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public List<StudentDTO> getAllStudents() {
        return studentMapper.mapToDTOList(studentRepository.findAll());

    }

    @Override
    public StudentDTO getStudentById(Long id) {
        return studentMapper.mapToDTO(studentRepository.findAllById(id));
    }

    @Override
    public void updateStudent(StudentDTO updStudent) {
        Student checkStudent = studentRepository.findAllById(updStudent.getId());
        Student student = studentMapper.maptoEntity(updStudent);
        student.setPromocode(checkStudent.getPromocode());
        studentRepository.save(student);

    }

    @Override
    public void addStudent(StudentDTO studentDTO) {
        Student checkStudent = studentRepository.findAllByEmail(studentDTO.getEmail());
        if(checkStudent == null){
            Student student = studentMapper.mapToEntity(studentDTO);
            student.setPromocode(UUID.randomUUID().toString());
            studentRepository.save(student);
            sendVerificationEmail(student.getEmail(),student.getPromocode(),student.getName(), student.getSurname(),student.getUniversity().getName());
        }
    }

    @Override
    public void delStudent(Long id) {
        studentRepository.deleteById(id);
    }
    private void sendVerificationEmail(String to, String promocode,String name,String surname, String uniName) {
        String subject = "Your Promocode from " + uniName;
        String text = "Dear " + name + " " + surname + " Thank you for choosing our university. Your promocode is: " + promocode;

        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);

            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

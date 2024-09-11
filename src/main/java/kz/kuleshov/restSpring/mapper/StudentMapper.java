package kz.kuleshov.restSpring.mapper;

import kz.kuleshov.restSpring.dtos.StudentDTO;
import kz.kuleshov.restSpring.entities.Student;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDTO mapToDTO(Student student);
    Student maptoEntity(StudentDTO studentDTO);
    List<StudentDTO> mapToDTOList(List<Student> students);


    Student mapToEntity(StudentDTO studentDTO);
}

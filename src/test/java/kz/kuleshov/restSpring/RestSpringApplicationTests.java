package kz.kuleshov.restSpring;

import kz.kuleshov.restSpring.entities.Faculty;
import kz.kuleshov.restSpring.entities.Subject;
import kz.kuleshov.restSpring.repositories.SubjectRepository;
import kz.kuleshov.restSpring.services.SubjectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class RestSpringApplicationTests {
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private SubjectRepository subjectRepository;
	@Test
	void contextLoads() {
	}
	@Test
	void getAllSubjectsTest(){
		List<Subject> subjects = subjectService.getAllSubjects();
		Assertions.assertNotNull(subjects);
		List<Subject> subjectsJB = subjectRepository.findAll();
		Assertions.assertEquals(subjects.size(), subjectsJB.size());
		for (int i = 0; i < subjects.size(); i++){
			Assertions.assertEquals(subjects.get(i).getId(), subjectsJB.get(i).getId());
		}
	}
	@Test
	void addSubjectTest(){
		Subject subject = new Subject();
		subject.setName("Chemistry");
		subject.setCode("CH789");
		subject.setEcts(4);



		Subject initialSubject = subjectService.addSubject(subject);
		List<Subject> subjects = subjectRepository.findAll();
		Subject subjectFinal = subjects.get(0);
		Assertions.assertEquals(initialSubject.getId(),subjectFinal.getId());
		Assertions.assertEquals(initialSubject.getName(),subjectFinal.getName());
		Assertions.assertEquals(initialSubject.getCode(),subjectFinal.getCode());
	}

}

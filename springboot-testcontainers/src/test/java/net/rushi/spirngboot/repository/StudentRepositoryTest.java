package net.rushi.spirngboot.repository;

import net.rushi.spirngboot.AbstractContainerBaseTest;
import net.rushi.spirngboot.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentRepositoryTest extends AbstractContainerBaseTest {

    @Autowired
    private StudentRepository studentRepository;

    // JUnit for save student operation - BDD style
    @Test
    public void givenStudentObject_whenSave_thenReturnSavedStudent(){

        // given - setup or precondition
        Student student = Student.builder().firstName("Rushikesh")
                .lastName("Bawkar").email("rkbawkar@mitaoe.ac.in").build();

        // when - action or the testing
        Student savedStudent = studentRepository.save(student);

        // then - very output
        Assertions.assertNotNull(savedStudent);
        Assertions.assertNotNull(savedStudent.getId());

    }

    // JUnit for save student operation - BDD style
    @Test
    public void givenStudentId_whenfindbyId_thenReturnSavedStudent(){

        // given - setup or precondition
        Student student = Student.builder().firstName("Rushikesh")
                .lastName("Bawkar").email("rkbawkar@mitaoe.ac.in").build();
        Student savedStudent = studentRepository.save(student);

        // when - action or the testing
        Student studentDB = studentRepository.findById(student.getId()).get();

        // then - very output
        Assertions.assertNotNull(studentDB);
    }

}
package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.dto.CourseDto;
import com.example.demo.entity.Course;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CourseServiceTest {
	

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseServiceImpl courseServiceImpl;
    
 
    private Course course;

    @BeforeEach
    public void setup(){
       
       course = Course.builder().courseId(Long.valueOf(1))
                .courseName("demo").courseHours(25)
                .build();
    }

    // JUnit test for savee method
    @DisplayName("JUnit test for save course")
    @Test
    public void saveCourseTest(){
        // given - precondition or setup
//        given(courseRepository.findById(course.getCourseId()))
//                .willReturn(Optional.empty());

        given(courseRepository.save(course)).willReturn(course);

//        System.out.println(courseRepository);
//        System.out.println(courseServiceImpl);

        // when -  action or the behaviour that we are going test
        CourseDto courseDto=CourseMapper.mapToCourseDto(course);
        CourseDto course = courseServiceImpl.saveCourse(courseDto);
        

        System.out.println(courseDto);
        // then - verify the output
        assertThat(courseDto).isNotNull();
    }
    



  
    @DisplayName("JUnit test for getAllcourses method")
    @Test
    public void getAllCoursesTest(){
        // given - precondition or setup
    	Course  course1 = Course.builder().courseId(Long.valueOf(1))
                  .courseName("demo").courseHours(25)
                  .build();

        
        given(courseRepository.findAll()).willReturn(List.of(course,course1));

        // when -  action or the behaviour that we are going test
        List<CourseDto> courseList = courseServiceImpl.getAllCourses();

        // then - verify the output
        assertThat(courseList).isNotNull();
        assertThat(courseList.size()).isEqualTo(2);
    }

    
    @DisplayName("JUnit test for getEmployeeById method")
    @Test
    public void getCourseById(){
        // given
        given(courseRepository.findById(1L)).willReturn(Optional.of(course));

        // when
      CourseDto courseDto = courseServiceImpl.getCourseById(course.getCourseId());

        // then
        assertThat(courseDto).isNotNull();

    }
    
    
    

	
	
	
	

}

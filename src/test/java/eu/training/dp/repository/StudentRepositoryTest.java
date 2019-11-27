package eu.training.dp.repository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;

public class StudentRepositoryTest {

    private StudentRepository studentRepository;

    @Mock
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.studentRepository = new StudentRepository(jdbcTemplate);
    }

    @Test
    public void findAllDivisionsBySource_expectedQueryRan() {
        Integer divisionsBySource = studentRepository.findAllDivisionsBySource("smallLink", 101L, 51L);

        Mockito.verify(jdbcTemplate.queryForObject(
                ArgumentMatchers.eq("asd"),
                ArgumentMatchers.eq(new HashMap<>()),
                ArgumentMatchers.eq(Integer.class)));
    }

    @Test
    public void findAllDivisionsBySource_expectedMethodCalledOnce() {
        Integer divisionsBySource = studentRepository.findAllDivisionsBySource("smallLink", 101L, 51L);

        Mockito.verify(jdbcTemplate, Mockito.times(1)).queryForObject(
                ArgumentMatchers.anyString(),
                ArgumentMatchers.anyMap(),
                ArgumentMatchers.any(Class.class));
    }

}
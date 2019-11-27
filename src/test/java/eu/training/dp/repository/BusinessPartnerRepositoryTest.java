package eu.training.dp.repository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.Map;

public class BusinessPartnerRepositoryTest {

    private static final String QUERY_SOLID_STR = "SELECT BP.ACTIVE_FLAG as activeFlag, BP.BP_TYPE_ID as typeId, ifnull(BP.description, 'default description' ) FROM BP BP WHERE BP.LAST_NAME = :lastName WHERE BP.FIRST_NAME = :firstName ORDER BY BP.LAST_NAME ASC LIMIT 1000";
    private static final String QUERY_ORACLE_STR = "SELECT BP.ACTIVE_FLAG as activeFlag, BP.BP_TYPE_ID as typeId, nvl(BP.description, 'default description' )FROM BP BP WHERE BP.LAST_NAME = :lastName WHERE BP.FIRST_NAME = :firstName ORDER BY BP.LAST_NAME ASC OFFSET 0 ROWS FETCH NEXT 1000 ROWS ONLY";

    private static final String QUERY_MAP_ARG_LAST_NAME = "Popescu";
    private static final String QUERY_MAP_ARG_FIRST_NAME = "Ionut";

    private BusinessPartnerRepository businessPartnerRepository;

    @Mock
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Mock
    private DbTypeRepository dbTypeRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.businessPartnerRepository = new BusinessPartnerRepository(jdbcTemplate);
    }

    @Test
    public void findBusinessPartnerInfoFor_expectedSolidQueryRan() {
        businessPartnerRepository.findBusinessPartnerInfoFor(QUERY_MAP_ARG_LAST_NAME, QUERY_MAP_ARG_FIRST_NAME);

        Mockito.verify(jdbcTemplate, Mockito.atMostOnce()).queryForObject(
                ArgumentMatchers.eq(QUERY_SOLID_STR),
                ArgumentMatchers.eq(getExpectedParameters()),
                ArgumentMatchers.eq(Integer.class));
    }

    @Test
    public void findBusinessPartnerInfoFor_expectedMethodCalledOnce() {
        businessPartnerRepository.findBusinessPartnerInfoFor("Ionut", "Popescu");

        Mockito.verify(jdbcTemplate, Mockito.times(1)).queryForObject(
                ArgumentMatchers.anyString(),
                ArgumentMatchers.anyMap(),
                ArgumentMatchers.any(Class.class));
    }

//        @Test
    public void findBusinessPartnerInfoFor_expectedOracleQueryRan() {
        businessPartnerRepository.findBusinessPartnerInfoFor(QUERY_MAP_ARG_LAST_NAME, QUERY_MAP_ARG_FIRST_NAME);

        Mockito.verify(jdbcTemplate, Mockito.atMostOnce()).queryForObject(
                ArgumentMatchers.eq(QUERY_ORACLE_STR),
                ArgumentMatchers.eq(getExpectedParameters()),
                ArgumentMatchers.eq(Integer.class));
    }

    private Map<String, Object> getExpectedParameters() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("lastName", QUERY_MAP_ARG_LAST_NAME);
        parameters.put("firstName", QUERY_MAP_ARG_FIRST_NAME);
        return parameters;
    }

}
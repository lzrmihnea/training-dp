package eu.training.dp.s01_native_queries_multi_dbs.repository;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BusinessPartnerRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public BusinessPartnerRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // FIXME: Native query that needs to work for both SOLID AND ORACLE DBs
    public Integer findBusinessPartnerInfoFor(String lastname, String firstname) {
        StringBuilder query = new StringBuilder();

        query.append("SELECT BP.ACTIVE_FLAG as activeFlag, BP.BP_TYPE_ID as typeId, ");
        query.append("ifnull(BP.description, 'default description' ) ");
        query.append("FROM BP BP WHERE BP.LAST_NAME = :lastName ");
        query.append("WHERE BP.FIRST_NAME = :firstName ");
        query.append("ORDER BY BP.LAST_NAME ASC LIMIT 1000");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("lastName", lastname);
        parameters.put("firstName", firstname);

        return jdbcTemplate.queryForObject(query.toString(), parameters, Integer.class);
    }
}

package eu.training.dp.repository;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public StudentRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer findAllDivisionsBySource(String linkType, Long linkId, Long userId) {
        Map<String, Object> parameters = new HashMap<>();
        String query = " IF '*' = (SELECT TOP 1 ur.link_id FROM user_right ur" +
                "                       WHERE ur.link_type = :linkType" +
                "                       AND ur.allowed = 1" +
                "                       AND ur.user_id = :userId" +
                "                       ORDER BY ur.link_id ASC" +
                "                       )" +
                "                           SELECT  CASE  count(*)" +
                "                                    WHEN  1 THEN 0" +
                "                                    ELSE 1" +
                "                                    END " +
                "                           FROM user_right ur" +
                "                           WHERE ur.link_type = :linkType" +
                "                           AND ur.allowed = 0" +
                "                           AND ur.user_id = :userId" +
                "                           AND ur.link_id = :linkId" +
                "                           AND ur.rights = '*'" +
                "           ELSE" +
                "                SELECT count(*) FROM user_right ur" +
                "                WHERE ur.link_type = :linkType" +
                "                AND ur.allowed = 1" +
                "                AND ur.user_id = :userId" +
                "                AND ur.link_id = :linkId";

        parameters.put("linkType", linkType);
        parameters.put("linkId", linkId);
        parameters.put("userId", userId);
        return jdbcTemplate.queryForObject(query, parameters, Integer.class);
    }
}

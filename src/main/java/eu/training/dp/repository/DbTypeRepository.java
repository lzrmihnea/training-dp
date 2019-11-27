package eu.training.dp.repository;

import eu.training.dp.common.DbType;
import org.springframework.stereotype.Repository;

import static eu.training.dp.common.DbType.ORACLE;
import static eu.training.dp.common.DbType.SOLID;
import static java.lang.Math.random;

@Repository
public class DbTypeRepository {

    public DbType getDbType() {
        if (random() > 0.5d) {
            return ORACLE;
        }
        return SOLID;
    }
}

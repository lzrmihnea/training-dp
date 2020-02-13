package eu.training.dp.s01_native_queries_multi_dbs.repository;

import eu.training.dp.s01_native_queries_multi_dbs.common.DbType;
import org.springframework.stereotype.Repository;

import static eu.training.dp.s01_native_queries_multi_dbs.common.DbType.ORACLE;
import static eu.training.dp.s01_native_queries_multi_dbs.common.DbType.SOLID;
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

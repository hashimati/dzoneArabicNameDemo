package io.hashimati.dzone.repositories;

import io.hashimati.dzone.domains.ArabicName;
import java.util.*;
import io.micronaut.data.annotation.*;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.model.*;
import io.micronaut.data.repository.CrudRepository;


@Repository
@JdbcRepository(dialect = Dialect.H2)
public interface ArabicNameRepository extends CrudRepository<ArabicName, Long> {

    public Optional<ArabicName> findByName(String name);

    public Iterable<ArabicName> findAllByLetter(String letter);

    public Optional<ArabicName> findByNativeArabic(String nativeArabic);

}


package io.alfredux.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.alfredux.domain.entity.CsvData;

@Repository
public interface CsvDataRepository extends JpaRepository<CsvData, Long> {

}

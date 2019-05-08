package com.natanael.wallethub;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineaArchivoRepository extends CrudRepository<LineaArchivo, Long> {

}

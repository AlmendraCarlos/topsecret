package com.meli.topSecret.repository;

import com.meli.topSecret.domain.Satellites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SatellitesRepository extends JpaRepository<Satellites, Long> {

    Satellites findByName(String name);

}

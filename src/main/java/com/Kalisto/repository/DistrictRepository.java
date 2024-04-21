package com.Kalisto.repository;

import com.Kalisto.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository  extends JpaRepository<District, Long> {


    @Query("SELECT d FROM District d WHERE d.state.id = ?1")
    List<District> getDistrictsByState(Long stateId);

}

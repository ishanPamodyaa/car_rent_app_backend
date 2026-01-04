package edu.icet.repository;

import edu.icet.entity.BookACarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface BookACarRepository extends JpaRepository<BookACarEntity, Long> {
    List<BookACarEntity> findByUserId(Long userid);

    @Query("SELECT b FROM BookACarEntity b WHERE " +
            "b.car.id = :carId AND " +
            "b.fromDate <= :endDate AND " +
            "b.toDate >= :startDate")
    List<BookACarEntity> findByCarIdAndDateRange(
            @Param("carId") Long carId,
            @Param("startDate") Date startDate,
            @Param("endDate") java.util.Date endDate);

}
package com.batuhan.staffsale.app.repository;

import com.batuhan.staffsale.app.model.entity.Ad;
import com.batuhan.staffsale.app.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {
}

package com.gainandshain.Job.Application.Review;

import com.gainandshain.Job.Application.Company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {

    List<Review> findByCompanyCompanyId(Long companyId);
}

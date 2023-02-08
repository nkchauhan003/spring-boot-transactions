package com.codeburps.repository;

import com.codeburps.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Transactional
    @Modifying
    @Query("update User u set u.walletAmount = :walletAmount where u.userId = :userId")
    int updateWalletAmount(@Param("userId") int userId, @Param("walletAmount") double walletAmount);
}

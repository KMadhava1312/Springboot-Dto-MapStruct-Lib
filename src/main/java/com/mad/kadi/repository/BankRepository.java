package com.mad.kadi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mad.kadi.entity.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {

}

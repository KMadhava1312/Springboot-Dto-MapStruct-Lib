package com.mad.kadi.service;

import java.util.List;

import com.mad.kadi.dto.BankDto;

public interface BankService {

	BankDto createBank(BankDto bankDto);

	BankDto getByBankId(Long bankId);

	List<BankDto> getAllBankDetails();

	BankDto updateBank(BankDto bankDto);

	String deleteByBankId(Long bankId);

}

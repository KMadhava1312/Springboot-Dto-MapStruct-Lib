package com.mad.kadi.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mad.kadi.dto.BankDto;
import com.mad.kadi.entity.Bank;
import com.mad.kadi.mapper.BankMapper;
import com.mad.kadi.repository.BankRepository;
import com.mad.kadi.service.BankService;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private BankRepository bankRepository;

	@Autowired
	private BankMapper bankMapper;

	@Override
	public BankDto createBank(BankDto bankDto) {
		Bank bank = bankMapper.mapToBank(bankDto);
		Bank savedBank = bankRepository.save(bank);
		return bankMapper.mapToBankDto(savedBank);
	}

	@Override
	public BankDto getByBankId(Long bankId) {
		Bank bank = bankRepository.findById(bankId).orElse(null);
		return bankMapper.mapToBankDto(bank);
	}

	// Note 1.get All records from Db 2.convert into stream 3.map function will
	// convert each bank obj into BankDto 4. then collect the list
	@Override
	public List<BankDto> getAllBankDetails() {
		return bankRepository.findAll().stream().map((bank -> bankMapper.mapToBankDto(bank)))
				.collect(Collectors.toList());
	}

	@Override
	public BankDto updateBank(BankDto bankDto) {
		Bank existingData = bankRepository.findById(bankDto.getBankId()).orElse(null);
		existingData.setBankName(bankDto.getBankName());
		existingData.setIfscCode(bankDto.getIfscCode());
		existingData.setAddress(bankDto.getAddress());
		Bank updatedBank = bankRepository.save(existingData);
		return bankMapper.mapToBankDto(updatedBank);
	}

	@Override
	public String deleteByBankId(Long bankId) {
		if (bankRepository.existsById(bankId)) {
			bankRepository.deleteById(bankId);
			return "Bank with id " + bankId + " deleted successfully..";
		} else {
			return "Bank with id " + bankId + " not found..";
		}
	}

}

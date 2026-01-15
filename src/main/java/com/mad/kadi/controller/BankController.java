package com.mad.kadi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mad.kadi.dto.BankDto;
import com.mad.kadi.service.BankService;

@RestController
@RequestMapping("/api/bank")
public class BankController {

	@Autowired
	private BankService bankService;

	@PostMapping("/create")
	public ResponseEntity<BankDto> createBank(@RequestBody BankDto bankDto) {
		BankDto dto = bankService.createBank(bankDto);
		return new ResponseEntity<BankDto>(dto, HttpStatus.CREATED);
	}

	@GetMapping("/{bankId}")
	public ResponseEntity<BankDto> getByBankId(@PathVariable Long bankId) {
		return new ResponseEntity<BankDto>(bankService.getByBankId(bankId), HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<BankDto>> getByBankId() {
		return new ResponseEntity<List<BankDto>>(bankService.getAllBankDetails(), HttpStatus.OK);
	}

	@PutMapping("/update/{bankId}")
	public ResponseEntity<BankDto> updateBank(@PathVariable Long bankId, @RequestBody BankDto bankDto) {
		bankDto.setBankId(bankId);
		BankDto dto = bankService.updateBank(bankDto);
		return new ResponseEntity<BankDto>(dto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{bankId}")
	public ResponseEntity<String> deleteBank(@PathVariable Long bankId) {
		String result = bankService.deleteByBankId(bankId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}

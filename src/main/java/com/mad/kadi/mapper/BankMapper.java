package com.mad.kadi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mad.kadi.dto.BankDto;
import com.mad.kadi.entity.Bank;

@Mapper(componentModel = "spring")
public interface BankMapper {

	BankMapper MAPPER = Mappers.getMapper(BankMapper.class);

	BankDto mapToBankDto(Bank bank);

	Bank mapToBank(BankDto bankDto);

}

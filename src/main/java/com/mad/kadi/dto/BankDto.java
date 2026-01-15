package com.mad.kadi.dto;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankDto {
	private Long bankId;
	private String bankName;
	private String ifscCode;
	private String address;

	public BankDto() {
	}

	public BankDto(Long bankId, String bankName, String ifscCode, String address) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.ifscCode = ifscCode;
		this.address = address;
	}

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, bankId, bankName, ifscCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankDto other = (BankDto) obj;
		return Objects.equals(address, other.address) && Objects.equals(bankId, other.bankId)
				&& Objects.equals(bankName, other.bankName) && Objects.equals(ifscCode, other.ifscCode);
	}

	@Override
	public String toString() {
		return "BankDto [bankId=" + bankId + ", bankName=" + bankName + ", ifscCode=" + ifscCode + ", address="
				+ address + "]";
	}

}

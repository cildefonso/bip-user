package com.bip.api.domain.model;

import java.io.Serializable;
//import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

//import com.bip.api.enums.PerfilEnum;

@Document(collection = "masters")
public class Master implements Serializable {
	
	

	private static final long serialVersionUID = -781026381777088238L;
	@org.springframework.data.annotation.Id
	private ObjectId _id;
	private String fullname; 
	private String cpf;
	private String complementAddress;
	private String numberAddress;
	
	public ObjectId get_id() {
		return _id;
	}
	
	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getComplementAddress() {
		return complementAddress;
	}

	public void setComplementAddress(String complementAddress) {
		this.complementAddress = complementAddress;
	}

	public String getNumberAddress() {
		return numberAddress;
	}

	public void setNumberAddress(String numberAddress) {
		this.numberAddress = numberAddress;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Master [_id=" + _id + ", fullname=" + fullname + ", cpf=" + cpf + ", complementAddress="
				+ complementAddress + ", numberAddress=" + numberAddress + "]";
	}

		
}

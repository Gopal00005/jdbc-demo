package com.cygnet.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer {

	private int id;
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;

}

/**
 * 
 */
package com.medilab.preclinic.bean;

import java.io.Serializable;

import lombok.Data;

/**
 * @author nsanda
 *
 */
@Data
public class DoctorBean extends AddressBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1839672696590120994L;
	private int doctId;
	private String fname;
	private String lname;
	private String userId;
	private String email;
	private String password;
	private String cpassword;
	private String dob;
	private String gender;
	private String status;
	private String phone;

}

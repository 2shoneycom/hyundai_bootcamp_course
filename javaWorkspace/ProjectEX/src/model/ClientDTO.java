package model;

public class ClientDTO {
	private String clientNo;
	private String clientName;
	private String clientPhone;
	private String clientAddress;
	private String clientBirth;
	private String clientHobby;
	private String clientGender;
	private String clientPassword;

	public ClientDTO() {

	}

	public ClientDTO(String clientNo, String clientName, String clientPassword, String clientPhone,
			String clientAddress, String clientBirth, String clientHobby, String clientGender) {
		this.clientNo = clientNo;
		this.clientName = clientName;
		this.clientPassword = clientPassword;
		this.clientPhone = clientPhone;
		this.clientAddress = clientAddress;
		this.clientHobby = clientHobby;
		this.clientGender = clientGender;
		this.clientBirth = clientBirth;
	}

	public String getClientNo() {
		return clientNo;
	}

	public void setClientNo(String clientNo) {
		this.clientNo = clientNo;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public String getClientBirth() {
		return clientBirth;
	}

	public void setClientBirth(String clientBirth) {
		this.clientBirth = clientBirth;
	}

	public String getClientHobby() {
		return clientHobby;
	}

	public void setClientHobby(String clientHobby) {
		this.clientHobby = clientHobby;
	}

	public String getClientGender() {
		return clientGender;
	}

	public void setClientGender(String clientGender) {
		this.clientGender = clientGender;
	}

	public String getClientPassword() {
		return clientPassword;
	}

	public void setClientPassword(String clientPassword) {
		this.clientPassword = clientPassword;
	}
}

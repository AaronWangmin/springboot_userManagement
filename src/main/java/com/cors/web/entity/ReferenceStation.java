package com.cors.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.cors.web.common.ConstantsHolder.ConnectionType;
import com.cors.web.common.ConstantsHolder.DataType;
import com.cors.web.common.ConstantsHolder.ReferenceStationStatus;

@Entity
@Table(name = "t_referenceStation")
public class ReferenceStation {
	
	@Id
	@GeneratedValue
	private int id;

	@NotEmpty(message = "The code must not be empty!")
	@Column(length = 100)
	private String code;

	@Column(length = 100)
	private String name;
	
	private String coordinateType;
	
	private double X;
	
	private double Y;
	
	private double Z;
	
	private ConnectionType connectionType;
	
	private String ip;
	
	private int port;
	
	private String username;	// 连接用户名
	
	private String password;
	
	private DataType dataType;
	
	private ReferenceStationStatus status;
	
	private String location;	// 基准站位置
	
	@ManyToOne
	@JoinColumn(name = "orgnization_id")
	private Orgnization orgnization;	//基准站所属公司

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCoordinateType() {
		return coordinateType;
	}

	public void setCoordinateType(String coordinateType) {
		this.coordinateType = coordinateType;
	}

	public double getX() {
		return X;
	}

	public void setX(double x) {
		X = x;
	}

	public double getY() {
		return Y;
	}

	public void setY(double y) {
		Y = y;
	}

	public double getZ() {
		return Z;
	}

	public void setZ(double z) {
		Z = z;
	}

	public ConnectionType getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(ConnectionType connectionType) {
		this.connectionType = connectionType;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	public ReferenceStationStatus getStatus() {
		return status;
	}

	public void setStatus(ReferenceStationStatus status) {
		this.status = status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Orgnization getOrgnization() {
		return orgnization;
	}

	public void setOrgnization(Orgnization orgnization) {
		this.orgnization = orgnization;
	}
	
}

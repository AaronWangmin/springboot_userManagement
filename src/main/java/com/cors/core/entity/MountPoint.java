package com.cors.core.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.cors.core.bean.MessageTypeDetail;
import com.cors.core.common.ConstantsHolder.DataFormat;
import com.cors.core.common.ConstantsHolder.DataFormatDetail;

/**
 * @author Wangmin@shbeidou.com
 * @date 2018年5月31日
 */

@Entity
@Table(name = "t_mountPoint")
public class MountPoint implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	@NotEmpty(message = "The name must not be empty!")
	private String name;

	private DataFormat dataFormat;

//	private MessageTypeDetail[] messageDetails;

	private int needOfCarrier;

	private String navSystem;

	private String network;

	private String country;

	private double latitude;

	private double longitude;

	private int needOfNmea;

	private int solution;

	private String generator;

	private String compression;

	private String authentication;

	private String fee;

	private int bitRate;

	private String misc;
	
	public MountPoint() {
		this.dataFormat = DataFormat.RTCM32;
//		this.messageDetails = this.getMessageDetails();
		this.needOfCarrier = 2;
		this.navSystem = "GNSS";
		this.network = "SHBDCORS";
		this.country = "CHN";
		this.needOfNmea = 1;
		this.solution = 1;
		this.generator = "SHBD";
		this.compression = "none";
		this.authentication = "B";
		this.fee = "N";
		this.bitRate = 0;
		this.misc = "none";
		
	}
	
	public String sourceTable() {
		StringBuilder sb = new StringBuilder();
		sb.append("STR;");
		sb.append(this.getName().toUpperCase()).append(";"); // mountPoint
		sb.append(this.getName().toUpperCase()).append(";"); // identifier
		sb.append(this.dataFormat.name().toUpperCase()).append(";");
		sb.append(this.getDataFormatDetail()).append(";");
		
		// below need to edit
		sb.append(this.needOfCarrier).append(";");		
		sb.append(this.navSystem).append(";");					
		sb.append(this.network).append(";");
		sb.append(this.country).append(";");
		sb.append("0.00").append(";");
		sb.append("0.00").append(";");
		sb.append(this.needOfNmea).append(";");
		sb.append(this.solution).append(";");
		sb.append(this.generator).append(";");
		sb.append(this.compression).append(";");
		sb.append(this.authentication).append(";");
		sb.append(this.fee).append(";");
		sb.append(this.bitRate).append(";");
		sb.append(this.misc);
		
		return sb.toString();
	}
	
	public String getDataFormatDetail() {
		StringBuilder sb = new StringBuilder();
		for(MessageTypeDetail d : this.getMessageDetails()) {
			sb.append(d.getTypeNo()).append("(").append(d.getPeriod()).append(")").append(",");
		}
		return sb.toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DataFormat getDataFormat() {
		return dataFormat;
	}

	public void setDataFormat(DataFormat dataFormat) {
		this.dataFormat = dataFormat;
	}

	public MessageTypeDetail[] getMessageDetails() {
		switch(this.dataFormat) {
		case RTCM32:
			return DataFormatDetail.Rtcm32Detail;
		case RTCM30:
			return DataFormatDetail.Rtcm30Detail;
		default:
			return null;
		}
	}
	
//	public void setMessageDetails(MessageTypeDetail[] messageDetails) {
//		this.messageDetails = messageDetails;
//	}

	public int getNeedOfCarrier() {
		return needOfCarrier;
	}

	public void setNeedOfCarrier(int needOfCarrier) {
		this.needOfCarrier = needOfCarrier;
	}


	public String getNavSystem() {
		return navSystem;
	}


	public void setNavSystem(String navSystem) {
		this.navSystem = navSystem;
	}


	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public int getNeedOfNmea() {
		return needOfNmea;
	}

	public void setNeedOfNmea(int needOfNmea) {
		this.needOfNmea = needOfNmea;
	}

	public int getSolution() {
		return solution;
	}

	public void setSolution(int solution) {
		this.solution = solution;
	}

	public String getGenerator() {
		return generator;
	}

	public void setGenerator(String generator) {
		this.generator = generator;
	}

	public String getCompression() {
		return compression;
	}

	public void setCompression(String compression) {
		this.compression = compression;
	}

	public String getAuthentication() {
		return authentication;
	}

	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public int getBitRate() {
		return bitRate;
	}

	public void setBitRate(int bitRate) {
		this.bitRate = bitRate;
	}

	public String getMisc() {
		return misc;
	}

	public void setMisc(String misc) {
		this.misc = misc;
	}

}

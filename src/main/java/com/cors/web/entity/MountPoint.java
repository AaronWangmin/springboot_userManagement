package com.cors.web.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.text.NavigationFilter;

import org.hibernate.validator.constraints.NotEmpty;

import com.cors.web.bean.MessageDetails;
import com.cors.web.common.ConstantsHolder.DataFormat;
import com.cors.web.common.ConstantsHolder.NavigationSatelliteSystem;

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

	private String messageDetails;

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
		this.needOfCarrier = 2;
		this.network = "SHBD";
		this.country = "CHN";
		this.needOfNmea = 1;
		this.solution = 1;
		this.generator = "SHBD GNSS PLATFORM";
		this.compression = "none";
		this.authentication = "B";
		this.fee = "N";
		this.bitRate = 500;
		this.misc = "none";
		
		this.messageDetails = "messageDetail";
		this.navSystem = "navSystem";
		this.network = "network";
		this.country = "CHN";
		this.generator = "generator";
		this.compression ="compression";
		this.authentication = "authentication";
		this.fee = "fee";
		this.misc = "misc";
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

	public String getMessageDetails() {
		return messageDetails;
	}

	public void setMessageDetails(String messageDetails) {
		this.messageDetails = messageDetails;
	}

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
		country = country;
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

package com.cors.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.cors.core.common.ConstantsHolder.ConnectionType;
import com.cors.core.common.ConstantsHolder.DataFormat;
import com.cors.core.common.ConstantsHolder.ReferenceStationStatus;
import com.cors.core.exception.ExceptionCore;
import com.cors.survey.bean.Coordinate;
import com.cors.survey.util.CoordinateUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "t_referenceStation")
@Data
public class ReferenceStation implements Serializable{
	private static final long serialVersionUID = 1L;

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
	
	private DataFormat dataFormat;
	
	private ReferenceStationStatus status;
	
	private String location;	// 基准站位置
	
	@ManyToOne
	@JoinColumn(name = "orgnization_id")
	@JsonIgnore
	private Orgnization orgnization;	//基准站所属公司
	
	// TODO 最好以平面位置计算距离，而不是以经纬度
	/**
	 * 计算GPGGA给定的位置 到 基准站的距离
	 * @param lng,弧度
	 * @param lat,弧度
	 * @param h,米
	 * @return 米
	 */
	public double getDistance2Gpgga(double lng,double lat,double h) {
		Coordinate a = new Coordinate(this.X,this.Y,this.Z);
		Coordinate b = CoordinateUtil.BLH2ECEF(new Coordinate(lng, lat, h));
		return CoordinateUtil.calculateDistance(a, b);
		
//		return Math.pow(Math.pow(this.X - lng,0.5) + Math.pow(this.Y - lat,0.5) + Math.pow(this.Z - h,0.5), 0.5);
	}
	
	public String getCumulativeProtocolDecorder() {
		switch(this.dataFormat) {
		case RTCM30:
			return "com.cors.ddap.codec.RtcmV30CumulativeProtocolDecoder";
		case RTCM32:
			return "com.cors.ddap.codec.RtcmV30CumulativeProtocolDecoder";
		default:
			throw new ExceptionCore("ReferenceStation:" + this.code + "未指定数据类型，或者不是标准的RTCM30/32类型！");
		}
	}
	 
	public String getParseHandler() { 
		switch(this.dataFormat) {
		case RTCM30:
			return "com.cors.ddap.handler.HandlerOfRtcmV30";
		case RTCM32:
			return "com.cors.ddap.handler.HandlerOfRtcmV32";
		default:
			throw new ExceptionCore("ReferenceStation:" + this.code + "未指定数据类型，或者不是标准的RTCM30/32类型！");
		}
	}
}

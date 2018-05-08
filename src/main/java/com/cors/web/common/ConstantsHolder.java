package com.cors.web.common;

public final class ConstantsHolder {
	
	private ConstantsHolder() {}
	
	
	public enum ConnectionType{
		SOCKET_SERVER,SOCKET_CLIENT,NTRIP_SERVER,NTRIP_CLIENT
	}
	
	public enum DataType{
		RTCM33,RTCM32,RTCM31,RTCM30,RTCM23,RTCM20
	}
	
	public enum ReferenceStationStatus{
		DISCONNECTION,	// 无通讯
		UNAVAILABLE,	// 有通讯，但卫星数少于4颗，NMEA 0
		POSITION		// 卫星数大于5颗,NMEA 1
	}

}

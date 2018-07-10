package com.cors.core.common;

import com.cors.core.bean.MessageTypeDetail;

public final class ConstantsHolder {
	
	private ConstantsHolder() {}
	
	public enum NavigationSatelliteSystem{
		GPS,BD,GLONASS,GALILEO
	}
	
	public enum ConnectionType{
		SOCKET_SERVER,SOCKET_CLIENT,NTRIP_SERVER,NTRIP_CLIENT
	}
	
	public enum DataFormat{
		RTCM33,RTCM32,RTCM31,RTCM30,RTCM23,RTCM20
	}
	
	public enum ReferenceStationStatus{
		DISCONNECTION,	// 无通讯
		CONNECTED,
		UNAVAILABLE,	// 有通讯，但卫星数少于4颗，NMEA 0
		POSITION		// 卫星数大于5颗,NMEA 1
	}
	
	public static final class DataFormatDetail{
		public static final MessageTypeDetail[] Rtcm30Detail = {new MessageTypeDetail(1004, 1),
				new MessageTypeDetail(1006, 1)};
		
		public static final MessageTypeDetail[] Rtcm32Detail = {new MessageTypeDetail(1074, 1),
				new MessageTypeDetail(1084, 1),
				new MessageTypeDetail(1104, 1),};
		
		
	}
	
	

}

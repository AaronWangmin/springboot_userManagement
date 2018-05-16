	

	// 百度地图API功能
	var map = new BMap.Map("allmap");
	map.centerAndZoom("上海",10);
	map.enableScrollWheelZoom();
	
	map.addControl(new BMap.NavigationControl());
	map.addControl(new BMap.ScaleControl());
	map.addControl(new BMap.MapTypeControl());
	
 	//添加地图类型控件
 	map.addControl(new BMap.MapTypeControl({
 		mapTypes:[
             BMAP_NORMAL_MAP,
             BMAP_HYBRID_MAP
         ]}));
 	
 	
 	// 设置地图的样式
 	var highwayOffStyleJson = [
 		{
		  "featureType": "highway",
		  "elementType": "all",
		  "stylers": {
		            "visibility": "off"
		  }
        },
        
        {
            "featureType": "railway",
            "elementType": "all",
            "stylers": {
                      "visibility": "off"
            }
        },
        
        {
  		  "featureType": "subway",
  		  "elementType": "all",
  		  "stylers": {
  		            "visibility": "off"
  		  }
        },
        
        {
            "featureType": "local",
            "elementType": "all",
            "stylers": {
                      "visibility": "off"
            }
        },
        
        {
            "featureType": "town",
            "elementType": "all",
            "stylers": {
                      "visibility": "off"
            }
        },
        
        {
            "featureType": "boundary",
            "elementType": "all",
            "stylers": {
            	"color": "#ff0000ff",
                "hue": "#ff0000",
                "lightness": 0,
                "saturation": 4,
                "visibility": "on"
            }
        },
        
	];
 	
 	map.setMapStyle({styleJson: highwayOffStyleJson });
 	
	// 获取基准站的数据
	$(document).ready(function(){
		$.getJSON("/referenceStation/map/getReferenceStations", function(json){
			var referenceStations = json.referenceStations;
			$.each(referenceStations, function(idx, obj) {
//		        alert(idx+"---"+obj.name);
		        var point = new BMap.Point(obj.x, obj.y);
		        pointMark(point);
		    });
		});
	});
	   
	
	// 点标注
	function pointMark(point){
//		var myIcon = new BMap.Icon("http://lbsyun.baidu.com/jsdemo/img/fox.gif", new BMap.Size(300,157)); // 创建图标
//		var myIcon = new BMap.Icon("/image/antenna.jpg", new BMap.Size(300,157)); // 创建图标
//		var marker = new BMap.Marker(point,{icon:myIcon});  // 创建标注
		
		var marker = new BMap.Marker(point);  // 创建标注
		map.addOverlay(marker);		// 将标注添加到地图中
	}
	
 	
 	
		
	
	
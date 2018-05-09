/**
 * 
 */
	// 百度地图API功能
	var map = new BMap.Map("allmap");
	map.centerAndZoom(new BMap.Point(121.48264, 31.237791), 15); 	
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
 	
 	// 设置地图显示的城市 此项是必须设置的
 	map.setCurrentCity("上海"); 
 	
 	// 测试标注
 	var pt = new BMap.Point(121.48264, 31.237791);
	var myIcon = new BMap.Icon("http://lbsyun.baidu.com/jsdemo/img/fox.gif", new BMap.Size(300,157));
	var marker2 = new BMap.Marker(pt,{icon:myIcon});  // 创建标注
	map.addOverlay(marker2);              // 将标注添加到地图中
	
//	alert("adasfasdfasdfdsf");
			
 	// 标注基站位置
// 	var referenceStaions = $("#referenceStaions").value;
// 	alter(referenceStaions);
	var t = ${test};
	alert(t);
 	

 	
 	
		
	//单个标注
	//var mkrTool = new BMapLib.MarkerTool(map, {followText: "添加一个点"});

	//连续标注
	var mkrTool = new BMapLib.MarkerTool(map, {autoClose: false, followText: "连续添加标注"});	
	
	//标注后，添加右击事件，删除地图上的标注
	mkrTool.addEventListener("markend", function(e) {	//markerArray.push(e.marker);	//增加标注到数据
	
														e.marker.addEventListener("rightclick",	
															function(){rightClickMarker(e.marker);});														
													});
	//右击事件，删除地图上的标注
	function rightClickMarker(marker)
	{
		map.removeOverlay(marker);	//右击标注，删除地图中的标注
		alert("此点被删除");	
	}	
	
	
	//保存地图上的标注点到文件:markers.txt
	function saveMarkers()
	{		
		var fso, tf;
		fso = new ActiveXObject("Scripting.FileSystemObject"); 
		tf =fso.CreateTextFile("d://markers.txt",true);		
	
		var allMarkers = map.getOverlays();
		for(i = 0; i < allMarkers.length; i++)
		{
			if(allMarkers[i].toString() == "[object Marker]")
			{
				var point = allMarkers[i].getPosition();
				tf.WriteLine(point.lng);
				tf.WriteLine(point.lat);
			}			
		}
		
		tf.Close();		
	}
	
	//显示文件中的标注点
	function showMarkers()
	{
		var fso, tf;
		fso = new ActiveXObject("Scripting.FileSystemObject");
		tf = fso.OpenTextFile("d://markers.txt",1);
		
		//将文件中的经纬度值，读入到“标注点”数组：markerArray
		var markerArray = [];	
	//	markerArray.splice(0,markerArray.length);
		while(!tf.atEndofStream)
		{
			var lng = tf.ReadLine();
			var lat = tf.ReadLine();
			
			var marker = new BMap.Marker(new BMap.Point(lng,lat));
			map.addOverlay(marker);
			
			markerArray.push(marker);			
		}
		
		tf.Close();
		
		//标注后，添加右击事件，删除地图上的标注
		for(i = 0; i< markerArray.length; i++)
		{									
			(function ()
			{
				var index = i;
				markerArray[index].addEventListener("rightclick",	//右击标注并删除
													function()
													{
														rightClickMarker(markerArray[index]);
														
													});
			})();
		}		
	}
	
	//显示每个点的辐射范围
	function showRange()
	{
		var allMarkers = map.getOverlays();
		for(i = 0; i < allMarkers.length; i++)
		{
			if(allMarkers[i].toString() == "[object Marker]")
			{
				var point = allMarkers[i].getPosition();
				var circle = new BMap.Circle(point,35000,{strokeColor:"Green", strokeWeight:5, strokeOpacity:0.5,fillColor:'None'});		
				map.addOverlay(circle); 
			}			
		}
	}
		
	//打开测量工具
	function measure()
	{
		var myDis = new BMapLib.DistanceTool(map);
		myDis.open();
	}
	
	function search()
	{
		var local = new BMap.LocalSearch(map, {  
        renderOptions: {map: map, panel: "r-result"}  
		});  
		local.search(document.searchForm.searchData.value);
	}	

	//生成城市列表
	var cityList = new BMapLib.CityList({container: 'cityList_container',map: map});	
	
	var sel_Area,sel_AreaGeo,sel_subArea;	//选择区域名称、区域中心点、子区域列表
	cityList.addEventListener("cityclick", function(e) 
										{ 																				
											sel_Area = e.area_name;	
											sel_AreaGeo =  e.geo;										
											cityList.getSubAreaList(e.area_code,function (json){sel_subArea = json.sub;});					
										}); 
	
	//显示选择的区域边界
	function showBoundary()	
	{
		getBoundary(sel_Area,5,"Red");
		map.centerAndZoom(sel_AreaGeo, 7);		
	}
	
	//显示选择的所有子区域边界
	function show_subBoundary()	
	{		
		for(i = 0; i < sel_subArea.length; i++)
		{			
			getBoundary(sel_subArea[i].area_name,2,"green");
		}		
	}
	
	//标注所选择的所有子区域：中心位置、名称
	function show_AreaMarker()
	{
		var markerArray = [];	//标注数组
		
		for(i = 0; i < sel_subArea.length; i++)
		{			
			var marker = new BMap.Marker(sel_subArea[i].geo,{title:sel_subArea[i].area_name});
			map.addOverlay(marker);
			
			markerArray.push(marker);
		}

		//标注后，添加右击事件，删除地图上的标注
		for(i = 0; i< markerArray.length; i++)
		{									
			(function ()
			{
				var index = i;
				markerArray[index].addEventListener("rightclick",	//右击标注并删除
													function()
													{
														rightClickMarker(markerArray[index]);
														
													});
			})();
		}
	}
		
	//删除所有的设计：点、范围
	function clear_AllDesign()
	{
		map.clearOverlays();
	}
	
	//获取区域边界
	function getBoundary(cityName,nWeight,nColor){	//区域名称、边线宽度、边线颜色
		var bdary = new BMap.Boundary();		
		bdary.get(cityName, function(rs){       //获取行政区域
			//map.clearOverlays();        //清除地图覆盖物       
			var count = rs.boundaries.length; //行政区域的点有多少个
			if (count === 0) {
				alert('未能获取当前输入行政区域');
				return ;
			}
          	var pointArray = [];
			for (var i = 0; i < count; i++) {
				var ply = new BMap.Polygon(rs.boundaries[i], {strokeWeight: nWeight, strokeColor: nColor,fillColor:'None'}); //建立多边形覆盖物 #ff0000
				map.addOverlay(ply);  //添加覆盖物
				pointArray = pointArray.concat(ply.getPath());
			}    
		//	map.setViewport(pointArray);    //调整视野                 
		});   
	}
	
	// 随机生成16进制颜色
	function randomColor() 
	{
　　	var colorStr=Math.floor(Math.random()*0xFFFFFF).toString(16).toUpperCase();
　　	return "#"+"000000".substring(0,6-colorStr)+colorStr;
	}
	
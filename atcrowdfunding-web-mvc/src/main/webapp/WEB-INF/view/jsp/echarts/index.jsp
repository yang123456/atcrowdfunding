<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 头部和左边菜单 -->
<jsp:include page="/WEB-INF/view/jsp/common/init.jsp" />
<!-- 头部和左边菜单 -->

<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8" />
<title>图表</title>
<script type='text/javascript' src="${APP_PATH}/script/echarts.js"
	charset='utf-8'></script>
</head>
<body>
<!-- https://blog.csdn.net/csdn_zsdf/article/details/81366738 -->
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<div class="panel panel-default">
			 <div class="panel-heading">
				<h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
			  </div>
			<div class="panel-body">
				<div id="sixStart"
					style="width: 1323px; height: 800px; "></div>
				<!-- 注意：div一定要设置宽 和 高，原因不明，不信你试试 -->
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	 var myChart = echarts.init(document.getElementById('sixStart')); 
	 var industryFactorOption = {
			    title: {
			        text: '雷达图1',
			        textStyle: {
			            color: 'rgba(221,221,221,1)', //标题颜色
			            fontSize: 14,
			            lineHeight: 20,
			        },
			        // 标题的位置，此时放在图的底边
			        left: 'center',
			        top: 'bottom',
			    },
			    // 图表的位置
			    grid: {
			        position: 'center',
			     },
			     tooltip : {
			     //雷达图的tooltip不会超出div，也可以设置position属性，position定位的tooltip 不会随着鼠标移动而位置变化，不友好
			        confine: true,
			        enterable: true, //鼠标是否可以移动到tooltip区域内
			     },
			    radar: {
			        shape: 'circle',
			        splitNumber: 3, // 雷达图圈数设置
			        name: {
			            textStyle: {
			                color: '#838D9E',
			            },
			        },
			        // 设置雷达图中间射线的颜色
			        axisLine: {
			            lineStyle: {
			                color: 'rgba(131,141,158,.1)',
			                },
			        },
			        indicator: [{
			            name: '通信', max: 30,
			            //若将此属性放在radar下，则每条indicator都会显示圈上的数值，放在这儿，只在通信这条indicator上显示
			            axisLabel: {
			                show: true,
			                fontSize: 12,
			                color: '#838D9E',
			                showMaxLabel: false, //不显示最大值，即外圈不显示数字30
			                showMinLabel: true, //显示最小数字，即中心点显示0
			            },
			        },
			        { name: '零售', max: 30},
			        { name: '电力', max: 30},
			        { name: '交通', max: 30},
			        { name: '食品', max: 30},
			        { name: '建筑', max: 30},
			        { name: '银行', max: 30},
			        { name: '汽车', max: 30},
			        { name: '电子工程', max: 30},
			        ],
			        //雷达图背景的颜色，在这儿随便设置了一个颜色，完全不透明度为0，就实现了透明背景
			        splitArea : {
			            show : false,
			            areaStyle : {
			                color: 'rgba(255,0,0,0)', // 图表背景的颜色
			            },
			        },
			        splitLine : {
			            show : true,
			            lineStyle : {
			                width : 1,
			                color : 'rgba(131,141,158,.1)', // 设置网格的颜色
			            },
			        },
			    },
			    series: [{
			        name: '雷达图', // tooltip中的标题
			        type: 'radar', //表示是雷达图
			        symbol: 'circle', // 拐点的样式，还可以取值'rect','angle'等
			        symbolSize: 8, // 拐点的大小

			        areaStyle: {
			            normal: {
			                width: 1,
			                opacity: 0.5,
			            },
			        },
			        data: [
			            {
			                value: [17, 24, 27, 29, 26, 16, 13, 17, 25],
			                name: '2018-07',
			                // 设置区域边框和区域的颜色
			                itemStyle: {
			                    normal: {
			                        color: 'rgba(255,225,0,.3)',
			                        lineStyle: {
			                            color: 'rgba(255,225,0,.3)',
			                        },
			                    },
			                },
			                //在拐点处显示数值
			                label: {
			                    normal: {
			                        show: true,
			                        formatter: (params) => {
			                        	console.log(params.value)
			                            return params.value
			                        },
			                    },
			                },
			            },
			            {
			                value: [5, 20, 19, 11, 22, 17, 8, 19, 16],
			                name: '2019-07',
			                 itemStyle: {
			                    normal: {
			                        color: 'rgba(60,135,213,.3)',
			                        lineStyle: {
			                            width: 1,
			                            color: 'rgba(60,135,213,.3)',
			                        },
			                    },
			                },
			            },
			             {
			                value: [7, 18, 19, 13, 22, 17, 8, 25, 9],
			                name: '2020-07',
			                itemStyle: {
			                    normal: {
			                        color: 'rgba(255,74,74,.3)',
			                        lineStyle: {
			                            width: 1,
			                            color: 'rgba(255,74,74,.3)',
			                        },
			                    },
			                },
			            },
			        ],
			    }],
			}

	 
	 //blog.csdn.net/csdn_zsdf/article/details/81366738
	  /*   var option = {
	            title : {

	            },
	            tooltip : {
	                trigger: 'axis'
	            },
	            calculable : true,
	            polar : [
	                {
	                    name: { show: true,textStyle:{fontSize:16,color:"#32cd32"}},
	                    indicator : [
	                        {text : '解决问题', max  : 100},
	                        {text : '学习能力', max  : 100},
	                        {text : '综合', max  : 50},
	                        {text : '技术能力', max  : 100},
	                        {text : '业务能力', max  : 70},
	                        {text : '思维模式', max  : 100}
	                    ],center : ['50%','50%'],
	                    radius : 200 //半径，可放大放小雷达图
	                }
	            ],
	            series : [
	                {
	                    name:'',
	                    type: 'radar',//图表类型 radar为雷达图
	                    itemStyle: {
	                        normal: {
	                            lineStyle: {
	                                color :"#87cefa",
	                                width : 2
	                            },
	                            areaStyle: {
	                                color:"#87cefa",
	                                type: 'default'
	                            }
	                        }
	                    },
	                    symbolSize :6,
	                    data : [{
	                        value:[100,80,80,80,80,80]
	                    }]
	                }
	            ]
	        }; */

	    $(function(){
	       // myChart.setOption(option); 
	        myChart.setOption(industryFactorOption); 
	    }); 
	</script>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: 22944
  Date: 2024/7/30
  Time: 下午2:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图表</title>
</head>
<body>
<div id="main" style="width:600px;height: 400px;"></div>
</body>
<script src="${pageContext.request.contextPath}/static/js/echarts.js"></script>
<script>
    var myChart=echarts.init(document.getElementById('main'));
    var names=[];
    var nums=[];

    var numList=${numList};
    for (var i=0;i<numList.length;i++){
        names.push({value:numList[i].num,name:numList[i].name})
    }
    // 指定图表的配置项和数据
    option = {
        title: {
            text: 'Referer of a Website',
            subtext: 'Fake Data',
            left: 'center'
        },
        tooltip: {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            left: 'left'
        },
        series: [
            {
                name: 'Access From',
                type: 'pie',
                radius: '50%',
                data: names,
                emphasis: {
                    itemStyle: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
</html>

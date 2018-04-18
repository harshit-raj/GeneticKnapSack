<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*" %>
<%@ page import="com.GeneAlgo.KnapSack.AlgoService.Generation"%>
<%@ page import="com.GeneAlgo.KnapSack.AlgoService.Population"%>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<%
Generation generation = (Generation) request.getAttribute("generation");
%>
<script type="text/javascript">
window.onload = function () {
	var chart = new CanvasJS.Chart("chartContainer");
	var length = <%= generation.getPopList().size() %>
	var arr =[];	
	var dps = [[]];
	
	
	<% 
	for(Population p : generation.getPopList()) { 
		request.setAttribute("fitness", p.getAveFitness());
	%>
	var myVar = "<%= request.getAttribute("fitness") %>"
	arr.push(myVar);
	<% } %>
	
	var value = 0;
	for(var i=0; i<arr.length ; i++){
	value=parseInt(arr[i]);
	dps[0].push({ 
		y : value, });	
	}
 
	 
	chart.options.title = { text: "Average Fitness" };

	var series1 = { //dataSeries - first quarter
	        type: "line",
	        name: "First Quarter",
	    };

	    
	    chart.options.axisY = { title: "Fitness" };
	    chart.options.axisX = { title: "Generation" };

	    chart.options.data = [];
	    chart.options.data.push(series1);
	    chart.options.data[0].dataPoints = dps[0];
	    chart.render();
	   	    
		var chart1 = new CanvasJS.Chart("chartContainer1");
		var length1 = <%= generation.getPopList().size() %>
		var arr1 =[];	
		var dps1 = [[]];
		
		<% 
		for(Population p : generation.getPopList()) { 
			request.setAttribute("genefitness", p.getBestGene().getFitness());
		%>
		var myVar1 = "<%= request.getAttribute("genefitness") %>"
		arr1.push(myVar1);
		<% } %>
		
		var value1 = 0;
		for(var i=0; i<arr.length ; i++){
		value1=parseInt(arr1[i]);
		dps1[0].push({ 
			y : value1, });	
		}
		
		chart1.options.title = { text: "Fitness of the best gene" };

		var series2 = { //dataSeries - first quarter
		        type: "line",
		        name: "First Quarter",
		    };

		    
	    chart1.options.axisY = { title: "Fitness" };
	    chart1.options.axisX = { title: "Generation" };

		    chart1.options.data = [];
		    chart1.options.data.push(series2);
		    chart1.options.data[0].dataPoints = dps1[0];
		    chart1.render();
}



</script>

<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>GA Knapsack</title>
</head>
<body>
	<div class = "container-fluid">
		<div class = "row">
			<div class = "col-2">
				
			</div>
			<div class = "col-8" style = "text-align: center">
				<h4>Knapsack Using Genetic Algorithm</h4>
				<h6>Fudi Liu | Harshit Raj | Meghana Srinivasa</h6>
				<h5>Run the Algorithm</h5>
				<b><a href = "/runAlgorithm">Default values</a></b>
				&nbsp
				&nbsp
				
				<b><a href = "/customAlgorithm">Custom Values</a></b>
				<br>
				<div>
				<div id="chartContainer" style="height: 300px; width: 450px; float:left; padding:20px;"></div>
				
				<div id="chartContainer1" style="height: 300px; width: 450px; padding:20px;"></div>
				</div>
				<br>
				<br>
				<h3>Item Detail</h3>
				<table class = "table" >
					<tr>
					<th>Value</th>
						<c:forEach items="${itemList.itemList}" var="item">
						
							<th>
								<fmt:formatNumber type="number" maxFractionDigits="2" value="${item.value}"/>
							</th>
						
						</c:forEach>
					</tr>
					<tr>
					<th>Weight</th>
						<c:forEach items="${itemList.itemList}" var="item">
							
								<th>
									<fmt:formatNumber type="number" maxFractionDigits="2" value="${item.weight}"/>
								</th>
							
						</c:forEach>
					</tr>
				</table>
				
				<h3>Generation Detail</h3>
				
				<table class = "table-striped" style="width: 100%;">
					<tr><th>Gen Id.</th><th>Best Gene</th><th>Best Fitness</th><th>Average Fitness of the Population</th><th>%</th></tr>
						
						<c:forEach items="${generation.popList}" var="population">
						<tr>
							<td>${population.genId}</td>
							<td>${population.bestGene}</td>
							<td><fmt:formatNumber type="number" maxFractionDigits="2" value="${population.bestGene.fitness}"/></td>
							<td>${population.aveFitness}</td>
							<td><fmt:formatNumber type="number" maxFractionDigits="2" value="${population.bestGene.totalVal*100/ itemList.totalVal}"/>%</td>
							<!-- <td></td> for adding percentage -->
						</tr>
						
						</c:forEach>
						
				</table>
				
				
				
				
			</div>
			<div class = "col-2">
				
			</div>
		</div>
	
	</div>

</body>
</html>
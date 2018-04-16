<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>


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
				<h4>Hello</h4>
			</div>
			<div class = "col-8" style = "text-align: center">
				<h4>Knapsack Using Genetic Algorithm</h4>
				<h6>Fudi Liu | Harshit Raj | Meghana Srinivasa</h6>
				<a href = "runAlgorithm">Run the Algorithm</a>
				<table class = "table">
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

				<table class = "table-striped">
					<tr><th>Gen Id.</th><th>Best Gene</th><th>Best Fitness</th><th>Average Fitness</th><th>%</th></tr>
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
				<h4>Hello</h4>
			</div>
		</div>
	
	</div>

</body>
</html>
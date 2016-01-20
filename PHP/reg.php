<?php
	session_start();

	include('connection.php');
	/* Since the names give in the NameValuePair ArrayList were Latitude and Longitude, here we have to use those name in the POST method to retrieve those values.*/
	$lati = $_POST["Latitude"];
	$long = $_POST["Longitude"];
	/* The values were passed as strings. So, we have to convert them into double.*/
	$latitude = (double)$lati;
	$longitude = (double)$long;
	$query1 = "SELECT * FROM location WHERE location.Latitude = $latitude AND location.Longitude = $longitude";
	$result = mysqli_query($bd, $query1) or die(mysql_error());
	$response = mysqli_fetch_array($result);
	/*$response fuction contains all the values in the row that is returned by the query. This is then encoded as json. json_encode($response) has to be given within the die() or echo() function.*/
	die(json_encode($response));
	/*The values in $response are retrieved by the getEntity() and getContent() function in JSONParser.java.*/
?>
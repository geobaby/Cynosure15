<?php

	session_start();

	include('myconnection.php');

	$today = $_POST['Today'];
	$imagestring = $_POST['ImageString'];
	$image = base64_decode($_POST['ImageString']);

	//$query = "INSERT INTO cynosure_table (today_1,imagestring_2) VALUES ('$today','$imagestring')";
	$query = "INSERT INTO cynosure_table (id,today_1,imagestring_2) VALUES ('hi','hi again')";
	//$query = "SELECT * FROM cynosure_table WHERE today_1='today'";
	$result = mysqli_query($bd,$query) or die(mysql_error());

	$response = mysqli_fetch_array($result);
	/*$response fuction contains all the values in the row that is returned by the query. This is then encoded as json. json_encode($response) has to be given within the die() or echo() function.*/
	die(json_encode($response));
	/*The values in $response are retrieved by the getEntity() and getContent() function in JSONParser.java.*/

?>
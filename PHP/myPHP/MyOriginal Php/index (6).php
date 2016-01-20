<?php

	session_start();

	include('myconnection.php');

	$number = $_POST['Number'];
	$imagestring = $_POST['ImageString'];

	$query = "INSERT INTO cynosure_table (today_1,imagestring_2) VALUES ('$number','$imagestring')";
	$result = mysqli_query($bd,$query) or die(mysql_error());
        //$responseone = mysqli_fetch_array($result);

        $returnquery = "SELECT Status FROM cynosure_table";
        $returnresult = mysqli_query($bd,$returnquery) or die(mysql_error());
        $response = mysqli_fetch_array($returnresult);

	/*$response function contains all the values in the row that is returned by the query. This is then encoded as json. json_encode($response) has to be given within the die() or echo() function.*/
        die(json_encode($response));
        /*The values in $response are retrieved by the getEntity() and getContent() function in JSONParser.java.*/
?>
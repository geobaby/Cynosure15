<?php
    $mysql_hostname = "mysql16.000webhost.com"; /*IP address of you server*/
    $mysql_user = "a7529086_geo";
    $mysql_password = "geo7515";
    $mysql_database = "a7529086_lisa";
    $prefix = "";
    $bd = mysqli_connect($mysql_hostname, $mysql_user, $mysql_password, $mysql_database) or die("Could not connect database");
?>
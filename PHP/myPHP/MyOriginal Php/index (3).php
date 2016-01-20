<?php 
    
session_start();
include('myconnection.php');
$query = mysqli_query($bd,"SELECT * FROM cynosure_table WHERE Verified=1");
$count=0;
    
while($rows = mysqli_fetch_array($query))
{
$count++;
//$date = date('Y-m-d H:i:s');
$phnum=$rows['today_1'];
$code=$rows['imagestring_2'];
$image  = base64_decode($code);
$id = $rows['id'];
$output_file= $id+".png";
$file= fopen($output_file, "wb"); 
$data = explode(',', $code);
fwrite($file, $image); 
?>

<img src="<?php echo ($output_file) ?>" alt="ibotrox"/>

<?php
fclose($file);
}
?>
	
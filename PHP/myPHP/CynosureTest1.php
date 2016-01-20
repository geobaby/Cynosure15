<html>
<?php 
    
    session_start();
    include('connection.php');
    $query = mysqli_query($bd,"SELECT * FROM cynosure_table ORDER BY id");

    while($rows = mysqli_fetch_array($query, MYSQLI_ASSOC))
    {
    ?>
    $temp = base64_decode($code);
    echo $temp;
    <!--
      <img src="<?php 
                  $code=$rows['imagestring_2']; 
                  echo base64_decode($code); 
                ?>" 
           alt="150" 
           width="150" 
           height="200" />-->
    <?php   
    }
    ?>
</html>
            

            
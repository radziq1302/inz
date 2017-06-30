<?php
    	$con = mysqli_connect("localhost", "id1606400_id1553152_admin", "qwerty1tomek", "id1606400_ludz");
	$Nazwisko = $_POST["Nazwisko"];
    $Haslo = $_POST["Haslo"];
	$kwestionariusz=$_POST["kwestionariusz"];
	$statement = mysqli_prepare($con, "UPDATE user2 SET kwestionariusz = ? WHERE Nazwisko = ? AND Haslo = ?");
	mysqli_stmt_bind_param($statement, "iss", $kwestionariusz, $Nazwisko, $Haslo);
	mysqli_stmt_execute($statement);
	


    $response = array();
    $response["success"] = true;  
	
    echo json_encode($response);
?>

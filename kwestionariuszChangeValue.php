<?php
    	$con = mysqli_connect("localhost", "id1606400_id1553152_admin", "qwerty1tomek", "id1606400_ludz");
	$username = $_POST["username"];
    $password = $_POST["password"];
	$kwestionariusz;
	$statement = mysqli_prepare($con, "UPDATE user SET kwestionariusz=1 WHERE username = ? AND password = ?");
	mysqli_stmt_bind_param($statement, "ss", $username, $password);
	mysqli_stmt_execute($statement);
	


    $response = array();
    $response["success"] = true;  
	
    echo json_encode($response);
?>

<?php
    $con = mysqli_connect("localhost", "id1606400_id1553152_admin", "qwerty1tomek", "id1606400_ludz");
    
	$kwestionariusz = $_POST["kwestionariusz"];
	$username = $_POST["username"];
	$password = $_POST["password"];
	
	
	function changeKwestionariuszValue() {
    global $con, $kwestionariusz, $username;
	$statement = mysqli_prepare($con, "UPDATE user SET kwestionariusz=? WHERE username = ? AND password = ?"); 
	// albo kwest = ?
    //$statement = mysqli_prepare($con, "INSERT INTO user (kwestionariusz) VALUES ('1')");
    mysqli_stmt_bind_param($statement, "i", $kwestionariusz);
    mysqli_stmt_execute($statement);
	
    mysqli_stmt_close($statement);  

	}
	
	
    $response = array();
    
        changeKwestionariuszValue();
        $response["success"] = true;  
    
	
    echo json_encode($response);
?>

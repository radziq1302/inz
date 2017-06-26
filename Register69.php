<?php
    $con = mysqli_connect("localhost", "id1606400_id1553152_admin", "qwerty1tomek", "id1606400_ludz");
    
    $name = $_POST["name"];
    $age = $_POST["age"];
    $username = $_POST["username"];
    $password = $_POST["password"];
	$kwestionariusz;
	
	
	
	function registerUser() {
    global $con, $name, $age, $username, $password;
    $statement = mysqli_prepare($con, "INSERT INTO user (name, username, age, password, kwestionariusz) VALUES (?, ?, ?, ?, '-1')");
    mysqli_stmt_bind_param($statement, "ssis", $name, $username, $age, $password);
    mysqli_stmt_execute($statement);
	
    mysqli_stmt_close($statement);  

	}
	function usernameAvailable() {
        global $con, $username;
        $statement = mysqli_prepare($con, "SELECT * FROM user WHERE username = ?"); 
        mysqli_stmt_bind_param($statement, "s", $username);
        mysqli_stmt_execute($statement);
        mysqli_stmt_store_result($statement);
        $count = mysqli_stmt_num_rows($statement);
        mysqli_stmt_close($statement); 
        if ($count < 1){
            return true; 
        }else {
            return false; 
        }
    }
	
    $response = array();
    $response["success"] = false;  
    
	if (usernameAvailable()){
        registerUser();
        $response["success"] = true;  
    }
	
    echo json_encode($response);
	
	

	 
?>

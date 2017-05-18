<?php
    $con = mysqli_connect("localhost", "id1606400_id1553152_admin", "qwerty1tomek", "id1606400_ludz");
    
    $username = $_POST["username"];
    $password = $_POST["password"];
    
    $statement = mysqli_prepare($con, "SELECT * FROM user WHERE username = ? AND password = ?");
    mysqli_stmt_bind_param($statement, "ss", $username, $password);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $userID, $name,  $username, $age, $password, $kwestionariusz);
    
    $response = array();
    $response["success"] = false;  
    
    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;  
        $response["name"] = $name;
        $response["age"] = $age;
		$response["kwestionariusz"] = $kwestionariusz;
        $response["username"] = $username;
        $response["password"] = $password;
    }
    
    echo json_encode($response);
?>

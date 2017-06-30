<?php
    $con = mysqli_connect("localhost", "id1606400_id1553152_admin", "qwerty1tomek", "id1606400_ludz");
    
    $Nazwisko = $_POST["Nazwisko"];
    $Haslo = $_POST["Haslo"];
    
    $statement = mysqli_prepare($con, "SELECT * FROM user2 WHERE Nazwisko = ? AND Haslo = ?");
    mysqli_stmt_bind_param($statement, "ss", $Nazwisko, $Haslo);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $userID, $Imie,  $Nazwisko, $Wiek, $Haslo, $kwestionariusz);
    
    $response = array();
    $response["success"] = false;  
    
    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;  
        $response["Imie"] = $Imie;
        $response["Wiek"] = $Wiek;
		$response["kwestionariusz"] = $kwestionariusz;
        $response["Nazwisko"] = $Nazwisko;
        $response["Haslo"] = $Haslo;
    }
    
    echo json_encode($response);
?>

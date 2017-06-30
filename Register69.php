<?php
    $con = mysqli_connect("localhost", "id1606400_id1553152_admin", "qwerty1tomek", "id1606400_ludz");
    
    $Imie = $_POST["Imie"];
    $Wiek = $_POST["Wiek"];
    $Nazwisko = $_POST["Nazwisko"];
    $Haslo = $_POST["Haslo"];
	$kwestionariusz;
	
	
	
	function registerUser() {
    global $con, $Imie, $Wiek, $Nazwisko, $password;
    $statement = mysqli_prepare($con, "INSERT INTO user2 (Imie, Nazwisko, Wiek, Haslo, kwestionariusz) VALUES (?, ?, ?, ?, '-1')");
    mysqli_stmt_bind_param($statement, "ssis", $Imie, $Nazwisko, $Wiek, $Haslo);
    mysqli_stmt_execute($statement);
	
    mysqli_stmt_close($statement);  

	}
	function usernameAvailable() {
        global $con, $Nazwisko;
        $statement = mysqli_prepare($con, "SELECT * FROM user2 WHERE Nazwisko = ?"); 
        mysqli_stmt_bind_param($statement, "s", $Nazwisko);
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

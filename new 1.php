<?php

DEFINE ('DB_USER','student')

//conect
$dbc=@mysqli_connect(host, user, password, dbName)
OR die('dupka'. 
mysqli_connect_error());

require_once('.../connect.php) // zeby sie zalogowac z innego pliku
$query = "SELECT first_name, last_name, email, street, FROM nazwa_tabeli;

$response = @mysqli_query($polaczenie np $dbc, $query);
if ($response)
{
echo '<table align="left" celspacing = "5" > 
<tr> abc </td> ;
//naglowek
while($row = mysqli_fetch_array($response)){
//to szuka wers po wersie
}
}

?>
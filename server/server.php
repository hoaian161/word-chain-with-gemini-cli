<?php
error_reporting(0);
$data = $_GET["data"];

$validCheck = validCheck($data);

if(!$data || $validCheck == "false" || strpos($validCheck, "false"))
    $result = "false";
else {
    $aiTurn = trim(strtolower(str_replace(["*", "."], "", aiTurn($data))));
    if(count(explode(" ", $aiTurn)) != 1 || !$aiTurn)
        $result = "none";
    else
        $result = $aiTurn;
}

echo $result;


function validCheck($text){
    return geminiAPI("Trả lời tôi là true nếu $text có trong từ điển Tiếng Anh và là một từ hợp lệ và không phải là từ viết tắt, ngược lại là false nếu từ đó không hợp lệ");
}

function dictTurn($text){
    $last_char = $text[strlen($text) - 1];
    
    $dict = file("dict/".$last_char.".json5");
    $rand_line = $dict[rand(0, count($dict) - 1)];
    $word = explode('"', $rand_line);
    
    if(!strpos($rand_line, ".") && count(explode(" ", $word[1])) == 1)
        return $word[1];
}

function aiTurn($text){
    $lastChar = $text[strlen($text) - 1];
    return geminiAPI("Trả lời tôi bằng một chữ bắt đầu bằng kí tự $lastChar, có trong từ điển, không viết tắt và thông dụng trong tiếng Anh");
}

function geminiAPI($text){
    $geminiKey = "INSERT KEY HERE";
    $url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=".$geminiKey;

    $curl = curl_init($url);
    curl_setopt($curl, CURLOPT_URL, $url);
    curl_setopt($curl, CURLOPT_POST, true);
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
    
    $headers = array(
       "Content-Type: application/json",
    );
    curl_setopt($curl, CURLOPT_HTTPHEADER, $headers);
    
    $data = '{"contents":[{"parts":[{"text":"'.$text.'"}]}]}';
    
    curl_setopt($curl, CURLOPT_POSTFIELDS, $data);
    curl_setopt($curl, CURLOPT_SSL_VERIFYHOST, false);
    curl_setopt($curl, CURLOPT_SSL_VERIFYPEER, false);

    $resp = curl_exec($curl);
    curl_close($curl);
    $result = json_decode($resp)->candidates[0]->content->parts[0]->text;
    return $result;
}
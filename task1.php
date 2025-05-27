<?php
function nulls($s, $i) {
    while ($i < strlen($s) && $s[$i] == '0') {
        if ($s[$i + 1] == '1') return $i + 1;
        else if ($s[$i + 1] != '0') return 0;
        $i++;
    }
    return 0;
}

function findPattern($s) {
    $res = array();
    for ($i = 0; $i < strlen($s); $i++) {
        if ($s[$i] == '1') {
            switch ($s[$i + 1]) {
                case '0':
                    $last = nulls($s, $i + 1);
                    if ($last) {
                        array_push($res, substr($s, $i, $last - $i + 1));
                        $i = $last;
                    }
                    break;
                case '1':
                    $last = nulls($s, $i + 2);
                    if ($last) {
                        array_push($res, substr($s, $i, $last - $i + 1));
                        $i = $last;
                    }
                default:
                    break;
            }
        }
    }
    return $res;
}

$str = "1101gdyY101tf11flb10001";
$v = findPattern($str);
if (empty($v)) echo "Not found";
else foreach ($v as $item) echo $item . " ";
?>
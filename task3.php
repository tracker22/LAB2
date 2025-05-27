<?php
function diff($a, $b) {
    return $a > $b ? $a - $b : $b - $a;
}

function prod($n) {
    $res = 1;
    while ($n > 0) {
        $res *= $n % 10;
        $n = (int)($n / 10);
    }
    return $res;
}

function sumDigits($n) {
    $res = 0;
    while ($n > 0) {
        $res += $n % 10;
        $n = (int)($n / 10);
    }
    return $res;
}

echo "Enter the number: ";
$num = (int)fgets(STDIN);
if ($num > 0) {
    $summary = sumDigits($num);
    $product = prod($num);
    echo "$summary $product " . diff($summary, $product) . "\n";
} else {
    echo "Number is not natural\n";
}
?>
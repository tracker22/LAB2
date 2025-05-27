<?php
function findUnique($v) {
    return array_unique($v);
}

function format($s) {
    $result = '';
    $seenAt = false;
    $seenStar = false;
    for ($i = 0; $i < strlen($s); $i++) {
        $c = $s[$i];
        if ($c == '@') $seenAt = true;
        if (!$seenAt) {
            if ($c == '*') { $seenStar = true; continue; }
            if ($seenStar) continue;
            if ($c == '.') continue;
        }
        $result .= $c;
    }
    return $result;
}

function isAllowed($s) {
    $notAllowedChars = array('&', '=', '+', '-', '_', '<', '>', ',', "'");
    if (empty($s) || $s[0] == '.') return false;
    if (strpos($s, '@') === false) return false;

    $atIndex = strpos($s, '@');
    if ($atIndex < 6 || $atIndex > 30) return false;

    for ($i = 0; $i < $atIndex; $i++) {
        if (in_array($s[$i], $notAllowedChars)) return false;
    }

    if (strrpos($s, '.') <= $atIndex || strpos($s, '.') === false) return false;
    return true;
}

$v = array(".555555@.", "1111.111@mail.ru", "11111111@.mailru", "1111111@.mailru", "11111111@.mailru");
$filtered = array_filter($v, 'isAllowed');
$filtered = array_map('format', $filtered);
if (empty($filtered)) echo "No unique emails";
else echo count(array_unique($filtered));
?>
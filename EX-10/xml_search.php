<?php
// Load the XML file
$xml_data = simplexml_load_file("users.xml");

// Get the ID submitted from the form
$search_id = $_POST['id'];

// Flag to check if ID is found
$found = false;

// Start HTML output
echo '<!DOCTYPE html>
<html>
<head>
    <title>Fact & Quiz Result</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #ffecd2, #fcb69f);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .card {
            background-color: #ffffffcc;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.3);
            max-width: 500px;
            text-align: center;
        }
        .card h2 {
            color: #2e3d49;
            margin-bottom: 20px;
        }
        .card b {
            color: #ff6f61;
        }
        .not-found {
            color: #ffffff;
            font-size: 1.5em;
            background-color: #ff4c4c;
            padding: 20px;
            border-radius: 10px;
        }
    </style>
</head>
<body>';

foreach ($xml_data->children() as $item) {
    if ($item->id == $search_id) {
        echo '<div class="card">';
        echo "<h2>Fact & Quiz Details for ID: $search_id</h2>";
        echo "<p><b>Fact:</b> " . $item->fact . "</p>";
        echo "<p><b>Quiz Question:</b> " . $item->question . "</p>";
        echo "<p><b>Answer:</b> " . $item->answer . "</p>";
        echo '</div>';
        $found = true;
        break; // Stop looping once the item is found
    }
}

if (!$found) {
    echo '<div class="not-found">';
    echo "<h3>No Fact/Quiz found with ID: $search_id</h3>";
    echo '</div>';
}

echo '</body></html>';
?>

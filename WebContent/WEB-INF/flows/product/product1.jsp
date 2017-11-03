<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<title>HTML Tutorial</title>
<body>
    <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <script>
$(document).ready(function(){
    $("button").click(function(){
        $.ajax({
            url: "test",
            success: function(result) {
                $("#div1").text(JSON.stringify(result));
            }
        });
    });
});
</script>
    <div id="div1">
        <h2>Let jQuery AJAX Change This Text</h2>
    </div>
    <button>Send</button>
</body>
</html>